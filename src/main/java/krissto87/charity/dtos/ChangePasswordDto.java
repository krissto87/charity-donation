package krissto87.charity.dtos;

import krissto87.charity.validation.constraints.SamePasswords;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data @SamePasswords
public class ChangePasswordDto {

    @NotBlank
    private String password;
    private String rePassword;
}
