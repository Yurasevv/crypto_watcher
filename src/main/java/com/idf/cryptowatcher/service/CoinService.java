package com.idf.cryptowatcher.service;

import com.idf.cryptowatcher.domain.Coin;
import com.idf.cryptowatcher.dto.CoinDto;
import com.idf.cryptowatcher.mapper.impl.CoinMapperImpl;
import com.idf.cryptowatcher.repo.CoinRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CoinService {

    @Autowired
    private CoinRepo coinRepo;
    private  CoinMapperImpl coinMapper;

    private final String URL = "https://api.coinlore.net/api/ticker/";

    public List<CoinDto> findAllCoins() {
        return coinRepo.findAll().stream()
                .map(coinMapper::map)
                .collect(Collectors.toList());
    }

    public Optional<BigDecimal> findPriceBySymbol(String symbol) {
        return coinRepo.findBySymbol(symbol)
                .map(Coin::getPriceUsd);
    }

}
