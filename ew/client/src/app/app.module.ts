import { BrowserModule, Title } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { MatFormFieldModule } from '@angular/material/form-field';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';
import { HttpModule } from '@angular/http';
import { LeaveService } from './EW_Leave/leave.service';
import { UtilsModule } from './EW_Utils/Utils.module';
import { JobReferenceComponent } from '../app/EW_Utils/job-reference/job-reference.component'
import { CommonModule } from '@angular/common';
import { FlatpickrModule } from 'angularx-flatpickr';
import { CalendarModule, DateAdapter } from 'angular-calendar';
import { adapterFactory } from 'angular-calendar/date-adapters/date-fns';
import { NgbModalModule } from '@ng-bootstrap/ng-bootstrap';
import { EwCalendarComponent } from './EW_Utils/ew-calendar/ew-calendar.component';
import 'hammerjs';
import { NgxPaginationModule } from 'ngx-pagination'; // <-- import the module
import { Ng2SearchPipeModule } from 'ng2-search-filter'; //importing the module
import { Ng2OrderModule } from 'ng2-order-pipe'; //importing the module
import { DateInputsModule } from '@progress/kendo-angular-dateinputs';
import { StorageServiceModule} from 'angular-webstorage-service';
import {EIPModule} from './EW_EIP/EIP.module';
import {LeaveModule} from './EW_Leave/leave.module';
import {ProfileDetailsModalComponent} from '../app/EW_EIP/profile-details-modal/profile-details-modal.component';
import {

  MatAutocompleteModule,
  MatButtonModule,
  MatButtonToggleModule,
  MatCardModule,
  MatCheckboxModule,
  MatChipsModule,
  MatDatepickerModule,
  MatDialogModule,
  MatExpansionModule,
  MatGridListModule,
  MatIconModule,
  MatInputModule,
  MatListModule,
  MatMenuModule,
  MatNativeDateModule,
  MatPaginatorModule,
  MatProgressBarModule,
  MatProgressSpinnerModule,
  MatRadioModule,
  MatRippleModule,
  MatSelectModule,
  MatSidenavModule,
  MatSliderModule,
  MatSlideToggleModule,
  MatSnackBarModule,
  MatSortModule,
  MatStepperModule,
  MatTableModule,
  MatTabsModule,
  MatToolbarModule,
  MatTooltipModule,
} from '@angular/material';
import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { EWDashboardComponent } from './ew-dashboard/ew-dashboard.component';
import { MyTeamComponent } from './EW_EIP/my-team/my-team.component';
import { MyTeamListComponent } from './EW_EIP/my-team/my-team-list.component';
import { EwLoginComponent } from './ew-login/ew-login.component';

@NgModule({
  imports: [
    StorageServiceModule,
    CommonModule,
    FormsModule,EIPModule,
    NgbModalModule,
    FlatpickrModule.forRoot(),
    CalendarModule.forRoot({
      provide: DateAdapter,
      useFactory: adapterFactory
    }),
     DateInputsModule,
    MatAutocompleteModule,
    HttpClientModule,
    HttpModule, NgxPaginationModule,
    MatButtonModule, Ng2SearchPipeModule, Ng2OrderModule,
    MatButtonToggleModule,
    MatCardModule,
    MatCheckboxModule,
    MatChipsModule,DateInputsModule,
    MatStepperModule,
    MatDatepickerModule,
    MatDialogModule,
    MatExpansionModule,
    MatGridListModule,
    MatIconModule,
    MatInputModule,
    MatListModule,
    MatMenuModule,
    MatNativeDateModule,
    MatPaginatorModule,
    MatProgressBarModule,
    MatProgressSpinnerModule,
    BrowserAnimationsModule,
    MatRadioModule,
    MatRippleModule,
    MatSelectModule,
    MatSidenavModule,
    MatSliderModule,
    MatSlideToggleModule,
    MatSnackBarModule,
    MatSortModule,
    MatTableModule,
    MatTabsModule,
    MatToolbarModule,
    MatTooltipModule,
    BrowserModule,
    FormsModule, ReactiveFormsModule,
    AppRoutingModule,
    UtilsModule,LeaveModule
  ],
  declarations: [
    AppComponent, EWDashboardComponent, JobReferenceComponent,
    EwCalendarComponent,
    EwLoginComponent],
  exports: [EwCalendarComponent],


  providers: [LeaveService, Title],
  bootstrap: [AppComponent]
})
export class AppModule {




}






