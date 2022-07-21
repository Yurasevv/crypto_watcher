package com.idf.cryptowatcher.dto.impl;

import com.idf.cryptowatcher.domain.User;
import com.idf.cryptowatcher.dto.api.UserDto;
import com.idf.cryptowatcher.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class UserDtoImpl implements UserDto {
    @Autowired
    UserRepo userRepo;

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepo.findByUsername(username);
    }
}
