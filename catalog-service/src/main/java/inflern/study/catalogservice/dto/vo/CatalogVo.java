package inflern.study.catalogservice.dto.vo;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CatalogVo {

    @RequiredArgsConstructor(access = AccessLevel.PRIVATE)
    @Builder
    @Getter
    public static class CatalogItem {
        private final String productId;
        private final String productName;
        private final Integer unitPrice;
        private final Integer stock;
        private final LocalDateTime createdAt;
    }

    @RequiredArgsConstructor(access = AccessLevel.PRIVATE)
    @Builder
    @Getter
    public static class CatalogInfo implements Serializable {
        private final CatalogItem catalog;
        private final Integer quantity;
        private final Integer unitPrice;
        private final Integer totalPrice;

        private final String orderId;
        private final String userId;
    }
}
