import { Component } from '@angular/core';
import { NumberSeriesService } from '../number-series.service';

@Component({
  selector: 'app-number-series',
  templateUrl: './number-series.component.html',
  styleUrls: ['./number-series.component.css']
})
export class NumberSeriesComponent {

  lb:number;
  ub:number;
  results!:number[];
  errMsg!:string;
  isJobRunning:boolean;

  constructor(private nss:NumberSeriesService) { 
    this.lb=0;
    this.ub=0;
    this.isJobRunning=false;
  }

  startSeries(){
    this.isJobRunning=true;
    this.results=[];

    this.nss.generateSeries(this.lb,this.ub).subscribe({
      next: val => {this.results.push(val);},
      error: err => {this.errMsg=err;this.isJobRunning=false;},
      complete: () => {this.isJobRunning=false;}
    });
  }
}
