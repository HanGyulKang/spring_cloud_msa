package inflern.study.userservice.controller;

import inflern.study.userservice.dto.RequestDto;
import inflern.study.userservice.dto.ResponseDto;
import inflern.study.userservice.dto.UserDto;
import inflern.study.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
