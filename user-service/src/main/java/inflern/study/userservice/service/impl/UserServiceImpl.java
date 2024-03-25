package inflern.study.userservice.service.impl;

import inflern.study.userservice.dto.ResponseDto;
import inflern.study.userservice.dto.UserDto;
import inflern.study.userservice.model.User;
import inflern.study.userservice.model.mapper.UserMapper;
import inflern.study.userservice.repository.UserRepository;
import inflern.study.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public ResponseDto.ResponseUserDto createUser(UserDto.CreateUserDto dto) {
        Optional<User> userByEmail = this.userRepository.findUserByEmail(dto.getEmail());
        if (userByEmail.isPresent()) {
            throw new IllegalArgumentException("already used email");
        }

        User user = this.userMapper.mapToUserEntity(dto);
        this.userRepository.save(user);

        return ResponseDto.ResponseUserDto.builder()
                .userId(user.getUserId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }
}
