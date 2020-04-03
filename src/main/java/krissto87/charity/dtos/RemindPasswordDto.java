package krissto87.charity.dtos;

import lombok.Data;

import javax.validation.constraints.Email;

@Data
public class RemindPasswordDto {

    @Email
    private String email;
}
