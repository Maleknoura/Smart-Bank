package com.wora.smartbank.util;

import com.wora.smartbank.entities.Request;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import java.util.Set;

public class ValidationUtil {

    private static final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private static final Validator validator = factory.getValidator();

    public static Set<ConstraintViolation<Request>> validateRequest(Request request) {
        return validator.validate(request);
    }

    public static boolean isValid(Request request) {
        return validateRequest(request).isEmpty();
    }
}
