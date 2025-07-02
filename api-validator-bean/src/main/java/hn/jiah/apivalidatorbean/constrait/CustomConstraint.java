package hn.jiah.apivalidatorbean.constrait;

import hn.jiah.apivalidatorbean.annotation.CustomValidator;
import hn.jiah.apivalidatorbean.dto.SimplePojoV2;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class CustomConstraint  implements ConstraintValidator<CustomValidator, SimplePojoV2> {
    @Override
    public void initialize(CustomValidator constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(SimplePojoV2 input, ConstraintValidatorContext constraintValidatorContext) {
        constraintValidatorContext.disableDefaultConstraintViolation();
        if(Objects.isNull(input)){
            constraintValidatorContext.buildConstraintViolationWithTemplate("Request must not be empty");
            return false;
        }
        return !isInvalidUsername(input.getUsername(), constraintValidatorContext)
                && !isInvalidEmail(input.getEmail(), constraintValidatorContext)
                && !isInvalidAmount(input.getAmount(), constraintValidatorContext)
                && !isInvalidCurrency(input.getCurrency(), constraintValidatorContext);
    }

    private boolean isInvalidCurrency(String currency, ConstraintValidatorContext constraintValidatorContext) {
        if(Objects.isNull(currency) || currency.isBlank()){
            addConstraint("Currency is required", constraintValidatorContext);
            return true;
        }
        if(currency.trim().length()!=3){
            addConstraint("Currency length must be exactly 3 characters", constraintValidatorContext);
            return true;
        }
        if(!currency.matches("\\w+") || !List.of("USD", "HNL").contains(currency)){
            addConstraint("invalid currency value", constraintValidatorContext);
            return true;
        }
        return false;
    }

    private boolean isInvalidAmount(BigDecimal amount, ConstraintValidatorContext constraintValidatorContext) {
        if(Objects.isNull(amount)){
            addConstraint("Amount is required", constraintValidatorContext);
            return true;
        }
        if(amount.compareTo(BigDecimal.ONE)<0){
            addConstraint("Amount must be greater than 0.00", constraintValidatorContext);
            return true;
        }
        if(amount.compareTo(BigDecimal.valueOf(1000L))>0){
            addConstraint("Amount must be less than 1000.00", constraintValidatorContext);
            return true;
        }
        return false;
    }

    private boolean isInvalidEmail(String email, ConstraintValidatorContext constraintValidatorContext) {
        if(Objects.isNull(email) || email.isBlank()){
            addConstraint("Email is required", constraintValidatorContext);
            return true;
        }
        if(!email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")){
            addConstraint("invalid email value", constraintValidatorContext);
            return true;
        }
        return false;
    }

    private boolean isInvalidUsername(String username, ConstraintValidatorContext constraintValidatorContext) {
        if(Objects.isNull(username) || username.isBlank()){
            addConstraint("Username is required", constraintValidatorContext);
            return true;
        }
        return false;
    }

    private void addConstraint(String message, ConstraintValidatorContext constraintValidatorContext){
        constraintValidatorContext.buildConstraintViolationWithTemplate(message).addConstraintViolation();
    }


}
