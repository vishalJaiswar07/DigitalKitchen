import { Component, OnInit, ViewChild} from '@angular/core';
import { LoginService } from '../login.service';
import { RecipeFormService } from '../recipe-form.service';
import { RegisterService } from '../register.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  @ViewChild("loginform") loginValue :  any
  @ViewChild("registerform") registerValue :  any

  

  constructor(private loginService:LoginService,private registerService:RegisterService,private recipeService:RecipeFormService) {}
  
  myToken:any;
  loginErrorMessage: string | null = ""
  
  ngOnInit(): void {
  }

  OnSubmit(loginData:any){  
    console.log(loginData);
    
    this.loginService.login(loginData).subscribe(
     { next: (response: any) => {
       console.log(response);
        this.loginErrorMessage=null;
        localStorage.setItem("Auth-Token", response.jwt)
     //   this.router.navigate(['RecipeFormComponent'])
      },
      error: (err: any) => {
        this.loginErrorMessage=err.error.messsage
      }}
      
    );
    this.loginValue.reset('')

  }

  onRegiterFormSubmit(registerData:any){
    console.log(registerData)
    this.loginService.RegiterUser(registerData).subscribe((response:any)=>{
      console.log(response);

    })
    console.log("Regiestered Succesufully")


  

    this.registerValue.reset('')
  }
  isShow = false
  showForm(){
    console.log("Displayed")
    this.isShow = !this.isShow;
  }
}
