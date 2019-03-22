package nl.hu.iac.webshop.Validators;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PrijsValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface PrijsConstraint {
    String message() default "Foutieve prijs";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
