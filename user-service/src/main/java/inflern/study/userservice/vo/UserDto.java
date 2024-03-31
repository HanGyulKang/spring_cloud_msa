package inflern.study.userservice.vo;

import inflern.study.userservice.dto.RequestDto;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserDto {

    @RequiredArgsConstructor(access = AccessLevel.PRIVATE)
    @Builder
    @Getter
    public static class CreateUserDto {
        private final String email;
        private final String name;
        private final String pwd;

        public static CreateUserDto from(RequestDto.CreateUserDto dto) {
            return CreateUserDto.builder()
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

        private final List<OrderDto.OrderItem> orders = new ArrayList<>();
    }
}
