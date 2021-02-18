package br.com.harisson.desafiocasadocodigo.model.domain;

import br.com.harisson.desafiocasadocodigo.model.response.CategoryPostResponseBody;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "The field 'name' is mandatory")
    private String name;

    public Category(@NotBlank String name) {
        this.name = name;
    }

    @Deprecated
    protected Category() {
    }

    public CategoryPostResponseBody toCategoryPostResponseBody() {
        return new CategoryPostResponseBody(this.name);
    }
}
