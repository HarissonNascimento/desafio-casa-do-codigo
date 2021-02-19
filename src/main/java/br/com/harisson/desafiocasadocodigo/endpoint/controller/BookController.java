package br.com.harisson.desafiocasadocodigo.endpoint.controller;

import br.com.harisson.desafiocasadocodigo.model.domain.Book;
import br.com.harisson.desafiocasadocodigo.model.request.BookPostRequestBody;
import br.com.harisson.desafiocasadocodigo.model.response.BookPostResponseBody;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping("/book")
public class BookController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping("/register-new")
    @Transactional
    public BookPostResponseBody createNewBook(@RequestBody @Valid BookPostRequestBody bookPostRequestBody){
        Book book = bookPostRequestBody.toBook(entityManager);
        entityManager.persist(book);
        return book.toBookPostResponseBody();
    }
}
