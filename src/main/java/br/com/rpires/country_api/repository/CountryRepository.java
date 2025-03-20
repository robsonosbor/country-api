package br.com.rpires.country_api.repository;

import br.com.rpires.country_api.domain.Country;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface CountryRepository extends CrudRepository<Country, Integer> {

    Page<Country> findAll(Pageable pageable);
}
