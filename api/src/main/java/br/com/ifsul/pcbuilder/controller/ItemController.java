package br.com.ifsul.pcbuilder.controller;

import br.com.ifsul.pcbuilder.dto.item.ItemCreationRequestDto;
import br.com.ifsul.pcbuilder.dto.item.ItemSearchingResponseDto;
import br.com.ifsul.pcbuilder.service.item.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/items")
public class ItemController {

    private final ItemService service;

    @PostMapping
    public void create(@RequestBody ItemCreationRequestDto requestDto) {
        service.create(requestDto);
    }

    @GetMapping
    public List<ItemSearchingResponseDto> search() {
        return service.search();
    }
}
