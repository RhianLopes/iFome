package br.com.ifsul.pcbuilder.service.item;

import br.com.ifsul.pcbuilder.dto.item.ItemCreationRequestDto;
import br.com.ifsul.pcbuilder.dto.item.ItemSearchingResponseDto;
import br.com.ifsul.pcbuilder.mapper.item.ItemMapper;
import br.com.ifsul.pcbuilder.domain.Item;
import br.com.ifsul.pcbuilder.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepository repository;

    private final ItemMapper mapper;

    @Override
    public void create(ItemCreationRequestDto requestDto) {
        final var item = mapper.mapFromItemCreationRequestDto(requestDto);
        repository.save(item);
    }

    @Override
    public List<ItemSearchingResponseDto> search() {
        return repository.findAll().stream()
                .map(mapper::mapToItemSearchingResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public Item findById(Long itemId) {
        return repository.findById(itemId)
                .orElseThrow(() -> new RuntimeException("Item não encontrado!"));
    }
}
