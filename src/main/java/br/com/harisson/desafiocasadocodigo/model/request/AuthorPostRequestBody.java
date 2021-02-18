package br.com.harisson.desafiocasadocodigo.model.request;

import br.com.harisson.desafiocasadocodigo.model.domain.Author;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AuthorPostRequestBody {

    @NotBlank(message = "The field 'name' is mandatory")
    private final String name;
    @NotBlank(message = "The field 'email' is mandatory")
    @Email
    private final String email;
    @NotBlank(message = "The field 'description' is mandatory")
    @Size(max = 400, message = "The field 'description' has a maximum length of 400 characters")
    private final String description;

    public AuthorPostRequestBody(@NotBlank String name, @NotBlank @Email String email, @NotBlank @Size(max = 400) String description) {
        this.name = name;
        this.email = email;
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public Author toAuthor() {
        return new Author(this.name, this.email, this.description);
    }
}
