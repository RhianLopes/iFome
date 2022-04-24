package br.com.ifsul.pcbuilder.service.order;

import br.com.ifsul.pcbuilder.dto.order.OrderCreationRequestDto;
import br.com.ifsul.pcbuilder.dto.order.OrderSearchingResponseDto;

import java.util.List;

public interface OrderService {

    void create(OrderCreationRequestDto requestDto);

    List<OrderSearchingResponseDto> search(String status);

    void confirm(Long id);

    void finish(Long id);

}
