package services.employee;

import model.DTOs.EmployeeDTO;
import model.entities.Employee;

public interface ICreateEmployeeService {
    Employee createEmployee(EmployeeDTO employee);
}
