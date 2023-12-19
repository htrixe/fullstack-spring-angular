import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { StudentsComponent } from './students/students.component';
import { EmployeesComponent } from './employees/employees.component';

const routes: Routes = [
  { path: 'students', component: StudentsComponent },
  { path: 'employees', component: EmployeesComponent }
];

@NgModule({
  declarations: [],
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
