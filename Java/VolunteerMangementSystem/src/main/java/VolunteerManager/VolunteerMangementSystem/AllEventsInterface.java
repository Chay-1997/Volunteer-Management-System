package VolunteerManager.VolunteerMangementSystem;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AllEventsInterface extends JpaRepository<AllEvents,Integer>{
	
	
	public AllEvents findByEventName(String event_name);
	
	
	@Query("Select ae from AllEvents ae where ae.eventName LIKE ?1%")
	public List<AllEvents> findByEventName2(String eventName);
	

}
