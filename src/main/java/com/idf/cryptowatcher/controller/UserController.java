package com.idf.cryptowatcher.controller;

import com.idf.cryptowatcher.dto.UserDto;
import com.idf.cryptowatcher.dto.UserNotifyDto;
import com.idf.cryptowatcher.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping
    public Optional<UserDto> notify(@Validated @RequestBody UserNotifyDto user) {
        return userService.create(user);
    }
}
