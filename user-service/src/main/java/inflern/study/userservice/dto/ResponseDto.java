package inflern.study.userservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import inflern.study.userservice.vo.UserDto;
import lombok.*;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ResponseDto {

    @RequiredArgsConstructor(access = AccessLevel.PRIVATE)
    @Builder
    @Getter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class ResponseUserDto {
        private final UserDto.UserItem user;
    }

    @RequiredArgsConstructor(access = AccessLevel.PRIVATE)
    @Builder
    @Getter
    public static class ResponseUsersDto {
        private final List<UserDto.UserItem> users;
    }
}
