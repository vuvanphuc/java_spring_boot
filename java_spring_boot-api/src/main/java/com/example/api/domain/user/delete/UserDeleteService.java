package com.example.api.domain.user.delete;

import com.example.api.service.CreateService;
import com.example.core.repository.UserRepository;
import lombok.RequiredArgsConstructor;

/**
 * User service.
 */
@RequiredArgsConstructor
@org.springframework.stereotype.Service
public class UserDeleteService implements CreateService<Long, UserDeleteResponse> {

    private final UserRepository userRepository;

    @Override
    public UserDeleteResponse execute(Long id) {
        Long i = userRepository.delete(id);
        return UserDeleteResponse.builder().result(i).build();
    }
}