#include <vxWorks.h>
#include "sync_task.h"
#include "shared_memory.h"

int tSyncTask;

void run_sync_task() {
	while (1) {
		printf("Sync Task - Flushing pending tasks...\n\n");
		semFlush(getSyncSem());
		taskDelay(500);
	}
}

void init_sync_task() {
	tSyncTask = taskSpawn("tSyncTask", 100, 0, 512, &run_sync_task);
}

void destroy_sync_task() {
	if (taskDelete(tSyncTask) == ERROR){
		logMsg("sync task deletion error \n");
	}
}
