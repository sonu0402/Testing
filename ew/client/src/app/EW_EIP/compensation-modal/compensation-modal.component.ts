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
  selector: 'app-compensation-modal',
  templateUrl: './compensation-modal.component.html'})
export class CompensationModalComponent implements OnInit {
 
  registerForm: FormGroup;
  submitted = false;

  constructor(private profileService: MyProfileService,private formBuilder: FormBuilder,public dialogRef: MatDialogRef<CompensationModalComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any
) { }
  ngOnInit() {
    this.registerForm = this.formBuilder.group({
      education:      ['', [ Validators.required ]],
      qualification: ['', [Validators.required]],
      College: ['', [Validators.required]],
      spec: ['', [Validators.required]],
      year: ['', [Validators.required]],
      score: ['', [Validators.required]],
  });
  }

  // convenience getter for easy access to form fields
  get f() { return this.registerForm.controls; }

  onSubmit() {
      this.submitted = true;

      // stop here if form is invalid
      if (this.registerForm.invalid) {
          return;
      }

      alert('SUCCESS!! :-)\n\n' + JSON.stringify(this.registerForm.value))
  }
}