package br.com.harisson.desafiocasadocodigo.endpoint.repository;

import br.com.harisson.desafiocasadocodigo.model.domain.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, Long> {

    Optional<Category> findByName(String name);
}
