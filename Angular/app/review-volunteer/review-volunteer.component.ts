import { stringify } from '@angular/compiler/src/util';
import { Component, OnInit } from '@angular/core';
import { ServiceClassService } from '../service-class.service';
import { VolunterEvent } from '../volunter-event';

@Component({
  selector: 'app-review-volunteer',
  templateUrl: './review-volunteer.component.html',
  styleUrls: ['./review-volunteer.component.scss']
})
export class ReviewVolunteerComponent implements OnInit {

  message:any;
  review:string;
  ve:VolunterEvent[];
  constructor(private service:ServiceClassService) { }

  ngOnInit(): void {

    this.service.getTheRegisteredVolunteers().subscribe(
      (data)=>{
        this.ve=data;
      },
      ()=>{}
    );


  }

  Review( vname:string, revi:string)
  {
    this.review=revi.trim();
    this.service.reviewTheVolunteer(vname,this.review).subscribe(
      (data)=>{
        console.log(data);
        this.message=data;
        alert(this.message);
      },
      ()=>{}
    );


  }

}
