import { Injectable } from '@angular/core';
import { Http, Response ,RequestOptions} from '@angular/http';
import { Router } from '@angular/router';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/toPromise';
import 'rxjs/add/operator/catch';
import { HttpClient, HttpHeaders, } from '@angular/common/http';
import { environment } from '../../../environments/environment';
import { Observable } from 'rxjs/Observable';

const httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };
  @Injectable()
  export class MyTeamService {
  
    baseUrl = environment.baseUrl;
  
  
    constructor(private http: HttpClient, private router: Router) { }
    GetMyTeamDetails(userCode, customerCode) {
        var headers = new HttpHeaders({ 'Content-type': "text/plain", 'Access-Control-Allow-Origin': "*" });
    
        return this.http.get(this.baseUrl + '/myteam?customerId=' + customerCode + '&userId=' + userCode, { headers: headers }).map((response: Response) => response);
      }
    }