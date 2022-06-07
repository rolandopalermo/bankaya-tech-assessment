package mx.com.bankaya.assessment.mapper;

import mx.com.bakaya.soap.tech_assestment.Abilities;
import mx.com.bankaya.assessment.dto.pokeapi.AbilityDto;
import mx.com.bankaya.assessment.dto.pokeapi.AbilityItemDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class AbilitiesMapperTest {

    @Mock
    AbilityMapper abilityMapper;

    @InjectMocks
    AbilitiesMapper abilitiesMapper;

    @Test
    void contextLoads() {
        assertNotNull(abilitiesMapper);
    }

    @Test
    void given_ValidDto_whenConvert_thenSuccess() {
        AbilityDto abilityDto = new AbilityDto();
        AbilityItemDto dto = new AbilityItemDto();
        dto.setAbility(abilityDto);
        dto.setSlot(BigInteger.ONE);
        dto.setIsHidden(true);
        Abilities result = abilitiesMapper.convert(dto);
        assertNotNull(result);
        assertTrue(result.isIsHidden());
        assertTrue(BigInteger.ONE.equals(result.getSlot()));
    }

}