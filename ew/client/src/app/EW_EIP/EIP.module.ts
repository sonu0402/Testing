import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { OngoingRequestComponent } from './ongoing-request/ongoing-request.component';
import {EIPService} from './eip.service';
import { MyProfileComponent } from './my-profile/my-profile.component';
import { ProfileDetailsModalComponent } from './profile-details-modal/profile-details-modal.component';
import { BsModalModule } from 'ng2-bs3-modal';
import {ModalService} from '../EW_Utils/NgServices/modal.service';
import { FormsModule } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';
import {AppRoutingModule} from '../app-routing.module';
import { MyTeamComponent } from '../EW_EIP/my-team/my-team.component';
import { MyTeamListComponent } from '../EW_EIP/my-team/my-team-list.component';
import { NgxPaginationModule } from 'ngx-pagination'; // <-- import the module
import { Ng2SearchPipeModule } from 'ng2-search-filter'; //importing the module
import { Ng2OrderModule } from 'ng2-order-pipe'; //importing the module
import { GrowlerModule } from '../EW_Utils/NgServices/growler/growler.module';
import { ContactModalComponent } from './contact-modal/contact-modal.component';
import { PersonalModalComponent } from './personal-modal/personal-modal.component';
import { BenefitModalComponent } from './benefit-modal/benefit-modal.component';
import { EmergencyModalComponent } from './emergency-modal/emergency-modal.component';
import { CompensationModalComponent } from './compensation-modal/compensation-modal.component';
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
  MatTabsModule,
  MatToolbarModule,
  MatTooltipModule,
} from '@angular/material';
import { UtilsModule } from '../EW_Utils/Utils.module';
import { MyProfileService } from './my-profile/myProfile.service';
import { MyTeamService } from './my-team/myTeam.service';
import { GrowlerService } from '../EW_Utils/NgServices/growler/growler.service';
import { AssetsModalComponent } from './assets-modal/assets-modal.component';
@NgModule({
  imports: [
    CommonModule,BsModalModule, MatAutocompleteModule,
    MatButtonToggleModule,
    MatCardModule,AppRoutingModule,
    MatCheckboxModule,
    MatStepperModule,ReactiveFormsModule,
    MatDatepickerModule,
    MatDialogModule,Ng2OrderModule,Ng2SearchPipeModule,NgxPaginationModule,
    MatExpansionModule,
    MatGridListModule,FormsModule,
    MatIconModule,
    MatInputModule,UtilsModule,
    MatListModule,
    MatMenuModule,
    MatNativeDateModule,
    MatPaginatorModule,
    MatProgressBarModule,GrowlerModule,
    MatProgressSpinnerModule,
    MatRadioModule,
    MatRippleModule,
    MatSelectModule,
    MatSidenavModule,
    MatSliderModule,
    MatSlideToggleModule,
    MatSnackBarModule,
    MatSortModule,
    MatTabsModule,
    MatToolbarModule,
    MatTooltipModule,
  ],
  exports:[BsModalModule,MyProfileComponent,ProfileDetailsModalComponent,MyTeamComponent,MyTeamListComponent],
  declarations: [OngoingRequestComponent,CompensationModalComponent,AssetsModalComponent,ContactModalComponent,PersonalModalComponent,EmergencyModalComponent,BenefitModalComponent, MyProfileComponent, ProfileDetailsModalComponent,MyTeamComponent,MyTeamListComponent],
  providers:[MyProfileService,MyTeamService,ModalService,GrowlerService],
  entryComponents: [
    CompensationModalComponent, ProfileDetailsModalComponent,ContactModalComponent,PersonalModalComponent,BenefitModalComponent,EmergencyModalComponent,AssetsModalComponent
]
})
export class EIPModule { 

  
}
