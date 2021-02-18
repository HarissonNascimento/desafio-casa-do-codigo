package br.com.harisson.desafiocasadocodigo.endpoint.repository;

import br.com.harisson.desafiocasadocodigo.model.domain.Author;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AuthorRepository extends CrudRepository<Author, Long> {

    Optional<Author> findByEmail(String email);
}
