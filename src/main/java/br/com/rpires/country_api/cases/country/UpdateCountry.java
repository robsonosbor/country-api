package br.com.rpires.country_api.cases.country;

import br.com.rpires.country_api.domain.Country;
import br.com.rpires.country_api.dto.PatchDto;
import br.com.rpires.country_api.exception.InvalidPropertyException;
import br.com.rpires.country_api.exception.PatchOperationException;
import br.com.rpires.country_api.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class UpdateCountry {

    private static final String PATCH_OPERATION_UPDATE = "UPDATE";

    private static final String FIELD_CODE = "code";

    private static final String FIELD_NAME = "name";

    private CountryRepository countryRepository;

    private GetCountry getCountry;

    @Autowired
    public UpdateCountry(CountryRepository countryRepository,
                         GetCountry getCountry) {
        this.countryRepository = countryRepository;
        this.getCountry = getCountry;
    }

    public Country update(Integer id, Country country) {
        Country countryDB = getCountry.findById(id);
        countryDB.setCode(country.getCode());
        countryDB.setName(country.getName());
        return countryRepository.save(countryDB);
    }

    public Country updateByPatch(Integer id, PatchDto dto) {
        Country countryDB = getCountry.findById(id);
        if (PATCH_OPERATION_UPDATE.equals(dto.getOp())) {
            if (FIELD_CODE.equals(dto.getKey())) {
                countryDB.setCode(dto.getValue());
            } else if (FIELD_NAME.equals(dto.getKey())) {
                countryDB.setName(dto.getValue());
            } else {
                StringBuilder sb = new StringBuilder("INVALID PROPERTY ");
                sb.append(dto.getKey());
                throw new InvalidPropertyException(sb.toString() , HttpStatus.BAD_REQUEST);
            }
        } else {
            throw new PatchOperationException("INVALID PATCH OPERATION", HttpStatus.BAD_REQUEST);
        }
        return countryRepository.save(countryDB);
    }
}
