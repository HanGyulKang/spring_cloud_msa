package inflern.study.userservice.model.mapper;

import inflern.study.userservice.dto.vo.UserVo;
import inflern.study.userservice.model.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

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

    public UserVo.UserItem userEntityToMap(User user) {
        return UserVo.UserItem.builder()
                .userId(user.getUserId())
                .name(user.getName())
                .email(user.getEmail())
                .createAt(user.getCreateAt())
                .build();
    }
}
