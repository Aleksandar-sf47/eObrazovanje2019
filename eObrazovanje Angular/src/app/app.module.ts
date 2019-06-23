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

@NgModule({
  declarations: [AppComponent, LoginComponent, AdminComponent, NavbarComponent, NastavnikComponent, NastavnikDodajComponent],
  imports: [BrowserModule, AppRoutingModule, FormsModule, HttpClientModule],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {}
