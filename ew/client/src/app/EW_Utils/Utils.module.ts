import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { JobReferenceComponent } from './job-reference/job-reference.component';
import { UpcomingEventsComponent } from './upcoming-events/upcoming-events.component';
import { UsefulLinksComponent } from './useful-links/useful-links.component';
import { OnlineUsersComponent } from './online-users/online-users.component';
import { AttendanceDashboardComponent } from './attendance-dashboard/attendance-dashboard.component';
import { UtilsService } from './utils.service';
import { OngoingEventsComponent } from './ongoing-events/ongoing-events.component';
import {EwDashboardSearchComponent} from '../EW_Utils/ew-dashboard-search/ew-dashboard-search.component';
import { CalendarDashboardComponent } from './calendar-dashboard/calendar-dashboard.component';
import { DateInputsModule } from '@progress/kendo-angular-dateinputs';
import {EventsDashboardComponent} from '../EW_Utils/events-dashboard/events-dashboard.component';
import { NavbarComponent } from './navbar/navbar.component';
 import {AppRoutingModule} from '../app-routing.module';
 import {UniquePipe} from './NgPipes/unique.pipe';
// import { GrowlerModule } from './NgServices/growler/growler.module';
@NgModule({
  imports: [
    CommonModule,DateInputsModule,AppRoutingModule

  ],
  exports: [UpcomingEventsComponent
    ,UsefulLinksComponent, OnlineUsersComponent, CalendarDashboardComponent,AttendanceDashboardComponent,EventsDashboardComponent, OngoingEventsComponent,EwDashboardSearchComponent,DateInputsModule,NavbarComponent,UniquePipe],
  declarations: [UpcomingEventsComponent,UniquePipe,NavbarComponent,UsefulLinksComponent, OnlineUsersComponent,EventsDashboardComponent, AttendanceDashboardComponent, OngoingEventsComponent,EwDashboardSearchComponent, CalendarDashboardComponent,],
  providers: [UtilsService]
})
export class UtilsModule { }
