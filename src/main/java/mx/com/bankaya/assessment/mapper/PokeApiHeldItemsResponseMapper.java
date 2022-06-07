package mx.com.bankaya.assessment.mapper;

import lombok.RequiredArgsConstructor;
import mx.com.bakaya.soap.tech_assestment.PokeApiHeldItemsResponse;
import mx.com.bankaya.assessment.dto.pokeapi.PokeApiResponseDto;
import mx.com.bankaya.assessment.interfaces.MapperService;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PokeApiHeldItemsResponseMapper implements MapperService<PokeApiResponseDto, PokeApiHeldItemsResponse> {

    private final HeldItemsMapper heldItemsMapper;

    @Override
    public PokeApiHeldItemsResponse convert(PokeApiResponseDto dto) {
        if (dto == null) {
            return null;
        }
        PokeApiHeldItemsResponse response = new PokeApiHeldItemsResponse();
        response.getHeldItems().addAll(heldItemsMapper.convertAll(dto.getHeldItems()));
        return response;
    }

}
