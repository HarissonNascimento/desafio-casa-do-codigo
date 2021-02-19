package br.com.harisson.desafiocasadocodigo.model.domain;

import br.com.harisson.desafiocasadocodigo.model.response.CategoryPostResponseBody;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "The field 'name' is mandatory")
    private String name;
    @OneToMany(mappedBy = "category")
    private List<Book> books;

    public Category(@NotBlank String name) {
        this.name = name;
    }

    @Deprecated
    protected Category() {
    }

    public CategoryPostResponseBody toCategoryPostResponseBody() {
        return new CategoryPostResponseBody(this.name);
    }

    public String getName() {
        return name;
    }
}
