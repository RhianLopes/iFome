package br.com.ifsul.pcbuilder.mapper.order;

import br.com.ifsul.pcbuilder.domain.Item;
import br.com.ifsul.pcbuilder.domain.OrderStatus;
import br.com.ifsul.pcbuilder.dto.order.OrderCreationRequestDto;
import br.com.ifsul.pcbuilder.domain.Order;
import br.com.ifsul.pcbuilder.dto.order.OrderSearchingItemResponseDto;
import br.com.ifsul.pcbuilder.dto.order.OrderSearchingResponseDto;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class OrderMapper {

    public Order mapFromOrderCreationRequestDto(OrderCreationRequestDto requestDto) {
        return Order.builder()
                .name(requestDto.getName())
                .phone(requestDto.getPhone())
                .status(OrderStatus.REQUESTED)
                .build();
    }

    public OrderSearchingResponseDto mapToOrderSearchingResponseDto(Order order) {
        return OrderSearchingResponseDto.builder()
                .id(order.getId())
                .name(order.getName())
                .phone(order.getPhone())
                .status(order.getStatus())
                .items(order.getItems().stream()
                        .map(this::mapToOrderSearchingItemResponseDto)
                        .collect(Collectors.toList()))
                .build();
    }

    public void mapToConfirm(Order order) {
        order.setStatus(OrderStatus.CONFIRMED);
    }

    public void mapToFinish(Order order) {
        order.setStatus(OrderStatus.FINISHED);
    }

    private OrderSearchingItemResponseDto mapToOrderSearchingItemResponseDto(Item item) {
        return OrderSearchingItemResponseDto.builder()
                .id(item.getId())
                .type(item.getType())
                .name(item.getName())
                .price(item.getPrice())
                .build();
    }
}
