package br.com.ifsul.pcbuilder.service.item;

import br.com.ifsul.pcbuilder.dto.item.ItemCreationRequestDto;
import br.com.ifsul.pcbuilder.dto.item.ItemSearchingResponseDto;
import br.com.ifsul.pcbuilder.domain.Item;

import java.util.List;

public interface ItemService {

    void create(ItemCreationRequestDto requestDto);

    List<ItemSearchingResponseDto> search();

    Item findById(Long itemId);

}
