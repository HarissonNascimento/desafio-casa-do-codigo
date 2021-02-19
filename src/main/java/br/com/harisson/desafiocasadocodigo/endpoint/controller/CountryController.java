package br.com.harisson.desafiocasadocodigo.endpoint.controller;

import br.com.harisson.desafiocasadocodigo.model.domain.Country;
import br.com.harisson.desafiocasadocodigo.model.request.CountryPostRequestBody;
import br.com.harisson.desafiocasadocodigo.model.response.CountryPostResponseBody;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping("/country")
public class CountryController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping("/register-new")
    @Transactional
    public CountryPostResponseBody createNewCountry(@RequestBody @Valid CountryPostRequestBody countryPostRequestBody){
        Country country = countryPostRequestBody.toCountry();
        entityManager.persist(country);
        return country.toCountryPostResponseBody();
    }
}
