#include <vxWorks.h>
#include <stdlib.h>
#include "shared_memory.h"
#include "signal_processor.h"
#include "message_queue.h"

typedef struct _sensorReading {
	char driveValue;
	char steerValue;
} SensorReading;

SensorReading _data;
int tSignalProcessor;
SEM_ID shutdownSem;
WDOG_ID wdId;

SensorReading* getSensorReading() {

	int driveRoll = rand() % 3;
	int steerRoll = rand() % 3;

	switch(driveRoll) {
	case 0:
		_data.driveValue = 'F';
		break;
	case 1:
		_data.driveValue = 'B';
		break;
	default:
		_data.driveValue = '-';
		break;
	}

	switch(steerRoll){
	case 0:
		_data.steerValue = 'L';
		break;
	case 1:
		_data.steerValue = 'R';
		break;
	default:
		_data.steerValue = '-';
		break;
	}

	return &_data;
}

//Watchdog function for setting off the shutdown task
void kill_car(){
	semGive(shutdownSem);
}

void run_signal_processor() {
	int i = 0;
	while (1) {
		//If this function is not called again in 10 seconds, shutdown the car.
		wdStart(wdId, (sysClkRateGet() * 10), kill_car, 0);
		
		char driveValue = *retrieve_data();
		char steerValue = *retrieve_data();
		setDriveMode(driveValue);
		setSteerMode(steerValue);
		printf("[%d]Signal Processor - Received values Drive[%c] and Steering[%c]\n",
				i,
				driveValue,
				steerValue);

		//Try to get synchronization semaphore
		semTake(getSyncSem(), WAIT_FOREVER);
		i = i + 1;
		taskDelay(1);
	}
}

void init_signal_processor() {
	tSignalProcessor = taskSpawn("tSignalProcessor", 90, 0, 512, &run_signal_processor);
	wdId = wdCreate();
	shutdownSem = getShutdownSem();
}

void destroy_signal_processor() {
	if (taskDelete(tSignalProcessor) == ERROR){
		logMsg("signal processor task deletion error \n");
	}
	wdDelete(wdId);
}
