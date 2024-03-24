package inflern.study.userservice.model.mapper;

import inflern.study.userservice.dto.UserDto;
import inflern.study.userservice.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User mapToUserEntity(UserDto.CreateUserDto dto) {
        return User.create(
                dto.getEmail(),
                dto.getName(),
                dto.getEncryptedPwd());
    }
}
