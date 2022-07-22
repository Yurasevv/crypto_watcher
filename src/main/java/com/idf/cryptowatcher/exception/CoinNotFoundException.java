package com.idf.cryptowatcher.exception;


public class CoinNotFoundException extends Exception {

    public CoinNotFoundException(){};

    public CoinNotFoundException(String message) {
        super(message);
    }
    public CoinNotFoundException(String message, Exception exception){
        super(message,exception);
    }
    public CoinNotFoundException(Exception exception){
        super(exception);
    }
}
