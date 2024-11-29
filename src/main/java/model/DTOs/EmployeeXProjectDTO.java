package model.DTOs;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import model.entities.Employee;
import model.entities.Project;

import java.util.List;

public class EmployeeXProjectDTO {
    private Long idEmployee;
    private Long idProject;
}


