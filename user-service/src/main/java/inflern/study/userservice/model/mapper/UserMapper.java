package inflern.study.userservice.model.mapper;

import inflern.study.userservice.vo.UserDto;
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

    public UserDto.UserItem entityToUserItem(User user) {
        return UserDto.UserItem.builder()
                .userId(user.getUserId())
                .name(user.getName())
                .email(user.getEmail())
                .createAt(user.getCreateAt())
                .build();
    }
}
