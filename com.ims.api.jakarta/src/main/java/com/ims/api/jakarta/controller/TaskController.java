package com.ims.api.jakarta.controller;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ims.api.jakarta.dao.repository.TaskRepository;
import com.ims.api.jakarta.entities.Task;
import com.ims.api.jakarta.entities.constant.TaskType;
import com.ims.api.jakarta.entities.rest.request.basic.TaskRequest;
import com.ims.api.jakarta.entities.rest.response.basic.IMSBasicResponse;
import com.ims.api.jakarta.entities.rest.response.basic.TaskResponse;

 

@RestController
public class TaskController {

	private final AtomicLong counter = new AtomicLong();	
	
	private static final Logger logger = LogManager.getLogger(TaskController.class);
	
	//private static final String BRI_PCS = "BRI"; //BRI-PCS
	private static final String BRI_PCS = "BRI-PCS"; 
	
	
	enum TypeStatus{DONE,OPEN}
	
	//page Size
	private static final int DATA_SIZE = 5;
	
	
	@Value("${ims.endpoint.url}")
	private String IMS_URL;
	
	@Autowired
	private TaskRepository taskDao;
	
	@PostMapping("/task/get")
	public IMSBasicResponse getTaskByTaskId(
			@RequestBody TaskRequest task) {
	
	
		boolean isSucces = true;
		String message = "OK";
	
		Optional<Task> taskObject = taskDao.findByIdAndClient(task.getTaskId(),BRI_PCS);
		
		
		if(taskObject.isPresent() == Boolean.FALSE) {
			isSucces = false;
			message = String.format("Unable to find task Id : %d", task.getTaskId());
			logger.error(message);
			return new IMSBasicResponse(isSucces, counter.incrementAndGet(),message);	
		}
		
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(task);
			logger.info(json);
		} catch (JsonProcessingException e1) {
			e1.printStackTrace();
			logger.error(e1);
			
		}
		
		
		Task t = taskObject.get();
		TaskResponse tmp = new TaskResponse();
		
		tmp.setTaskID(String.valueOf(t.getTaskId()));
		tmp.setMID(t.getMID());
		tmp.setTID(t.getTID());
		tmp.setMerchant(t.getTerminalName());
		tmp.setTaskStatus(t.getTaskStatus());
		tmp.setTaskType(t.getTaskType());
		tmp.setLongitude(String.valueOf(t.getLongitude()));
		tmp.setLatitude(String.valueOf(t.getLatitude()));
		
		if(t.getPhoto0() != null)
			tmp.setPhoto0(String.format("%simage/taskimage?imagename=%s", IMS_URL,t.getPhoto0()));
		if(t.getPhoto1() != null)
			tmp.setPhoto1(String.format("%simage/taskimage?imagename=%s", IMS_URL,t.getPhoto1()));
		if(t.getPhoto2() != null)
			tmp.setPhoto2(String.format("%simage/taskimage?imagename=%s", IMS_URL,t.getPhoto2()));
		if(t.getPhoto3() != null)
			tmp.setPhoto3(String.format("%simage/taskimage?imagename=%s", IMS_URL,t.getPhoto3()));
		if(t.getPhoto4() != null)
			tmp.setPhoto4(String.format("%simage/taskimage?imagename=%s", IMS_URL,t.getPhoto4()));
		if(t.getPhoto5() != null)
			tmp.setPhoto5(String.format("%simage/taskimage?imagename=%s", IMS_URL,t.getPhoto5()));
		if(t.getSignature() != null)
			tmp.setSignature(String.format("%simage/taskimage?imagename=%s", IMS_URL,t.getSignature()));
		
		
		
		tmp.setSNOld(t.getSNOld());
		tmp.setSNNew(t.getSNNew());
		tmp.setTicketID(t.getTicketID());
		tmp.setTaskDetail(t.getTaskDetail());
		tmp.setMerchantCondition(t.getMerchantCondition());
		tmp.setEDCCondition(t.getEDCCondition());
		tmp.setMerchantInfo(t.getMerchantInfo());
		
		tmp.setDateTimeStatus(t.getDateTimeStatus());
		tmp.setInsertTime(t.getInsertAccess().getInsertDateTime());
		tmp.setPdf(String.format("%stask/print/single/%s~%s~%s~%s~%d", IMS_URL,
				t.getTID(),
				t.getMID(),
				t.getTaskType(),
				t.getClient(),
				t.getTaskId()));
		tmp.setDateTimeStatus(t.getDateTimeStatus());
		tmp.setInsertTime(t.getInsertAccess().getInsertDateTime());		
		
		
		/**
		 * continue...	
		 */
		
