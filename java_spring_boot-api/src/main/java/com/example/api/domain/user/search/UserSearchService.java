package com.example.api.domain.user.search;

import com.example.api.service.SearchPagingService;
import com.example.core.entity.User;
import com.example.core.repository.UserRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;

/**
 * User service.
 */
@RequiredArgsConstructor
@org.springframework.stereotype.Service
public class UserSearchService implements SearchPagingService<UserSearchRequest, UserSearchPageResponse> {

    private final UserRepository userRepository;

    @Override
    public UserSearchPageResponse execute(UserSearchRequest userSearchRequest) {
        List<User> listUser = userRepository.findAll(userSearchRequest.convertToUser());
        List<UserSearchResponse> listUserRes = listUser.stream().map(UserSearchResponse::of).toList();
        int count = userRepository.count(userSearchRequest.convertToUser());
        int totalPage = (int)Math.ceil(count / userSearchRequest.getPageSize());
        return UserSearchPageResponse.of(listUserRes, userSearchRequest.getCurrentPage(),
                userSearchRequest.getPageSize(), totalPage);
    }
}