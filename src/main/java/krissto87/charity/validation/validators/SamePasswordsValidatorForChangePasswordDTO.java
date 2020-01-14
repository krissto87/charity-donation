package krissto87.charity.validation.validators;

import krissto87.charity.dtos.ChangePasswordDTO;
import krissto87.charity.validation.constraints.SamePasswords;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class SamePasswordsValidatorForChangePasswordDTO implements ConstraintValidator<SamePasswords, ChangePasswordDTO> {
    @Override
    public void initialize(SamePasswords constraint) {

    }

    @Override
    public boolean isValid(ChangePasswordDTO changePasswordDTO, ConstraintValidatorContext context) {
        if (changePasswordDTO.getPassword() == null || changePasswordDTO.getRePassword() == null) {
            return true;
        }
        boolean valid = changePasswordDTO.getPassword().equals(changePasswordDTO.getRePassword());
        if (!valid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("SamePasswords.changePasswordDTO.rePassword")
                    .addPropertyNode("rePassword").addConstraintViolation();
        }
        return valid;
    }
}
