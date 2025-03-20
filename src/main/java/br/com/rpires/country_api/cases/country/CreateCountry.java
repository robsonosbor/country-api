package br.com.rpires.country_api.cases.country;

import br.com.rpires.country_api.domain.Country;
import br.com.rpires.country_api.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCountry {

    private CountryRepository countryRepository;

    @Autowired
    public CreateCountry(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public Country create(Country country) {
        return countryRepository.save(country);
    }
}
