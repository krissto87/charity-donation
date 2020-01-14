package krissto87.charity.validation.validators;

import krissto87.charity.dtos.RegistrationDataDTO;
import krissto87.charity.validation.constraints.SamePasswords;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class SamePasswordsValidatorForRegistrationDataDTO implements ConstraintValidator<SamePasswords, RegistrationDataDTO> {

    public void initialize(SamePasswords constraint) {
    }

    public boolean isValid(RegistrationDataDTO registrationData, ConstraintValidatorContext context) {
        if (registrationData.getPassword() == null || registrationData.getRePassword() == null) {
            return true;
        }
        else {
            boolean valid = registrationData.getPassword().equals(registrationData.getRePassword());
            if (!valid) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate("SamePasswords.registrationData.rePassword")
                        .addPropertyNode("rePassword").addConstraintViolation();
            }
            return valid;
        }
    }
}
