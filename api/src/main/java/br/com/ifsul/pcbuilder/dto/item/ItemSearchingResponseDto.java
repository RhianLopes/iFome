package br.com.ifsul.pcbuilder.dto.item;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemSearchingResponseDto {

    private Long id;

    private String name;

    private String type;

    private BigDecimal price;

}
