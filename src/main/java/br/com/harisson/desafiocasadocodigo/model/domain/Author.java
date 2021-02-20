package br.com.harisson.desafiocasadocodigo.model.domain;

import br.com.harisson.desafiocasadocodigo.model.response.AuthorPostResponseBody;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false, length = 400)
    private String description;
    @Column(nullable = false)
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

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getRegistrationTime() {
        return registrationTime;
    }

    public List<Book> getBooks() {
        return books;
    }
}
