package com.idf.cryptowatcher.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoinDto {

    private Long id;

    private String symbol;

    @JsonProperty("price_usd")
    private BigDecimal price;
}
