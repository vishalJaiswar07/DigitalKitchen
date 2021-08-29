import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Subject } from 'rxjs';
import {environment} from '../environments/environment.prod'

@Injectable({
  providedIn: 'root'
})
export class RecipeService {

  url:any;

  page:any=0

  recipeStream:Subject<any>=new Subject();

  

  constructor(private httpClient: HttpClient) { 
    
  }

  getNextPage(){
     let pg=localStorage.getItem("pageNo");
     let nextPg:any;
     if(pg!=null)
       nextPg = +pg;
    localStorage.setItem("pageNo",nextPg.toString())
    this.page=nextPg;
  }

  getPreviousPage(){
    let pg=localStorage.getItem("pageNo");
     let nextPg:any;
     if(pg!=null)
       nextPg = -pg;
    localStorage.setItem("pageNo",nextPg.toString())
    this.page=nextPg;
  }

  getAllRecipes(){
    this.url=`${environment.baseurl}/api/recipes/all?page=${this.page}`

    this.httpClient.get(this.url).subscribe((recipes:any)=>{
      this.recipeStream.next(recipes);
    });
  }

  getRecipeByName(name:any){
    this.url=`${environment.baseurl}/api/recipes/paginated/${name}?page=${this.page}`

    this.httpClient.get(this.url).subscribe((recipes:any)=>{
      this.recipeStream.next(recipes);
    });
  }

  getRecipeByCategory(category:any){
    this.url=`${environment.baseurl}/api/recipes/paginated/${category}?page=${this.page}`

    this.httpClient.get(this.url).subscribe((recipes:any)=>{
      this.recipeStream.next(recipes);
    });
  }


  getRecipeById(id:any){
    this.url=`${environment.baseurl}/api/recipes//${id}`

   return this.httpClient.get(this.url);
  }

}
