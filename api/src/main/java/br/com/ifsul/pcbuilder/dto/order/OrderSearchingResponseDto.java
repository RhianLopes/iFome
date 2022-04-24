package br.com.ifsul.pcbuilder.dto.order;

import br.com.ifsul.pcbuilder.domain.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderSearchingResponseDto {

    private Long id;

    private String name;

    private String phone;

    private OrderStatus status;

    private List<OrderSearchingItemResponseDto> items;

}
