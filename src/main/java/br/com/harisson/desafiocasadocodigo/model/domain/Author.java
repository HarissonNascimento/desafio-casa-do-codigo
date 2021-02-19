package br.com.harisson.desafiocasadocodigo.model.domain;

import br.com.harisson.desafiocasadocodigo.model.response.AuthorPostResponseBody;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "The field 'name' is mandatory")
    private String name;
    @NotBlank(message = "The field 'email' is mandatory")
    @Email
    private String email;
    @NotBlank(message = "The field 'description' is mandatory")
    @Size(max = 400, message = "The field 'description' has a maximum length of 400 characters")
    private String description;
    @NotNull
    private final LocalDateTime registrationTime = LocalDateTime.now();
    @OneToMany(mappedBy = "author")
    private List<Book> books;

    public Author(@NotBlank String name, @NotBlank @Email String email, @NotBlank @Size(max = 400) String description) {
        this.name = name;
        this.email = email;
        this.description = description;
    }

    @Deprecated
    protected Author() {
    }

    public AuthorPostResponseBody toAuthorPostResponseBody() {
        return new AuthorPostResponseBody(this.name, this.email);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
