package com.tz.javafx.validator;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by hjl on 2015/9/23.
 */
public class AgeValidator implements ConstraintValidator<IsAge,Object> {

    private static final Logger LOGGER = Logger.getLogger(AgeValidator.class);

    public static final int MAX_AGE_LENGTH = 3;

    @Override
    public void initialize(IsAge constraintAnnotation) {
        LOGGER.debug("initialize...");
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        LOGGER.debug("isValid...");
        String age = (String) value;
        return StringUtils.isNotBlank(age)
                && StringUtils.isNumeric(age)
                && age.length() <= MAX_AGE_LENGTH;
    }
}
