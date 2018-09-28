import { Component, OnInit } from '@angular/core';
import { Title }     from '@angular/platform-browser';
import { filter } from 'rxjs/operators';
import { MyTeamService } from './myTeam.service';


@Component({
  selector: 'app-my-team-list',
  templateUrl: './my-team-list.component.html'
})
export class MyTeamListComponent implements OnInit {
  companyCode;
  userCode;
  errors;
filter;
MyTeamData;
customerCode;
noPageShow: boolean = true;


key: string = 'name';
  reverse: boolean = false;
  sort(key){
    this.key = key;
    this.reverse = !this.reverse;
  }
  p: number = 1;
  constructor(private titleService: Title,private teamService:MyTeamService) { }

  
  
  ngOnInit() {
    this.titleService.setTitle( "My Team List" );
    this.companyCode = sessionStorage.getItem("companyCode")
    this.userCode = sessionStorage.getItem("userCode")
    this.customerCode = sessionStorage.getItem("customerCode")


    this.teamService.GetMyTeamDetails(this.userCode,this.customerCode).subscribe(
      response => {
        this.MyTeamData = JSON.parse(JSON.stringify(response));
        // if (this.MyTeamData == null) {
        //   this.noPageShow = true;
        // }
      },
      error => {
        console.log("Error is -", error);
      },
      () => { }
    );
  }

}
