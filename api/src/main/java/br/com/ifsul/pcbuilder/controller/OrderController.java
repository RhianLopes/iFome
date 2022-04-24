package br.com.ifsul.pcbuilder.controller;

import br.com.ifsul.pcbuilder.dto.order.OrderCreationRequestDto;
import br.com.ifsul.pcbuilder.dto.order.OrderSearchingResponseDto;
import br.com.ifsul.pcbuilder.service.order.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    private void create(@RequestBody OrderCreationRequestDto requestDto) {
        orderService.create(requestDto);
    }

    @GetMapping
    public List<OrderSearchingResponseDto> search(@RequestParam(name = "status", required = false) String status) {
        return orderService.search(status);
    }

    @PatchMapping("/confirm")
    public void confirm(@RequestParam(name = "id") Long id) {
        orderService.confirm(id);
    }

    @PatchMapping("/finish")
    public void finish(@RequestParam(name = "id") Long id) {
        orderService.finish(id);
    }
}
