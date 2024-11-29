package model.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjectResponseDTO {
    private String id;
    private String project_name;
    private String description;
    private String start_date;
    private String end_date;
    private String state;
}
