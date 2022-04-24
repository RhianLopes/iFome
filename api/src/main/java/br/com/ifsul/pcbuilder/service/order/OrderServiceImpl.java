package br.com.ifsul.pcbuilder.service.order;

import br.com.ifsul.pcbuilder.domain.OrderStatus;
import br.com.ifsul.pcbuilder.dto.order.OrderCreationRequestDto;
import br.com.ifsul.pcbuilder.dto.order.OrderSearchingResponseDto;
import br.com.ifsul.pcbuilder.mapper.order.OrderMapper;
import br.com.ifsul.pcbuilder.domain.Order;
import br.com.ifsul.pcbuilder.repository.OrderRepository;
import br.com.ifsul.pcbuilder.service.orderitem.OrderItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderItemService orderItemService;

    private final OrderRepository repository;

    private final OrderMapper mapper;

    @Override
    public void create(OrderCreationRequestDto requestDto) {
        final Order order = repository.save(mapper.mapFromOrderCreationRequestDto(requestDto));
        orderItemService.create(order, requestDto.getItems());
    }

    @Override
    public List<OrderSearchingResponseDto> search(String status) {
        List<Order> orders;
        if (Objects.isNull(status)) {
            orders = repository.findAll();
        } else {
            orders = repository.findByStatus(OrderStatus.valueOf(status));
        }
        return orders.stream()
                .map(mapper::mapToOrderSearchingResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public void confirm(Long id) {
        final var order = findById(id);
        mapper.mapToConfirm(order);
        repository.save(order);
    }

    @Override
    public void finish(Long id) {
        final var order = findById(id);
        mapper.mapToFinish(order);
        repository.save(order);
    }

    private Order findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado!"));
    }
}
