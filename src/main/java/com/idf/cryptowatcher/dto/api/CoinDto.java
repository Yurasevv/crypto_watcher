package com.idf.cryptowatcher.dto.api;

import com.idf.cryptowatcher.domain.Coin;

import java.util.List;
import java.util.Optional;

public interface CoinDto {
    List<Coin> getAll();
    Optional<Coin> findBySymbol(String symbol);
}
