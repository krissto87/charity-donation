package krissto87.charity.validation.validators;

import krissto87.charity.dtos.ChangePasswordDto;
import krissto87.charity.validation.constraints.SamePasswords;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class SamePasswordsValidatorForChangePasswordDto implements ConstraintValidator<SamePasswords, ChangePasswordDto> {
    @Override
    public void initialize(SamePasswords constraint) {

    }

    @Override
    public boolean isValid(ChangePasswordDto changePassword, ConstraintValidatorContext context) {
        if (changePassword.getPassword() == null || changePassword.getRePassword() == null) {
            return true;
        }
        boolean valid = changePassword.getPassword().equals(changePassword.getRePassword());
        if (!valid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("SamePasswords.changePassword.rePassword")
                    .addPropertyNode("rePassword").addConstraintViolation();
        }
        return valid;
    }
}
