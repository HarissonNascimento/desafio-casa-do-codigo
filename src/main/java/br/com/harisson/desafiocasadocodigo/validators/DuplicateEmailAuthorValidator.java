package br.com.harisson.desafiocasadocodigo.validators;

import br.com.harisson.desafiocasadocodigo.endpoint.repository.AuthorRepository;
import br.com.harisson.desafiocasadocodigo.model.domain.Author;
import br.com.harisson.desafiocasadocodigo.model.request.AuthorPostRequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class DuplicateEmailAuthorValidator implements Validator {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return AuthorPostRequestBody.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }

        AuthorPostRequestBody requestBody = (AuthorPostRequestBody) o;
        Optional<Author> optionalAuthor = authorRepository.findByEmail(requestBody.getEmail());

        if (optionalAuthor.isPresent()) {
            errors.rejectValue("email", null, "This email already registered!" + requestBody.getEmail());
        }
    }
}
