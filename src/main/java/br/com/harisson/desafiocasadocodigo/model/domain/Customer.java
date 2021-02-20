package br.com.harisson.desafiocasadocodigo.model.domain;

import br.com.harisson.desafiocasadocodigo.model.response.CustomerPostResponseBody;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String surname;
    @Column(nullable = false, unique = true)
    private String document;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String complement;
    @Column(nullable = false)
    private String city;
    @OneToOne
    private Country country;
    @OneToOne
    private State state;
    @Column(nullable = false)
    private String phoneNumber;
    @Column(nullable = false)
    private String zipCode;

    public Customer(@NotBlank @Email String email,
                    @NotBlank String name,
                    @NotBlank String surname,
                    @CPF @CNPJ @Size(min = 11, max = 14) @NotBlank String document,
                    @NotBlank String address,
                    @NotBlank String complement,
                    @NotBlank String city,
                    @NotNull Country country,
                    State state,
                    @NotBlank String phoneNumber,
                    @NotBlank String zipCode) {

        this.email = email;
        this.name = name;
        this.surname = surname;
        this.document = document;
        this.address = address;
        this.complement = complement;
        this.city = city;
        this.country = country;
        this.state = state;
        this.phoneNumber = phoneNumber;
        this.zipCode = zipCode;

    }

    @Deprecated
    protected Customer() {
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getDocument() {
        return document;
    }

    public String getAddress() {
        return address;
    }

    public String getComplement() {
        return complement;
    }

    public String getCity() {
        return city;
    }

    public Country getCountry() {
        return country;
    }

    public State getState() {
        return state;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getZipCode() {
        return zipCode;
    }

    public CustomerPostResponseBody toCustomerPostResponseBody() {
        return new CustomerPostResponseBody(this.id);
    }
}
