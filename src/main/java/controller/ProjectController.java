package controller;

import model.DTOs.ProjectDTO;
import model.DTOs.ProjectResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.project.ICreateProjectService;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    private ICreateProjectService createProjectService;

    private static final Logger logger = LoggerFactory.getLogger(ProjectController.class);
    @PostMapping
    public ResponseEntity<ProjectResponseDTO> createProject(@RequestBody ProjectDTO projectDTO) {
        ProjectResponseDTO responseDTO = createProjectService.createProject(projectDTO);

        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }
}
