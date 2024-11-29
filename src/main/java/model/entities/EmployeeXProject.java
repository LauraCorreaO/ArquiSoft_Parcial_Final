package model.entities;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "employee_x_project")
public class EmployeeXProject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id_employee_x_project")
    private Long idEmployeeXProject;

    @ManyToOne
    @JoinColumn(name = "id_employee", nullable = false)
    private Employee employee; //FK Empleado

    @ManyToOne
    @JoinColumn(name = "id_project", nullable = false)
    private Project project;   //FK Proyecto
}
