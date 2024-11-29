package services.employee;

import model.DTOs.EmployeeDTO;
import model.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.IEmployeeRepository;

@Service
public class EmployeeService implements EmployeeInterface{
    @Autowired
    private IEmployeeRepository employeeRepository;

    @Override
    public Employee createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setName(employeeDTO.getName());
        employee.setEmail(employeeDTO.getEmail());
        employee.setDni(employeeDTO.getDni());
        employee.setCharge(employeeDTO.getCharge());

        return employeeRepository.save(employee);
    }
}
