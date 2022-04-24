package br.com.ifsul.pcbuilder.mapper.orderitem;

import br.com.ifsul.pcbuilder.domain.Item;
import br.com.ifsul.pcbuilder.domain.Order;
import br.com.ifsul.pcbuilder.domain.OrderItem;
import org.springframework.stereotype.Component;

@Component
public class OrderItemMapper {

    public OrderItem mapFromCreation(Order order, Integer quantity, Item item) {
        return OrderItem.builder()
                .order(order)
                .quantity(quantity)
                .item(item)
                .build();
    }
}
