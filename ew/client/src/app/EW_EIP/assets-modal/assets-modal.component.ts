import { Component, OnInit, Inject, ViewChild, ElementRef } from '@angular/core';
import { MatDialog, MatDialogConfig, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { FormControl, FormGroup, Validators, FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-assets-modal',
  templateUrl: './assets-modal.component.html'
})
export class AssetsModalComponent implements OnInit {

  constructor(private formBuilder: FormBuilder,public dialogRef: MatDialogRef<AssetsModalComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any) { }
  ngOnInit() {
  }

}
