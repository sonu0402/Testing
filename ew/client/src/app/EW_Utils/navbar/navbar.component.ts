import { Component, OnInit } from '@angular/core';
import { UtilsService } from '../utils.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html'
})
export class NavbarComponent implements OnInit {
  userCode;
  companyCode;
  errors;
  UserName:any;
  constructor(private utilsService: UtilsService) { }
  myVar: boolean = false;

  disp() {

    this.myVar = !this.myVar;
  }



  ngOnInit() {
    this.companyCode = sessionStorage.getItem("companyCode")
    this.userCode = sessionStorage.getItem("userCode")

    this.utilsService.GetUsername(this.userCode).subscribe(
      (result: any) => {
        console.log("Response isss -", result);
        // this.UserName = result;
        this.UserName = JSON.parse(JSON.stringify(result));
        console.log(this.UserName)
        
      },
      error => {
        console.log("Error is -", error);
        this.errors = error;
      },
      () => { }
    );



  }

  
}