package inflern.study.userservice.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ResponseDto {

    @RequiredArgsConstructor
    @Getter
    public static class CreateUserDto {
        private final String name;
        private final String email;
    }
}
