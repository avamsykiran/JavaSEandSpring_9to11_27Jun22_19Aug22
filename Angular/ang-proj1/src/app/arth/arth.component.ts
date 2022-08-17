import { Component } from '@angular/core';

@Component({
  selector: 'app-arth',
  templateUrl: './arth.component.html',
  styleUrls: ['./arth.component.css']
})
export class ArthComponent  {

  n1:number;
  n2:number;

  showSum:boolean;
  showDif:boolean;
  showPrd:boolean;
  showQut:boolean;
  showRem:boolean;

  constructor() {
    this.n1=0;
    this.n2=0;

    this.showSum=true;
    this.showDif=true;
    this.showPrd=true;
    this.showQut=true;
    this.showRem=true;
   }


}
