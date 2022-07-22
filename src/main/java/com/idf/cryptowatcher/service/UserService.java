package com.idf.cryptowatcher.service;

import com.idf.cryptowatcher.domain.User;
import com.idf.cryptowatcher.dto.UserDto;
import com.idf.cryptowatcher.dto.UserNotifyDto;
import com.idf.cryptowatcher.mapper.impl.UserMapper;
import com.idf.cryptowatcher.mapper.impl.UserNotifyMapper;
import com.idf.cryptowatcher.repo.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@Transactional
public class UserService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserNotifyMapper userNotifyMapper;

    @Autowired
    CoinService coinService;

    @Transactional
    public Optional<UserDto> create(UserNotifyDto userCreateDto) {
        return Optional.of(userCreateDto)
                .map(userNotifyMapper::map)
                .map(userRepo::save)
                .map(userMapper::map);
    }
    public void checkUserPrice() {
        List<User> userList = userRepo.findAll();

        if (!userList.isEmpty()) {

            for (User userItem : userList) {

                Optional<BigDecimal> actualPrice = coinService.findPriceBySymbol(userItem.getCryptoSymbol());
                BigDecimal userPrice = userItem.getCryptoPrice();
                BigDecimal percentOfUserPrice = BigDecimal.valueOf(100).multiply(
                        (actualPrice.get()
                                .subtract(userPrice)
                                .divide(userPrice, 2, RoundingMode.HALF_UP)));

                if (percentOfUserPrice.abs().compareTo(BigDecimal.valueOf(1)) > 0) {
                    log.warn(String.format("Symbol: %s, Username: %s, price change: %.2f%%",
                            userItem.getCryptoSymbol(), userItem.getUsername(), percentOfUserPrice.abs()));
                    
                }
            }
        }
    }
}


