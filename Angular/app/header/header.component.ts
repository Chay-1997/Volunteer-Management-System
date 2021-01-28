import { Component, OnInit } from '@angular/core';
import{TokenserviceService} from '../tokenservice.service'

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {
  showWhenVolunteer=false;
  showWhenAdmin=false;
  showWhenEventOrg=false;
  showWhenVolunteerForm=false;
  isLoggedIn=false;
  logIn=true;
  regIn=true
  ;
  showWhenEventOrgEvent=false;
  
  private roles:string[];


  

  constructor(private tokenservice:TokenserviceService) { }

  ngOnInit(): void {
    this.isLoggedIn = !!this.tokenservice.getToken();
      if(this.isLoggedIn)
      {
        const user=this.tokenservice.getUser();
        this.roles=user.roles;

        this.showWhenAdmin=this.roles.includes("ROLE_ADMIN");
        this.showWhenEventOrg=this.roles.includes("ROLE_EVENTORG");

        if(this.showWhenAdmin)
        {
          this. showWhenAdmin=true;
          this.isLoggedIn=true;
          this.showWhenVolunteer=true;
          this.regIn=false;
        

        }
        else if(this.showWhenEventOrg){
          this.showWhenEventOrg=true;
          this.isLoggedIn=true;
          this.regIn=false;
          this.showWhenEventOrgEvent=true;
          //this.showWhenVolunteerForm=true;
        }else{
          this.showWhenVolunteer=true;
          this.showWhenVolunteerForm=true;
          this.isLoggedIn=true;
          this.logIn=true;
          this.showWhenVolunteerForm=false;

          this.regIn=false;
        }
        

      }

  }

  logout()
  {
      this.tokenservice.signOut();
      window.location.reload();
  }

}
