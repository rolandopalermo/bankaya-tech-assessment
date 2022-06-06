package mx.com.bankaya.assessment.dto.pokeapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigInteger;

@Data
public class AbilityItemDto {

    private AbilityDto ability;
    @JsonProperty("is_hidden")
    private Boolean isHidden;
    private BigInteger slot;

}
