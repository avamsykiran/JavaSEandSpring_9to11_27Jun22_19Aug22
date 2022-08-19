import { Injectable } from '@angular/core';
import { Observable, Observer } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class NumberSeriesService {

  constructor() { }

  generateSeries(lb:number,ub:number) :Observable<number>{
    
    let nssJob = (observer:Observer<number>) => {
      if(lb>ub){
        observer.error("Invlaid boundaries");
        return;
      }

      let currentValue=lb;
      let handler = setInterval(()=>{
        observer.next(currentValue);
        currentValue++;
        if(currentValue>ub){
          clearInterval(handler);
          observer.complete();
        }
      },500);
    };

    return new Observable(nssJob);
  }
}
