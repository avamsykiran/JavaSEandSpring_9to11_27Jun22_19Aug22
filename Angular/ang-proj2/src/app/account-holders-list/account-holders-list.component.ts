import { Component, OnInit } from '@angular/core';
import { AccountHolder } from '../account-holder';
import { AccountHolderService } from '../account-holder.service';

@Component({
  selector: 'app-account-holders-list',
  templateUrl: './account-holders-list.component.html',
  styleUrls: ['./account-holders-list.component.css']
})
export class AccountHoldersListComponent implements OnInit {

  ahs!:AccountHolder[];
  err!:string;

  constructor(private ahService:AccountHolderService) { }

  ngOnInit(): void {
    this.ahService.getAll().subscribe({
      next: data => {this.ahs=data;},
      error: errMsg => {console.error(errMsg); this.err="Umable to lead data! Please try again!";}
    });
  }

}
