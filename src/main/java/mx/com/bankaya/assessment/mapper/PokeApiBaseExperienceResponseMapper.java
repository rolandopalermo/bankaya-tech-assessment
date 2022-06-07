package mx.com.bankaya.assessment.mapper;

import lombok.RequiredArgsConstructor;
import mx.com.bakaya.soap.tech_assestment.PokeApiBaseExperienceResponse;
import mx.com.bankaya.assessment.dto.pokeapi.PokeApiResponseDto;
import mx.com.bankaya.assessment.interfaces.MapperService;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PokeApiBaseExperienceResponseMapper implements MapperService<PokeApiResponseDto, PokeApiBaseExperienceResponse> {
    @Override
    public PokeApiBaseExperienceResponse convert(PokeApiResponseDto pokeApiResponse) {
        if (pokeApiResponse == null) {
            return null;
        }
        PokeApiBaseExperienceResponse response = new PokeApiBaseExperienceResponse();
        response.setBaseExperience(pokeApiResponse.getBaseExperience());
        return response;
    }
}