		return new IMSBasicResponse(isSucces, counter.incrementAndGet(),tmp);
		
	}
	
	
	
	@PostMapping("/task/getbyticketid")
	public IMSBasicResponse getTaskByTicketId(
			@RequestBody TaskRequest task) {
	
	
		boolean isSucces = true;
		String message = "OK";
	
		List<Task> taskObject = taskDao.findByTicketId(task.getTicketID(),BRI_PCS);
		
		
		if(taskObject.size() == 0) {
			isSucces = false;
			message = String.format("Unable to find ticket Id : %s", task.getTicketID());
			logger.error(message);
			return new IMSBasicResponse(isSucces, counter.incrementAndGet(),message);	
		}
		
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(task);
			logger.info(json);
		} catch (JsonProcessingException e1) {
			e1.printStackTrace();
			logger.error(e1);
			
		}
	
		
		
		Iterator<Task> i = taskObject.iterator();
		List response = new ArrayList();
		while(i.hasNext()) {
			Task t = (Task)i.next();
			
			TaskResponse tmp = new TaskResponse();
			tmp.setTaskID(String.valueOf(t.getTaskId()));
			tmp.setMID(t.getMID());
			tmp.setTID(t.getTID());
			tmp.setTaskType(t.getTaskType());
			tmp.setMerchant(t.getTerminalName());
			tmp.setTaskStatus(t.getTaskStatus());
			tmp.setLongitude(String.valueOf(t.getLongitude()));
			tmp.setLatitude(String.valueOf(t.getLatitude()));
			
			
			if(t.getPhoto0() != null)
				tmp.setPhoto0(String.format("%simage/taskimage?imagename=%s", IMS_URL,t.getPhoto0()));
			if(t.getPhoto1() != null)
				tmp.setPhoto1(String.format("%simage/taskimage?imagename=%s", IMS_URL,t.getPhoto1()));
			if(t.getPhoto2() != null)
				tmp.setPhoto2(String.format("%simage/taskimage?imagename=%s", IMS_URL,t.getPhoto2()));
			if(t.getPhoto3() != null)
				tmp.setPhoto3(String.format("%simage/taskimage?imagename=%s", IMS_URL,t.getPhoto3()));
			if(t.getPhoto4() != null)
				tmp.setPhoto4(String.format("%simage/taskimage?imagename=%s", IMS_URL,t.getPhoto4()));
			if(t.getPhoto5() != null)
				tmp.setPhoto5(String.format("%simage/taskimage?imagename=%s", IMS_URL,t.getPhoto5()));
			if(t.getSignature() != null)
				tmp.setSignature(String.format("%simage/taskimage?imagename=%s", IMS_URL,t.getSignature()));
			
			
			
		
			tmp.setSNOld(t.getSNOld());
			tmp.setSNNew(t.getSNNew());
			tmp.setTicketID(t.getTicketID());
			tmp.setTaskDetail(t.getTaskDetail());
			tmp.setMerchantCondition(t.getMerchantCondition());
			tmp.setEDCCondition(t.getEDCCondition());
			tmp.setMerchantInfo(t.getMerchantInfo());
			
			tmp.setDateTimeStatus(t.getDateTimeStatus());
			tmp.setInsertTime(t.getInsertAccess().getInsertDateTime());
			tmp.setPdf(String.format("%stask/print/single/%s~%s~%s~%s~%d", IMS_URL,
					t.getTID(),
					t.getMID(),
					t.getTaskType(),
					t.getClient(),
					t.getTaskId()));
			tmp.setDateTimeStatus(t.getDateTimeStatus());
			tmp.setInsertTime(t.getInsertAccess().getInsertDateTime());				
	
			
			/**
			 * continue...	
			 */
		
			response.add(tmp);
		}
		
		return new IMSBasicResponse(isSucces, counter.incrementAndGet(),response);
		
	}
	
	
	
	
	@PostMapping("/task/getbyterminalinfo")
	public IMSBasicResponse getTaskByTIDMID(
			@RequestBody TaskRequest task) {
	
	
		boolean isSucces = true;
		String message = "OK";
		Integer page = task.getPage();
	
		if(page == null) {
			isSucces = false;
			message = "Page is required!";
			logger.error(message);
			return new IMSBasicResponse(isSucces, counter.incrementAndGet(),message);	
		}
	
		if(page == 0) {
			isSucces = false;
			message = "Page should be start with 1!";
			logger.error(message);
			return new IMSBasicResponse(isSucces, counter.incrementAndGet(),message);	
			
		}
		
		page = page-1;
		
		
		if(task.getTaskType() == null || task.getTaskType().isEmpty()) {
			isSucces = false;
			message = String.format("taskType should not be empty! (%s, %s, %s, %s, %s)", 
					TaskType.DEPLOY_ID,
					TaskType.REPLACE_ID,
					TaskType.CM_ID,
					TaskType.PM_ID,
					TaskType.PULLOUT_ID
					);
			logger.error(message);
			return new IMSBasicResponse(isSucces, counter.incrementAndGet(),message);	
		}
		
		
		
		if(task.getTaskInMonth() != null && (task.getTaskInMonth() >= 1 && task.getTaskInMonth() <=12) == false ) {
			isSucces = false;
			message = "Invalid month! it should be 1-12";
			logger.error(message);
			return new IMSBasicResponse(isSucces, counter.incrementAndGet(),message);	
		}
		
		
		
		
		
		
		
		String taskType = null;
		
		switch(task.getTaskType()) {
	       	case TaskType.DEPLOY_ID:
	       		taskType = TaskType.DEPLOY; 
	         	break;
	       	case TaskType.REPLACE_ID:
	       		taskType = TaskType.REPLACE; 
           	break;
	       	case TaskType.CM_ID :
	       		taskType = TaskType.CM; 
              break;
	       	case TaskType.PM_ID:
	       		taskType = TaskType.PM; 
      		break;
	       	case TaskType.PULLOUT_ID :
	       		taskType = TaskType.PULLOUT; 
            break;
      }
    	
		
	 
		Pageable pageable = PageRequest.of(page, DATA_SIZE, 
				Sort.by(
			    	Order.desc("taskId"))
				);
		
		
		
		
		List<Task> taskObject;
		
		if(task.getTaskInMonth() == null) {
			taskObject = taskDao.findByTIDMIDTaskTypeAndClient( task.getTID(), task.getMID(),
					taskType,
					BRI_PCS,
					pageable);
		}else {
			taskObject = taskDao.findByTIDMIDMonthAndClient( task.getTID(), task.getMID(),
					taskType,
					BRI_PCS,
					task.getTaskInMonth(),
					pageable);
		}
		
		
		
		
		if(taskObject.size() == 0) {
			isSucces = false;
			message = String.format("Unable to find TID: %s MID :%s", task.getTID(), task.getMID());
			logger.error(message);
			return new IMSBasicResponse(isSucces, counter.incrementAndGet(),message);	
		}
		
		try {
			
			
			
			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
			String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(task);
			logger.info(json);
		} catch (JsonProcessingException e1) {
			e1.printStackTrace();
			logger.error(e1);
			
		}
	
		
		
		Iterator<Task> i = taskObject.iterator();
		List response = new ArrayList();
		while(i.hasNext()) {
			Task t = (Task)i.next();
			
			TaskResponse tmp = new TaskResponse();
			tmp.setTaskID(String.valueOf(t.getTaskId()));
			tmp.setMID(t.getMID());
			tmp.setTID(t.getTID());
			tmp.setTaskType(t.getTaskType());
			tmp.setMerchant(t.getTerminalName());
			tmp.setTaskStatus(t.getTaskStatus());
			tmp.setLongitude(String.valueOf(t.getLongitude()));
			tmp.setLatitude(String.valueOf(t.getLatitude()));
			
			if(t.getPhoto0() != null)
				tmp.setPhoto0(String.format("%simage/taskimage?imagename=%s", IMS_URL,t.getPhoto0()));
			if(t.getPhoto1() != null)
				tmp.setPhoto1(String.format("%simage/taskimage?imagename=%s", IMS_URL,t.getPhoto1()));
			if(t.getPhoto2() != null)
				tmp.setPhoto2(String.format("%simage/taskimage?imagename=%s", IMS_URL,t.getPhoto2()));
			if(t.getPhoto3() != null) 
				tmp.setPhoto3(String.format("%simage/taskimage?imagename=%s", IMS_URL,t.getPhoto3()));
			if(t.getPhoto4() != null)
				tmp.setPhoto4(String.format("%simage/taskimage?imagename=%s", IMS_URL,t.getPhoto4()));
			if(t.getPhoto5() != null)
				tmp.setPhoto5(String.format("%simage/taskimage?imagename=%s", IMS_URL,t.getPhoto5()));
			if(t.getSignature() != null)
				tmp.setSignature(String.format("%simage/taskimage?imagename=%s", IMS_URL,t.getSignature()));
			

			tmp.setSNOld(t.getSNOld());
			tmp.setSNNew(t.getSNNew());
			tmp.setTicketID(t.getTicketID());
			tmp.setTaskDetail(t.getTaskDetail());
			tmp.setMerchantCondition(t.getMerchantCondition());
			tmp.setEDCCondition(t.getEDCCondition());
			tmp.setMerchantInfo(t.getMerchantInfo());
		
			//display DONE only
			tmp.setPdf(String.format("%stask/print/single/%s~%s~%s~%s~%d", IMS_URL,
					t.getTID(),
					t.getMID(),
					t.getTaskType(),
					t.getClient(),
					t.getTaskId()));
			tmp.setDateTimeStatus(t.getDateTimeStatus());
			tmp.setInsertTime(t.getInsertAccess().getInsertDateTime());
			
			/**
			 * continue...	
			 */
		
			response.add(tmp);
		}
		
		
		return new IMSBasicResponse(isSucces, counter.incrementAndGet(),response, Long.valueOf(taskObject.size())  );
		
	}

	
	
	
	 
	
	
}
