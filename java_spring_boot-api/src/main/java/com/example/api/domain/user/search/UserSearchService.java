package com.example.api.domain.user.search;

import com.example.api.service.SearchService;
import com.example.core.entity.User;
import com.example.core.repository.UserRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;

/**
 * User service.
 */
@RequiredArgsConstructor
@org.springframework.stereotype.Service
public class UserSearchService implements SearchService<UserSearchRequest, UserSearchResponse> {

    private final UserRepository userRepository;

    @Override
    public List<UserSearchResponse> execute(UserSearchRequest userSearchRequest) {
        List<User> listUser = userRepository.findAll();
        return listUser.stream().map(UserSearchResponse::of).toList();
    }
}