import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddEventComponent } from './add-event/add-event.component';
import { EventsComponent } from './events/events.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { RegisteringEventguyComponent } from './registering-eventguy/registering-eventguy.component';
import { ReviewVolunteerComponent } from './review-volunteer/review-volunteer.component';
import { VolunteerRegistrationComponent } from './volunteer-registration/volunteer-registration.component';
import { VolunteersComponent } from './volunteers/volunteers.component';

const routes: Routes = [
  {
    path:"home",component:HomeComponent
  },
  {
    path:"",redirectTo:"home",pathMatch:"full"

  },
  {
    path:"add-event",component:AddEventComponent
  },
  {
    path:"register-with-event",component:RegisteringEventguyComponent
  },
  {
    path:"login", component:LoginComponent
  },
  {
    path:"register",component:RegisterComponent
  },
  {
    path:"events",component:EventsComponent
  },
  {
    path:"volunteers",component:VolunteersComponent
  },
  {
    path:"register-volunteer",component:VolunteerRegistrationComponent
  },
  {
    path:"review",component:ReviewVolunteerComponent
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
