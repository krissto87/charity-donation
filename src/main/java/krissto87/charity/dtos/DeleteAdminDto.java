package krissto87.charity.dtos;

import krissto87.charity.validation.constraints.ActiveAdmin;
import lombok.Data;

@Data @ActiveAdmin
public class DeleteAdminDto {

    private Long id;
    private String email;

}
