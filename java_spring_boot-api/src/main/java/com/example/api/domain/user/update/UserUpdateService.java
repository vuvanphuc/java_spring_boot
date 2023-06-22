package com.example.api.domain.user.update;

import com.example.api.service.CreateService;
import com.example.core.entity.User;
import com.example.core.repository.UserRepository;
import lombok.RequiredArgsConstructor;

/**
 * User service.
 */
@RequiredArgsConstructor
@org.springframework.stereotype.Service
public class UserUpdateService implements CreateService<UserUpdateRequest, UserUpdateResponse> {

    private final UserRepository userRepository;

    @Override
    public UserUpdateResponse execute(UserUpdateRequest userUpdateRequest) {
        User user = userUpdateRequest.convertToUser();
        UserUpdateResponse userResponse = UserUpdateResponse.of(user);
        userRepository.update(user);
        return userResponse;
    }
}