import { Component, OnInit, Inject, ViewChild, ElementRef } from '@angular/core';
import { MatDialog, MatDialogConfig, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { FormControl, FormGroup, Validators, FormBuilder } from '@angular/forms';
import { MyProfileModal } from './myProfileModal';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import { Title } from '@angular/platform-browser';
import { MatSnackBar } from '@angular/material';
import { MyProfileService } from '../my-profile/myProfile.service';
import { HttpClient, HttpHeaders, } from '@angular/common/http';
import { HttpErrorResponse } from '@angular/common/http';
import { GrowlerService, GrowlerMessageType } from '../../EW_Utils/NgServices/growler/growler.service';
import {fileValidator} from '../../EW_Utils/NgComponent/CustomValidator';

@Component({
  selector: 'app-profile-details-modal',
  templateUrl: './profile-details-modal.component.html'
})
export class ProfileDetailsModalComponent implements OnInit {
  educationForm: FormGroup;
  myProfile = new MyProfileModal();
  isValidFormSubmitted: boolean = null;
  message: string = "Qualification Details Updated !!";
  action: string = "Dismiss";
  showTableData: boolean = false;
  showQual: boolean = false;
  edu_img:boolean= false;
  rd = [];
  gd = [];
  wd = [];
  form: FormGroup;
  loading: boolean = false;
  empId;
  EmpDetailss = [];
  userCode;
  school;
  EmpDetails = [];
  arrBirds = [];
  custCode;
  imageUrl: string = "/assets/img/default-image.png";
  fileToUpload: File = null;
  data = [];
  requiredFlag: boolean = false;
  showMandatoryFlag:boolean = false;
  education = [
    {
      "edu_level": "school",
      "branch": [
        {
          "branchName": "Commerce",

        },
        {
          "branchName": "Science",

        },
        {
          "branchName": "Arts",

        }
      ]
    },

    {
      "edu_level": "Graduation",

      "branch": [
        {

          "branchName": "ECE",

        },

        {

          "branchName": "CS",

        },

        {

          "branchName": "IT",

        }



      ]
    },

    {
      "edu_level": "Post_graduation",

      "branch": [
        {

          "branchName": "M.tech",

        },
        {

          "branchName": "M.sc",

        },
        {

          "branchName": "M.sc",

        }
      ]
    }
  ]
  myvar: boolean = false;
  showAddLink: boolean = false;
  showEditLink: boolean = false;
  showModal: boolean = false;
  EducationDetails;
  tabRights;
  Labels = {};
  ggg = [];
  hhh;
  jjj = [];
  arr = [];
  @ViewChild('fileInput') fileInput: ElementRef;


  constructor(private profileService: MyProfileService, private route: ActivatedRoute, private httpService: HttpClient, private titleService: Title, public snackBar: MatSnackBar, private fb: FormBuilder,
    private router: Router, private growler: GrowlerService,
    public dialogRef: MatDialogRef<ProfileDetailsModalComponent>,
    @Inject(MAT_DIALOG_DATA) public dataV: any
  ) {

  }

  ngOnInit() {
    this.custCode = sessionStorage.getItem("customerCode")
    let request = './assets/EIP_Labels_1_' + this.custCode + '.json';
    this.httpService.get(request).subscribe(
      data => {
        this.Labels = data;

        for (var key in this.Labels) {
          // console.log(key + "keyt");

          if (this.Labels[key]._req === 'Y') {

            console.log(this.Labels[key]._name + "name");
            this.requiredFlag = true;

            // console.log(this.Labels + "Labels");
          }

          if (this.Labels[key]._man === 'Y' && this.Labels[key]._req === 'Y'){
            console.log(this.Labels[key]._name + "man");

            this.showMandatoryFlag = true;
          }

        }
        // let arry = datta[0];

        // console.log(arry + "arry");
        // this.ggg = datta[0];
        // console.log(this.ggg + "ddddd");

        // this.ggg = JSON.parse(JSON.stringify(datta));
        // console.log(this.ggg + "fff");


        // for (var i in arry) {
        //   console.log(arry[i]._name + "kkkkk");  // iterate over each keys
        // }
        // console.log(arry[i]._name + "names"); // for specific
        // this.hhh = arry[43]._name
        // this.arrBirds = datta as string[];
        // console.log(this.arrBirds[0] + "arr");
        // this.jjj = this.arrBirds;

        // for (let key in this.arrBirds[0]) {
        //   console.log(key + "ddd" + this.arrBirds[0][key]._req);

        //   if (this.arrBirds[0][key]._req == 'Y') {
        //     this.rd = this.arrBirds[0][key]._name
        //     console.log(this.rd + "rd");

        //   }
        //   if (this.arrBirds[0][key]._man == 'Y') {
        //     this.gd = this.arrBirds[0][key]._name
        //     console.log(this.rd + "gd");

        //   }
        //   if (this.arrBirds[0][key]._man == 'N') {
        //     this.wd = this.arrBirds[0][key]._name
        //     console.log(this.rd + "wd");

        //   }
        //   this.Labels = this.arrBirds[0][key]._name;
        //   console.log(key + "key")
        // }
      },
      (err: HttpErrorResponse) => {
        console.log(err.message);
      }
    );
    this.userCode = sessionStorage.getItem("userCode")
    this.custCode = sessionStorage.getItem("customerCode")
    this.profileService.getTabRights(this.userCode).subscribe(
      (result: any) => {
        this.tabRights = JSON.parse(JSON.stringify(result));

        // console.log(this.tabRights.empSupviewApp + "dsds");
        // let context = this;
        //         var resultArray = Object.keys(result).map(function (tabRightsNamedIndex) {
        //           let tabRights = result[tabRightsNamedIndex];
        // console.log(tabRights + " "+ "sss");
        //           if (tabRights.empTabAppEmploy == "Y") {
        //             context.empTabTypes = tabRights.empTabType;
        //             console.log(context.empTabTypes + " " + "jjj");
        //           }
        //          if(tabRights.empTabAdd == "Y"){


        //          }
        //   if(tabRights.empTabEdit == "Y"){

        //   }



        // });

      },
      error => {
      },
      () => { }
    );
    this.profileService.getTabRights(this.userCode).subscribe(resemployee => {
      this.data = JSON.parse(JSON.stringify(resemployee))

      for (let method of this.data) {
        if (method.empTabAppEmploy == "Y" && method.empTabEdit == "Y") {

          this.arr.push(method);
          if (method.empTabType == "Education") {

            this.profileService.getEmpEducationDetails(this.userCode).subscribe(response => {
              this.EducationDetails = JSON.parse(JSON.stringify(response))
              console.log(this.EducationDetails + "edu");

              if (this.EducationDetails == null) {
                this.showAddLink = true;
              }
              else {
                this.showEditLink = true;
              }
            }
            );


          }

          if (method.empTabAdd == "Y") {
            this.showAddLink = true;
          }

          if (method.empTabEdit == "Y") {
            this.showEditLink = true;
          }

        }

      }
    });


    this.empId = sessionStorage.getItem("userCode")

    this.titleService.setTitle("Education Profile");

    this.educationForm = new FormGroup({
      eduLevelId: new FormControl('', [Validators.required]),
      qualification: new FormControl('', [Validators.required]),
      college: new FormControl('', [Validators.required]),
      spec: new FormControl('', [Validators.required]),
      year: new FormControl('', [Validators.required]),
      egrade: new FormControl('', [Validators.required]),
      empHighest: new FormControl('', [Validators.required]),

    });

    this.profileService.getEmployeeDetails(this.userCode).subscribe
      ((result: any) => {
        console.log(result + "json")
        this.EmpDetailss = JSON.parse(JSON.stringify(result));
        console.log(this.EmpDetailss + "dgh")



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

    // this.profileService.getQualificationDetails(this.route.snapshot.params['id'])
    //   .subscribe((result: any) => {
    //     console.log(result);
    //     this.educationForm.get('fname').setValue(result.firstName);
    //     this.educationForm.get('lname').setValue(result.lastName);
    //     this.educationForm.get('mnum').setValue(result.mobileNumber);
    //     this.educationForm.get('email').setValue(result.email);
    //     this.educationForm.get('add').setValue(result.address);
    //     this.educationForm.get('uid').setValue(result.userId);
    //     this.educationForm.get('custId').setValue(result.customerId);


  }
  onFormSubmit() {
    this.growler.growl('Education Details Invalid!', GrowlerMessageType.Danger);

    this.isValidFormSubmitted = false;
    if (this.educationForm.invalid) {
      return;
    }
    console.log("dssd")
    this.isValidFormSubmitted = true;
    // console.log(this.educationForm.get('eduLevelId').value);
    this.myProfile.qualification = this.educationForm.get('qualification').value;
    this.myProfile.college = this.educationForm.get('college').value;
    this.myProfile.spec = this.educationForm.get('spec').value;
    this.myProfile.year = this.educationForm.get('year').value;
    this.myProfile.egrade = this.educationForm.get('egrade').value;
    this.myProfile.empHighest = this.educationForm.get('empHighest').value;
    // this.myProfile.moduleCode = "EIP_Attch_Edu";
    // this.myProfile.custId = this.custCode;
    this.myProfile.empId = this.userCode;
    // this.myProfile.file = this.fileToUpload;
    // this.myProfile.subTabType = "Education";
    this.profileService.addNewQualification(this.myProfile.empId, this.myProfile.college, this.myProfile.qualification, this.myProfile.spec, this.myProfile.year, this.myProfile.egrade, this.myProfile.empHighest, this.fileToUpload).subscribe(res => console.log(res));
    this.growler.growl('Education Details Submitted!', GrowlerMessageType.Success);


    this.openSnackBar();


  }

  reset() {
    this.educationForm.reset({
    });
  }
  openSnackBar() {
    this.snackBar.open(this.message, this.action, {
      duration: 3000,
    });
  }

  addNewQual() {
    this.showQual = true;
    this.showTableData = false;
  }

  handleFileInput(file: FileList) {
   
    if (fileValidator(file.item(0))){
   
   this.fileToUpload =file.item(0);
   
   
       //Show image preview
       var reader = new FileReader();
       reader.onload = (event: any) => {
         this.imageUrl = event.target.result;
         console.log("path data",event.target.result);
         
       }
       reader.readAsDataURL(this.fileToUpload);
   
   
   this.edu_img= false;
   
    }
    else {
   
    
   console.log("format is not supported");
   this.edu_img= true;
   
    }
  }

 

  // OnSubmit(Caption, Image) {
  //   this.profileService.postFile(Caption.value, this.fileToUpload).subscribe(
  //     data => {
  //       console.log('done');
  //       Caption.value = null;
  //       Image.value = null;
  //       this.imageUrl = "/assets/img/default-image.png";
  //     }
  //   );
  // }

}



// this.profileService.getEmployeeDetails(this.userCode).subscribe
//       ((result: any) => {

//         this.EmpDetails = JSON.parse(JSON.stringify(result));
//         console.log(this.EmpDetails + "dgh")


//         // result.forEach(request => {

//         //   if (request.buName == "Corporate")
//         //     console.log("dsd");

//         // }
//         // )
//       },
//       error => {
//       },
//       () => { }
//       );