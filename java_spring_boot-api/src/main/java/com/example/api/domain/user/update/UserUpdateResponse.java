package com.example.api.domain.user.update;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.example.core.entity.User;

import java.time.OffsetDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * User response.
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdateResponse {

    private Long id;
    private String username;
    private String password;
    private String email;
    private String address;

    @JsonFormat(
            shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd'T'HH:mm:ss[.SSS]XXX",
            timezone = "UTC")
    private OffsetDateTime createdAt;

    private String createdBy;

    @JsonFormat(
            shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd'T'HH:mm:ss[.SSS]XXX",
            timezone = "UTC")
    private OffsetDateTime updatedAt;

    private String updatedBy;

    @JsonFormat(
            shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd'T'HH:mm:ss[.SSS]XXX",
            timezone = "UTC")
    private OffsetDateTime deletedAt;

    private String deletedBy;

    /**
     * User response.
     */
    public static UserUpdateResponse of(User user) {
        return UserUpdateResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .address(user.getAddress())
                .email(user.getEmail())
                .createdBy(user.getCreatedBy())
                .updatedAt(user.getUpdatedAt())
                .updatedBy(user.getUpdatedBy())
                .deletedAt(user.getDeletedAt())
                .deletedBy(user.getDeletedBy())
                .build();
    }
}
