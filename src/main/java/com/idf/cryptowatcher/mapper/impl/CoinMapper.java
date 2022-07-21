package com.idf.cryptowatcher.mapper.impl;

import com.idf.cryptowatcher.domain.Coin;
import com.idf.cryptowatcher.dto.CoinDto;
import com.idf.cryptowatcher.mapper.api.Mapper;
import org.springframework.stereotype.Component;

@Component
public class CoinMapper implements Mapper<Coin, CoinDto> {

    @Override
    public CoinDto map(Coin coin) {
        return new CoinDto (
                coin.getId(),
                coin.getSymbol(),
                coin.getPriceUsd()
        );
    }
}
