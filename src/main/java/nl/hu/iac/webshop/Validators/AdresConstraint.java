package nl.hu.iac.webshop.Validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = AdresValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface AdresConstraint {
    String message() default "Ongeldig Adres";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
