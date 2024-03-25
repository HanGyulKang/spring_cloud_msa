package inflern.study.userservice.model.mapper;

import inflern.study.userservice.dto.UserDto;
import inflern.study.userservice.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapper {

    private final BCryptPasswordEncoder passwordEncoder;

    public User mapToUserEntity(UserDto.CreateUserDto dto) {
        return User.create(
                dto.getEmail(),
                dto.getName(),
                passwordEncoder.encode(dto.getPwd()));
    }
}
