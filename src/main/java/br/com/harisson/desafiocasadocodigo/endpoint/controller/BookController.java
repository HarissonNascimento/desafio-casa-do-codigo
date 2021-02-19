package br.com.harisson.desafiocasadocodigo.endpoint.controller;

import br.com.harisson.desafiocasadocodigo.model.domain.Book;
import br.com.harisson.desafiocasadocodigo.model.request.BookPostRequestBody;
import br.com.harisson.desafiocasadocodigo.model.response.BookGetResponseBody;
import br.com.harisson.desafiocasadocodigo.model.response.BookPostResponseBody;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/book")
public class BookController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping("/register-new")
    @Transactional
    public BookPostResponseBody createNewBook(@RequestBody @Valid BookPostRequestBody bookPostRequestBody) {
        Book book = bookPostRequestBody.toBook(entityManager);
        entityManager.persist(book);
        return book.toBookPostResponseBody();
    }

    @GetMapping("/list-all")
    public List<BookGetResponseBody> listAllBooks() {
        String jpql = "select b from Book b";
        List<Book> resultList = entityManager.createQuery(jpql, Book.class).getResultList();
        return resultList.stream().map(Book::toBookGetResponseBody).collect(Collectors.toList());
    }
}
