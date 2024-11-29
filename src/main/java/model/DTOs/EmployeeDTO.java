package model.DTOs;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDTO {
    private String id;
    private String name;
    private String email;
    private String dni;
    private String charge;
}
