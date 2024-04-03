package inflern.study.catalogservice;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/catalog-service")
@RequiredArgsConstructor
public class CatalogServiceApplication {

	private final Environment env;

	public static void main(String[] args) {
		SpringApplication.run(CatalogServiceApplication.class, args);
	}

	@GetMapping("/health_check")
	public String healthCheck() {
		return String.format("CATALOG-SERVICE :: Healthy! on PORT %s", env.getProperty("local.server.port"));
	}
}
