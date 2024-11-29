package model.DTOs;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeXProjectResponseDTO {
    private Long employee;
    private String employeeName;
    private List<EmployeeXProjectResponseDTO> projects;
}
