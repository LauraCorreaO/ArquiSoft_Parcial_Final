package controller;

import model.DTOs.EmployeeXProjectResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
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
    public CollectionModel<EntityModel<EmployeeXProjectResponseDTO>> getProjectsByEmployeeId(@PathVariable Long employeeId) {

        List<EmployeeXProjectResponseDTO> projects = impGetProjectListService.getProjectsByEmployeeId(employeeId);

        List<EntityModel<EmployeeXProjectResponseDTO>> projectResources = projects.stream()
                .map(project -> {
                    EntityModel<EmployeeXProjectResponseDTO> projectResource = EntityModel.of(project);

                    projectResource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EmployeeXProjectController.class)
                            .getProjectsByEmployeeId(employeeId)).withSelfRel());

                    projectResource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EmployeeXProjectController.class)
                            .getProjectsByEmployeeId(employeeId)).withRel("employee-details"));

                    return projectResource;
                })
                .toList();

        CollectionModel<EntityModel<EmployeeXProjectResponseDTO>> collectionModel = CollectionModel.of(projectResources);

        collectionModel.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EmployeeXProjectController.class)
                .getProjectsByEmployeeId(employeeId)).withSelfRel());

        return collectionModel;
    }


}
