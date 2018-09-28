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
  selector: 'app-benefit-modal',
  templateUrl: './benefit-modal.component.html'
})
export class BenefitModalComponent implements OnInit {
  EmpDetails = [];
  userCode;
  loginForm: FormGroup;
  errorMessage: string;
  constructor(private profileService: MyProfileService,private formBuilder: FormBuilder,public dialogRef: MatDialogRef<BenefitModalComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any
) { }

buildForm() {
  this.loginForm = this.formBuilder.group({
      education:      ['', [ Validators.required ]],
      qualification: ['', [Validators.required]],
      College: ['', [Validators.required]],
      spec: ['', [Validators.required]],
      year: ['', [Validators.required]],
      score: ['', [Validators.required]],
      empHighest:['', [Validators.required]],
  });
}
  ngOnInit() {
    this.userCode = sessionStorage.getItem("userCode")

    this.buildForm();
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
