package br.com.harisson.desafiocasadocodigo.model.request;

import br.com.harisson.desafiocasadocodigo.model.domain.Category;

import javax.validation.constraints.NotBlank;

public class CategoryPostRequestBody {

    @NotBlank(message = "The field 'name' is mandatory")
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Category toCategory() {
        return new Category(this.name);
    }
}
