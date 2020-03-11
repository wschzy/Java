import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './page/login/login.component';
import { IndexComponent } from './page/index/index.component';
import { PersonalComponent } from './page/personal/personal.component';
import { SpendComponent } from './page/spend/spend.component';
import { CategoryComponent } from './page/category/category.component';
import { AddFamilyComponent } from './page/add-family/add-family.component';
import { FamilyListComponent } from './page/family-list/family-list.component';
import { TaskComponent } from './page/task/task.component';
import { UserComponent } from './page/user/user.component';
import { AddUserComponent } from './page/add-user/add-user.component';
import { OverviewComponent } from './page/overview/overview.component';
import { RankComponent } from './page/rank/rank.component';
const routes: Routes = [
  { path:'login',component:LoginComponent,pathMatch:'full' },
  { path:'',component:LoginComponent},
  {path:'index',component:IndexComponent},
  {path:'personal',component:PersonalComponent},
  {path:'spend',component:SpendComponent},
  {path:'category',component:CategoryComponent},
  {path:'add-family',component:AddFamilyComponent},
  {path:'family-list',component:FamilyListComponent},
  {path:'task',component:TaskComponent},
  {path:'user',component:UserComponent},
  {path:'add-user',component:AddUserComponent},
  {path:'overview',component:OverviewComponent},
  {path:'rank',component:RankComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
