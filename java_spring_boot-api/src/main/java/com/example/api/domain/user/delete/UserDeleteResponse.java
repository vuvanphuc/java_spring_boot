package com.example.api.domain.user.delete;

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
public class UserDeleteResponse {
    private Long result;
}
