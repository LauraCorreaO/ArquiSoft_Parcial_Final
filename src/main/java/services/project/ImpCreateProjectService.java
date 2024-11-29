package services.project;

import model.DTOs.ProjectDTO;
import model.DTOs.ProjectResponseDTO;
import model.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.IProjectRepository;

@Service
public class ImpCreateProjectService implements ICreateProjectService{
    @Autowired
    private IProjectRepository projectRepository;

    @Override
    public ProjectResponseDTO createProject(ProjectDTO projectDTO) {
        // Convertir el ProjectDTO a la entidad Project
        Project project = new Project();
        project.setProject_name(projectDTO.getProject_name());
        project.setDescription(projectDTO.getDescription());
        // Aquí puedes agregar más campos si es necesario

        // Guardar el proyecto en la base de datos
        Project savedProject = projectRepository.save(project);

        // Convertir el Project guardado a un ProjectResponseDTO
        ProjectResponseDTO responseDTO = new ProjectResponseDTO();
        responseDTO.setId(savedProject.getId().toString());
        responseDTO.setProject_name(savedProject.getProject_name());
        responseDTO.setDescription(savedProject.getDescription());
        responseDTO.setStart_date(savedProject.getStart_date());
        responseDTO.setEnd_date(savedProject.getEnd_date());
        responseDTO.setState(savedProject.getState());

        return responseDTO;
    }
}
