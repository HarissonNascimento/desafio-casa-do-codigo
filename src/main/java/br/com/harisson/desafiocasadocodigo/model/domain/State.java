package br.com.harisson.desafiocasadocodigo.model.domain;

import br.com.harisson.desafiocasadocodigo.model.response.StatePostResponseBody;

import javax.persistence.*;

@Entity
public class State {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    public State(String name, Country country) {
        this.name = name;
        this.country = country;
    }

    @Deprecated
    protected State() {
    }

    public StatePostResponseBody toStatePostResponseBody() {
        return new StatePostResponseBody(this.name, this.country.getName());
    }
}
