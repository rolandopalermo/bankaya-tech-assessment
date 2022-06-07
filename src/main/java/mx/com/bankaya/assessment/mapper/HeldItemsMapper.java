package mx.com.bankaya.assessment.mapper;

import lombok.RequiredArgsConstructor;
import mx.com.bakaya.soap.tech_assestment.HeldItems;
import mx.com.bankaya.assessment.dto.pokeapi.HeldItemDto;
import mx.com.bankaya.assessment.interfaces.MapperService;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class HeldItemsMapper implements MapperService<HeldItemDto, HeldItems> {

    private final ItemMapper itemMapper;
    private final VersionDetailsMapper versionDetailsMapper;

    @Override
    public HeldItems convert(HeldItemDto dto) {
        if (dto == null) {
            return null;
        }
        HeldItems response = new HeldItems();
        response.setItem(itemMapper.convert(dto.getItem()));
        response.getVersionDetails().addAll(versionDetailsMapper.convertAll(dto.getVersionDetails()));
        return response;
    }

}
