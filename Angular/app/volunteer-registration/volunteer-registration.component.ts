import { Component, OnInit } from '@angular/core';
import { ServiceClassService } from '../service-class.service';
import{VolunterEvent} from '../volunter-event';
@Component({
  selector: 'app-volunteer-registration',
  templateUrl: './volunteer-registration.component.html',
  styleUrls: ['./volunteer-registration.component.scss']
})
export class VolunteerRegistrationComponent implements OnInit {
 

  ele:any;
  event:string;
  check:any="";
  message:any;
  // ve:VolunterEvent;
  ve:VolunterEvent=new VolunterEvent("",0,"","","",0,"");
  constructor(private service:ServiceClassService) { }


  public giveThisEvent(event_name: string) {
    console.log(event_name);
  }
  

  async ngOnInit(): Promise<void> {
    //
    //console.log(this.check);
   // c.setAttribute("value","dashdas");
    //var c=document.getElementById("check");
    //console.log(c);
    
    //c.setAttribute("value",this.check);

   //await this.delay(1000)
   //console.log(this.event)
    
  }

  Register()
  {

    this.service.addTheVolunteer(this.ve).subscribe(
      (data)=>{
        console.log(data);
        this.message=data;
      },
      ()=>{

      }
    )


  }




  //async giveThisEvent(event_name: string) {
    //await this.delay(5)
    //this.event=event_name;
    //c//onsole.log(this.event);
    //this.ele=document.getElementById('ex').innerHTML;
    
    //console.log(this.event_name)
   // this.ele=this.event_name


    //console.log(ex);
    //window.onload=function(){
    //this.check=event_name;
    //console.log(this.check);
    
    //c=event_name;
    //console.log(c);
    //}
    //var c=document.getElementById('check');
    //console.log(c);
    //c.innerHTML="asd";
    //console.log(c);
   // console.log("i am here");

  //  var x=document.readyState;
  //  if(x=="complete")
  //  {
  
  //  }
   //onreadystatechange
    //  document.addEventListener('DOMContentLoaded',function(){

    //      console.log("i am here");
    //      var c=document.getElementById('check');
    //      console.log(c);
    //      var s="sdasda";
    //      c.innerHTML=s;

    //      c.setAttribute('value',s);
    //  })

     // var c=document.getElementById('check');
     // c.innerHTML="sadkahsbd";


   
    // this.check=event_name;
    // console.log("ded"+this.check);
    // this.ngOnInit() 
     
    
    // console.log(event_name);
    // console.log("here");
    //var ex=document.getElementById("eventnameregistered");
    //ex.innerHTML=event_name;
    //console.log(event_name);
    
    //var v=event_name;
    //var cc=c.innerHTML;
   // c.innerHTML="djshbas";
    
    //console.log(c);
    //c.innerHTML=v;    
    //console.log("At end ti");    
    

 // }

   //delay(ms: number) {
    //return new Promise( resolve => setTimeout(resolve, ms) );
//}

}
