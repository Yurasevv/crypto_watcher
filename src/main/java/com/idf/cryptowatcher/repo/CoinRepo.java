package com.idf.cryptowatcher.repo;

import com.idf.cryptowatcher.domain.Coin;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CoinRepo extends CrudRepository<Coin, Long> {
    Optional<Coin> findBySymbol(String symbol);
}
