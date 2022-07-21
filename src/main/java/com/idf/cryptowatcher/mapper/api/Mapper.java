package com.idf.cryptowatcher.mapper.api;

public interface Mapper<F, T> {
    T map(F object);

    default T map(F from, T to) {
        return to;
    }
}
