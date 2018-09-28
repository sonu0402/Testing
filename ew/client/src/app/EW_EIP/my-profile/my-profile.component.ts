import { Component, OnInit, Pipe, PipeTransform } from '@angular/core';
import { ModalService } from '../../EW_Utils/NgServices/modal.service';
import { ProfileDetailsModalComponent } from '../profile-details-modal/profile-details-modal.component';
import { Title } from '@angular/platform-browser';
import { UniquePipe } from '../../EW_Utils/NgPipes/unique.pipe';
import { MyProfileService } from './myProfile.service';
import { HttpClient, HttpHeaders, } from '@angular/common/http';
import { HttpErrorResponse } from '@angular/common/http';
import { GrowlerService, GrowlerMessageType } from '../../EW_Utils/NgServices/growler/growler.service';
import { ContactModalComponent } from '../contact-modal/contact-modal.component';
import { PersonalModalComponent } from '../personal-modal/personal-modal.component';
import { BenefitModalComponent } from '../benefit-modal/benefit-modal.component';
import { EmergencyModalComponent } from '../emergency-modal/emergency-modal.component';
import { CompensationModalComponent } from '../compensation-modal/compensation-modal.component';
import {AssetsModalComponent} from '../assets-modal/assets-modal.component';
@Component({
  selector: 'app-my-profile',
  templateUrl: './my-profile.component.html',

})
export class MyProfileComponent implements OnInit {
  show;
  userCode;
  tabRights;
  EmpDetails:any;
  ggg;
  filteration = [];
  empTabTypes;
  myvar: boolean = false;
  showAddLink: boolean = false;
  showEditLink: boolean = false;
  // showModal: boolean = false;
  EducationDetails;
  data = [];
  arrBirds = [];
  hide = [];
  wayout = [];
  custCode;
  Labels = {};
  rd = [];
  gd = [];
  wd = [];
  requiredFlag: boolean = false;
  showMandatoryFlag: boolean = false;
  // arr = [];

  constructor(private modalService: ModalService, private growler: GrowlerService, private httpService: HttpClient, private titleService: Title, private profileService: MyProfileService) { }

