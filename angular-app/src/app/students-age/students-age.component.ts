import { Component, OnInit, Input } from '@angular/core';

@Component({ 
  selector: 'app-students-age',
  templateUrl: './students-age.component.html',
  styleUrls: ['./students-age.component.css']
})
export class StudentsAgeComponent implements OnInit {

  @Input() studentAge : number;

  constructor() { }

  ngOnInit() {
  }

}
