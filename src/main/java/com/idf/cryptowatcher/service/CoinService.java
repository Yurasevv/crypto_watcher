package com.idf.cryptowatcher.service;

import com.idf.cryptowatcher.domain.Coin;
import com.idf.cryptowatcher.dto.CoinDto;
import com.idf.cryptowatcher.mapper.impl.CoinMapper;
import com.idf.cryptowatcher.mapper.impl.CoinUpdMapper;
import com.idf.cryptowatcher.repo.CoinRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;


import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CoinService {

    @Autowired
    private CoinRepo coinRepo;
    @Autowired
    private CoinMapper coinMapper;
    @Autowired
    private CoinUpdMapper coinUpdMapper;
    @Autowired
    private RestTemplate restTemplate;


    private final String URL = "https://api.coinlore.net/api/ticker/";

    @Transactional
    public void updateCoins() {
        String ids = "90,80,48543";
        ResponseEntity<List<CoinDto>> responseEntity = restTemplate.exchange(
                URL + "?id=" + ids,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<CoinDto>>() {
                }
        );
        List<CoinDto> coinDtoList = responseEntity.getBody();

        if (coinDtoList != null) {
            coinDtoList.forEach(dto -> coinRepo.findById(dto.getId())
                            .map(entity -> coinUpdMapper.map(dto, entity))
                            .map(coinDto -> coinRepo.updatePrice(dto.getPrice(), dto.getId()))
            );
        }
    }

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
