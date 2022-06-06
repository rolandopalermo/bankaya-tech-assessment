package mx.com.bankaya.assessment.service;

import lombok.val;
import mx.com.bankaya.assessment.exceptions.ServiceFaultException;
import mx.com.bankaya.assessment.service.PokeApiService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class PokeApiServiceIntegrationTest {

    @Autowired
    PokeApiService pokeApiService;

    @Test
    void contextLoads() {
        assertNotNull(pokeApiService);
    }

    @Test
    void given_ValidPokemonName_whenFindInfoByName_thenSuccess() {
        val response = pokeApiService.findFirstPokemonInfoByName("pikachu");
        assertNotNull(response);
    }

    @Test
    void given_InvalidPokemonName_whenFindInfoByName_thenSuccess() {
        assertThrows(ServiceFaultException.class, () -> pokeApiService.findFirstPokemonInfoByName("."));
    }

}
