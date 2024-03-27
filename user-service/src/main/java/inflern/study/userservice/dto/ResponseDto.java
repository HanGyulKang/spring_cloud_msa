package inflern.study.userservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ResponseDto {

    @RequiredArgsConstructor(access = AccessLevel.PRIVATE)
    @Builder
    @Getter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class ResponseUserDto {
        private final String email;
        private final String name;
        private final String userId;

        private final List<ResponseOrderDto> orders;
    }

    @RequiredArgsConstructor(access = AccessLevel.PRIVATE)
    @Builder
    @Getter
    public static class ResponseOrderDto {
        private final String productId;
        private final Integer qty;
        private final Integer unitPrice;
        private final Integer totalPrice;
        private final LocalDateTime createAt;

        private final String orderId;
    }
}
