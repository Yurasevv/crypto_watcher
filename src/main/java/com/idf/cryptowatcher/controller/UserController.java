package com.idf.cryptowatcher.controller;

import com.idf.cryptowatcher.dto.UserDto;
import com.idf.cryptowatcher.dto.UserNotifyDto;
import com.idf.cryptowatcher.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;


    //request format ?username=u&cryptoSymbol=btc
    @PostMapping
    public Optional<UserDto> notify(@Validated @RequestBody UserNotifyDto user) {
        return userService.create(user);
    }

    @GetMapping
    public List<UserDto> findAll() {
        return userService.findAllUsers();
    }

}
