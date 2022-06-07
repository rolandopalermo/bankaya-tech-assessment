package mx.com.bankaya.assessment.mapper;

import lombok.RequiredArgsConstructor;
import mx.com.bakaya.soap.tech_assestment.PokeApiBaseExperienceResponse;
import mx.com.bakaya.soap.tech_assestment.PokeApiIdResponse;
import mx.com.bankaya.assessment.dto.pokeapi.PokeApiResponseDto;
import mx.com.bankaya.assessment.interfaces.MapperService;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PokeApiIdResponseMapper implements MapperService<PokeApiResponseDto, PokeApiIdResponse> {
    @Override
    public PokeApiIdResponse convert(PokeApiResponseDto dto) {
        if (dto == null) {
            return null;
        }
        PokeApiIdResponse response = new PokeApiIdResponse();
        response.setId(dto.getId());
        return response;
    }
}
