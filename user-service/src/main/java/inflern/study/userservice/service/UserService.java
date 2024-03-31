package inflern.study.userservice.service;

import inflern.study.userservice.dto.ResponseDto;
import inflern.study.userservice.dto.vo.UserVo;

public interface UserService {
    ResponseDto.UserResponseDto createUser(UserVo.CreateUserItem createUserDto);
    ResponseDto.UserResponseDto getUserByUserId(String userId);
    ResponseDto.UsersResponseDto getUserByAll();
}
