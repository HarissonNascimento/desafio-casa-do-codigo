package br.com.harisson.desafiocasadocodigo.model.response;

import javax.validation.constraints.NotBlank;


public class AuthorPostResponseBody {

    private final String name;
    private final String email;

    public AuthorPostResponseBody(@NotBlank String name, @NotBlank String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
