package br.com.harisson.desafiocasadocodigo.endpoint.controller;

import br.com.harisson.desafiocasadocodigo.model.domain.Customer;
import br.com.harisson.desafiocasadocodigo.model.request.CustomerPostRequestBody;
import br.com.harisson.desafiocasadocodigo.model.response.CustomerPostResponseBody;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping("/register-new")
    @Transactional
    public CustomerPostResponseBody createNewCustomer(@RequestBody @Valid CustomerPostRequestBody customerPostRequestBody){
        Customer customer = customerPostRequestBody.toCustomer(entityManager);
        entityManager.persist(customer);
        return customer.toCustomerPostResponseBody();
    }
}
