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
  selector: 'app-emergency-modal',
  templateUrl: './emergency-modal.component.html'
})
export class EmergencyModalComponent implements OnInit {
  registerForm: FormGroup;
  submitted = false;
  
  constructor(private formBuilder: FormBuilder,public dialogRef: MatDialogRef<EmergencyModalComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any) { }
    loginForm: FormGroup;
  ngOnInit() {


    this.registerForm = this.formBuilder.group({
      education:      ['', [ Validators.required ]],
      qualification: ['', [Validators.required]],
      College: ['', [Validators.required]],
      spec: ['', [Validators.required]],
      year: ['', [Validators.required]],
      score: ['', [Validators.required]],
      empHighest:['', [Validators.required]],
  });



  }
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
