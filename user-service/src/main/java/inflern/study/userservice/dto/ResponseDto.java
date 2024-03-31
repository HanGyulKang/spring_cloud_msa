package inflern.study.userservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import inflern.study.userservice.dto.vo.UserVo;
import lombok.*;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ResponseDto {

    @RequiredArgsConstructor(access = AccessLevel.PRIVATE)
    @Builder
    @Getter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class UserResponseDto {
        private final UserVo.UserItem user;
    }

    @RequiredArgsConstructor(access = AccessLevel.PRIVATE)
    @Builder
    @Getter
    public static class UsersResponseDto {
        private final List<UserVo.UserItem> users;
    }
}
