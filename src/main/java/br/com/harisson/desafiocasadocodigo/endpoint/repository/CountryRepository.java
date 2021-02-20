package br.com.harisson.desafiocasadocodigo.endpoint.repository;

import br.com.harisson.desafiocasadocodigo.model.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
    boolean existsByIdAndStatesName(Long id,String name);
}
