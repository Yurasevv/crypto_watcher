package com.idf.cryptowatcher.controller;

import com.idf.cryptowatcher.dto.CoinDto;
import com.idf.cryptowatcher.service.CoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/coins")
public class CoinController {

    @Autowired
    private CoinService coinService;

    @GetMapping
    public List<CoinDto> findAllCryptocurrency() {
        return coinService.findAllCoins();
    }

    @GetMapping("/{symbol}")
    public BigDecimal findPriceCryptocurrencyBySymbol(@PathVariable("symbol") String symbol) {
        return coinService.findPriceBySymbol(symbol)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
