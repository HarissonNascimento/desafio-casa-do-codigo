package br.com.harisson.desafiocasadocodigo.model.request;

import br.com.harisson.desafiocasadocodigo.annotation.UniqueStateName;
import br.com.harisson.desafiocasadocodigo.model.domain.Country;
import br.com.harisson.desafiocasadocodigo.model.domain.State;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@UniqueStateName
public class StatePostRequestBody {

    @NotBlank
    private String name;
    @NotNull
    private Long countryId;

    public StatePostRequestBody(@NotBlank String name, @NotNull Long countryId) {
        this.name = name;
        this.countryId = countryId;
    }

    public String getName() {
        return name;
    }

    public Long getCountryId() {
        return countryId;
    }

    public State toState(EntityManager entityManager) {
        Country country = entityManager.find(Country.class, this.countryId);
        return new State(this.name, country);
    }
}
