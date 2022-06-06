package mx.com.bankaya.assessment.mapper;

import lombok.RequiredArgsConstructor;
import mx.com.bakaya.soap.tech_assestment.Abilities;
import mx.com.bankaya.assessment.dto.pokeapi.AbilityItemDto;
import mx.com.bankaya.assessment.interfaces.MapperService;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AbilitiesMapper implements MapperService<AbilityItemDto, Abilities> {

    private final AbilityMapper abilityMapper;

    @Override
    public Abilities convert(AbilityItemDto dto) {
        if (dto == null) {
            return null;
        }
        Abilities response = new Abilities();
        response.setAbility(abilityMapper.convert(dto.getAbility()));
        response.setIsHidden(dto.getIsHidden());
        response.setSlot(dto.getSlot());
        return response;
    }

}
