package br.com.harisson.desafiocasadocodigo.annotation;

import br.com.harisson.desafiocasadocodigo.validator.CountryHaveStateValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * This annotation is specific to this project, of the
 * CustomerPostRequestBody.class and will probably not work elsewhere
 **/

@Documented
@Constraint(validatedBy = {CountryHaveStateValidator.class})
@Target({ANNOTATION_TYPE, TYPE})
@Retention(RUNTIME)
public @interface CountryHaveState {

    String message() default "{br.com.harisson.desafiocasadocodigo.annotation.CountryHaveState}";

    Class<? extends Payload>[] payload() default {};

    Class<?>[] groups() default {};
}
