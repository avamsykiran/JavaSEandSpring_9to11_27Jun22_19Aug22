import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class GreetService {

  constructor() { }

  public greetUser(userName:string):string{
    return "Hello "+userName;
  }
}
