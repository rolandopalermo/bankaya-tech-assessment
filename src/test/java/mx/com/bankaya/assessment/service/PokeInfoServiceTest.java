package mx.com.bankaya.assessment.service;

import lombok.val;
import mx.com.bakaya.soap.tech_assestment.PokeApiAbilitiesRequest;
import mx.com.bakaya.soap.tech_assestment.PokeApiAbilitiesResponse;
import mx.com.bankaya.assessment.dto.pokeapi.PokeApiResponseDto;
import mx.com.bankaya.assessment.exceptions.ServiceFault;
import mx.com.bankaya.assessment.exceptions.ServiceFaultException;
import mx.com.bankaya.assessment.mapper.PokeApiAbilitiesResponseMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static mx.com.bankaya.assessment.util.Constants.SoapConstants.ERROR;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PokeInfoServiceTest {

    @Mock
    PokeApiService pokeApiService;

    @Mock
    PokeApiAbilitiesResponseMapper pokeApiAbilitiesResponseMapper;

    @InjectMocks
    PokeInfoService pokeInfoService;

    @Test
    void contextLoads() {
        assertNotNull(pokeInfoService);
    }

    @Test
    void given_ValidPokemonName_whenGetAbilities_thenSuccess() {
        val request = new PokeApiAbilitiesRequest();
        request.setPokemonName("junit");
        when(pokeApiService.findFirstPokemonInfoByName(anyString())).thenReturn(new PokeApiResponseDto());
        when(pokeApiAbilitiesResponseMapper.convert(any())).thenReturn(new PokeApiAbilitiesResponse());
        val result = pokeInfoService.getAbilities(request);
        assertNotNull(result);
    }

    @Test
    void given_InvalidPokemonName_whenGetAbilities_thenEmpty() {
        val request = new PokeApiAbilitiesRequest();
        request.setPokemonName("junit");
        when(pokeApiService.findFirstPokemonInfoByName(anyString())).thenThrow(new ServiceFaultException(ERROR, new ServiceFault("errorMessage", "")));
        assertThrows(ServiceFaultException.class, () -> pokeInfoService.getAbilities(request));
    }

}
