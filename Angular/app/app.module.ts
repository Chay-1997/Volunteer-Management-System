import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import{FormsModule} from '@angular/forms';
import{HttpClientModule} from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { HomeComponent } from './home/home.component';
import { EventsComponent } from './events/events.component';
import { VolunteersComponent } from './volunteers/volunteers.component';
import { VolunteerRegistrationComponent } from './volunteer-registration/volunteer-registration.component';
import { ReviewVolunteerComponent } from './review-volunteer/review-volunteer.component';
import{authInterceptorProviders} from '../app/_helpers/authinterceptor';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { RegisteringEventguyComponent } from './registering-eventguy/registering-eventguy.component';
import { AddEventComponent } from './add-event/add-event.component'
@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    HomeComponent,
    EventsComponent,
    VolunteersComponent,
    VolunteerRegistrationComponent,
    ReviewVolunteerComponent,
    LoginComponent,
    RegisterComponent,
    RegisteringEventguyComponent,
    AddEventComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [authInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }
