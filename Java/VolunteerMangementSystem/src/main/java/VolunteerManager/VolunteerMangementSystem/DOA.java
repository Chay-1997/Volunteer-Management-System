package VolunteerManager.VolunteerMangementSystem;

import java.util.Comparator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class DOA {
	
	@Autowired
	AllEventsInterface aie;
	
	@Autowired
	VolunteerInterface vi;
	
	@Autowired
	VolunteerAndEventInterface ve;
	

	public List<AllEvents> getAllEvents() {
		// TODO Auto-generated method stub
		List<AllEvents> l=aie.findAll();
		return l;
	}

	public List<Volunteers> getAllVolunteers() {
		// TODO Auto-generated method stub
		List<Volunteers>l=vi.findAll();
		return l;
	}

	public void addVolunteer(VolunteerWithRegisteredEvent v) {
		// TODO Auto-generated method stu
		ve.save(v);
		Volunteers vo=new Volunteers(0,v.getVolunteername(),v.getAge(),v.getQualification(),v.getEmail(),v.getAddress(),v.getMobilenumber(),"");
		
		vi.save(vo);
		
		
		
		
		
		
	}

	public List<VolunteerWithRegisteredEvent> getAllVolRegistered() {
		// TODO Auto-generated method stub
		List<VolunteerWithRegisteredEvent>l=ve.findAll();
		return l;
	}

	public AllEvents getEventData(String eventnameregistered) {
		// TODO Auto-generated method stub
		return aie.findByEventName(eventnameregistered);
	}

	public void deleteTheVolunteer(String volunteername) {
		// TODO Auto-generated method stub
		vi.deleteByvolunteername(volunteername);
		ve.deleteByvolunteername(volunteername);
		
		
	}

	@org.springframework.data.jpa.repository.Query("From AllEvents ae where ae.eventName LIKE s%")
	public List<AllEvents> getEventsByType(String s) {
		// TODO Auto-generated method stub
		
		//return aie.findByEventNameLike(s);
		List<AllEvents>ls= aie.findByEventName2(s);
		return ls;
		
		
		
		
		
	}

	public List<AllEvents> sortOnDate() {
		// TODO Auto-generated method stub
		List<AllEvents> tobesorted=aie.findAll();
		
		Comparator<AllEvents> day=new SortOnDay();
		tobesorted.sort(day);
		
		Comparator<AllEvents> mon=new SortOnMonth();
		tobesorted.sort(mon);
		
		Comparator<AllEvents> year=new SortOnYear();
		tobesorted.sort(year);

		
		
		
		
		
		return tobesorted;
	}
	
	
	
	public List<AllEvents> sortOnCity()
	{
		List<AllEvents> ls=aie.findAll();
		Comparator<AllEvents> city=new SortOnCity();
		ls.sort(city);
		return ls;
		
	}

	public void updateTheVolunteer(String volunteername, String reviewResult) {
		// TODO Auto-generated method stu
		//Volunteers vs=vi.findByvolunteername(volunteername);
		//System.out.println(vs.getVolunteername());
		
		
		//Volunteers vup=new Volunteers(vs.getVolunteerid(),vs.getVolunteername(),vs.getAge(),vs.getQualification(),vs.getEmail(),vs.address,vs.getMobileno(),reviewResult);
		//vi.save(vup);
		
		List<Volunteers> ls=vi.findAll();
		
		for(int i=0;i<ls.size();i++)
		{
			if(ls.get(i).getVolunteername().equals(volunteername))
			{
				ls.get(i).setReview(reviewResult);
			}
			
			
		}
		
		vi.saveAll(ls);
		
		
		
		
		
	}

}
