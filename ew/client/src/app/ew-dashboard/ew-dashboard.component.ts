import { Component, OnInit } from '@angular/core';
import { Title }     from '@angular/platform-browser';

@Component({
  selector: 'app-ew-dashboard',
  templateUrl: './ew-dashboard.component.html'
})
export class EWDashboardComponent implements OnInit {

  constructor(private titleService: Title) { }

  ngOnInit() {
    this.titleService.setTitle( "Dashboard" );
  }

}
