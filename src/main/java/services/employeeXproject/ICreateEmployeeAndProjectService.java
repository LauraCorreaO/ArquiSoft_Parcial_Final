package services.employeeXproject;

import model.DTOs.EmployeeDTO;
import model.DTOs.ProjectDTO;
import model.entities.Employee;

public interface ICreateEmployeeAndProjectService {
    Employee createEmployeeAndProject(EmployeeDTO employeeDTO, ProjectDTO projectDTO);
}
