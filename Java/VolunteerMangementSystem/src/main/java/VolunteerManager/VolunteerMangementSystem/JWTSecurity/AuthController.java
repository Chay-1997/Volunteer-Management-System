package VolunteerManager.VolunteerMangementSystem.JWTSecurity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

import VolunteerManager.VolunteerMangementSystem.AllEvents;
import VolunteerManager.VolunteerMangementSystem.AllEventsInterface;
import VolunteerManager.VolunteerMangementSystem.SentimentAnalyzer;
import VolunteerManager.VolunteerMangementSystem.SentimentResult;
import VolunteerManager.VolunteerMangementSystem.ServiceInterface;
import VolunteerManager.VolunteerMangementSystem.VolunteerAndEventInterface;
import VolunteerManager.VolunteerMangementSystem.VolunteerInterface;
import VolunteerManager.VolunteerMangementSystem.VolunteerWithRegisteredEvent;
import VolunteerManager.VolunteerMangementSystem.Volunteers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	UserRepositiry userRepository;
	
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	PasswordEncoder encoder;
	
	
	@Autowired
	JwtUtils jwtUtils;
	
	@Autowired
	VolunteerInterface vir;
	@Autowired
	AllEventsInterface ae;
	
	
@PostMapping("/signin")
	
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest)
	{
		
		Authentication authentication=authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						loginRequest.getUsername(), 
						loginRequest.getPassword()));
		
		
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt=jwtUtils.generateJwtToken(authentication);
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();		
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(new JwtResponse(jwt, 
												 userDetails.getId(), 
												 userDetails.getUsername(), 
												 userDetails.getEmail(), 
												 roles));
		
		
		
		
	}








	





@PostMapping("/registervolunteer")
public  ResponseEntity<?> registerVol(@RequestBody RegisteringClass rc)
{
	SignupRequest sq=new SignupRequest();
	sq.setUsername(rc.getName());
	sq.setEmail(rc.getEmail());
	sq.setPassword(rc.getPassword());
	sq.setRole(null);
	Volunteers vr=new Volunteers(0,rc.getName(),rc.getAge(),rc.getQualification(),rc.getEmail(),rc.getAddress(),rc.getNumber(),"");
	
	vir.save(vr);
	
	
	
	
	return registerUser(sq);
	
	
	
	
}
	








//@PostMapping("/signup")

public ResponseEntity<?>registerUser(@Valid @RequestBody SignupRequest signUprequest)
{
	if(userRepository.existsByUsername(signUprequest.getUsername())) {
		
		return ResponseEntity.badRequest().
				body
				(new MessageResponse("Error:User is Already Taken"));
		
	}
	
	if (userRepository.existsByEmail(signUprequest.getEmail())) {
		return ResponseEntity
				.badRequest()
				.body(new MessageResponse("Error: Email is already in use!"));
	}
	
	User user = new User(signUprequest.getUsername(), 
			 signUprequest.getEmail(),
			 encoder.encode( signUprequest.getPassword()));
	
	Set<String> strRoles=signUprequest.getRole();
	System.out.println(signUprequest.getRole());
	Set<Role>roles=new HashSet();
	
	
	
	if(strRoles==null)
	{
		Role vol = roleRepository.findByName(ERoles.ROLE_VOLUNTEER)
				.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		roles.add(vol);
		
	}
	else
	{
		strRoles.forEach(role->{
			switch(role) {
			
			
			case "admin":
				
				Role adminRole = roleRepository.findByName(ERoles.ROLE_ADMIN)
				.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
				roles.add(adminRole);
			
			
			break;
			
			case "volunteer":
				Role volunter = roleRepository.findByName(ERoles.ROLE_VOLUNTEER)
				.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		roles.add(volunter);
		break;
				
		
			default:
				Role eventOrg = roleRepository.findByName(ERoles.ROLE_EVENTORG)
				.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		roles.add(eventOrg);
		
		
				
			}	
			});
		
	}
	
	
	user.setRoles(roles);
	userRepository.save(user);
	
	return ResponseEntity.ok(new MessageResponse("Registered"));
	
	
	
	
	
	
	
}


@Autowired
ServiceInterface service;

@GetMapping("/getAllEvents")
@PreAuthorize("hasRole('ROLE_VOLUNTEER') or hasRole('ROLE_ADMIN')")
public List<AllEvents> getAllEvents()
{
	return service.getAllEvents();
}


@GetMapping("/getAllVolunteers")
@CrossOrigin
@PreAuthorize("hasRole('ROLE_ADMIN')")
public List<Volunteers>getAllVolunteers()
{
	return service.getAllVolunteers();
}


