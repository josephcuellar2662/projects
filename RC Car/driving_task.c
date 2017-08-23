#include <vxWorks.h>
#include "shared_memory.h"
#include "driving_task.h"

int tDrivingTask;
SEM_ID syncTask;

void run_driving_task() {
	while(1) {
		char currentValue = getDriveMode();
		printf("Driving Task - Received Drive mode of %c\n", currentValue);
		
		//Try to get sync sem
		semTake(getSyncSem(), WAIT_FOREVER);
		taskDelay(1);
	}
}

void init_driving_task() {
	tDrivingTask = taskSpawn("tDrivingTask", 97, 0, 512, &run_driving_task);
}

void destroy_driving_task() {
	if (taskDelete(tDrivingTask) == ERROR){
		logMsg("driving task deletion error \n");
	}
}
