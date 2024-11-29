package services.employeeXproject;

import model.DTOs.EmployeeXProjectResponseDTO;
import model.entities.EmployeeXProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.IEmployeeXProjectRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ImpGetProjectListService {
    @Autowired
    private IEmployeeXProjectRepository employeeXProjectRepository;

    public List<EmployeeXProjectResponseDTO> getProjectsByEmployeeId(Long employeeId) {
        List<EmployeeXProject> employeeXProjects = employeeXProjectRepository.findByEmployeeId(employeeId);

        return employeeXProjects.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private EmployeeXProjectResponseDTO convertToDTO(EmployeeXProject entity) {
        EmployeeXProjectResponseDTO dto = new EmployeeXProjectResponseDTO();
        dto.setEmployee(entity.getEmployee().getId());
        return dto;
    }
}
