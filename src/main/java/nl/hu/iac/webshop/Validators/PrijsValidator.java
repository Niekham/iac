package nl.hu.iac.webshop.Validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PrijsValidator implements
        ConstraintValidator<PrijsConstraint, Double> {
    @Override
    public void initialize(PrijsConstraint prijs) {
    }
    @Override
    public boolean isValid(Double prijs,
                           ConstraintValidatorContext cxt) {
        return prijs != null && (prijs > 0);
    }

}
