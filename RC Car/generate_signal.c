#include <vxWorks.h>
#include <stdlib.h>
#include "signal_processor.h"
#include "message_queue.h"
#include "signal_processor.h"

typedef struct _sensorReading {
	char driveValue;
	char steerValue;
} SensorReading;

int tGenerateSignal;

void generate_signal(){
	while(1){
		//Get sensor values and place them in shared memory
		SensorReading* sensorValue = getSensorReading();
		char driveValue = sensorValue->driveValue;
		char steerValue = sensorValue->steerValue;
		send_data(driveValue);
		send_data(steerValue);
		
		//Try to get synchronization semaphore
		semTake(getSyncSem(), WAIT_FOREVER);
		taskDelay(1);
	}
}

void init_generate_signal(){
	tGenerateSignal = taskSpawn("tGenerateSignal", 85, 0, 512, &generate_signal);
}

void destroy_generate_signal(){
	if (taskDelete(tGenerateSignal) == ERROR){
		logMsg("generate signal task deletion error \n");
	}
}
