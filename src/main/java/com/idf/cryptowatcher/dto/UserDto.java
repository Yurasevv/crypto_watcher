package com.idf.cryptowatcher.dto;


import lombok.Value;

import java.math.BigDecimal;

@Value
public class UserDto {
    Long id;
    String username;
    String cryptoSymbol;
    BigDecimal cryptoPrice;
}
