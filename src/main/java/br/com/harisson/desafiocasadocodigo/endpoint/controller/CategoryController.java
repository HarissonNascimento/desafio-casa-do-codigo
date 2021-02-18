package br.com.harisson.desafiocasadocodigo.endpoint.controller;

import br.com.harisson.desafiocasadocodigo.model.domain.Category;
import br.com.harisson.desafiocasadocodigo.model.request.CategoryPostRequestBody;
import br.com.harisson.desafiocasadocodigo.model.response.CategoryPostResponseBody;
import br.com.harisson.desafiocasadocodigo.validators.DuplicateNameCategoryValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private DuplicateNameCategoryValidator duplicateNameCategoryValidator;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(duplicateNameCategoryValidator);
    }

    @PostMapping("/register-new")
    @Transactional
    public CategoryPostResponseBody createNewCategory(@RequestBody @Valid CategoryPostRequestBody categoryPostRequestBody) {
        Category category = categoryPostRequestBody.toCategory();
        entityManager.persist(category);
        return category.toCategoryPostResponseBody();
    }
}
