package fj.utopis.user.DTO;

import jakarta.validation.constraints.NotNull;

import java.time.Instant;

public record UserResponse(
        String id,
        String username,
        String firstname,
        String lastname,
        String email,
        String imageUrl,
        Instant createdDate,
        Instant lastModifiedDate
) {
}
