package VolunteerManager.VolunteerMangementSystem;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api/rest")
public class RestController {
	
//	@Autowired
//	ServiceInterface service;
//	
////	@GetMapping("/getAllEvents")
////	@CrossOrigin
////	@PreAuthorize("hasRole('VOLUNTEER') or hasRole('ADMIN') or hasRole('EVENTORG') ")
////	public List<AllEvents> getAllEvents()
////	{
////		return service.getAllEvents();
////	}
//	
//	
//	@GetMapping("/getAllVolunteers")
//	@CrossOrigin
//	public List<Volunteers>getAllVolunteers()
//	{
//		return service.getAllVolunteers();
//	}
//	
//	
//	@PostMapping("/addVolunteer")
//	@CrossOrigin
//	public String addVolunteer(@RequestBody VolunteerWithRegisteredEvent v)
//	{
//		
//		service.addVolunteer(v);
//		
//		
//		AllEvents al=service.getEventData(v.getEventnameregistered());
//		
//		String num="+91"+v.getMobilenumber();
//		
//		   String ACCOUNT_SID = "AC38477e21658f674575f11fb278f8fac6"; 
//		     String AUTH_TOKEN ="e75b0dba659cdc68367fd3527d8f70b7";
//		     Twilio.init(ACCOUNT_SID, AUTH_TOKEN); 
//		     Message message = Message.creator( new
//		    		 com.twilio.type.PhoneNumber("whatsapp:"+num), new
//		    		  com.twilio.type.PhoneNumber("whatsapp:+14155238886"),
//		    		  al.getEvent_name()+"\n"+al.getCity()+"\n"+al.getTime()+"\n"+al.address+"\n"+al.getDate_of_event()) .create();
//		    		 
//		     
//		            System.out.println(message.getSid()); 
//		
//		
//		return "Hey "+v.volunteername+" thank for registereing we have sent event details on your whatsapp!!!";
//	}
//	
//
//	@GetMapping("/reviewTheVolunteer/{review}/{volunteername}")
//	@CrossOrigin
//	@Transactional
//	public String reviewTheVol(@PathVariable String review,@PathVariable String volunteername)
//	{
//			String text = review;
//
//	     SentimentAnalyzer sentimentAnalyzer = new SentimentAnalyzer();
//
//	     sentimentAnalyzer.initialize();
//
//	     SentimentResult sentimentResult = sentimentAnalyzer.getSentimentResult(text);
//
//	     System.out.println("Sentiments Classification:");
//
//	     System.out.println("Very positive: " + sentimentResult.getSentimentClass().getVeryPositive()+"%");
//
//	     System.out.println("Positive: " + sentimentResult.getSentimentClass().getPositive()+"%");
//
//	     System.out.println("Neutral: " + sentimentResult.getSentimentClass().getNeutral()+"%");
//
//	     System.out.println("Negative: " + sentimentResult.getSentimentClass().getNegative()+"%");
//
//	     System.out.println("Very negative: " + sentimentResult.getSentimentClass().getVeryNegative()+"%");
//
//	     System.out.println("\nSentiments result:");
//
//	     System.out.println("Sentiment Score: " + sentimentResult.getSentimentScore());
//
//	     System.out.println("Sentiment Type: " + sentimentResult.getSentimentType());
//	  String reviewResult=sentimentResult.getSentimentType();
//	  
//	  String s="Hey The Review is "+reviewResult+" Thank You For Your Feedback";
//	  
//	  if(reviewResult.equals("Negative") || reviewResult.contentEquals("Very negative"))
//	  {
//		  s="Hey Review Has be recoreded and actions are being taken thank you";
//		  
//		  //service.deleteTheVolunteer(volunteername);	
//		  service.updateTheVolunteerActions(volunteername,reviewResult);
//	  
//	  }
//	  else 
//	  {
//		  service.updateTheVolunteerActions(volunteername,reviewResult);
//		  
//	  }
//	  
//	  
//	  
//		
//		return s;
//	}
//	
//	
//	
//	
//	@GetMapping("/getAllRegisteredVolunteersWithEvent")
//	@CrossOrigin
//	@Transactional
//	public List<VolunteerWithRegisteredEvent> getAll()
//	{
//		return service.getAllVolRegisteredWithEvent();
//	
//	}
//	
//	
//	
//	@GetMapping("/sendInviteViaWhatsApp/{mobileno}")
//	@CrossOrigin
//	public String sendInvite(@PathVariable String mobileno)
//	{
//		String num="+91"+mobileno;
//		List<AllEvents>le=service.getAllEvents();
//		
//		String ACCOUNT_SID = "AC38477e21658f674575f11fb278f8fac6"; 
//	     String AUTH_TOKEN ="e75b0dba659cdc68367fd3527d8f70b7";
//	     Twilio.init(ACCOUNT_SID, AUTH_TOKEN); 
//	     Message message = Message.creator( new
//	    		 com.twilio.type.PhoneNumber("whatsapp:"+num), new
//	    		  com.twilio.type.PhoneNumber("whatsapp:+14155238886"),
//	    		  
//	    		 "Hey Amigo Hope Your Doing Well We Had To Keep You Updated With All The Things Happeneing"+"\n"+
//	    		 "These Are Some Events"+"\n"+
//	    		 "Event Name :"+le.get(0).eventName+"\n"+
//	    		 "Event Name :"+le.get(1).eventName+"\n"+
//	    		 "Event Name :"+le.get(2).eventName+"\n"+
//	    		 "Event Name :"+le.get(3).eventName+"\n"+
//	    		 "Event Name :"+le.get(4).eventName+"\n"+
//	    		 
//	    		 "Get Register Yourself and get going Cheers!!!").create();
//	    		 
//	     
//	            System.out.println(message.getSid()); 
//	
//	
//	return "Invite Sent!!!";///"whatspapp:28928u0129u"
//		
//		
//		}
//	
//	
//	
//	@GetMapping("/searchEventOnName/{name}")
//	@CrossOrigin
//	public List<AllEvents> getEventByName(@PathVariable String name)
//	{
//		
//		return service.getEventsOnType(name);
//		
//		
//		
//	}
//	
//	
//	@GetMapping("/EventSortOnDate")
//	@CrossOrigin
//	
//	public List<AllEvents> sortOnDate()
//	{
//		return service.sortOnDate();
//		
//	}
//	
//	@GetMapping("/EventSortOnCity")
//	@CrossOrigin
//	
//	public List<AllEvents> sortOnCity()
//	{
//		return service.sortOnCity();
//	}
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
