import { Component, OnInit } from '@angular/core';
import { Title } from '@angular/platform-browser';
// import * as JS from '/external.js' 



@Component({
  selector: 'app-root',
  templateUrl: './app.component.html'
})

export class AppComponent implements OnInit {
  loadAPI: Promise<any>;

  constructor(

    private titleService: Title
  ) {
    // console.log(test1());
    // alert(test1());

    
      
   

   }


  ngOnInit() {
    this.titleService.setTitle('EmployWise Login');


  }
 
}
