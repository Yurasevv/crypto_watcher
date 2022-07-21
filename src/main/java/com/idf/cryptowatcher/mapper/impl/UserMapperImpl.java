package com.idf.cryptowatcher.mapper.impl;

import com.idf.cryptowatcher.domain.User;
import com.idf.cryptowatcher.dto.UserDto;
import com.idf.cryptowatcher.mapper.api.Mapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements Mapper<User, UserDto> {

    @Override
    public UserDto map(User user) {
        return new UserDto(
                user.getId(),
                user.getUsername(),
                user.getCryptoSymbol(),
                user.getCryptoPrice()
        );
    }
}
