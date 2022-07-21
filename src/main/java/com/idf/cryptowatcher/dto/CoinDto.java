package com.idf.cryptowatcher.dto;

import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoinDto {

    private Long id;

    private String symbol;

    private BigDecimal price;
}
