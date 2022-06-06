package mx.com.bankaya.assessment.mapper;

import mx.com.bankaya.assessment.dto.pokeapi.AbilityDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class AbilityMapperTest {

    @InjectMocks
    AbilityMapper abilityMapper;

    @Test
    void contextLoads() {
        assertNotNull(abilityMapper);
    }

    @Test
    void given_ValidDto_whenConvert_thenSuccess() {
        var dto = new AbilityDto();
        dto.setUrl("https://localhost");
        dto.setName("JUnit");
        var result = abilityMapper.convert(dto);
        assertNotNull(result);
        assertEquals("https://localhost", result.getUrl());
        assertEquals("JUnit", result.getName());
    }

}