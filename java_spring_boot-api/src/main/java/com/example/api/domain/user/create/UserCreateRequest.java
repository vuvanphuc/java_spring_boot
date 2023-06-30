package com.example.api.domain.user.create;

import java.time.OffsetDateTime;

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
public class UserCreateRequest {

    private String username;
    private String password;
    private String email;
    private String address;

    public User convertToUser() {
        OffsetDateTime createdAt = OffsetDateTime.now();
        OffsetDateTime updatedAt = OffsetDateTime.now();
        return User.builder()
                .username(this.username)
                .email(this.email)
                .password(this.password)
                .address(this.address)
                .createdBy("system")
                .createdAt(createdAt)
                .updatedBy("system")
                .updatedAt(updatedAt)
                .build();
    }
}