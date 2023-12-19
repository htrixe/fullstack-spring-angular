export interface Employee {
    status: string;
    data?: (DataEntity)[] | null;
  }
  export interface DataEntity {
    id: string;
    employee_name: string;
    employee_salary: string;
    employee_age: string;
    profile_image: string;
  }
  