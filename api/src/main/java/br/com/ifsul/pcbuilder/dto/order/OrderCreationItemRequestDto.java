package br.com.ifsul.pcbuilder.dto.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderCreationItemRequestDto {

    @NotNull
    private Long id;

    @NotNull
    private Integer quantity;
}
