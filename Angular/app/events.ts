export class Events {
    
    eventid:number
     event_name:string;
	 address:string;
	 city:string;
	 date_of_event:Date;
	 time:string;
    no_of_volunteers_required:number;
    

    constructor(eventid:number,eventName:string,address:string,city:string,date_of_event:Date,time:string,no_of_volunteers_required:number)
    {
        this.eventid=eventid;
        this.event_name=eventName;
        this.address=address;
        this.city=city;
        this.date_of_event=date_of_event;
        this.time=time;
        this.no_of_volunteers_required=no_of_volunteers_required;
    }



}














