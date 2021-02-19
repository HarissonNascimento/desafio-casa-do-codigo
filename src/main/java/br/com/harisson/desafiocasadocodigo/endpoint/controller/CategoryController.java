package br.com.harisson.desafiocasadocodigo.endpoint.controller;

import br.com.harisson.desafiocasadocodigo.model.domain.Category;
import br.com.harisson.desafiocasadocodigo.model.request.CategoryPostRequestBody;
import br.com.harisson.desafiocasadocodigo.model.response.CategoryPostResponseBody;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping("/register-new")
    @Transactional
    public CategoryPostResponseBody createNewCategory(@RequestBody @Valid CategoryPostRequestBody categoryPostRequestBody) {
        Category category = categoryPostRequestBody.toCategory();
        entityManager.persist(category);
        return category.toCategoryPostResponseBody();
    }
}
