package inflern.study.userservice.service.impl;

import inflern.study.userservice.dto.ResponseDto;
import inflern.study.userservice.vo.UserDto;
import inflern.study.userservice.model.User;
import inflern.study.userservice.model.mapper.UserMapper;
import inflern.study.userservice.repository.UserRepository;
import inflern.study.userservice.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
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
        User save = this.userRepository.save(user);
        UserDto.UserItem userItem = this.userMapper.entityToUserItem(save);

        return ResponseDto.ResponseUserDto.builder()
                .user(userItem)
                .build();
    }

    @Override
    public ResponseDto.ResponseUserDto getUserByUserId(String userId) {
        User user = this.userRepository.findByUserId(userId)
                .orElseThrow(EntityNotFoundException::new);

        UserDto.UserItem userItem = this.userMapper.entityToUserItem(user);

        return ResponseDto.ResponseUserDto.builder()
                .user(userItem)
                .build();
    }

    @Override
    public ResponseDto.ResponseUsersDto getUserByAll() {
        List<UserDto.UserItem> users = this.userRepository.findAll()
                .stream()
                .map(userMapper::entityToUserItem)
                .toList();

        return ResponseDto.ResponseUsersDto.builder()
                .users(users)
                .build();
    }
}
