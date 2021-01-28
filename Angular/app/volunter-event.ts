export class VolunterEvent {

    volunteername:string;
    age:number;
    qualification:string;
    email:string;
    address:string;
    mobilenumber:number;
    eventnameregistered:string;


    constructor(volunteername:string,age:number, qualification:string,email:string,address:string, mobilenumber:number,eventnameregistered:string)
    {
        this.volunteername=volunteername;
        this.age=age;
        this.qualification=qualification;
        this.email=email;
        this.address=address;
        this.mobilenumber=mobilenumber;
        this.eventnameregistered=eventnameregistered;

    }

}

