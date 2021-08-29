import { Component, OnInit } from '@angular/core';
import {RecipeViewService} from '../recipe-view.service'


@Component({
  selector: 'app-recipe-view',
  templateUrl: './recipe-view.component.html',
  styleUrls: ['./recipe-view.component.css']
})
export class RecipeViewComponent implements OnInit {
  public NutritionAccordian=true;
  public IngredientsAccordian=true;
  public ProcessAccordian=true;
 



  constructor(private recipeViewService:RecipeViewService) { }

  ngOnInit(): void {
    
    

  }
  

  NutrientAccordianChange(){
    this.NutritionAccordian=!this.NutritionAccordian;
  }
  IngredientAccordianChange(){
    this.IngredientsAccordian=!this.IngredientsAccordian;
  }
  ProcessAccordianChange(){
    this.ProcessAccordian=!this.ProcessAccordian;


  }

  recipe=this.recipeViewService.getNewRecipe();

  

}
