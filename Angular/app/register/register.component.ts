import { Component, OnInit } from '@angular/core';
import{AuthServiceService} from '../auth-service.service'
import{Registeringvol}from '../registeringvol';
@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {


  mobNum:number;
  ageMin:number;
  rv:Registeringvol=new Registeringvol("",0,"","",0,"","");
  form: any = {};
  isSuccessful = false;
  isSignUpFailed = false;
  errorMessage = '';
  constructor(private authService:AuthServiceService) { }

  ngOnInit(): void {
  }

  onSubmit(): void {
    this.authService.register(this.form).subscribe(
      data => {
        console.log(data);
        this.isSuccessful = true;
        this.isSignUpFailed = false;
      },
      err => {
        this.errorMessage = err.error.message;
        this.isSignUpFailed = true;
      }
    );
  }

 imposeAgeMinMax() {
     if(this.ageMin<18)
     {
       alert("enter age greater than 18");
       
     }
     if(this.ageMin>40)
     {
       alert("enter age less or equal to 40");
     }

   

    
  }


  imposeRestOnMob()
  {
    if(this.mobNum.toString().length <10)
    {
      alert("Hey Number is Invalid");
    }
    if(this.mobNum.toString().length>10)
    {
      alert("Hey Number is Invalid");
    }
  }

 


}
