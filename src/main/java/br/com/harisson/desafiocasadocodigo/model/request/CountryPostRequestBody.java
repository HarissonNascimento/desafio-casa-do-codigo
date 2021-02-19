package br.com.harisson.desafiocasadocodigo.model.request;

import br.com.harisson.desafiocasadocodigo.annotation.UniqueValue;
import br.com.harisson.desafiocasadocodigo.model.domain.Country;

import javax.validation.constraints.NotBlank;

public class CountryPostRequestBody {

    @NotBlank
    @UniqueValue(domainClass = Country.class, fieldName = "name", message = "The field 'name' must be unique")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country toCountry(){
        return new Country(this.name);
    }
}
