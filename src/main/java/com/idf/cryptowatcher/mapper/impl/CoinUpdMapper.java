package com.idf.cryptowatcher.mapper.impl;

import com.idf.cryptowatcher.domain.Coin;
import com.idf.cryptowatcher.dto.CoinDto;
import com.idf.cryptowatcher.mapper.api.Mapper;
import org.springframework.stereotype.Component;

@Component
public class CoinUpdMapper implements Mapper<CoinDto, Coin>{

    @Override
    public Coin map(CoinDto object) {
            Coin coin = new Coin();

            return coin;

    }
}



