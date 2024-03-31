package inflern.study.userservice.service;

import inflern.study.userservice.dto.ResponseDto;
import inflern.study.userservice.dto.vo.UserVo;

public interface UserService {
    ResponseDto.ResponseUserDto createUser(UserVo.CreateUserItem createUserDto);
    ResponseDto.ResponseUserDto getUserByUserId(String userId);
    ResponseDto.ResponseUsersDto getUserByAll();
}
