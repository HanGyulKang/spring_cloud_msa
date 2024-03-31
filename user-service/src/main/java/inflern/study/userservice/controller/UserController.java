package inflern.study.userservice.controller;

import inflern.study.userservice.dto.RequestDto;
import inflern.study.userservice.dto.ResponseDto;
import inflern.study.userservice.vo.UserDto;
import inflern.study.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/user-service")
public class UserController {

    private final UserService userService;

    @PostMapping("/users")
    public ResponseEntity<ResponseDto.ResponseUserDto> createUser(@RequestBody RequestDto.CreateUserDto request) {
        ResponseDto.ResponseUserDto response = this.userService.createUser(
                UserDto.CreateUserDto.from(request)
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/users")
    public ResponseEntity<ResponseDto.ResponseUsersDto> getUsers() {
        ResponseDto.ResponseUsersDto response = this.userService.getUserByAll();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<ResponseDto.ResponseUserDto> getUser(@PathVariable(name = "userId") String userId) {
        ResponseDto.ResponseUserDto response = this.userService.getUserByUserId(userId);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
