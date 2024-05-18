package inflern.study.userservice.dto.vo;

import inflern.study.userservice.dto.RequestDto;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserVo {

    @RequiredArgsConstructor(access = AccessLevel.PRIVATE)
    @Builder
    @Getter
    public static class CreateUserItem {
        private final String email;
        private final String name;
        private final String pwd;

        public static CreateUserItem from(RequestDto.CreateUserDto dto) {
            return CreateUserItem.builder()
                    .email(dto.getEmail())
                    .name(dto.getName())
                    .pwd(dto.getPwd())
                    .build();
        }
    }

    @RequiredArgsConstructor(access = AccessLevel.PRIVATE)
    @Builder
    @Getter
    public static class UserItem {
        private final String userId;
        private final String email;
        private final String name;
        private final LocalDateTime createAt;

        private final List<OrderVo.OrderItem> orders;
    }
}
