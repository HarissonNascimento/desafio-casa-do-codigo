package br.com.harisson.desafiocasadocodigo.model.request;

import br.com.harisson.desafiocasadocodigo.annotation.CountryHaveState;
import br.com.harisson.desafiocasadocodigo.annotation.ExistById;
import br.com.harisson.desafiocasadocodigo.annotation.UniqueValue;
import br.com.harisson.desafiocasadocodigo.model.domain.Country;
import br.com.harisson.desafiocasadocodigo.model.domain.Customer;
import br.com.harisson.desafiocasadocodigo.model.domain.State;
import br.com.harisson.desafiocasadocodigo.util.document.CnpjGroup;
import br.com.harisson.desafiocasadocodigo.util.document.CpfGroup;
import br.com.harisson.desafiocasadocodigo.util.document.CustomerGroupSequenceProvider;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;
import org.hibernate.validator.group.GroupSequenceProvider;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@CountryHaveState(message = "This country have states, please, select one!")
@GroupSequenceProvider(CustomerGroupSequenceProvider.class)
public class CustomerPostRequestBody {

    @NotBlank(message = "The field 'email' is mandatory")
    @Email
    @UniqueValue(domainClass = Customer.class, fieldName = "email", message = "The field 'email' must be unique")
    private String email;
    @NotBlank(message = "The field 'name' is mandatory")
    private String name;
    @NotBlank(message = "The field 'surname' is mandatory")
    private String surname;
    @CPF(groups = CpfGroup.class)
    @CNPJ(groups = CnpjGroup.class)
    @Size(min = 11, max = 14)
    @NotBlank(message = "The field 'document' is mandatory")
    @UniqueValue(domainClass = Customer.class, fieldName = "document", message = "The field 'document' must be unique")
    private String document;
    @NotBlank(message = "The field 'address' is mandatory")
    private String address;
    @NotBlank(message = "The field 'complement' is mandatory")
    private String complement;
    @NotBlank(message = "The field 'city' is mandatory")
    private String city;
    @NotNull(message = "The field 'countryId' is mandatory")
    @ExistById(domainClass = Country.class, idFieldName = "id", message = "Country is not found")
    private Long countryId;
    private Long stateId;
    @NotBlank(message = "The field 'phoneNumber' is mandatory")
    private String phoneNumber;
    @NotBlank(message = "The field 'zipCode' is mandatory")
    private String zipCode;

    public CustomerPostRequestBody(@NotBlank @Email String email,
                                   @NotBlank String name,
                                   @NotBlank String surname,
                                   @CPF @CNPJ @Size(min = 11, max = 14) @NotBlank String document,
                                   @NotBlank String address,
                                   @NotBlank String complement,
                                   @NotBlank String city,
                                   @NotNull Long countryId,
                                   Long stateId,
                                   @NotBlank String phoneNumber,
                                   @NotBlank String zipCode) {
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.document = document;
        this.address = address;
        this.complement = complement;
        this.city = city;
        this.countryId = countryId;
        this.stateId = stateId;
        this.phoneNumber = phoneNumber;
        this.zipCode = zipCode;
    }

    public Customer toCustomer(EntityManager entityManager) {
        State state = null;
        Country country = entityManager.find(Country.class, this.countryId);
        if (stateId != null)
            state= entityManager.find(State.class, this.stateId);
        return new Customer(this.email, this.name, this.surname, this.document, this.address, this.complement, this.city, country, state, this.phoneNumber, this.zipCode);
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

    public Long getCountryId() {
        return countryId;
    }

    public Long getStateId() {
        return stateId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getZipCode() {
        return zipCode;
    }
}
