import { Component } from '@angular/core';
import { GreetService } from '../greet.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent {

  userName:string;
  greeting:string;

  logos:string[];
  logoIndex:number;
  logoWidth:number;

  isCentered:boolean;
  isBorderApplied:boolean;

  team:string[];

  constructor(private gs:GreetService) { 

    this.userName="Somebody";
    this.greeting=gs.greetUser(this.userName);

    this.logoIndex=0;
    this.logos=[
      "assets/imgs/w1.png",
      "assets/imgs/w2.jpg",
      "assets/imgs/w3.jpg",
      "assets/imgs/w4.jpg"
    ];
    this.logoWidth=200;
    this.isCentered=true;
    this.isBorderApplied=true;

    this.team=["Vamsy","Lalitha","Sonum","Trupti"];
  }

  toggleImage(){
    this.logoIndex++;
    if(this.logoIndex==this.logos.length){
      this.logoIndex=0;
    }
  }

  updateGreeting(){
    this.greeting=this.gs.greetUser(this.userName);
  }
}
