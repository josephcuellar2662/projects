#include <vxWorks.h>
#include "shared_memory.h"
#include "steering_task.h"

int tSteeringTask;
SEM_ID syncTask;

void run_steering_task() {
	while(1) {
		char currentValue = getSteerMode();
		printf("Steer Task - Received Steer mode of %c\n", currentValue);
		
		//Try to get sync sem
		semTake(getSyncSem(), WAIT_FOREVER);
		taskDelay(1);
	}
}

void init_steering_task() {
	tSteeringTask = taskSpawn("tSteeringTask", 97, 0, 512, &run_steering_task);
}

void destroy_steering_task() {
	if (taskDelete(tSteeringTask) == ERROR){
		logMsg("steering task deletion error \n");
	}}
