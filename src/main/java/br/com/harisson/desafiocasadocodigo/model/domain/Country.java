package br.com.harisson.desafiocasadocodigo.model.domain;

import br.com.harisson.desafiocasadocodigo.model.response.CountryPostResponseBody;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    @OneToMany(mappedBy = "country")
    private List<State> states;

    public Country(@NotBlank String name) {
        this.name = name;
    }

    @Deprecated
    protected Country(){
    }

    public String getName() {
        return name;
    }

    public CountryPostResponseBody toCountryPostResponseBody() {
        return new CountryPostResponseBody(this.name);
    }
}
