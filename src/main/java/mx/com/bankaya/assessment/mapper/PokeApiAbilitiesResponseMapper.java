package mx.com.bankaya.assessment.mapper;

import lombok.RequiredArgsConstructor;
import mx.com.bakaya.soap.tech_assestment.PokeApiAbilitiesResponse;
import mx.com.bankaya.assessment.dto.pokeapi.PokeApiResponseDto;
import mx.com.bankaya.assessment.interfaces.MapperService;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PokeApiAbilitiesResponseMapper implements MapperService<PokeApiResponseDto, PokeApiAbilitiesResponse> {

    private final AbilitiesMapper abilitiesMapper;

    public PokeApiAbilitiesResponse convert(PokeApiResponseDto pokeApiResponse) {
        if (pokeApiResponse == null) {
            return null;
        }
        PokeApiAbilitiesResponse response = new PokeApiAbilitiesResponse();
        response.getAbilities().addAll(abilitiesMapper.convertAll(pokeApiResponse.abilities));
        return response;
    }

}
