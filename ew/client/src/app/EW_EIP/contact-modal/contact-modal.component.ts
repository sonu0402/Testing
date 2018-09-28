
import { Component, OnInit, Inject, ViewChild, ElementRef } from '@angular/core';
import { MatDialog, MatDialogConfig, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { FormControl, FormGroup, Validators, FormBuilder } from '@angular/forms';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import { Title } from '@angular/platform-browser';
import { MatSnackBar } from '@angular/material';
import { MyProfileService } from '../my-profile/myProfile.service';
import { HttpClient, HttpHeaders, } from '@angular/common/http';
import { HttpErrorResponse } from '@angular/common/http';
@Component({
  selector: 'app-contact-modal',
  templateUrl: './contact-modal.component.html'})
export class ContactModalComponent implements OnInit {
  EmpDetails = [];
  userCode;
  constructor(private profileService: MyProfileService,public dialogRef: MatDialogRef<ContactModalComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any
  ) { }

  
  
  
  
  ngOnInit() {
    this.userCode = sessionStorage.getItem("userCode")

    this.profileService.getEmployeeDetails(this.userCode).subscribe
      ((result: any) => {
        console.log(result + "json")
        this.EmpDetails = JSON.parse(JSON.stringify(result));



        // result.forEach(request => {

        //   if (request.buName == "Corporate")
        //     console.log("dsd");

        // }
        // )
      },
      error => {
      },
      () => { }
      );
  }

}
