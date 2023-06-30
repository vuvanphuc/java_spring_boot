package com.example.api.domain.user.search;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * User search page response.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserSearchPageResponse {
    private List<UserSearchResponse> listUser;
    private int pageSize;
    private int currentPage;
    private int totalPage;

    public static UserSearchPageResponse of(List<UserSearchResponse> list, int currentPageRes, int pageSizeRes, int totalPage) {
        totalPage = totalPage <= 0 ? 1 : totalPage;
        return UserSearchPageResponse.builder()
                .listUser(list)
                .currentPage(currentPageRes)
                .pageSize(pageSizeRes)
                .totalPage(totalPage)
                .build();
    }
}
