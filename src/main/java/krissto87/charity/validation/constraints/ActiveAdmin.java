package krissto87.charity.validation.constraints;


import krissto87.charity.validation.validators.ActiveAdminForDeleteAdminDTO;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ActiveAdminForDeleteAdminDTO.class)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ActiveAdmin {
    String message() default "{krissto87.charity.validation.constraints.ActiveAdmin.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
