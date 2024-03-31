package inflern.study.userservice.service.impl;

import inflern.study.userservice.dto.ResponseDto;
import inflern.study.userservice.dto.vo.UserVo;
import inflern.study.userservice.model.entity.User;
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
    public ResponseDto.UserResponseDto createUser(UserVo.CreateUserItem dto) {
        Optional<User> userByEmail = this.userRepository.findUserByEmail(dto.getEmail());
        if (userByEmail.isPresent()) {
            throw new IllegalArgumentException("already used email");
        }

        User user = this.userMapper.mapToUserEntity(dto);
        User save = this.userRepository.save(user);
        UserVo.UserItem userItem = this.userMapper.userEntityToMap(save);

        return ResponseDto.UserResponseDto.builder()
                .user(userItem)
                .build();
    }

    @Override
    public ResponseDto.UserResponseDto getUserByUserId(String userId) {
        User user = this.userRepository.findByUserId(userId)
                .orElseThrow(EntityNotFoundException::new);

        UserVo.UserItem userItem = this.userMapper.userEntityToMap(user);

        return ResponseDto.UserResponseDto.builder()
                .user(userItem)
                .build();
    }

    @Override
    public ResponseDto.UsersResponseDto getUserByAll() {
        List<UserVo.UserItem> users = this.userRepository.findAll()
                .stream()
                .map(userMapper::userEntityToMap)
                .toList();

        return ResponseDto.UsersResponseDto.builder()
                .users(users)
                .build();
    }
}
