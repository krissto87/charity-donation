package krissto87.charity.dtos;

import krissto87.charity.validation.constraints.SamePasswords;
import lombok.Data;
import javax.validation.constraints.*;

@Data @SamePasswords
public class RegistrationDataDTO {

    @NotBlank @Email
    private String email;
    @NotBlank
    private String name;
    @NotBlank
    private String surname;
    @NotBlank
    private String password;
    @NotBlank
    private String rePassword;
}
