import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RecipesContainerComponent } from './recipes-container/recipes-container.component';
import { RecipeFormComponent } from './recipe-form/recipe-form.component';
import { LandingPageContainerComponent } from './landing-page-container/landing-page-container.component';
import { LoginComponent } from './login/login.component';
import { RecipeViewComponent } from './recipe-view/recipe-view.component';

const routes: Routes = [
  {path:'Home',component: LandingPageContainerComponent},
  {path:'',component: LandingPageContainerComponent},

  {path:'recipeform',component: RecipeFormComponent},
  {path:'recipe',component: RecipeViewComponent},
  {path:'recipes',component:RecipesContainerComponent},
  {path:'login',component: LoginComponent}


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
