package mx.com.bankaya.assessment.dto.pokeapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class PokeApiResponseDto {

    public List<AbilityItemDto> abilities;
    @JsonProperty("base_experience")
    private BigDecimal baseExperience;
    @JsonProperty("held_items")
    private List<HeldItemDto> heldItems;
    private Long id;
    private String name;
    /*@JsonProperty("location_area_encounters")
    private List<LocationAreaEncounterDto> locationAreaEncounters;*/

}
