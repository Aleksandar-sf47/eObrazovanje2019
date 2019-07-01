import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";
import { AdminComponent } from "./components/admin/admin.component";
import { LoginComponent } from "./components/login/login.component";
import { NastavnikDetaljiComponent } from './components/nastavnik-detalji/nastavnik-detalji.component';
import { UceniciDetaljiComponent } from './components/ucenici-detalji/ucenici-detalji.component';
import { PredmetDetaljiComponent } from './components/predmet-detalji/predmet-detalji.component';

const routes: Routes = [
  { path: "", component: AdminComponent },
  { path: "login", component: LoginComponent },
  { path: "nastavnik-details/:id", component: NastavnikDetaljiComponent},
  { path: "ucenik-details/:id", component : UceniciDetaljiComponent},
  { path: "predmet-details/:id", component: PredmetDetaljiComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
