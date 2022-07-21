package com.idf.cryptowatcher.dto.impl;

import com.idf.cryptowatcher.domain.Coin;
import com.idf.cryptowatcher.dto.api.CoinDto;
import com.idf.cryptowatcher.repo.CoinRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class CoinDtoImpl implements CoinDto {

    @Autowired
    private CoinRepo coinRepo;
    @Override
    public List<Coin> getAll() {
        return coinRepo.findAll();
    }

    @Override
    public Optional<Coin> findBySymbol(String symbol) {
        return coinRepo.findBySymbol(symbol);
    }
}
