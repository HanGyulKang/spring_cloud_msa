package inflern.study.myfirstservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/first-service")
public class MyFirstServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyFirstServiceApplication.class, args);
	}

	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome to the First service.";
	}
}
