package com.example.api.domain.user.create;

import com.example.api.service.CreateService;
import com.example.core.entity.User;
import com.example.core.repository.UserRepository;
import lombok.RequiredArgsConstructor;

/**
 * User service.
 */
@RequiredArgsConstructor
@org.springframework.stereotype.Service
public class UserCreateService implements CreateService<UserCreateRequest, UserCreateResponse> {

    private final UserRepository userRepository;

    @Override
    public UserCreateResponse execute(UserCreateRequest userCreateRequest) {
        User user = userCreateRequest.convertToUser();
        UserCreateResponse userResponse = UserCreateResponse.of(user);
        userRepository.create(user);
        return userResponse;
    }
}