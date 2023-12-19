import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { StudentsComponent } from './students/students.component';
import { StudentsAgeComponent } from './students-age/students-age.component';
import { AppRoutingModule } from './app-routing.module';

import { HttpClientModule }    from '@angular/common/http';
import { EmployeesComponent } from './employees/employees.component';

@NgModule({
  declarations: [
    AppComponent,
    StudentsComponent,
    StudentsAgeComponent,
    EmployeesComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
