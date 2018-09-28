import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Router } from '@angular/router';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/toPromise';
import 'rxjs/add/operator/catch';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from '../../environments/environment.prod';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};
@Injectable()
export class UtilsService {

  baseUrl = environment.baseUrl;


  constructor(private http: HttpClient, private router: Router) { }

  GetUsername(userCode) {
    var headers = new HttpHeaders({ 'Content-type': "text/plain", 'Access-Control-Allow-Origin': "*" });

    return this.http.get(this.baseUrl + '/username/' + userCode, { headers: headers }).map((response: Response) => response);
  }
}