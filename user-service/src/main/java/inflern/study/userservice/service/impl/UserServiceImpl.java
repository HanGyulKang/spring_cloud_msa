package inflern.study.userservice.service.impl;

import inflern.study.userservice.dto.ResponseDto;
import inflern.study.userservice.dto.UserDto;
import inflern.study.userservice.model.User;
import inflern.study.userservice.model.mapper.UserMapper;
import inflern.study.userservice.repository.UserRepository;
import inflern.study.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public ResponseDto.CreateUserDto createUser(UserDto.CreateUserDto dto) {
        User user = this.userMapper.mapToUserEntity(dto);
        User saved = this.userRepository.save(user);

        return new ResponseDto.CreateUserDto(saved.getName(), saved.getEmail());
    }
}
