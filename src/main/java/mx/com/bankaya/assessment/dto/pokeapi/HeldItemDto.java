package mx.com.bankaya.assessment.dto.pokeapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class HeldItemDto {

    private ItemDto item;
    @JsonProperty("version_details")
    private List<VersionDetailDto> versionDetails;

}
