#include <vxWorks.h>
#include <time.h>
#include "shared_memory.h"
#include "steering_task.h"
#include "driving_task.h"

int tLoggingTask;
SEM_ID syncTask;

struct timespec tpstart; 
struct timespec tpend; 


void run_logging_task() {
	tickSet(0);
	clock_gettime(CLOCK_REALTIME, &tpstart); 
	while(1) {
		char currentSteerValue = getSteerMode();
		char currentDriveValue = getDriveMode();
		printf("Log Task - [%c] is the Steer Value, [%c] is the Drive Value\t \n", currentSteerValue, currentDriveValue);
		
		clock_gettime(CLOCK_REALTIME, &tpend); 
		
		int tsec = (int)tpend.tv_sec - (int)tpstart.tv_sec;
		int tnano = (int)tpend.tv_nsec - (int)tpstart.tv_nsec;
		printf("Steering and driving mode was logged at %d sec and %d nsec and %d ticks\n", tsec, tnano, tickGet());
		
		//Try to get sync sem
		semTake(getSyncSem(), WAIT_FOREVER);
		taskDelay(1);
	}
}

void init_logging_task() {
	tLoggingTask = taskSpawn("tLoggingTask", 97, 0, 512, &run_logging_task);
}

void destroy_logging_task() {
	if (taskDelete(tLoggingTask) == ERROR){
		logMsg("logging task deletion error \n");
	}
}
