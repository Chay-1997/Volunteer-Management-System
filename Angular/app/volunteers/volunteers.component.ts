import { Component, OnInit } from '@angular/core';
import { ServiceClassService } from '../service-class.service';
import { Volunteers } from '../volunteers';

@Component({
  selector: 'app-volunteers',
  templateUrl: './volunteers.component.html',
  styleUrls: ['./volunteers.component.scss']
})
export class VolunteersComponent implements OnInit {
  message:any;
  searchKey:string;
  v:Volunteers[]
  constructor(private service:ServiceClassService) { }

  ngOnInit(): void {
  
  this.service.getAllVolunteers().subscribe(
    (data)=>{
      this.v=data;

      for (const i of this.v) {
        if(i.review=="Negative" ||  i.review=="Very Negative")
        {
          console.log(document.getElementById("#inBtn"));
        }
      }
    },
    ()=>{}
    )
  
  
  }

  Invite(mobileno:number)
  {
    console.log(mobileno.toString());
    //console.log(mobileno);
     this.service.InvitingApi(mobileno.toString()).subscribe(
       (data)=>{ 
         this.message=data;
         console.log(this.message);
         alert(this.message);

       },()=>{}
     )

  
    }



    getVolReview()
    {
      if(this.searchKey=="")
      {
        this.service.getAllVolunteers().subscribe(
          (data)=>{
            this.v=data;
          },
          ()=>{

          }
        )
        return;
      }
      this.service.getVolunteersOnReview(this.searchKey).subscribe(
        (data)=>{
          this.v=data;
        },
        ()=>{

        }

      )

    }


}
