package hn.jiah.apivalidatorbean.constrait;

import hn.jiah.apivalidatorbean.annotation.ValidUsername;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Objects;

public class ValidUsernameConstraint implements ConstraintValidator<ValidUsername, String> {
    @Override
    public void initialize(ValidUsername constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String input, ConstraintValidatorContext constraintValidatorContext) {
        constraintValidatorContext.disableDefaultConstraintViolation();
        return !isInvalidUsername(input, constraintValidatorContext);
    }

    private boolean isInvalidUsername(String username, ConstraintValidatorContext constraintValidatorContext) {
        if(Objects.isNull(username) || username.isBlank()){
            constraintValidatorContext.buildConstraintViolationWithTemplate("{username.notempty}").addConstraintViolation();
            return true;
        }
        return false;
    }


}
