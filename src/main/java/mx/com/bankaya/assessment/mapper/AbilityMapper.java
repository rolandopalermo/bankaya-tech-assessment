package mx.com.bankaya.assessment.mapper;

import mx.com.bakaya.soap.tech_assestment.Ability;
import mx.com.bankaya.assessment.dto.pokeapi.AbilityDto;
import mx.com.bankaya.assessment.interfaces.MapperService;
import org.springframework.stereotype.Component;

@Component
public class AbilityMapper implements MapperService<AbilityDto, Ability> {

    @Override
    public Ability convert(AbilityDto dto) {
        if (dto == null) {
            return null;
        }
        Ability ability = new Ability();
        ability.setName(dto.getName());
        ability.setUrl(dto.getUrl());
        return ability;
    }

}
