
#include <vxWorks.h>
#include "shared_memory.h"
#include "signal_processor.h"
#include "driving_task.h"
#include "steering_task.h"
#include "logging_task.h"
#include "sync_task.h"
#include "shutdown_alarm.h"

void start_rc_car() {
	init_generate_signal();
	init_message_queue();
	init_shared_memory();
	init_signal_processor();
	init_steering_task();
	init_driving_task();
	init_logging_task();
	init_sync_task();
	init_shutdown_task();
}

void stop_rc_car() {
	logMsg("Stopping rc car\n");
	destroy_message_queue();
	destroy_generate_signal();
	destroy_shared_memory();
	destroy_signal_processor();
	destroy_driving_task();
	destroy_steering_task();
	destroy_logging_task();
	destroy_sync_task();
	destroy_shutdown_task();
}
