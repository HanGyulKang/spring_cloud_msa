package inflern.study.orderservice.service;

import inflern.study.orderservice.dto.OrderDto;
import inflern.study.orderservice.jpa.Order;
import inflern.study.orderservice.jpa.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    @Transactional
    public OrderDto createOrder(OrderDto dto) {
        dto.setOrderId(UUID.randomUUID().toString());
        dto.setTotalPrice(dto.getQuantity() * dto.getUnitPrice());

        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Order order = mapper.map(dto, Order.class);
        order.setCreatedAt(LocalDateTime.now());

        orderRepository.save(order);
        return mapper.map(order, OrderDto.class);
    }

    @Override
    @Transactional(readOnly = true)
    public Order getOrderByOrderId(String orderId) {
        return orderRepository.findByOrderId(orderId);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Order> getOrdersByUserId(String userId) {
        return orderRepository.findByUserId(userId);
    }
}
