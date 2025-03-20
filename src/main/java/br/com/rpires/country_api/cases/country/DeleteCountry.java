package br.com.rpires.country_api.cases.country;

import br.com.rpires.country_api.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteCountry {

    private CountryRepository countryRepository;

    @Autowired
    public DeleteCountry(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public void delete(Integer id) {
        countryRepository.deleteById(id);
    }
}
