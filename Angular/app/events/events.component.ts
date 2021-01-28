import { Component, OnInit } from '@angular/core';
import { Events } from '../events';
import{ServiceClassService} from '../service-class.service'
import { VolunteerRegistrationComponent } from '../volunteer-registration/volunteer-registration.component';
import{AuthServiceService} from '../auth-service.service'
import{TokenserviceService} from '../tokenservice.service'
@Component({
  selector: 'app-events',
  templateUrl: './events.component.html',
  styleUrls: ['./events.component.scss']
})
export class EventsComponent implements OnInit {
  
  ifItIsVolunteer=false;
  searchKey:string="";
  vs:VolunteerRegistrationComponent;
  e:Events[];
  btnCity:any="City ";
  btnDate:any="Date Of Event "
  ifItsAdmin=true;
  constructor(private service:ServiceClassService,private token:TokenserviceService) { }

  ngOnInit(): void {
    

    this.service.getAllEvents().subscribe(
      (data)=>{
        this.e=data;
        console.log(this.e);
        console.log(this.e[0].event_name);
      },()=>{}
    )

     if(this.token.getUser().roles.includes("ROLE_VOLUNTEER"))
     {
      this.ifItIsVolunteer=true;
      this.ifItsAdmin=false;

     }




  }

  registerWithThisEvent(event_name:string)
  {
    console.log("here");
    console.log(event_name);
    //this.vs.giveThisEvent(event_name);
    
    console.log(this.token.getUser().email);

    this.service.sendMessgeToVolunteerLogin(this.token.getUser().email,event_name).subscribe(
      (data)=>{
        alert(data);
      },
      ()=>{

      }
    )





  }


  sortOnCity()
  {
   // document.getElementById("#btn2").innerHTML="new-Btn";
   this.btnCity="City Sorted";

    this.service.getEventSortedOnCity().subscribe(
      (data)=>{
        this.e=data;

      },

      ()=>{

      }
    )





  

  }

  sortOnDate()
  {
    this.btnDate="Date Sorted";
    this.service.getEventSortedOnDate().subscribe(
      (data)=>{
        this.e=data;

      },

      ()=>{

      }
    )

  }



  checking()
  {
    //console.log(this.searchKey);
    if(this.searchKey)
    {

    this.service.searchOnKey(this.searchKey).subscribe(
      (data)=>{
        this.e=data;

      },
      ()=>{

      }
    )
  }
  else
{
  this.service.getAllEvents().subscribe(
    (data)=>{
      this.e=data;
    },()=>{}
  )
  
}
  
}

  




}
