import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AccountHolder } from '../account-holder';
import { AccountHolderService } from '../account-holder.service';

@Component({
  selector: 'app-account-holder-form',
  templateUrl: './account-holder-form.component.html',
  styleUrls: ['./account-holder-form.component.css']
})
export class AccountHolderFormComponent implements OnInit {

  ah:AccountHolder;
  errMsg!:string;

  constructor(private ahService:AccountHolderService,private router:Router) { 
    this.ah={fullName:'',mobile:'',mailId:''};
  }

  ngOnInit(): void {
  }

  formSubmitted(){
    this.ahService.add(this.ah).subscribe({
      next: data => {this.router.navigateByUrl("/home");},
      error: err =>{console.error(err);this.errMsg="Unable to save data!";}
    });
  }
}
