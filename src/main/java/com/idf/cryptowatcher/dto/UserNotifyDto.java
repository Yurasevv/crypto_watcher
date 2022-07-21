package com.idf.cryptowatcher.dto;

import com.sun.istack.NotNull;
import lombok.Value;

@Value
public class UserNotifyDto {

    @NotNull
    String username;

    @NotNull
    String cryptoSymbol;
}
