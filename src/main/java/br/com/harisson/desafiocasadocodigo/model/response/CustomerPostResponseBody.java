package br.com.harisson.desafiocasadocodigo.model.response;

import javax.validation.constraints.NotNull;

public class CustomerPostResponseBody {

    private final Long id;

    public CustomerPostResponseBody(@NotNull Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
