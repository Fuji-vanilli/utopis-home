package fj.utopis.user.DTO;

import jakarta.validation.constraints.NotNull;

public record UserRequest(
        @NotNull(message = "username required!")
        String username,
        String firstname,
        String lastname,
        @NotNull(message = "email required!")
        String email,
        String imageUrl
) {
}
