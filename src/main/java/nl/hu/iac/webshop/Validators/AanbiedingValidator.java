package nl.hu.iac.webshop.Validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AanbiedingValidator implements
        ConstraintValidator<AanbiedingConstraint, Long> {
@Override
public void initialize(AanbiedingConstraint  aanbieding) {
        }
@Override
public boolean isValid(Long aanbieding,
        ConstraintValidatorContext cxt) {
        return aanbieding != 0 && (aanbieding < 100);
        }
}
