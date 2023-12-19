import { Component, OnInit } from '@angular/core';
import { Student } from '../student'
import { StudentService } from '../student.service'

@Component({
  selector: 'app-students',
  templateUrl: './students.component.html',
  styleUrls: ['./students.component.css']
})
export class StudentsComponent implements OnInit {

  students : Student[];

  selectedStudentAge: number;

  onSelect(age: number): void {
    this.selectedStudentAge = age;
  }

  constructor(private studentService: StudentService) { }

  ngOnInit() {
    this.getStudents();
  }

  getStudents(): void {
    //let obj = new StudentService();
    this.students = this.studentService.getStudents();
  }

}
