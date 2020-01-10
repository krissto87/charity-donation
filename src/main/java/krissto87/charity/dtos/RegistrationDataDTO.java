package krissto87.charity.dtos;

import krissto87.charity.validation.constraints.SamePasswords;
import krissto87.charity.validation.constraints.ValidPassword;
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
    @ValidPassword
    private String password;
    private String rePassword;
}
