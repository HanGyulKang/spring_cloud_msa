package inflern.study.orderservice.service;

import inflern.study.orderservice.dto.OrderDto;
import inflern.study.orderservice.jpa.Order;

public interface OrderService {
    OrderDto createOrder(OrderDto orderDetails);
    OrderDto getOrderByOrderId(String orderId);
    Iterable<Order> getOrdersByUserId(String userId);
}
