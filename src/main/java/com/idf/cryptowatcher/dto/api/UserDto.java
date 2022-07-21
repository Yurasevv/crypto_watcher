package com.idf.cryptowatcher.dto.api;

import com.idf.cryptowatcher.domain.User;

import java.util.Optional;

public interface UserDto {
    Optional<User> findByUsername(String username);
}
