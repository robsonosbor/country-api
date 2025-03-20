package br.com.rpires.country_api;

import br.com.rpires.country_api.cases.country.CreateCountry;
import br.com.rpires.country_api.cases.country.DeleteCountry;
import br.com.rpires.country_api.cases.country.GetCountry;
import br.com.rpires.country_api.cases.country.UpdateCountry;
import br.com.rpires.country_api.resources.CountryResource;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = CountryResource.class)
public class CountryResourceTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private GetCountry getCountry;

    @MockBean
    private DeleteCountry deleteCountry;

    @MockBean
    private UpdateCountry updateCountry;

    @MockBean
    private CreateCountry createCountry;

    @Test
    public void findByIdTest() throws Exception {
        mockMvc.perform(get("/country/{id}",1)
                        .contentType("application/json"))
                .andExpect(status().isOk());
    }

    @Test
    public void findAllTest() throws Exception {
        mockMvc.perform(get("/country?page=0&size=1", 0,1)
                        .contentType("application/json"))
                .andExpect(status().isOk());
    }
}
