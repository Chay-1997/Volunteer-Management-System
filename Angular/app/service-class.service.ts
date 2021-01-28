import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Events } from './events';
import{HttpClient} from '@angular/common/http'
import { VolunterEvent } from './volunter-event';
import{Volunteers} from '../app/volunteers'
import{TokenserviceService} from '../app/tokenservice.service'
import{EventClassToAdd}from '../app/event-class-to-add'
@Injectable({
  providedIn: 'root'
})
export class ServiceClassService{
  id:number;
  
  searchOnKey(s:string):Observable<Events[]> {
    return this.http.get<Events[]>("http://localhost:8080/api/auth/searchEventOnName"+"/"+s);
  }
  getEventSortedOnDate():Observable<Events[]> {
    
    return this.http.get<Events[]>("http://localhost:8080/api/auth/EventSortOnDate");    
  }
  
  
  
  getEventSortedOnCity() :Observable<Events[]>{
    return this.http.get<Events[]>("http://localhost:8080/api/auth/EventSortOnCity");
    
  }
  InvitingApi(mobileno: string) {
    
    console.log(mobileno);
    return this.http.get('http://localhost:8080/api/auth/sendInviteViaWhatsApp/'+mobileno,{responseType:"text" as 'json'});



  }
  getAllVolunteers():Observable<Volunteers[]>{
   return this.http.get<Volunteers[]>("http://localhost:8080/api/auth/getAllVolunteers");
  }
  reviewTheVolunteer(vname: string, review: string) {
  
    return this.http.get('http://localhost:8080/api/auth/reviewTheVolunteer/'+review+"/"+vname,{responseType:'text' as 'json'});
  
  
  }

  getTheRegisteredVolunteers():Observable<VolunterEvent[]> {
    this.id=this.token.getUser().id;
    
    return this.http.get<VolunterEvent[]>('http://localhost:8080/api/auth/getVolunteersBasedOnToken/'+this.id);
  }
  
  
  addTheVolunteer(ve:VolunterEvent)
   {
     return this.http.post('http://localhost:8080/api/auth/addVolunteer',ve,{responseType:'text' as 'json'});
    
  }

  constructor(private http:HttpClient,private token:TokenserviceService) { }

  public getAllEvents():Observable<Events[]>
  {
    return this.http.get<Events[]>('http://localhost:8080/api/auth/getAllEvents');
  }


  public sendMessgeToVolunteerLogin(em:String,ename:string)
  {

    return this.http.get("http://localhost:8080/api/auth/sendMessageWhataspp/"+em+"/"+ename,{responseType:'text' as 'json'});
  }

  public addEventDetails(events:EventClassToAdd)
  {
    //console.log("gere")
    return this.http.post("http://localhost:8080/api/auth/addAnEvent",events,{responseType:'text' as 'json'})

  }


public getVolunteersOnReview(rev:string):Observable<Volunteers[]>
{
  return this.http.get<Volunteers[]>('http://localhost:8080/api/auth/GetVolunteersByReview/'+rev);

}


}
