package br.com.harisson.desafiocasadocodigo.model.response;

import javax.validation.constraints.NotBlank;

public class StatePostResponseBody {

    private String stateName;
    private String countryName;

    public StatePostResponseBody(@NotBlank String stateName,@NotBlank String countryName) {
        this.stateName = stateName;
        this.countryName = countryName;
    }

    public String getStateName() {
        return stateName;
    }

    public String getCountryName() {
        return countryName;
    }
}
