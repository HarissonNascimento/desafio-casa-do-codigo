package br.com.harisson.desafiocasadocodigo.model.response;

import javax.validation.constraints.NotBlank;

public class CountryPostResponseBody {

    private String name;

    public CountryPostResponseBody(@NotBlank String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
