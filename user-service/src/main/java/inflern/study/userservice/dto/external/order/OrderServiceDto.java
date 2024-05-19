package inflern.study.userservice.dto.external.order;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderServiceDto {

    @NoArgsConstructor
    @Data
    public static class OrderItem {
        private String productId;
        private Integer quantity;
        private Integer unitPrice;
        private Integer totalPrice;
        private LocalDateTime createAt;

        private String orderId;
    }
}
