package inflern.study.userservice.service;

import inflern.study.userservice.dto.ResponseDto;
import inflern.study.userservice.dto.UserDto;

public interface UserService {
    ResponseDto.ResponseUserDto createUser(UserDto.CreateUserDto createUserDto);
}
