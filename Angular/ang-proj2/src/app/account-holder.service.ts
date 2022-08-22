import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AccountHolder } from './account-holder';

@Injectable({
  providedIn: 'root'
})
export class AccountHolderService {

  apiUrl:string;
  constructor(private httpClient:HttpClient) {
    this.apiUrl="http://localhost:9999/profiles"
    //this.apiUrl="http://localhost:9100"
  }

  getAll():Observable<AccountHolder[]>{
    return this.httpClient.get<AccountHolder[]>(this.apiUrl);
  }

  getById(ahId:number):Observable<AccountHolder>{
    return this.httpClient.get<AccountHolder>(this.apiUrl+"/"+ahId);
  }

  add(ah:AccountHolder):Observable<AccountHolder>{
    return this.httpClient.post<AccountHolder>(this.apiUrl,ah);
  }
}
