package inflern.study.userservice.dto;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ResponseDto {

    @RequiredArgsConstructor(access = AccessLevel.PRIVATE)
    @Builder
    @Getter
    public static class ResponseUserDto {
        private final String name;
        private final String email;
        private final String userId;
    }
}
