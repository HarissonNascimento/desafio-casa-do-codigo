package br.com.harisson.desafiocasadocodigo.validators;

import br.com.harisson.desafiocasadocodigo.endpoint.repository.CategoryRepository;
import br.com.harisson.desafiocasadocodigo.model.domain.Category;
import br.com.harisson.desafiocasadocodigo.model.request.CategoryPostRequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class DuplicateNameCategoryValidator implements Validator {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return CategoryPostRequestBody.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }

        CategoryPostRequestBody requestBody = (CategoryPostRequestBody) o;

        Optional<Category> optionalCategory = categoryRepository.findByName(requestBody.getName());

        if (optionalCategory.isPresent()) {
            errors.rejectValue("name", null, "This name already taken " + requestBody.getName());
        }
    }
}
