import { Component, OnInit } from '@angular/core';
import{AuthServiceService} from '../auth-service.service'

@Component({
  selector: 'app-registering-eventguy',
  templateUrl: './registering-eventguy.component.html',
  styleUrls: ['./registering-eventguy.component.scss']
})
export class RegisteringEventguyComponent implements OnInit {

  form: any = {};
  isSuccessful = false;
  isSignUpFailed = false;
  errorMessage = '';
  constructor(private ser:AuthServiceService) { }

  ngOnInit(): void {
  }

  onSubmit():void{

    this.ser.registerWithEvent(this.form).subscribe(
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

}
