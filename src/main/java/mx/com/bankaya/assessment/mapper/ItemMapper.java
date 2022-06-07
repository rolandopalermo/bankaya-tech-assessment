package mx.com.bankaya.assessment.mapper;

import lombok.RequiredArgsConstructor;
import mx.com.bakaya.soap.tech_assestment.Item;
import mx.com.bankaya.assessment.dto.pokeapi.ItemDto;
import mx.com.bankaya.assessment.interfaces.MapperService;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ItemMapper implements MapperService<ItemDto, Item> {

    @Override
    public Item convert(ItemDto dto) {
        if (dto == null) {
            return null;
        }
        Item response = new Item();
        response.setName(dto.getName());
        response.setUrl(dto.getUrl());
        return response;
    }

}
