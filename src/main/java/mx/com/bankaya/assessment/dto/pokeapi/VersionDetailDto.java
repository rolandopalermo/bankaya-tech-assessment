package mx.com.bankaya.assessment.dto.pokeapi;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class VersionDetailDto {

    private BigDecimal rarity;
    private VersionDto version;

}
