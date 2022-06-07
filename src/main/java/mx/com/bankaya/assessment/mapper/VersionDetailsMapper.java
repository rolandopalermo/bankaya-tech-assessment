package mx.com.bankaya.assessment.mapper;

import lombok.RequiredArgsConstructor;
import mx.com.bakaya.soap.tech_assestment.VersionDetails;
import mx.com.bankaya.assessment.dto.pokeapi.VersionDetailDto;
import mx.com.bankaya.assessment.interfaces.MapperService;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class VersionDetailsMapper implements MapperService<VersionDetailDto, VersionDetails> {

    private final VersionMapper versionMapper;

    @Override
    public VersionDetails convert(VersionDetailDto dto) {
        if (dto == null) {
            return null;
        }
        VersionDetails response = new VersionDetails();
        response.setRarity(dto.getRarity());
        response.setVersion(versionMapper.convert(dto.getVersion()));
        return response;
    }

}
