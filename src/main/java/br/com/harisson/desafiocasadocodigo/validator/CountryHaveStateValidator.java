package br.com.harisson.desafiocasadocodigo.validator;

import br.com.harisson.desafiocasadocodigo.annotation.CountryHaveState;
import br.com.harisson.desafiocasadocodigo.endpoint.repository.CountryRepository;
import br.com.harisson.desafiocasadocodigo.exception.notfound.NotFoundException;
import br.com.harisson.desafiocasadocodigo.model.domain.Country;
import br.com.harisson.desafiocasadocodigo.model.domain.State;
import br.com.harisson.desafiocasadocodigo.model.request.CustomerPostRequestBody;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;
import java.util.stream.Collectors;

public class CountryHaveStateValidator implements ConstraintValidator<CountryHaveState, Object> {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        CustomerPostRequestBody customerPostRequestBody = (CustomerPostRequestBody) o;

        if (customerPostRequestBody.getCountryId() == null){
            return false;
        }

        Country country = countryRepository.findById(customerPostRequestBody.getCountryId())
                .orElseThrow(() -> new NotFoundException("Country not found"));

        List<State> states = country.getStates();

        if (states.isEmpty()) {
            return customerPostRequestBody.getStateId() == null;
        } else {
            if (customerPostRequestBody.getStateId() == null) {
                return false;
            }
            Long stateId = customerPostRequestBody.getStateId();
            List<Long> collect = states.stream().map(State::getId).collect(Collectors.toList());
            return collect.stream().anyMatch(l -> l.equals(stateId));
        }

    }
}
