package com.example.api.service;

public interface CreateService<S, T> {
    T execute(S request);
}
