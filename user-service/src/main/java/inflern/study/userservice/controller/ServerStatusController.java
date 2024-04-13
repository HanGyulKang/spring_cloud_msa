package inflern.study.userservice.controller;

import inflern.study.userservice.config.dto.ConfigMessageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ServerStatusController {

    private final ConfigMessageDto configMessage;
    private final Environment env;

    @GetMapping("/health_check")
    public String healthCheck() {
        return String.format("USER-SERVICE :: Healthy! on LOCAL PORT=" + env.getProperty("local.server.port")
                           + "\n:: server.port=" + env.getProperty("server.port")
                           + "\n:: token secret=" + env.getProperty("token.secret")
                           + "\n:: token expiration time=" + env.getProperty("token.expiration_time")
        );
    }

    @GetMapping("/welcome")
    public String welcome() {
        return configMessage.getGreeting();
    }
}
