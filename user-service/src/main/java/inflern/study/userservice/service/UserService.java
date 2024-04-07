package inflern.study.userservice.service;

import inflern.study.userservice.dto.ResponseDto;
import inflern.study.userservice.dto.vo.UserVo;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    ResponseDto.ResponseUserDto createUser(UserVo.CreateUserItem createUserDto);
    ResponseDto.ResponseUserDto getUserByUserId(String userId);
    ResponseDto.ResponseUsersDto getUserByAll();
    ResponseDto.ResponseUserDto getUserDetailsByEmail(String email);
}
