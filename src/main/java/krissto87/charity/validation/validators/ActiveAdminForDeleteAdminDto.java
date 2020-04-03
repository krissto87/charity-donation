package krissto87.charity.validation.validators;

import krissto87.charity.dtos.DeleteAdminDto;
import krissto87.charity.utils.GeneralUtils;
import krissto87.charity.validation.constraints.ActiveAdmin;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ActiveAdminForDeleteAdminDto implements ConstraintValidator<ActiveAdmin, DeleteAdminDto> {

    @Override
    public void initialize(ActiveAdmin constraint) {

    }

    @Override
    public boolean isValid(DeleteAdminDto adminDTO, ConstraintValidatorContext context) {
            boolean valid = adminDTO.getEmail().equals(GeneralUtils.getUsername());
            if (valid) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate("ActiveAdmin.admin.*")
                        .addConstraintViolation();
            }
            return !valid;
    }
}
