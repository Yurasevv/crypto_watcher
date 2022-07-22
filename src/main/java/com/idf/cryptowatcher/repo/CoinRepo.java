package com.idf.cryptowatcher.repo;


import com.idf.cryptowatcher.domain.Coin;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Qualifier("coin")
@Repository
public interface CoinRepo extends CrudRepository<Coin, Long> {

    List<Coin> findAll();
    Optional<Coin> findBySymbol(String symbol);

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("update Coin c " +
            "set c.price = :price " +
            "where c.id = :id")
    int updatePrice(BigDecimal price, Long id);
}
