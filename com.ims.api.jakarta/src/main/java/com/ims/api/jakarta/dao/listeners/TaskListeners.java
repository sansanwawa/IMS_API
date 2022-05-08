package com.ims.api.jakarta.dao.listeners;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ims.api.jakarta.entities.Task;

public class TaskListeners {

	private static Logger logger = LogManager.getLogger(TaskListeners.class);

	@PrePersist
	@PreUpdate
	@PreRemove
	private void beforeAnyUpdate(Task task) {
		logger.info("[TASK AUDIT] called beforeAnyUpdate .... ");
	}

	@PostPersist
	@PostUpdate
	@PostRemove
	private void afterAnyUpdate(Task task) {
		logger.info("[TASK AUDIT] called afterAnyUpdate .... ");
	}

	@PostLoad
	private void afterLoad(Task task) {
		logger.info("[TASK AUDIT] called afterLoad : " + task.getTaskId());
	}

}
