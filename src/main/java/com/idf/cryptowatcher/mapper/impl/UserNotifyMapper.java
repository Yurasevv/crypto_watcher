package com.idf.cryptowatcher.mapper.impl;

import com.idf.cryptowatcher.domain.User;
import com.idf.cryptowatcher.dto.UserNotifyDto;
import com.idf.cryptowatcher.mapper.api.Mapper;
import com.idf.cryptowatcher.repo.CoinRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserNotifyMapper implements Mapper<UserNotifyDto, User> {

    @Autowired
    CoinRepo coinRepo;

    @Override
    public User map(UserNotifyDto dto) {
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setCryptoSymbol(dto.getCryptoSymbol());
        user.setCryptoPrice(coinRepo.findBySymbol(dto.getCryptoSymbol()).get().getPrice());

        return user;
    }
}
