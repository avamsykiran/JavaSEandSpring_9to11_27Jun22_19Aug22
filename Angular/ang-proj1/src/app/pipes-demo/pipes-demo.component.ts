import { Component } from '@angular/core';

@Component({
  selector: 'app-pipes-demo',
  templateUrl: './pipes-demo.component.html',
  styleUrls: ['./pipes-demo.component.css']
})
export class PipesDemoComponent  {

  str:string;
  num:number;
  date:Date;

  constructor() { 
    this.str="Hello world! How are you";
    this.num=Math.PI;
    this.date=new Date();
  }

}
