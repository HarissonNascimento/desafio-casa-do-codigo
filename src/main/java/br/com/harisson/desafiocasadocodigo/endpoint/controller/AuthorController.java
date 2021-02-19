package br.com.harisson.desafiocasadocodigo.endpoint.controller;

import br.com.harisson.desafiocasadocodigo.model.domain.Author;
import br.com.harisson.desafiocasadocodigo.model.request.AuthorPostRequestBody;
import br.com.harisson.desafiocasadocodigo.model.response.AuthorPostResponseBody;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping("/register-new")
    @Transactional
    public AuthorPostResponseBody createNewAuthor(@RequestBody @Valid AuthorPostRequestBody authorPostRequestBody) {
        Author author = authorPostRequestBody.toAuthor();
        entityManager.persist(author);
        return author.toAuthorPostResponseBody();
    }
}
