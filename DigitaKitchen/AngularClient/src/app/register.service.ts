import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from '../environments/environment.prod'

@Injectable({
  providedIn: 'root'
})
export class RegisterService {

  constructor(private httpClient: HttpClient) { }

  register(userDetails:any){
    let url  = `${environment.baseurl}/api/users`
    return this.httpClient.post(url,userDetails);
  }
}
