import { BrowserModule } from "@angular/platform-browser";
import { NgModule } from "@angular/core";

import { AppRoutingModule } from "./app-routing.module";
import { AppComponent } from "./app.component";
import { LoginComponent } from "./components/login/login.component";
import { FormsModule } from "@angular/forms";
import { AdminComponent } from "./components/admin/admin.component";
import { NavbarComponent } from "./components/navbar/navbar.component";
import { HttpClientModule } from "@angular/common/http";
import { NastavnikComponent } from './components/nastavnik/nastavnik.component';
import { NastavnikDodajComponent } from './components/nastavnik-dodaj/nastavnik-dodaj.component';
import { NastavnikDetaljiComponent } from './components/nastavnik-detalji/nastavnik-detalji.component';
import { NastavnikEditComponent } from './components/nastavnik-edit/nastavnik-edit.component';
import { UceniciComponent } from './components/ucenici/ucenici.component';
import { UceniciDetaljiComponent } from './components/ucenici-detalji/ucenici-detalji.component';
import { UcenikDodajComponent } from './components/ucenik-dodaj/ucenik-dodaj.component';
import { UcenikEditComponent } from './components/ucenik-edit/ucenik-edit.component';
import { PredmetComponent } from './components/predmet/predmet.component';
import { PredmetDodajComponent } from './components/predmet-dodaj/predmet-dodaj.component';
import { PredmetDetaljiComponent } from './components/predmet-detalji/predmet-detalji.component';


@NgModule({
  declarations: [AppComponent, LoginComponent, AdminComponent, NavbarComponent, NastavnikComponent, NastavnikDodajComponent, NastavnikDetaljiComponent, NastavnikEditComponent, UceniciComponent, UceniciDetaljiComponent, UcenikDodajComponent, UcenikEditComponent, PredmetComponent, PredmetDodajComponent, PredmetDetaljiComponent],
  imports: [BrowserModule, AppRoutingModule, FormsModule, HttpClientModule],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {}
