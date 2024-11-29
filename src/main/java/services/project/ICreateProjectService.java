package services.project;

import model.DTOs.ProjectDTO;
import model.DTOs.ProjectResponseDTO;
import model.entities.Project;

public interface ICreateProjectService {
    ProjectResponseDTO createProject(ProjectDTO project);
}
