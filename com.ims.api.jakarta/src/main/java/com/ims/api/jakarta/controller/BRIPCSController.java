package com.ims.api.jakarta.controller;


import java.util.Date;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import javax.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ims.api.jakarta.dao.repository.CityRepository;
import com.ims.api.jakarta.dao.repository.SIKCorrectiveRepository;
import com.ims.api.jakarta.dao.repository.SIKRepository;
import com.ims.api.jakarta.entities.City;
import com.ims.api.jakarta.entities.SIK;
import com.ims.api.jakarta.entities.SIKCorrective;
import com.ims.api.jakarta.entities.embedded.InsertAccess;
import com.ims.api.jakarta.entities.rest.request.basic.SIKCMRequest;
import com.ims.api.jakarta.entities.rest.request.basic.SIKRequest;
import com.ims.api.jakarta.entities.rest.response.basic.IMSBasicResponse;
import com.ims.api.jakarta.entities.rest.response.basic.SIKResponse;

 

@RestController
public class BRIPCSController {

	private final AtomicLong counter = new AtomicLong();	
	
	private static final Logger logger = LogManager.getLogger(BRIPCSController.class);
	
	
	@Value("${ims.api.endpoint.url}")
	private String IMS_API_URL;

	
	@Autowired
	private SIKRepository SIKDao;
	
	@Autowired
	private CityRepository cityDao;
	
	@Autowired
	private SIKCorrectiveRepository SIKCMDao;
	
	/*	
	@GetMapping("/bri")
	public String index() {
		return "OKKKKK!";
	}*/
	
	
	@PostMapping("/bri/sik/get")
	public IMSBasicResponse sikChecker(
			@RequestBody SIKRequest sik) {
	
	
		boolean isSucces = true;
		String message = "OK";
	
		String SIKKey = String.format("%s-%s-%s-%s", 
				sik.getSIKNumber(),
				sik.getTID(),
				sik.getMID(),
				sik.getRequestType());

		Optional<SIK> sikObject = SIKDao.findById(SIKKey);
		
		
		if(sikObject.isPresent() == Boolean.FALSE) {
			isSucces = false;
			message = String.format("Unable to find : %s", SIKKey);
			logger.error(message);
			return new IMSBasicResponse(isSucces, counter.incrementAndGet(),message);	
		}
		
		
		SIKResponse response = new SIKResponse();
		SIK loadSIK = sikObject.get();
		
		
		response.setMID(loadSIK.getMID());
		response.setTID(loadSIK.getTID());
		response.setMerchant(loadSIK.getMerchant());
		response.setSIKNumber(loadSIK.getNoSIK());
		response.setRequestType(loadSIK.getStatusJOB());
		
		/**
		 * continue...	
		 */
		
		return new IMSBasicResponse(isSucces, counter.incrementAndGet(),response);
		
	}
	
	
	
	
	@PostMapping("/bri/sik/create")
	public IMSBasicResponse create(
			@RequestBody SIKRequest sik) {
	
		boolean isSucces = true;
		String message;
		
		
		
		Optional<City> city = cityDao.findById(sik.getCity());
		
		if(city.isPresent() == Boolean.FALSE) {
			isSucces = false;
			message = String.format("Unable to find city '%s', please see %scity/all", sik.getCity(), IMS_API_URL);
			logger.error(message);
			return new IMSBasicResponse(isSucces, counter.incrementAndGet(),message);
		}
		
		
		
		
		
		String SIKKey = String.format("%s-%s-%s-%s", sik.getSIKNumber(),sik.getTID(),sik.getMID(),sik.getRequestType());
	
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(sik);
			logger.info(json);
		} catch (JsonProcessingException e1) {
			e1.printStackTrace();
			logger.error(e1);
			
		}
		
		Optional<SIK> sikObject = SIKDao.findById(SIKKey);
		
		if(sikObject.isPresent()) {
			isSucces = false;
			message = String.format("Duplicate SIK: %s %s %s %s", 
					sik.getSIKNumber(),
					sik.getTID(),
					sik.getMID(),
					sik.getRequestType()
					);
			logger.error(message);
			return new IMSBasicResponse(isSucces, counter.incrementAndGet(),message);	
		}

		
		
		
		
