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
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    @Transactional
    public ResponseDto.ResponseUserDto createUser(UserVo.CreateUserItem dto) {
        Optional<User> userByEmail = this.userRepository.findUserByEmail(dto.getEmail());
        if (userByEmail.isPresent()) {
            throw new IllegalArgumentException("already used email");
        }

        User user = this.userMapper.mapToUserEntity(dto);
        User save = this.userRepository.save(user);
        UserVo.UserItem userItem = this.userMapper.userEntityToMap(save);

        return ResponseDto.ResponseUserDto.builder()
                .user(userItem)
                .build();
    }

    @Override
    @Transactional(readOnly = true)
    public ResponseDto.ResponseUserDto getUserByUserId(String userId) {
        User user = this.userRepository.findByUserId(userId)
                .orElseThrow(EntityNotFoundException::new);

        UserVo.UserItem userItem = this.userMapper.userEntityToMap(user);

        return ResponseDto.ResponseUserDto.builder()
                .user(userItem)
                .build();
    }

    @Override
    @Transactional(readOnly = true)
    public ResponseDto.ResponseUsersDto getUserByAll() {
        List<UserVo.UserItem> users = this.userRepository.findAll()
                .stream()
                .map(userMapper::userEntityToMap)
                .toList();

        return ResponseDto.ResponseUsersDto.builder()
                .users(users)
                .build();
    }
}
