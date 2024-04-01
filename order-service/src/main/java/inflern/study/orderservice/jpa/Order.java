package inflern.study.orderservice.jpa;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "orders")
public class Order implements Serializable { // 직렬화를 넣어주는 목적 : 객체를 전송하거나 데이터 보관하기 위해 마샬링, 언마샬링을 위해 사용

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "product_id", nullable = false, length = 120, unique = true)
    private String productId;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "unit_price", nullable = false)
    private Integer unitPrice;

    @Column(name = "total_price", nullable = false)
    private Integer totalPrice;

    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(name = "order_id", nullable = false)
    private String orderId;

    @Column(name = "created_at", updatable = false, nullable = false)
    private LocalDateTime createdAt;
}