  ngOnInit() {
    this.custCode = sessionStorage.getItem("customerCode")
    let request = './assets/EIP_Labels_1_' + this.custCode + '.json';
    this.httpService.get(request).subscribe(
      data => {
        this.Labels = data;

        for (var key in this.Labels) {
          // console.log(key + "keyt");

          if (this.Labels[key]._req === 'Y') {

            this.Labels[key]._name = this.Labels[key]._name;
            console.log(this.Labels[key]._name + "name");
            this.requiredFlag = true;

            // console.log(this.Labels + "Labels");
          }

          if (this.Labels[key]._man === 'Y') {
            this.showMandatoryFlag = true;
          }

        }


        // this.arrBirds = data as string[];


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







        // this.filteration = JSON.parse(JSON.stringify(data))
        // console.log(this.filteration);

        // for (var req in data) {
        //   this.Labels[req] = data[req]._req;
        //   console.log(this.Labels[req]);

        //   if (this.Labels[req] == "Y") {

        //   }

        // }
        // for (let xxx of this.filteration) {
        //   console.log(xxx + "sss");

        // }




        // if (this.arrBirds[0][key]._req == 'Y') {
        //   this.rd = this.arrBirds[0][key]._name
        //   console.log(this.rd + "rd");

        // }
        // if (this.arrBirds[0][key]._man == 'Y') {
        //   this.gd = this.arrBirds[0][key]._name
        //   console.log(this.rd + "gd");

        // }
        // if (this.arrBirds[0][key]._man == 'N') {
        //   this.wd = this.arrBirds[0][key]._name
        //   console.log(this.rd + "wd");

        // }
        // this.Labels = this.arrBirds[0][key]._name;
        // console.log(key + "key")
        // }

        // for(var a in data){
        //  this.Labels[a] = data[a]._name;
        //  console.log(this.Labels);

        // }




        // this.arrBirds = data as string[];
        // for (let key in this.arrBirds[0]) {
        //   console.log(key + "ddd" + this.arrBirds[0][key]._name);
        //   this.Labels = this.arrBirds[0][key]._name;
        // }
        // for(let mey of this.arrBirds){
        //   console.log(mey);
        // }
      },
      (err: HttpErrorResponse) => {
        console.log(err.message);
      }
    );


    this.titleService.setTitle("My Profile");
    this.userCode = sessionStorage.getItem("userCode")

    // this.profileService.getTabRights(this.userCode).subscribe(
    //   (result: any) => {
    //     this.tabRights = JSON.parse(JSON.stringify(result));

    //     // console.log(this.tabRights.empSupviewApp + "dsds");
    //     // let context = this;
    //     //         var resultArray = Object.keys(result).map(function (tabRightsNamedIndex) {
    //     //           let tabRights = result[tabRightsNamedIndex];
    //     // console.log(tabRights + " "+ "sss");
    //     //           if (tabRights.empTabAppEmploy == "Y") {
    //     //             context.empTabTypes = tabRights.empTabType;
    //     //             console.log(context.empTabTypes + " " + "jjj");
    //     //           }
    //     //          if(tabRights.empTabAdd == "Y"){


    //     //          }
    //     //   if(tabRights.empTabEdit == "Y"){

    //     //   }



    //     // });

    //   },
    //   error => {
    //     console.log("Error is -", error);
    //   },
    //   () => { }
    // );
    this.profileService.getTabRights(this.userCode).subscribe(resemployee => {

      this.data = JSON.parse(JSON.stringify(resemployee))
      console.log("DSSDsd" + this.data)


      for (let method of this.data) {
        if (method.empTabAppEmploy == "Y" && method.empTabEdit == "Y") {

          // this.data = JSON.parse(JSON.stringify(this.data + "sssss"))
          this.data = JSON.parse(JSON.stringify(this.data))

          console.log(this.data + "ENTERED")
          // this.arr.push(method);
          if (method.empTabType == "Education") {

            this.profileService.getEmpEducationDetails(this.userCode).subscribe(response => {
              this.EducationDetails = JSON.parse(JSON.stringify(response))
              console.log("EducationDetails" + this.EducationDetails)

              if (this.EducationDetails == null) {
                this.showAddLink = true;
              }
              else {
                this.showEditLink = true;
              }
            }
            );


          }

          // if(method.empTabAdd == "Y"){
          //   this.showAddLink = true;
          // }

          // if(method.empTabEdit == "Y"){
          //   this.showEditLink = true;
          // }

        }

      }
    });

    this.profileService.getEmployeeDetails(this.userCode).subscribe
      (response => {
        // this.EmpDetails = response;
        this.EmpDetails = JSON.parse(JSON.stringify(response));
        // console.log(this.EmpDetails + "eee");
        // for (let kkk of this.EmpDetails) {
        //   alert("kkk")
        // }
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

  showModal(temp) {
    if (temp.empTabType == "Education")
      this.modalService.open(ProfileDetailsModalComponent, {
        height: '550px',
        width: '900px',
      })

      if (temp.empTabType == "Contact")
      this.modalService.open(ContactModalComponent, {
        height: '550px',
        width: '900px',
      })

      if (temp.empTabType == "Personal")
      this.modalService.open(PersonalModalComponent, {
        height: '550px',
        width: '900px',
      })


      if (temp.empTabType == "Default")
      this.modalService.open(BenefitModalComponent, {
        height: '550px',
        width: '900px',
      })


      if (temp.empTabType == "Emergency")
      this.modalService.open(EmergencyModalComponent, {
        height: '550px',
        width: '900px',
      })



      if (temp.empTabType == "Compensation")
      this.modalService.open(CompensationModalComponent, {
        height: '550px',
        width: '900px',
      })

      if (temp.empTabType == "Assets")
      this.modalService.open(AssetsModalComponent, {
        height: '550px',
        width: '900px',
      }) 





  }

}