		try {
			
			InsertAccess insert = new InsertAccess();
			insert.setCreatedBy("api-system");
			insert.setInsertDateTime(new Date());
			SIK s = new SIK();
			s.setInsertAccess(insert);
			s.setSIKKey(SIKKey); 
			s.setClient("BRI-PCS");
			s.setCity(sik.getCity());
			s.setKanwilIndopay(city.get().getKanwilIndopay().toUpperCase());
			s.setServicePoint(city.get().getServicePoint().toUpperCase());
			s.setNoSIK(sik.getSIKNumber());
			s.setMID(sik.getMID());
			s.setTID(sik.getTID());
			s.setAlamat(sik.getAddress());
			s.setStatusJOB(sik.getRequestType());
			s.setTglRequest(sik.getRequestDate());
			s.setPeruntukkanEDC(sik.getEDCOwner());
			s.setKartuDebetBRI(sik.getBRIDebet());
			s.setKartuKreditBRI(sik.getBRICredit());
			s.setKartuBrizzi(sik.getBrizzi());
			s.setKartuBankLain(sik.getOthersCard());
			s.setJarkomEDC(sik.getCommType());
			s.setMerchant(sik.getMerchant());
			s.setAlamat(sik.getAddress());
			s.setKota(sik.getCity());
			s.setTelp(sik.getPhoneNumber());
			s.setTglImplementasi(sik.getImplementationDate());
			s.setGroup(sik.getMerchantGroup());
			s.setUkerPerekomendasi(sik.getWorkUnitRecommendation());
			s.setPeriodeEvent(sik.getEventPeriod());
			s.setSN(sik.getSN());
			s.setICCID(sik.getICCID());
			s.setRefId(sik.getRefId());
			s.setPIC(sik.getPic());
			
			
			SIKDao.save(s);
			message = String.format("SIK has been created! : %s", sik.getSIKNumber());
		}catch (Exception e) {
			message = String.format("%s", "SIK creation failed, please check log for detail..");
			//e.printStackTrace();
			logger.error(e);
			logger.error("Localize : " + e.getLocalizedMessage());
			logger.error("Message : " + e.getMessage());

			isSucces = false;
		}
		
		return new IMSBasicResponse(isSucces, counter.incrementAndGet(),message);
	}
	

	
	@PostMapping("/bri/sik/cm/create")
	public IMSBasicResponse CMCreate(
			@RequestBody SIKCMRequest sik) {
	
		boolean isSucces = true;
		String message;
		
		
		
		Optional<City> city = cityDao.findById(sik.getCity());
		
		if(city.isPresent() == Boolean.FALSE) {
			isSucces = false;
			message = String.format("Unable to find city '%s', please see %scity/all", sik.getCity(), IMS_API_URL);
			logger.error(message);
			return new IMSBasicResponse(isSucces, counter.incrementAndGet(),message);
		}
		
		
		
		
		
		
	
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(sik);
			logger.info(json);
		} catch (JsonProcessingException e1) {
			e1.printStackTrace();
			logger.error(e1);
			
		}
		
		Optional<SIKCorrective> sikObject = SIKCMDao.findById(sik.getTicketNumber());
		
		if(sikObject.isPresent()) {
			isSucces = false;
			message = String.format("Duplicate TicketNumber: %s", 
					sik.getTicketNumber());
			logger.error(message);
			return new IMSBasicResponse(isSucces, counter.incrementAndGet(),message);	
		}
		
		
		
		try {
			
			SIKCorrective cm = new SIKCorrective();
			InsertAccess insert = new InsertAccess();
			insert.setCreatedBy("api-system");
			insert.setInsertDateTime(new Date());
			cm.setInsertAccess(insert);
			cm.setTiketNumber(sik.getTicketNumber());
			cm.setMid(sik.getMid());
			cm.setTid(sik.getTid());
			cm.setClient("BRI-PCS");
			cm.setMerchantName(sik.getMerchant());
			cm.setAddress(sik.getAddress());
			cm.setRequestDate(sik.getRequestDate());
			cm.setAgent(sik.getAgent());
			cm.setCases(sik.getCases());
			cm.setCity(sik.getCity());
			cm.setPic(sik.getPic());
			cm.setPhoneNumber(sik.getPhoneNumber());
			cm.setSn(sik.getSn());
			cm.setNote(sik.getNote());
			cm.setDueDate(sik.getDueDate());
			cm.setClient("BRI-PCS");
			cm.setKanwilIndopay(city.get().getKanwilIndopay());
			cm.setServicePoint(city.get().getServicePoint());
			cm.setStatus("OPEN");
			
			SIKCMDao.save(cm);
			message = String.format("Ticket Number has been created! : %s", sik.getTicketNumber());
		}catch (Exception e) {
			message = String.format("%s", "SIK creation failed, please check log for detail..");
			logger.error(e);
			logger.error("Localize : " + e.getLocalizedMessage());
			logger.error("Message : " + e.getMessage());

			isSucces = false;
		}
		
		return new IMSBasicResponse(isSucces, counter.incrementAndGet(),message);
	}
	

	
	
}
