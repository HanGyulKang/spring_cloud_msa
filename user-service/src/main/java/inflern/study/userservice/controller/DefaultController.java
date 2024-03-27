package inflern.study.userservice.controller;

import inflern.study.userservice.config.dto.ConfigMessageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user-service")
@RestController
@RequiredArgsConstructor
public class DefaultController {

    private final ConfigMessageDto configMessage;
    private final Environment env;

    @GetMapping("/health_check")
    public String healthCheck() {
        return String.format("Healthy! on PORT %s", env.getProperty("local.server.port"));
    }

    @GetMapping("/welcome")
    public String welcome() {
        return configMessage.getGreeting();
    }
}
