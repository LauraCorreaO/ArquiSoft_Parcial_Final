package services.employeeXproject;

import model.DTOs.EmployeeDTO;
import model.DTOs.ProjectDTO; // DTO para el proyecto
import model.entities.Employee;
import model.entities.Project;
import model.entities.EmployeeXProject;
import repository.IEmployeeRepository;
import repository.IProjectRepository;
import repository.IEmployeeXProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpCreateEmployeeAndProjectService implements ICreateEmployeeAndProjectService {

    @Autowired
    private IEmployeeRepository employeeRepository;

    @Autowired
    private IProjectRepository projectRepository;

    @Autowired
    private IEmployeeXProjectRepository employeeXProjectRepository;

    @Override
    public Employee createEmployeeAndProject(EmployeeDTO employeeDTO, ProjectDTO projectDTO) {
        Employee employee = new Employee();
        employee.setName(employeeDTO.getName());
        employee.setEmail(employeeDTO.getEmail());
        employee.setDni(employeeDTO.getDni());
        employee.setCharge(employeeDTO.getCharge());
        employee = employeeRepository.save(employee);

        Project project = new Project();
        project.setProject_name(projectDTO.getProject_name());
        project.setDescription(projectDTO.getDescription());
        project = projectRepository.save(project);

        EmployeeXProject employeeXProject = new EmployeeXProject();
        employeeXProject.setEmployee(employee);
        employeeXProject.setProject(project);
        employeeXProjectRepository.save(employeeXProject);

        return employee;
    }
}
