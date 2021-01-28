package VolunteerManager.VolunteerMangementSystem;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class ServiceClass implements ServiceInterface {

	@Autowired
	DOA doa;
	
	@Override
	public List<AllEvents> getAllEvents() {
		// TODO Auto-generated method stub
		return doa.getAllEvents();
	}

	@Override
	public List<Volunteers> getAllVolunteers() {
		// TODO Auto-generated method stub
		return doa.getAllVolunteers();
	}

	@Override
	public void addVolunteer(VolunteerWithRegisteredEvent v) {
		// TODO Auto-generated method stub

			doa.addVolunteer(v);
	}

	@Override
	public List<VolunteerWithRegisteredEvent> getAllVolRegisteredWithEvent() {
		// TODO Auto-generated method stub
		return doa.getAllVolRegistered();
	}

	@Override
	public AllEvents getEventData(String eventnameregistered) {
		// TODO Auto-generated method stub
		return doa.getEventData(eventnameregistered);
	}

	@Override
	public void deleteTheVolunteer(String volunteername) {
		// TODO Auto-generated method stub
		doa.deleteTheVolunteer(volunteername);
	}

	@Override
	public List<AllEvents> getEventsOnType(String s) {
		// TODO Auto-generated method stub
		return doa.getEventsByType(s);
	}

	@Override
	public List<AllEvents> sortOnDate() {
		// TODO Auto-generated method stub
		return doa.sortOnDate();
	}

	@Override
	public List<AllEvents> sortOnCity() {
		// TODO Auto-generated method stub
		return doa.sortOnCity();
	}

	@Override
	public void updateTheVolunteerActions(String volunteername, String reviewResult) {
		// TODO Auto-generated method stub
		
		doa.updateTheVolunteer(volunteername,reviewResult);
		
	}

	

	

	
	

	
	
}
