package com.ims.api.jakarta.config.utils.poster;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ims.api.jakarta.config.SchedulingConfig;
import com.ims.api.jakarta.dao.repository.TaskRepository;
import com.ims.api.jakarta.entities.Task;
import com.ims.api.jakarta.entities.constant.TaskType;
import com.ims.api.jakarta.entities.rest.response.basic.PCSResponse;

/*
 * 
 * 
 * 
Update Tiket
URL : /pcs/updateTicket
required POST : 
- status
- dateTime
- keterangan
- lat
- long
- idTicket

Ticket Progress
URL : /pcs/ticketProgress
required POST :
- caseId

Request EDC
URL : /pcs/reqEDC
required POST :
- POI
- snCurrent
- snNew
- keterangan
 */

//Sandy : set @Configuration to enable all annotations
@Configuration
public class TaskPoster implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3110934903128646541L;
	
 	private static Logger logger = LogManager.getLogger(TaskPoster.class);

	@Value("${ims.internal.endpoint.url}")
	private String endpoint;
	
	public static String IMS_INTERNAL_URL;

	@PostConstruct
	private void init(){
		IMS_INTERNAL_URL = endpoint;
	}
	
	
	
	
	public static int post(Task task, TaskRepository taskDao) {
		
		 try {
		
			 String URL_UPDATE = String.format("%spcs/updateTicketMidTid", TaskPoster.IMS_INTERNAL_URL);
			
			 logger.info(String.format("HitToUrl=%s", URL_UPDATE));
			 
			 CloseableHttpClient client = HttpClients.createDefault();
			 HttpPost httpPost = new HttpPost(URL_UPDATE);
			 List<NameValuePair> params = new ArrayList<NameValuePair>();
			 
			 
			 DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
			 String strDate = null;
			 
			 /**
			  * status
			  * 1 : IN PROGRESS
			  * 2 : PENDING
			  * 3 : DONE
			  */
	        
	        int status = 0;
	      
	        if(task.getTaskStatus().trim().toUpperCase().equals("DONE")) {
	         	 status = 3;
	         	 strDate = dateFormat.format(task.getDateTimeStatus());  
	        }
	        
	        String taskType = task.getTaskType();
	        int ticketType = 0;
	        switch(taskType) {
		       	case TaskType.DEPLOY :
		      		ticketType = 1;
		         	break;
		       	case TaskType.REPLACE:
	        		ticketType = 2;
	             	break;
	        	case TaskType.CM :
	        		//deprecated, CM not supported
	          		ticketType = 3;
	                break;
		       	case TaskType.PM:
		        	ticketType = 4;
	        		break;
	        	case TaskType.PULLOUT :
	        		ticketType = 5;
	                break;
	        }
	        
	    	
	     	params.add(new BasicNameValuePair("ticketType", 	String.valueOf(ticketType)	));
			params.add(new BasicNameValuePair("status", 		String.valueOf(status)	));
			params.add(new BasicNameValuePair("dateTime", 		strDate));
			params.add(new BasicNameValuePair("keterangan", 	task.getNote()));
			params.add(new BasicNameValuePair("lat", 			String.valueOf( task.getLatitude()) ));
			params.add(new BasicNameValuePair("long", 			String.valueOf( task.getLongitude()) ));
			params.add(new BasicNameValuePair("taskID", 		String.valueOf( task.getTaskId() ) ));
			params.add(new BasicNameValuePair("MID", 			task.getMID() ));
			params.add(new BasicNameValuePair("TID", 			task.getTID() ));
	
			 
			 
			httpPost.setEntity(new UrlEncodedFormEntity(params));
			HttpEntity h = httpPost.getEntity();
			CloseableHttpResponse response = client.execute(httpPost);
			String requestContent = EntityUtils.toString(h);
			logger.info("request  = " + requestContent);
			String responseString = new BasicResponseHandler().handleResponse(response);
			
			 
			ObjectMapper mapper = new ObjectMapper();
			PCSResponse res = mapper.readValue(responseString,PCSResponse.class);
	
			String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(res);
			
			logger.info("response = " + json);
			
			return res.getCode();
			
			 
			 } catch (UnsupportedEncodingException e) {
				e.printStackTrace();
				logger.error(e.getMessage());
				logger.error(e);
			} catch (ClientProtocolException e) {
				e.printStackTrace();
				logger.error(e.getMessage());
				logger.error(e);
			} catch (IOException e) {
				e.printStackTrace();
				logger.error(e.getMessage());
				logger.error(e);
			}
	
			return -1;
		
		
		
	}
	
	
	
	
	
	public static int postTicket(Task task, TaskRepository taskDao) {
		
		 try {
		
		 String URL_UPDATE = String.format("%spcs/updateTicket", TaskPoster.IMS_INTERNAL_URL);
		
		 logger.info(String.format("HitToUrl=%s", URL_UPDATE));
			
		 
		 
		 CloseableHttpClient client = HttpClients.createDefault();
		 HttpPost httpPost = new HttpPost(URL_UPDATE);
		 List<NameValuePair> params = new ArrayList<NameValuePair>();
		 
		 
		 DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		 String strDate = null;
		 
		 
         
         int status = 0;
       
         if(task.getTaskStatus().trim().toUpperCase().equals("DONE")) {
          	 status = 3;
    		 strDate = dateFormat.format(task.getDateTimeStatus());  
         }
         
         
      
         params.add(new BasicNameValuePair("idTicket", 		task.getTicketID())); 
		 params.add(new BasicNameValuePair("status", 		String.valueOf(status)	));
		 params.add(new BasicNameValuePair("dateTime", 		strDate));
		 params.add(new BasicNameValuePair("keterangan", 	task.getNote()));
		 params.add(new BasicNameValuePair("lat", 			String.valueOf( task.getLatitude()) ));
		 params.add(new BasicNameValuePair("long", 			String.valueOf( task.getLongitude()) ));
		 params.add(new BasicNameValuePair("taskID", 		String.valueOf( task.getTaskId() ) ));

		 
		 
		 httpPost.setEntity(new UrlEncodedFormEntity(params));
		 HttpEntity h = httpPost.getEntity();
		 CloseableHttpResponse response = client.execute(httpPost);
		 String requestContent = EntityUtils.toString(h);
		 logger.info("request  = " + requestContent);
		 String responseString = new BasicResponseHandler().handleResponse(response);
		
		 
		 ObjectMapper mapper = new ObjectMapper();
		 PCSResponse res = mapper.readValue(responseString,PCSResponse.class);
		 String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(res);
		
		 logger.info("response = " + json);
		
		return res.getCode();
		
		 
		 } catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			logger.error(e);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			logger.error(e);
		} catch (IOException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			logger.error(e);
		}

		return -1;
		
		
		
	}

	
	

}
