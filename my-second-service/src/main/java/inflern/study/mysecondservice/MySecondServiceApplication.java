package inflern.study.mysecondservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/second-service")
public class MySecondServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MySecondServiceApplication.class, args);
	}

	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome to the Second service.";
	}
}
