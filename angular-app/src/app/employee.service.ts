import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Employee } from './employee';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  
  private employeesUrl = 'http://dummy.restapiexample.com/api/v1/employees';

  constructor(private http: HttpClient) { }

  getEmployees(): Observable<Employee> {
    return this.http.get<Employee>(this.employeesUrl);
  }
}
