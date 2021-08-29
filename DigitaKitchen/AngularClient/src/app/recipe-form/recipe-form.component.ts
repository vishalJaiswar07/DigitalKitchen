import { Component, OnInit } from '@angular/core';
import { RecipeFormService } from '../recipe-form.service';
import { HttpClient } from '@angular/common/http';
import {FormArray, FormControl, FormGroup,Validators, FormBuilder} from '@angular/forms';
import firebase from 'firebase';


@Component({
  selector: 'app-recipe-form',
  templateUrl: './recipe-form.component.html',
  styleUrls: ['./recipe-form.component.css']
})
export class RecipeFormComponent  {

  Imagefile: any;
  recipe:any;
  imageUrl:any;


  profileFormGroup: FormGroup = this.fb.group({
    name: ['', [Validators.required]],
    preparation_time: ['', [Validators.required]],
    total_time: ['', [Validators.required]],
    ImageUrl: [''],
    nutrition: this.fb.array([]),
    category: this.fb.array([]),
    items: this.fb.array([]),
    process: this.fb.array([])

  });


  get items(){
    return this.profileFormGroup.controls['items'] as FormArray
  }
  get category(){
    return this.profileFormGroup.controls['category'] as FormArray
  }
  get process(){
    
    return this.profileFormGroup.controls['process'] as FormArray
  }
  get nutrition(){
    return this.profileFormGroup.controls['nutrition'] as FormArray
  }

  handleFileInput(files: any){
    this.Imagefile = files.item(0);
    this.fireBaseUpload();



  }
  fireBaseUpload(){
    let name="123"+Date.now();
    let storageRef = firebase.storage().ref('/images/'+ name);
    let uploadTask = storageRef.put(this.Imagefile);
    uploadTask.on('state_changed',(snapshot)=>{

      switch (snapshot.state) {
        case firebase.storage.TaskState.PAUSED:
          console.log('Upload is paused');
          break;
        case firebase.storage.TaskState.RUNNING:
          console.log('Upload is running');
          break;
      }


    },(error)=>{console.log(error)},()=>{
      uploadTask.snapshot.ref.getDownloadURL().then(
        (downloadURL)=> {

       // You get your url from here
        console.log('File available at', downloadURL);
        this.imageUrl=downloadURL;

      
     
    });
    });


  }

  handleSubmit(event: any) {

    if (this.profileFormGroup.valid) {
      let categoryList= this.profileFormGroup.controls['category'].value.map( ( el:any )=>{ 
        return el.category; 
       });

       let stepsList= this.profileFormGroup.controls['process'].value.map( ( el:any )=>{
        return el.process; 
       } );

      this.recipe={
        name:this.profileFormGroup.controls['name'].value,
        preparation_time:this.profileFormGroup.controls['preparation_time'].value,
        image_url:this.imageUrl,
        total_time:this.profileFormGroup.controls['total_time'].value ,
        nutrition:this.profileFormGroup.controls['nutrition'].value,
        category:categoryList,
        items:this.profileFormGroup.controls['items'].value ,
        process:stepsList 
      }

   console.log(this.recipe);
   this.recipeService.saveRecipe(this.recipe).subscribe((response)=>{
    console.log(response);
  },(err)=>{
    console.log(err);
  });



  }
  this.profileFormGroup.reset()
}


  addNewItems() {
    const ItemForm: FormGroup = this.fb.group({
      ingredients: [''],
      amount: [0]
    })
    this.items.push(ItemForm)
  }
  addNewNutrition() {
    const NutritionForm: FormGroup = this.fb.group({
      nutrition: [''],
      amount: [0]
    })
    this.nutrition.push(NutritionForm)
  }
  addNewCategory() {
    const CategoryForm: FormGroup = this.fb.group({
      category: ['']
    })
    this.category.push(CategoryForm)
  }
  addNewProcess() {
    const ProcessForm: FormGroup = this.fb.group({
      process: ['']
    })
    
    this.process.push(ProcessForm)
  }


  removeCategory(idx:number) {
    this.category.removeAt(idx)
  }

  removeItems(idx:number) {
    this.items.removeAt(idx)
  }
  removeProcess(idx:number) {
    this.process.removeAt(idx)
  }

  removeNutrition(idx:number) {
    this.nutrition.removeAt(idx)
  }

  constructor(private fb: FormBuilder,private recipeService:RecipeFormService) { }

  ngOnInit(): void {
  }

}
