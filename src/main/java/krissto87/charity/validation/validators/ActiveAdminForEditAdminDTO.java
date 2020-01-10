package krissto87.charity.validation.validators;

import krissto87.charity.dtos.DeleteAdminDTO;
import krissto87.charity.utils.GeneralUtils;
import krissto87.charity.validation.constraints.ActiveAdmin;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ActiveAdminForEditAdminDTO implements ConstraintValidator<ActiveAdmin, DeleteAdminDTO> {

    @Override
    public void initialize(ActiveAdmin constraint) {

    }

    @Override
    public boolean isValid(DeleteAdminDTO adminDTO, ConstraintValidatorContext context) {
            boolean valid = adminDTO.getEmail().equals(GeneralUtils.getUsername());
            if (valid) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate("You can't delete logged admin!")
                        .addConstraintViolation();
            }
            return !valid;
    }
}
