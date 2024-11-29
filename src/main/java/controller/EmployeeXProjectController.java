package controller;

import model.DTOs.EmployeeXProjectResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.employeeXproject.ImpGetProjectListService;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeXProjectController {
    @Autowired
    private ImpGetProjectListService impGetProjectListService;

    @GetMapping("/{employeeId}/projects")
    public List<EmployeeXProjectResponseDTO> getProjectsByEmployeeId(@PathVariable Long employeeId) {
        return impGetProjectListService.getProjectsByEmployeeId(employeeId);
    }


}
