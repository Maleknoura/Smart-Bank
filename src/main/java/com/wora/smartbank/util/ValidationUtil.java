package com.wora.smartbank.util;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.hibernate.validator.messageinterpolation.ParameterMessageInterpolator;

import java.util.Set;

@ApplicationScoped
public class ValidationUtil {

    private final Validator validator;

    public ValidationUtil() {
        ValidatorFactory factory = Validation.byDefaultProvider()
                .configure()
                .messageInterpolator(new ParameterMessageInterpolator())
                .buildValidatorFactory();
        this.validator = factory.getValidator();
    }

    public <T> Set<ConstraintViolation<T>> validateRequest(T object) {
        return validator.validate(object);
    }
}