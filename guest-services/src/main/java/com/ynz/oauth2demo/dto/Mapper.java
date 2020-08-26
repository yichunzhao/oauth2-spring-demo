package com.ynz.oauth2demo.dto;

public interface Mapper<S, T> {
    T map(S s);

    S inverse(T t);
}
