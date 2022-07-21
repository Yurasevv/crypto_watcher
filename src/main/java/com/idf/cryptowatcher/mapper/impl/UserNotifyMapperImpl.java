package com.idf.cryptowatcher.mapper.impl;

import com.idf.cryptowatcher.domain.User;
import com.idf.cryptowatcher.dto.UserNotifyDto;
import com.idf.cryptowatcher.mapper.api.Mapper;
import com.idf.cryptowatcher.repo.CoinRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserNotifyMapperImpl implements Mapper<UserNotifyDto, User> {

    @Autowired
    CoinRepo coinRepo;


    @Override
    public User map(UserNotifyDto object) {
        User user = new User();
        user.setUsername(object.getUsername());
        user.setCryptoSymbol(object.getCryptoSymbol());
        user.setCryptoPrice(coinRepo.findBySymbol(object.getCryptoSymbol()).get().getPriceUsd());

        return user;
    }
}
