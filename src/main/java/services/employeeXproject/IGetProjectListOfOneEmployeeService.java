package services.employeeXproject;

import model.DTOs.EmployeeXProjectResponseDTO;

public interface IGetProjectListOfOneEmployeeService {
    EmployeeXProjectResponseDTO getProjectList(Long idEmpleado);
}

