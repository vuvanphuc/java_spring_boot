package com.example.api.domain.user.update;

import com.example.core.entity.User;

import java.time.LocalDate;

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
public class UserUpdateRequest {

    private Long id;
    private String username;
    private String password;
    private String email;
    private String address;
    private LocalDate birthday;

    public User convertToUser() {
        return User.builder()
                .id(this.id)
                .username(this.username)
                .email(this.email)
                .password(this.password)
                .address(this.address)
                .createdBy("system")
                .updatedBy("system")
                .build();
    }
}