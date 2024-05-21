package inflern.study.userservice.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.client.RestTemplate;

@Configuration
public class UserServiceConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    // 기존에 gateway ip, port를 사용해서 호출하던 것을
    // 필요한 service name으로 호출할 수 있도록 도와 줌
    @LoadBalanced  
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
