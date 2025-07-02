package hn.jiah.apivalidatorbean.constrait;

import hn.jiah.apivalidatorbean.annotation.CustomValidator;
import hn.jiah.apivalidatorbean.annotation.ValidCurrency;
import hn.jiah.apivalidatorbean.dto.SimplePojoV2;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class ValidCurrencyConstraint implements ConstraintValidator<ValidCurrency, String> {
    @Override
    public void initialize(ValidCurrency constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String input, ConstraintValidatorContext constraintValidatorContext) {
        constraintValidatorContext.disableDefaultConstraintViolation();
        return !isInvalidCurrency(input, constraintValidatorContext);
    }

    private boolean isInvalidCurrency(String currency, ConstraintValidatorContext constraintValidatorContext) {
        if(Objects.isNull(currency) || currency.isBlank()){
            addConstraint("{currency.notempty}", constraintValidatorContext);
            return true;
        }
        if(currency.trim().length()!=3){
            addConstraint("{currency.size}", constraintValidatorContext);
            return true;
        }
        if(!currency.matches("\\w+") || !List.of("USD", "HNL").contains(currency)){
            addConstraint("{currency.notvalid}", constraintValidatorContext);
            return true;
        }
        return false;
    }

    private void addConstraint(String message, ConstraintValidatorContext constraintValidatorContext){
        constraintValidatorContext.buildConstraintViolationWithTemplate(message).addConstraintViolation();
    }


}
