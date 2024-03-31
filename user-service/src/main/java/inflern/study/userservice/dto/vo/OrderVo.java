package inflern.study.userservice.dto.vo;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderVo {

    @RequiredArgsConstructor(access = AccessLevel.PRIVATE)
    @Builder
    @Getter
    public static class OrderItem {
        private final String productId;
        private final Integer quantity;
        private final Integer unitPrice;
        private final Integer totalPrice;
        private final LocalDateTime createAt;

        private final String orderId;
    }
}