package br.com.ifsul.pcbuilder.mapper.item;

import br.com.ifsul.pcbuilder.dto.item.ItemCreationRequestDto;
import br.com.ifsul.pcbuilder.dto.item.ItemSearchingResponseDto;
import br.com.ifsul.pcbuilder.domain.Item;
import org.springframework.stereotype.Component;

@Component
public class ItemMapper {

    public Item mapFromItemCreationRequestDto(ItemCreationRequestDto requestDto) {
        return Item.builder()
                .name(requestDto.getName())
                .price(requestDto.getPrice())
                .type(requestDto.getType())
                .build();
    }

    public ItemSearchingResponseDto mapToItemSearchingResponseDto(Item item) {
        return ItemSearchingResponseDto.builder()
                .name(item.getName())
                .id(item.getId())
                .price(item.getPrice())
                .type(item.getType())
                .build();
    }
}
