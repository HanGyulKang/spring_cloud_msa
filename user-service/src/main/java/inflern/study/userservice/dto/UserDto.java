package inflern.study.userservice.dto;

import inflern.study.userservice.utils.UserUtils;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserDto {
    @RequiredArgsConstructor(access = AccessLevel.PRIVATE)
    @Builder(access = AccessLevel.PRIVATE)
    @Getter
    public static class CreateUserDto {
        private final String email;
        private final String name;
        private final String encryptedPwd;

        public static CreateUserDto from(RequestDto.CreateUserDto dto) {
            return CreateUserDto.builder()
                    .email(dto.getEmail())
                    .name(dto.getName())
                    .encryptedPwd(UserUtils.encryptPwd(dto.getPwd()))
                    .build();
        }
    }
}
