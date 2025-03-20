package br.com.rpires.country_api.cases.country;

import br.com.rpires.country_api.domain.Country;
import br.com.rpires.country_api.exception.NotFoundException;
import br.com.rpires.country_api.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class GetCountry {

    private CountryRepository countryRepository;

    @Autowired
    public GetCountry(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public Page<Country> findAll(Integer page, Integer size) {
        return countryRepository.findAll(PageRequest.of(page, size));
    }

    public Country findById(Integer id) {
        return countryRepository.findById(id).orElseThrow(()-> new NotFoundException("ENTITY NOT FOUND", HttpStatus.NOT_FOUND));
    }
}
