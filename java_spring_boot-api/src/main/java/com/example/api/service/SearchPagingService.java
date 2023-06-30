package com.example.api.service;

/**
 * Search service.
 *
 * @param <S> request
 * @param <T> response
 */
public interface SearchPagingService<S, T> {
    T execute(S request);
}