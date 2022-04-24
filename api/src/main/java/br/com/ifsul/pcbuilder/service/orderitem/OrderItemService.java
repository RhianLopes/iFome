package br.com.ifsul.pcbuilder.service.orderitem;

import br.com.ifsul.pcbuilder.dto.order.OrderCreationItemRequestDto;
import br.com.ifsul.pcbuilder.domain.Order;

import java.util.List;

public interface OrderItemService {

    void create(Order order, List<OrderCreationItemRequestDto> requestItemsDto);

}
