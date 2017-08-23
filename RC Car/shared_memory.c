#include <vxWorks.h>
#include "shared_memory.h"

SEM_ID driveSem;
SEM_ID steerSem;
SEM_ID syncSem;
SEM_ID shutdownSem;

char _driveMode = '-';
char _steerMode = '-';

void init_shared_memory() {
	driveSem = semMCreate(0); /* mutex semaphore fifo */
	steerSem = semMCreate(0); /* mutex semaphore fifo */
	syncSem = semBCreate(1, 0); /* priority binary semaphore empty */
	shutdownSem = semBCreate(1, 0); /* priority binary semaphore empty */
}

void destroy_shared_memory() {
	semDelete(driveSem);
	semDelete(steerSem);
	semDelete(syncSem);
	semDelete(shutdownSem);
}

char getDriveMode() {
	semTake(driveSem, WAIT_FOREVER);
	char mode = _driveMode;
	semGive(driveSem);
	return mode;
}

void setDriveMode(char mode) {
	semTake(driveSem, WAIT_FOREVER);
	_driveMode = mode;
	semGive(driveSem);
}

char getSteerMode() {
	semTake(steerSem, WAIT_FOREVER);
	char mode = _steerMode;
	semGive(steerSem, WAIT_FOREVER);
	return mode;
}

void setSteerMode(char mode) {
	semTake(steerSem, WAIT_FOREVER);
	_steerMode = mode;
	semGive(steerSem);
}

SEM_ID getSyncSem() {
	return syncSem;
}

SEM_ID getShutdownSem(){
	return shutdownSem;
}
