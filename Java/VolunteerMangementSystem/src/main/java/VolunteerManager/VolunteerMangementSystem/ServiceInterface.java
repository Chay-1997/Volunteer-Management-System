package VolunteerManager.VolunteerMangementSystem;

import java.util.List;

public interface ServiceInterface {

	List<AllEvents> getAllEvents();

	List<Volunteers> getAllVolunteers();

	void addVolunteer(VolunteerWithRegisteredEvent v);

	List<VolunteerWithRegisteredEvent> getAllVolRegisteredWithEvent();

	AllEvents getEventData(String eventnameregistered);

	void deleteTheVolunteer(String volunteername);

	List<AllEvents> getEventsOnType(String s);

	List<AllEvents> sortOnDate();

	List<AllEvents> sortOnCity();

	void updateTheVolunteerActions(String volunteername, String reviewResult);

	

}
