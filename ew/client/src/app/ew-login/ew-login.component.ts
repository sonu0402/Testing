import { Component, OnInit } from '@angular/core';
import { LOCAL_STORAGE, WebStorageService } from 'angular-webstorage-service';
@Component({
  selector: 'app-ew-login',
  templateUrl: './ew-login.component.html'
})
export class EwLoginComponent implements OnInit {
  companyList;
  usersList;
  userCode;
  companyCode;
  customerCode;
  public data: any = []


  loginData = [
    {
      "CustomerName": "sony",
      "code": 1,
      "companies": [
        {
          "CompanyName": "Sony India Pvt. Ltd.",
          "code": 621,
          "users": [
            {
              userName: "central admin Administrator",
              userId: "1"
            },
            {
              userName: "Sanjay Kr. Bhatnagar",
              userId: "1"
            }
          ]
        }
      ]
    },
 
    {
      "CustomerName": "ggsl",
      "code": 4,
 
 
      "companies": [
        {
 
          "CompanyName": "Global Groupware Solutions Limited",
          "code": 2,
 
          "users": [
            {
              userName: "Pankaj Kumar",
              userId: "153"
            },
            {
              userName: "Pankaj Kumar bhatnagar",
              userId: "18799"
            }
 
          ]
        }
      ]
    },
 
    {
      "CustomerName": "people",
      "code": 47,
 
 
      "companies": [
        {
 
          "CompanyName": "People Pvt Ltd",
          "code": 21,
 
          "users": [
            {
              userName: "nishant Kumar",
              userId: "150"
            },
            {
              userName: "Suraj yadav",
              userId: "150"
 
 
            }
 
          ]
        }
      
      ]
    }
  ]



  ngOnInit() {

  }

  onCustomerNameChange(customerSelected) {

    for (let customer of this.loginData) {
      if (customer.CustomerName == customerSelected) {
        this.customerCode=customer.code;
        this.companyList = customer.companies;
        break;

      }

    }
    sessionStorage.setItem("customerCode",this.customerCode)
    console.log(this.customerCode + "ss");

  }

  onCompanyNameChange(companySelected) {


    for (let customer of this.companyList) {
      if (customer.CompanyName == companySelected) {
        this.usersList = customer.users;
        this.companyCode = customer.code;
        console.log(this.companyCode);


      }

    }
    sessionStorage.setItem("companyCode", this.companyCode);
  }
  userSelection(user) {

    for (let users of this.usersList) {
      if (users.userName == user) {
        this.userCode = users.userId;
        console.log("userCode" + this.userCode);

      }

    }
    sessionStorage.setItem("userCode", this.userCode);

  }
}


