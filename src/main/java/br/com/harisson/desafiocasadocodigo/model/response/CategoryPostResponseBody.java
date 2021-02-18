package br.com.harisson.desafiocasadocodigo.model.response;

import javax.validation.constraints.NotBlank;

public class CategoryPostResponseBody {

    private final String name;

    public CategoryPostResponseBody(@NotBlank String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
