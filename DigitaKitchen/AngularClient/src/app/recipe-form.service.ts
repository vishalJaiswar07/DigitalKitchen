import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from '../environments/environment.prod'



@Injectable({
  providedIn: 'root'
})
export class RecipeFormService {
  
  

  constructor(private httpClient: HttpClient) { 
    
    
  }
   


  saveRecipe(data:any){
  let url  = `${environment.baseurl}/api/private/recipes`
    return this.httpClient.post(url,data,{headers:{
      'Authorization':'Bearer '+localStorage.getItem("Auth-Token")
    }})
  }
}
