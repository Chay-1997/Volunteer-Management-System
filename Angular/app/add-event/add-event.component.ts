import { Component, OnInit } from '@angular/core';
import{EventClassToAdd} from '../event-class-to-add'
import{ServiceClassService} from '../service-class.service'
import{TokenserviceService} from '../tokenservice.service'
@Component({
  selector: 'app-add-event',
  templateUrl: './add-event.component.html',
  styleUrls: ['./add-event.component.scss']
})
export class AddEventComponent implements OnInit {

  //  d:any=new Date();
  //  dd:any=this.d.toDateString().now();

  
 es:EventClassToAdd=new EventClassToAdd(0,"","","","","",0,this.token.getUser().id);
  constructor(private service:ServiceClassService,private token:TokenserviceService) { }

  ngOnInit(): void {
    
  }

  Add()
  {
    console.log(this.token.getUser().id);
     this.service.addEventDetails(this.es).subscribe(
       (data)=>{
         alert(data);
       },
       ()=>{

       }
     )

  }

}
