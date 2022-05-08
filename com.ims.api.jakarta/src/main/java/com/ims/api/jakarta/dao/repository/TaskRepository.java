package com.ims.api.jakarta.dao.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.ims.api.jakarta.entities.Task;

public interface TaskRepository extends CrudRepository<Task, Long>{
 
	@Query("from Task where taskId =:taskId AND active = 1 AND client=:client")
	public Optional<Task> findByIdAndClient(@Param("taskId") Long taskId, @Param("client") String client);
	

	@Query("from Task where TID =:TID AND MID =:MID AND taskStatus = 'DONE' AND taskType=:taskType AND active = 1 AND client=:client AND MONTH(dateTimeStatus) =:in_month AND YEAR(dateTimeStatus) = YEAR(NOW())")
	public List<Task> findByTIDMIDMonthAndClient(
				@Param("TID") String TID,
				@Param("MID") String MID, 
				@Param("taskType") String taskType, 
				@Param("client") String client,
				@Param("in_month") Integer in_month,
				Pageable pageable);

	@Query("from Task where TID =:TID AND MID =:MID AND taskStatus = 'DONE' AND taskType=:taskType AND active = 1 AND client=:client")
	public List<Task> findByTIDMIDTaskTypeAndClient(
				@Param("TID") String TID,
				@Param("MID") String MID, 
				@Param("taskType") String taskType, 
				@Param("client") String client,
				Pageable pageable);

	
	
	
	@Query("from Task where ticketID =:ticketID AND active = 1 AND client=:client")
	public List<Task> findByTicketId(@Param("ticketID") String ticketID, @Param("client") String client);
	
	@Query("from Task where hitToClient IN (0) AND active = 1 AND client='BRI-PCS'")
	public List<Task> findByTaskNotAlreadySubmittedForPCS();
	
	@Transactional
	@Modifying
	@Query("Update Task SET hitToClient =:hitToClient where client='BRI-PCS' AND taskId=:taskId")
	public int updateHitStatus(@Param("hitToClient") int hitToClient, @Param("taskId") Long taskId);
	
	
	
	
	
}