@PostMapping("/addVolunteer")
@CrossOrigin
public String addVolunteer(@RequestBody VolunteerWithRegisteredEvent v)
{
	
	service.addVolunteer(v);
	
	
	AllEvents al=service.getEventData(v.getEventnameregistered());
	
	String num="+91"+v.getMobilenumber();
	
	   String ACCOUNT_SID = "AC38477e21658f674575f11fb278f8fac6"; 
	     String AUTH_TOKEN ="e75b0dba659cdc68367fd3527d8f70b7";
	     Twilio.init(ACCOUNT_SID, AUTH_TOKEN); 
	     Message message = Message.creator( new
	    		 com.twilio.type.PhoneNumber("whatsapp:"+num), new
	    		  com.twilio.type.PhoneNumber("whatsapp:+14155238886"),
	    		  al.getEvent_name()+"\n"+al.getCity()+"\n"+al.getTime()+"\n"+al.address+"\n"+al.getDate_of_event()) .create();
	    		 
	     
	            System.out.println(message.getSid()); 
	
	
	return "Hey "+v.volunteername+" thank for registereing we have sent event details on your whatsapp!!!";
}


@GetMapping("/reviewTheVolunteer/{review}/{volunteername}")
@CrossOrigin
@Transactional
public String reviewTheVol(@PathVariable String review,@PathVariable String volunteername)
{
		String text = review;

     SentimentAnalyzer sentimentAnalyzer = new SentimentAnalyzer();

     sentimentAnalyzer.initialize();

     SentimentResult sentimentResult = sentimentAnalyzer.getSentimentResult(text);

     System.out.println("Sentiments Classification:");

     System.out.println("Very positive: " + sentimentResult.getSentimentClass().getVeryPositive()+"%");

     System.out.println("Positive: " + sentimentResult.getSentimentClass().getPositive()+"%");

     System.out.println("Neutral: " + sentimentResult.getSentimentClass().getNeutral()+"%");

     System.out.println("Negative: " + sentimentResult.getSentimentClass().getNegative()+"%");

     System.out.println("Very negative: " + sentimentResult.getSentimentClass().getVeryNegative()+"%");

     System.out.println("\nSentiments result:");

     System.out.println("Sentiment Score: " + sentimentResult.getSentimentScore());

     System.out.println("Sentiment Type: " + sentimentResult.getSentimentType());
  String reviewResult=sentimentResult.getSentimentType();
  
  String s="Hey The Review is "+reviewResult+" Thank You For Your Feedback";
  
  if(reviewResult.equals("Negative") || reviewResult.contentEquals("Very negative"))
  {
	  s="Hey Review Has be recoreded and actions are being taken thank you";
	  
	  //service.deleteTheVolunteer(volunteername);	
	  service.updateTheVolunteerActions(volunteername,reviewResult);
  
  }
  else 
  {
	  service.updateTheVolunteerActions(volunteername,reviewResult);
	  
  }
  
  
  
	
	return s;
}




@GetMapping("/getAllRegisteredVolunteersWithEvent")
@CrossOrigin
@Transactional
public List<VolunteerWithRegisteredEvent> getAll()
{
	return service.getAllVolRegisteredWithEvent();

}



@GetMapping("/sendInviteViaWhatsApp/{mobileno}")
@CrossOrigin
public String sendInvite(@PathVariable String mobileno)
{
	String num="+91"+mobileno;
	List<AllEvents>le=service.getAllEvents();
	
	String ACCOUNT_SID = "AC38477e21658f674575f11fb278f8fac6"; 
     String AUTH_TOKEN ="e75b0dba659cdc68367fd3527d8f70b7";
     Twilio.init(ACCOUNT_SID, AUTH_TOKEN); 
     Message message = Message.creator( new
    		 com.twilio.type.PhoneNumber("whatsapp:"+num), new
    		  com.twilio.type.PhoneNumber("whatsapp:+14155238886"),
    		  
    		 "Hey Amigo Hope Your Doing Well We Had To Keep You Updated With All The Things Happeneing"+"\n"+
    		 "These Are Some Events"+"\n"+
    		 "Event Name :"+le.get(0).eventName+"\n"+
    		 "Event Name :"+le.get(1).eventName+"\n"+
    		 "Event Name :"+le.get(2).eventName+"\n"+
    		 "Event Name :"+le.get(3).eventName+"\n"+
    		 "Event Name :"+le.get(4).eventName+"\n"+
    		 
    		 "Get Register Yourself and get going Cheers!!!").create();
    		 
     
            System.out.println(message.getSid()); 


            return "Invite Sent!!!";///"whatspapp:28928u0129u"
	
	
	}



