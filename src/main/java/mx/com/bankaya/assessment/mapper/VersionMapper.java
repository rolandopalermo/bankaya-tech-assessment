package mx.com.bankaya.assessment.mapper;

import lombok.RequiredArgsConstructor;
import mx.com.bakaya.soap.tech_assestment.Version;
import mx.com.bankaya.assessment.dto.pokeapi.VersionDto;
import mx.com.bankaya.assessment.interfaces.MapperService;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class VersionMapper implements MapperService<VersionDto, Version> {

    @Override
    public Version convert(VersionDto dto) {
        if (dto == null) {
            return null;
        }
        Version response = new Version();
        response.setName(dto.getName());
        response.setUrl(dto.getUrl());
        return response;
    }

}
