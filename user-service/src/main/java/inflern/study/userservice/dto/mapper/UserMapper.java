package inflern.study.userservice.dto.mapper;

import inflern.study.userservice.dto.external.order.OrderServiceDto;
import inflern.study.userservice.dto.vo.UserVo;
import inflern.study.userservice.model.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserMapper {

    private final BCryptPasswordEncoder passwordEncoder;

    public User mapToUserEntity(UserVo.CreateUserItem dto) {
        return User.create(
                dto.getEmail(),
                dto.getName(),
                passwordEncoder.encode(dto.getPwd()));
    }

    public UserVo.UserItem mapToDto(User user) {
        return UserVo.UserItem.builder()
                .userId(user.getUserId())
                .name(user.getName())
                .email(user.getEmail())
                .createAt(user.getCreateAt())
                .build();
    }

    public UserVo.UserItem mapToDto(User user, List<OrderServiceDto.OrderItem> orderItems) {
        return UserVo.UserItem.builder()
                .userId(user.getUserId())
                .name(user.getName())
                .email(user.getEmail())
                .createAt(user.getCreateAt())
                .orders(orderItems)
                .build();
    }
}
