package nl.hu.iac.webshop.Validators;

import javax.validation.Payload;
import javax.validation.Constraint;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = AanbiedingValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface AanbiedingConstraint {
    String message() default "Ongeldige Aanbieding";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
