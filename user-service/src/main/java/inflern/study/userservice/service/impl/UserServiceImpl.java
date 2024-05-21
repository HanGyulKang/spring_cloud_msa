package inflern.study.userservice.service.impl;

import inflern.study.userservice.dto.ResponseDto;
import inflern.study.userservice.dto.external.order.OrderServiceDto;
import inflern.study.userservice.dto.vo.UserVo;
import inflern.study.userservice.model.entity.User;
import inflern.study.userservice.dto.mapper.UserMapper;
import inflern.study.userservice.repository.UserRepository;
import inflern.study.userservice.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    private final RestTemplate restTemplate;
    private final Environment env;

    @Override
    @Transactional
    public ResponseDto.ResponseUserDto createUser(UserVo.CreateUserItem dto) {
        this.userRepository.findByEmail(dto.getEmail())
                .ifPresent((user) -> {
                    throw new IllegalArgumentException("already used email");
                });

        User user = this.userMapper.mapToUserEntity(dto);
        User save = this.userRepository.save(user);
        UserVo.UserItem userItem = this.userMapper.mapToDto(save);

        return ResponseDto.ResponseUserDto.builder()
                .user(userItem)
                .build();
    }

    @Override
    @Transactional(readOnly = true)
    public ResponseDto.ResponseUserDto getUserByUserId(String userId) {
        User user = this.userRepository.findByUserId(userId)
                .orElseThrow(EntityNotFoundException::new);

        String orderUrl = String.format("http://%s/%s/%s/%s",
                env.getProperty("order-service.name"),
                env.getProperty("order-service.url"),
                userId,
                env.getProperty("order-service.get-orders"));

        ResponseEntity<List<OrderServiceDto.OrderItem>> orderItemsResponse =
                this.restTemplate.exchange(orderUrl, HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<OrderServiceDto.OrderItem>>() {
                });

        List<OrderServiceDto.OrderItem> orderItems = orderItemsResponse.getBody();
        UserVo.UserItem userItem = this.userMapper.mapToDto(user, orderItems);

        return ResponseDto.ResponseUserDto.builder()
                .user(userItem)
                .build();
    }

    @Override
    @Transactional(readOnly = true)
    public ResponseDto.ResponseUsersDto getUserByAll() {
        List<UserVo.UserItem> users = this.userRepository.findAll()
                .stream()
                .map(this.userMapper::mapToDto)
                .toList();

        return ResponseDto.ResponseUsersDto.builder()
                .users(users)
                .build();
    }

    @Override
    @Transactional(readOnly = true)
    public ResponseDto.ResponseUserDto getUserDetailsByEmail(String email) {
        User user = this.userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(email));

        UserVo.UserItem userItem = this.userMapper.mapToDto(user);
        return ResponseDto.ResponseUserDto.builder()
                .user(userItem)
                .build();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final String email = username;

        User user = this.userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(email));

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(), user.getEncryptedPwd(),
                true,
                true,
                true,
                true,
                new ArrayList<>()
        );
    }
}
