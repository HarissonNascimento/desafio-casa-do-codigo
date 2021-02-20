package br.com.harisson.desafiocasadocodigo.endpoint.controller;

import br.com.harisson.desafiocasadocodigo.model.domain.State;
import br.com.harisson.desafiocasadocodigo.model.request.StatePostRequestBody;
import br.com.harisson.desafiocasadocodigo.model.response.StatePostResponseBody;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping("/state")
public class StateController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping("/register-new")
    @Transactional
    public StatePostResponseBody createNewState(@RequestBody @Valid StatePostRequestBody statePostRequestBody){
        State state = statePostRequestBody.toState(entityManager);
        entityManager.persist(state);
        return state.toStatePostResponseBody();
    }
}
