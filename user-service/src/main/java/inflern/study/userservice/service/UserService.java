package inflern.study.userservice.service;

import inflern.study.userservice.dto.ResponseDto;
import inflern.study.userservice.vo.UserDto;

public interface UserService {
    ResponseDto.ResponseUserDto createUser(UserDto.CreateUserDto createUserDto);
    ResponseDto.ResponseUserDto getUserByUserId(String userId);
    ResponseDto.ResponseUsersDto getUserByAll();
}
