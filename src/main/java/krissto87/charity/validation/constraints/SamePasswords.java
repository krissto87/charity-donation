package krissto87.charity.validation.constraints;

import krissto87.charity.validation.validators.SamePasswordsValidatorForChangePasswordDto;
import krissto87.charity.validation.validators.SamePasswordsValidatorForRegistrationDataDto;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = {SamePasswordsValidatorForRegistrationDataDto.class,
        SamePasswordsValidatorForChangePasswordDto.class})
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface SamePasswords {
    String message() default "";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
