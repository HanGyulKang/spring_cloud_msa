package inflern.study.userservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RequestDto {

    @NoArgsConstructor
    @Getter
    public static class CreateUserDto {
        @NotBlank(message = "email cannot be null")
        @Size(min = 2, message = "Email not be less than two characters")
        @Email
        private String email;

        @NotBlank(message = "Name cannot be blank or empty")
        private String name;

        @NotBlank(message = "pwd cannot be empty")
        @Size(min = 8, message = "Password must be equal or greater than 8 characters")
        private String pwd;
    }
}
