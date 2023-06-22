package com.example.api.domain.user.update;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * User controller.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserUpdateController {

    private final UserUpdateService userUpdateService;

    @PutMapping
    public ResponseEntity<UserUpdateResponse> create(@RequestBody UserUpdateRequest userUpdateRequest) {
        return ResponseEntity.ok(userUpdateService.execute(userUpdateRequest));
    }
}
