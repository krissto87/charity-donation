package krissto87.charity.dtos;

import lombok.Data;

@Data
public class EditUserDTO {


    private Long id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private Boolean active;
}
