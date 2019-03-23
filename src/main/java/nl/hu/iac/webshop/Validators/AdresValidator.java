package nl.hu.iac.webshop.Validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class AdresValidator implements
        ConstraintValidator<AdresConstraint, String> {
    @Override
    public void initialize(AdresConstraint adres) {
    }
    @Override
    public boolean isValid(String adres,
                           ConstraintValidatorContext cxt) {
        return adres != null && adres.length() <=6;
    }
}
