package br.com.rpires.country_api.resources;

import br.com.rpires.country_api.cases.country.CreateCountry;
import br.com.rpires.country_api.cases.country.DeleteCountry;
import br.com.rpires.country_api.cases.country.GetCountry;
import br.com.rpires.country_api.cases.country.UpdateCountry;
import br.com.rpires.country_api.domain.Country;
import br.com.rpires.country_api.dto.PatchDto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("country")
public class CountryResource {

    private final GetCountry getCountry;

    private final DeleteCountry deleteCountry;

    private final UpdateCountry updateCountry;

    private final CreateCountry createCountry;

    @Autowired
    public CountryResource(GetCountry getCountry,
                           DeleteCountry deleteCountry,
                           UpdateCountry updateCountry,
                           CreateCountry createCountry) {
        this.getCountry = getCountry;
        this.deleteCountry = deleteCountry;
        this.updateCountry = updateCountry;
        this.createCountry = createCountry;
    }

    @Operation(summary = "Find all countries with pagination")
    @GetMapping
    public ResponseEntity<Page<Country>> list(@RequestParam(name = "page", required = true) Integer page,
                                              @RequestParam(name = "size", required = true) Integer size) {
        return ResponseEntity.ok(getCountry.findAll(page, size));
    }

    @Operation(summary = "Find country by id")
    @GetMapping("/{id}")
    public ResponseEntity<Country> getById(@PathVariable(name = "id", required = true) Integer id) {
        return ResponseEntity.ok(getCountry.findById(id));
    }

    @Operation(summary = "Delete country by id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable(name = "id", required = true) Integer id) {
        deleteCountry.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Update country")
    @PutMapping("/{id}")
    public ResponseEntity<Country> update(@PathVariable(name = "id", required = true) Integer id,
                                          @RequestBody @Valid Country country) {
        return ResponseEntity.ok(updateCountry.update(id, country));
    }

    @Operation(summary = "Update a property of country")
    @PatchMapping("/{id}")
    public ResponseEntity<Country> patch(@PathVariable(name = "id", required = true) Integer id,
                                          @RequestBody PatchDto dto) {
        return ResponseEntity.ok(updateCountry.updateByPatch(id, dto));
    }

    @Operation(summary = "Create a new country")
    @PostMapping
    public ResponseEntity<Country> create(@RequestBody @Valid Country country) {
        return ResponseEntity.ok(createCountry.create(country));
    }
}
