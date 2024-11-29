package repository;

import model.entities.EmployeeXProject;
import model.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IEmployeeXProjectRepository extends JpaRepository<EmployeeXProject, Long> {
    List<EmployeeXProject> findByEmployeeId(Long employeeId);
}
