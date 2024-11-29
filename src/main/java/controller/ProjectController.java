package controller;

import model.DTOs.ProjectDTO;
import model.DTOs.ProjectResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
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
    public ResponseEntity<EntityModel<ProjectResponseDTO>> createProject(@RequestBody ProjectDTO projectDTO) {
        ProjectResponseDTO responseDTO = createProjectService.createProject(projectDTO);

        EntityModel<ProjectResponseDTO> projectResource = EntityModel.of(responseDTO);

        projectResource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProjectController.class)
                .createProject(projectDTO)).withSelfRel());

        projectResource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProjectController.class)
                .createProject(projectDTO)).withRel("update"));

        return new ResponseEntity<>(projectResource, HttpStatus.CREATED);
    }
}
