package br.com.ifsul.pcbuilder.service.orderitem;

import br.com.ifsul.pcbuilder.dto.order.OrderCreationItemRequestDto;
import br.com.ifsul.pcbuilder.mapper.orderitem.OrderItemMapper;
import br.com.ifsul.pcbuilder.domain.Order;
import br.com.ifsul.pcbuilder.domain.OrderItem;
import br.com.ifsul.pcbuilder.repository.OrderItemRepository;
import br.com.ifsul.pcbuilder.service.item.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderItemServiceImpl implements OrderItemService {

    private final OrderItemRepository repository;

    private final OrderItemMapper mapper;

    private final ItemService service;

    @Override
    public void create(Order order, List<OrderCreationItemRequestDto> requestItemsDto) {
        final List<OrderItem> newOrderItems = new ArrayList<>();
        requestItemsDto.forEach(it -> {
            final var item = service.findById(it.getId());
            final var orderItem = mapper.mapFromCreation(order, it.getQuantity(), item);
            newOrderItems.add(orderItem);
        });
        repository.saveAll(newOrderItems);
    }
}