@GetMapping("/searchEventOnName/{name}")
@CrossOrigin
public List<AllEvents> getEventByName(@PathVariable String name)
{
	
	return service.getEventsOnType(name);
	
	
	
}


@GetMapping("/EventSortOnDate")
@CrossOrigin

public List<AllEvents> sortOnDate()
{
	return service.sortOnDate();
	
}

@GetMapping("/EventSortOnCity")
@CrossOrigin

public List<AllEvents> sortOnCity()
{
	return service.sortOnCity();
}



@Autowired
VolunteerAndEventInterface vaei;

@GetMapping("/sendMessageWhataspp/{email}/{event}")
public String sendMessageViaWhatsapp(@PathVariable String email,@PathVariable String event )
{
	Volunteers vdata=vir.findByemail(email);
	//System.out.println(vdata.getMobileno());
	AllEvents ev= ae.findByEventName(event);
	
	VolunteerWithRegisteredEvent vw=new VolunteerWithRegisteredEvent(0,vdata.getVolunteername(),vdata.getAge(),vdata.getQualification(),
			
		vdata.getEmail(),vdata.getAddress(),vdata.getMobileno(),event);
	
	vaei.save(vw);
	
	String num="+91"+vdata.getMobileno();
	
	   String ACCOUNT_SID = "AC38477e21658f674575f11fb278f8fac6"; 
	     String AUTH_TOKEN ="e75b0dba659cdc68367fd3527d8f70b7";
	     Twilio.init(ACCOUNT_SID, AUTH_TOKEN); 
	     Message message = Message.creator( new
	    		 com.twilio.type.PhoneNumber("whatsapp:"+num), new
	    		  com.twilio.type.PhoneNumber("whatsapp:+14155238886"),
	    		  ev.getEvent_name()+"\n"+ev.getCity()+"\n"+ev.getTime()+"\n"+ev.address+"\n"+ev.getDate_of_event()) .create();
	    		 
	     
	            System.out.println(message.getSid()); 
	

	
	
	String s="No Data found";
	if(vdata!=null)
	{
		s="Message  Sent";
	}
	
	
	
	
	return s;
	
	
	
}




@PostMapping("/registerWithEventGuy")

 public  ResponseEntity<?> registerEvent(@RequestBody EventPeopleRegistering epr)
 {
	
	Set<String>s=new HashSet<String>();
	String setRole="EventOrg";
	s.add(setRole);
	
	SignupRequest sq=new SignupRequest();
	
	sq.setUsername(epr.getHostname());
	sq.setEmail(epr.getEmail());
	sq.setPassword(epr.getPassword());
	sq.setRole(s);
	
	
	return registerUser(sq);
	
	
	
	
	
	
	
	
 }


@Autowired
AllEventsInterface aie;

@Autowired
EventGuyInterface egi;

@PostMapping("/addAnEvent")
public String addEvent(@RequestBody EventAddingWithTokenIs al)
{
	AllEvents toadd=new AllEvents(0,al.getEvent_name(),al.getAddress(),al.getCity(),al.getDate_of_event(),al.getTime(),al.getNo_of_volunteers_required());
	int token=al.getTokenid();
	AllEvents s=aie.save(toadd);
	GuyEvent guy=new GuyEvent(0,token,al.getEvent_name());
	egi.save(guy);
	if(s!=null)
	{
		return "Event Added";
	}
	
	return "Adding Event Failed";
}

@Autowired
VolunteerWithRegisteredEvent are;

@GetMapping("/getVolunteersBasedOnToken/{id}")
public List<VolunteerWithRegisteredEvent> getAll(@PathVariable int id)
{

	List<Volunteers>allList=service.getAllVolunteers();

	List<GuyEvent> vlo=egi.findAllById(id);
	List<VolunteerWithRegisteredEvent>tosend=new ArrayList<VolunteerWithRegisteredEvent>();
	
	for(int i=0;i<vlo.size();i++)
	{
		String s=vlo.get(i).getEvent();
		List<VolunteerWithRegisteredEvent> alldata=vaei.findAllByeventnameregistered(s);
		tosend.addAll(alldata);
		
		
		
	}
	
	return tosend;
	
	
	
	
	
	
	
}


@GetMapping("/GetVolunteersByReview/{review}")
@CrossOrigin
@Query("From Volunteer vl where vl.review LIKE review%")
public List<Volunteers> getVolunteersByReview(@PathVariable String review)
{
	
	return vir.findByreview(review);	
	
}






































	

	
	





}
