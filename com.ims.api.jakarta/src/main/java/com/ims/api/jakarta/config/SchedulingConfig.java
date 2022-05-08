package com.ims.api.jakarta.config;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import com.ims.api.jakarta.config.utils.poster.TaskPoster;
import com.ims.api.jakarta.dao.repository.TaskRepository;
import com.ims.api.jakarta.entities.Task;
import com.ims.api.jakarta.entities.constant.TaskType;



@Configuration
@EnableScheduling
public class SchedulingConfig {
	
	private static Logger logger = LogManager.getLogger(SchedulingConfig.class);

	@Autowired
	private TaskRepository taskDao;


	@Scheduled(fixedDelay = 5000)
	public void scheduleFixedDelayTask() {
		
		logger.info( "Fixed delay task - " + System.currentTimeMillis() / 1000);
		
		List<Task> task = (List<Task>) taskDao.findByTaskNotAlreadySubmittedForPCS();
		
		task.forEach( t -> {
			
			int status = -1;
			if(t.getTaskType().equalsIgnoreCase(TaskType.CM))
				status = TaskPoster.postTicket(t,taskDao);
			else 
				status = TaskPoster.post(t,taskDao);
			
			if(t.getHitToClient() == 0)
				taskDao.updateHitStatus(1, t.getTaskId());
			
			logger.info(String.format(" taskId = %s", t.getTaskId()));
		});
		
		
	}	
	
	 

}
