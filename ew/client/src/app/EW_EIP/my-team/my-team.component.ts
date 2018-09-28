import { Component, OnInit } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { filter } from 'rxjs/operators';
import { MyTeamService } from './myTeam.service';


@Component({
  selector: 'app-my-team',
  templateUrl: './my-team.component.html'
})
export class MyTeamComponent implements OnInit {
  companyCode;
  userCode;
  errors;
  filter;
  MyTeamData;
  customerCode;
  key: string = 'name';
  reverse: boolean = false;
  noPageShow: boolean = true;
  sort(key) {
    this.key = key;
    this.reverse = !this.reverse;
  }
  p: number = 1;
  constructor(private titleService: Title, private teamService: MyTeamService) { }

  ngOnInit() {
    this.titleService.setTitle("My Team");

    this.companyCode = sessionStorage.getItem("companyCode")
    this.userCode = sessionStorage.getItem("userCode")
    this.customerCode = sessionStorage.getItem("customerCode")


    this.teamService.GetMyTeamDetails(this.userCode, this.customerCode).subscribe(
      response => {
        console.log("response is:" + response)
        this.MyTeamData = JSON.parse(JSON.stringify(response));
        console.log(this.MyTeamData);
        // if (this.MyTeamData == null) {
        //   this.noPageShow = true;
        // }

        this.MyTeamData.forEach(element => {
          console.log(element.userName + "sasasasas");
        });
      },
      error => {
        console.log("Error is -", error);
      },
      () => { }
    );


  }

}
