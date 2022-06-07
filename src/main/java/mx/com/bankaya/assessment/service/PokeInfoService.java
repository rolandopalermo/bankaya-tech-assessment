package mx.com.bankaya.assessment.service;

import lombok.RequiredArgsConstructor;
import mx.com.bakaya.soap.tech_assestment.PokeApiAbilitiesRequest;
import mx.com.bakaya.soap.tech_assestment.PokeApiAbilitiesResponse;
import mx.com.bakaya.soap.tech_assestment.PokeApiBaseExperienceRequest;
import mx.com.bakaya.soap.tech_assestment.PokeApiBaseExperienceResponse;
import mx.com.bakaya.soap.tech_assestment.PokeApiHeldItemsRequest;
import mx.com.bakaya.soap.tech_assestment.PokeApiHeldItemsResponse;
import mx.com.bakaya.soap.tech_assestment.PokeApiIdRequest;
import mx.com.bakaya.soap.tech_assestment.PokeApiIdResponse;
import mx.com.bankaya.assessment.dto.pokeapi.PokeApiResponseDto;
import mx.com.bankaya.assessment.mapper.PokeApiAbilitiesResponseMapper;
import mx.com.bankaya.assessment.mapper.PokeApiBaseExperienceResponseMapper;
import mx.com.bankaya.assessment.mapper.PokeApiHeldItemsResponseMapper;
import mx.com.bankaya.assessment.mapper.PokeApiIdResponseMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PokeInfoService {

    private final PokeApiService pokeApiService;
    private final PokeApiAbilitiesResponseMapper pokeApiAbilitiesResponseMapper;
    private final PokeApiBaseExperienceResponseMapper pokeApiBaseExperienceResponseMapper;
    private final PokeApiHeldItemsResponseMapper pokeApiHeldItemsMapper;
    private final PokeApiIdResponseMapper pokeApiIdResponseMapper;

    public PokeApiAbilitiesResponse getAbilities(PokeApiAbilitiesRequest req) {
        PokeApiResponseDto pokeApiResponse = pokeApiService.findFirstPokemonInfoByName(req.getPokemonName());
        return pokeApiAbilitiesResponseMapper.convert(pokeApiResponse);
    }

    public PokeApiBaseExperienceResponse getBaseExperience(PokeApiBaseExperienceRequest req) {
        PokeApiResponseDto pokeApiResponse = pokeApiService.findFirstPokemonInfoByName(req.getPokemonName());
        return pokeApiBaseExperienceResponseMapper.convert(pokeApiResponse);
    }

    public PokeApiHeldItemsResponse getHeldItems(PokeApiHeldItemsRequest req) {
        PokeApiResponseDto pokeApiResponse = pokeApiService.findFirstPokemonInfoByName(req.getPokemonName());
        return pokeApiHeldItemsMapper.convert(pokeApiResponse);
    }

    public PokeApiIdResponse getId(PokeApiIdRequest req) {
        PokeApiResponseDto pokeApiResponse = pokeApiService.findFirstPokemonInfoByName(req.getPokemonName());
        return pokeApiIdResponseMapper.convert(pokeApiResponse);
    }
}
