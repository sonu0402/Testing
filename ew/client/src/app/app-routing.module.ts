import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EWDashboardComponent } from './ew-dashboard/ew-dashboard.component';
import { MyTeamComponent } from './EW_EIP/my-team/my-team.component';
import { MyTeamListComponent } from './EW_EIP/my-team/my-team-list.component';
import { EwCalendarComponent } from './EW_Utils/ew-calendar/ew-calendar.component';
import { EwLoginComponent } from './ew-login/ew-login.component';
import { MyProfileComponent } from './EW_EIP/my-profile/my-profile.component';

const appRoutes: Routes = [
  { path: '', component: EwLoginComponent },
  { path: 'dashboard', component: EWDashboardComponent },
  { path: 'myTeam', component: MyTeamComponent },
  { path: 'myTeamListView', component: MyTeamListComponent },
  { path: 'myProfile', component: MyProfileComponent },
  { path: '**', component: EwLoginComponent }

]
@NgModule({
  imports: [RouterModule.forRoot(appRoutes)],
  exports: [RouterModule],
  declarations: []
})

export class AppRoutingModule {


}
