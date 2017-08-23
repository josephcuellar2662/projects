#include <vxWorks.h>
#include "shared_memory.h"
#include "rc_car_manager.h"
#include "shutdown_alarm.h"

int tShutdownTask;
SEM_ID shutdownSem;

void run_shutdown_task() {
	//Blocks until someone gives to the semaphore (signal_processor).
	semTake(shutdownSem, WAIT_FOREVER);
	stop_rc_car();
}

void init_shutdown_task() {
	tShutdownTask = taskSpawn("tShutdownTask", 50, 0, 512, &run_shutdown_task);
	shutdownSem = getShutdownSem();
}

void destroy_shutdown_task() {
	if (taskDelete(tShutdownTask) == ERROR){
		logMsg("Shutdown task deletion error \n");
	}
}
