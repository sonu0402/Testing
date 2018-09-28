import { Injectable } from '@angular/core';
import { Http, Response ,RequestOptions} from '@angular/http';
import { Router } from '@angular/router';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/toPromise';
import 'rxjs/add/operator/catch';
import { HttpClient, HttpHeaders, } from '@angular/common/http';
import { environment } from '../../environments/environment';
import { Observable } from 'rxjs/Observable';


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};
@Injectable()
export class EIPService {

  baseUrl = environment.baseUrl;


  constructor(private http: HttpClient, private router: Router) { }

  GetMyTeamDetails(userCode, customerCode) {
    var headers = new HttpHeaders({ 'Content-type': "text/plain", 'Access-Control-Allow-Origin': "*" });

    return this.http.get(this.baseUrl + '/myteam?customerId=' + customerCode + '&userId=' + userCode, { headers: headers }).map((response: Response) => response);
  }

  // addNewQualification(myProfile){
  //   var body = JSON.stringify(myProfile);
  //   console.log(body);

  // 	return this.http.post(this.baseUrl + '/emp-education' + '/Education', body, {});
  // }

  getQualificationDetails(id) {

  }


  getTabRights(userCode) {
    var headers = new HttpHeaders({ 'Content-type': "text/plain", 'Access-Control-Allow-Origin': "*" });

    return this.http.get(this.baseUrl + '/tabsrights/' + 817, { headers: headers }).map((response: Response) => response);

  }

  getEmployeeDetails(userCode) {
    var headers = new HttpHeaders({ 'Content-type': "text/plain", 'Access-Control-Allow-Origin': "*" });

    return this.http.get(this.baseUrl + '/mydetails/' + userCode, { headers: headers }).map((response: Response) => response);
  }

  getEmpEducationDetails(userCode) {
    var headers = new HttpHeaders({ 'Content-type': "text/plain", 'Access-Control-Allow-Origin': "*" });

    return this.http.get(this.baseUrl + '/emp-educations/' + userCode, { headers: headers }).map((response: Response) => response);
  }

  addNewQualification(empId,college,qualification,spec,year,egrade,empHighest,fileToUpload: File): Observable <any> {
    var headers = new HttpHeaders();
  headers.append('Content-Type', 'application/form-data');

    // const endpoint = 'http://localhost:28101/api/UploadImage';
    const formData: FormData = new FormData();
    formData.append('empId', empId);
    formData.append('file', fileToUpload);
    formData.append('moduleCode', "EIP_Attch_Edu");
    formData.append('custId', "1");
     formData.append('college', college);
     formData.append('qualification', qualification);
     formData.append('spec', spec);
     formData.append('year', year);
     formData.append('egrade', egrade);
     formData.append('empHighest', empHighest);

    //  formData.append('employeeEducation', JSON.stringify(myProfile));
    return this.http
      .post(this.baseUrl + '/emp-education' + '/Education', formData) .map((response: Response) => {
        return response;
        
    })
  }
}