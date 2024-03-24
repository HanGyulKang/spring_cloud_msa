package inflern.study.userservice.dto;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class ConfigMessageDto {

    private ConfigMessageDto(@Value("${greeting.message}") String greeting) {
        this.greeting = greeting;
    }

    private final String greeting;
}
