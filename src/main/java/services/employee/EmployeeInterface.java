package services.employee;

import model.DTOs.EmployeeDTO;
import model.DTOs.EmployeeXProjectResponseDTO;
import model.entities.Employee;

public interface EmployeeInterface {
    Employee createEmployee (EmployeeDTO empleado);
}
