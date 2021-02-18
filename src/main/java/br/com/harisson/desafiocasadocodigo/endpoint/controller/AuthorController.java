package br.com.harisson.desafiocasadocodigo.endpoint.controller;

import br.com.harisson.desafiocasadocodigo.model.domain.Author;
import br.com.harisson.desafiocasadocodigo.model.request.AuthorPostRequestBody;
import br.com.harisson.desafiocasadocodigo.model.response.AuthorPostResponseBody;
import br.com.harisson.desafiocasadocodigo.validators.DuplicateEmailAuthorValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private DuplicateEmailAuthorValidator duplicateEmailAuthorValidator;

    @InitBinder
    public void init(WebDataBinder binder){
        binder.addValidators(duplicateEmailAuthorValidator);
    }

    @PostMapping("/register-new")
    @Transactional
    public AuthorPostResponseBody createNewAuthor(@RequestBody @Valid AuthorPostRequestBody authorPostRequestBody) {
        Author author = authorPostRequestBody.toAuthor();
        entityManager.persist(author);
        return author.toAuthorPostResponseBody();
    }
}
