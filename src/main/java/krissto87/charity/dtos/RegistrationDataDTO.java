package krissto87.charity.dtos;

import lombok.Data;
import javax.validation.constraints.*;

@Data
public class RegistrationDataDTO {

    @NotBlank
    private String name;
    @NotBlank
    private String surname;
    @NotBlank @Email
    private String email;
    @NotBlank @Size(min = 4, max = 12)
    private String password;
    @NotBlank @Size(min = 4, max = 12)
    private String rePassword;
}
