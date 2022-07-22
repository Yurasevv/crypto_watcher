package com.idf.cryptowatcher.controller;

import com.idf.cryptowatcher.dto.CoinDto;
import com.idf.cryptowatcher.exception.CoinNotFoundException;
import com.idf.cryptowatcher.service.CoinService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/coins")
public class CoinController {

    @Autowired
    private CoinService coinService;

    @GetMapping
    public List<CoinDto> findAllCoins() {
        return coinService.findAllCoins();
    }

    @GetMapping("/{symbol}")
    public Optional<BigDecimal> findPriceCoinBySymbol(@PathVariable("symbol") String symbol) {
        return coinService.findPriceBySymbol(symbol);
    }
}
