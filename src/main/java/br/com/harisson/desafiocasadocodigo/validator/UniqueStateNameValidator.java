package br.com.harisson.desafiocasadocodigo.validator;

import br.com.harisson.desafiocasadocodigo.annotation.UniqueStateName;
import br.com.harisson.desafiocasadocodigo.endpoint.repository.CountryRepository;
import br.com.harisson.desafiocasadocodigo.model.request.StatePostRequestBody;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueStateNameValidator implements ConstraintValidator<UniqueStateName, Object> {
    @Autowired
    private CountryRepository countryRepository;

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        StatePostRequestBody statePostRequestBody = (StatePostRequestBody) o;
        return !countryRepository.existsByIdAndStatesName(statePostRequestBody.getCountryId(), statePostRequestBody.getName());
    }
}
