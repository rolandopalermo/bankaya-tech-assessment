package mx.com.bankaya.assessment.service;

import lombok.RequiredArgsConstructor;
import mx.com.bakaya.soap.tech_assestment.PokeApiAbilitiesRequest;
import mx.com.bakaya.soap.tech_assestment.PokeApiAbilitiesResponse;
import mx.com.bankaya.assessment.dto.pokeapi.PokeApiResponseDto;
import mx.com.bankaya.assessment.mapper.PokeApiAbilitiesResponseMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PokeInfoService {

    private final PokeApiService pokeApiService;
    private final PokeApiAbilitiesResponseMapper pokeApiAbilitiesResponseMapper;

    public PokeApiAbilitiesResponse getAbilities(PokeApiAbilitiesRequest req) {
        PokeApiResponseDto pokeApiResponse = pokeApiService.findFirstPokemonInfoByName(req.getPokemonName());
        return pokeApiAbilitiesResponseMapper.convert(pokeApiResponse);
    }

}
