import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from '../environments/environment.prod'


@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private httpClient:HttpClient) { }

  

  login(userDetails:any){
    let url  = `${environment.baseurl}/login`
     return this.httpClient.post(url,userDetails);
  }

  RegiterUser(registerData:any){
    let url  = `${environment.baseurl}/api/users`
    return this.httpClient.post(url,registerData);

  }


}
