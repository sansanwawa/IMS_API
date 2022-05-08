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

import com.ims.api.jakarta.entities.SIK;
import com.ims.api.jakarta.entities.Task;

public class SIKListeners {

	private static Logger logger = LogManager.getLogger(SIKListeners.class);

	@PrePersist
	@PreUpdate
	@PreRemove
	private void beforeAnyUpdate(SIK sik) {
			logger.info("[SIK AUDIT] About to add....................");
	}

	@PostPersist
	@PostUpdate
	@PostRemove
	private void afterAnyUpdate(SIK sik) {
		logger.info("[SIK AUDIT] add/update/delete complete for sik: " + sik.getSIKKey());
	}

	@PostLoad
	private void afterLoad(SIK sik) {
		logger.info("[SIK AUDIT] sik loaded from database: " + sik.getSIKKey());
	}

}
