package inflern.study.userservice;

import inflern.study.userservice.config.dto.ConfigMessageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RequiredArgsConstructor
@RequestMapping("/")
@RestController
public class UserServiceApplication {

	private final ConfigMessageDto configMessage;

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

	@GetMapping("/health_check")
	public String healthCheck() {
		return "Healthy!";
	}

	@GetMapping("/welcome")
	public String welcome() {
		return configMessage.getGreeting();
	}

	@GetMapping("/actuator/info")
	public String actuator() {
		return "user";
	}
}
