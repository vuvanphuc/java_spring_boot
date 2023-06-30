package com.example.api.domain.user.search;

import com.example.core.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * User request.
 */
@Data
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class UserSearchRequest {

    private Long id;
    private String username;
    private String email;
    private String address;
    private int pageNumber;
    private int pageSize;
    private int totalPage;
    private int currentPage;

    public User convertToUser() {
        return User.builder()
                .id(this.id)
                .username(this.username)
                .email(this.email)
                .address(this.address)
                .pageNumber(this.pageNumber)
                .pageSize(this.pageSize)
                .build();
    }
}