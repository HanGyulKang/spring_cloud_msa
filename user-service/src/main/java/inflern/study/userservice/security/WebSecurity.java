package inflern.study.userservice.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.expression.WebExpressionAuthorizationManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurity {

//    private final UserService userService;
//    private final BCryptPasswordEncoder bCryptPasswordEncoder;
//    private final Environment env;

//    public static final String ALLOWED_IP_ADDRESS = "127.0.0.1";
//    public static final String SUBNET = "/32";
//    public static final IpAddressMatcher ALLOWED_IP_ADDRESS_MATCHER = new IpAddressMatcher(ALLOWED_IP_ADDRESS + SUBNET);


    @Bean
    protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
//        AuthenticationManagerBuilder authenticationManagerBuilder =
//                http.getSharedObject(AuthenticationManagerBuilder.class);
//        authenticationManagerBuilder.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder);

//        AuthenticationManager authenticationManager = authenticationManagerBuilder.build();

        http.csrf(AbstractHttpConfigurer::disable);
        http.authorizeHttpRequests((authz) -> authz
                .requestMatchers(new AntPathRequestMatcher("/actuator/**")).permitAll()
                .requestMatchers(new AntPathRequestMatcher("/user-service/users/**", "POST")).permitAll()
                .requestMatchers(new AntPathRequestMatcher("/user-service/**", "GET")).permitAll()
                .requestMatchers("/**").access(
                        new WebExpressionAuthorizationManager("hasIpAddress('127.0.0.1') or hasIpAddress('172.30.1.48')"))
                .anyRequest().authenticated());

        http.headers((headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin)));

//        http.authorizeHttpRequests((authz) -> authz
//                                .requestMatchers(new AntPathRequestMatcher("/actuator/**")).permitAll()
//                                .requestMatchers(new AntPathRequestMatcher("/h2-console/**")).permitAll()
//                                .requestMatchers(new AntPathRequestMatcher("/users", "POST")).permitAll()
//                                .requestMatchers("/**").access(
//                                        new WebExpressionAuthorizationManager("hasIpAddress('127.0.0.1') or hasIpAddress('172.30.1.48')"))
//                                .anyRequest().authenticated()
//                )
//                .authenticationManager(authenticationManager)
//                .sessionManagement((session) -> session
//                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS));
//
//        http.addFilter(getAuthenticationFilter(authenticationManager));

        return http.build();
    }
//
//    private AuthorizationDecision hasIpAddress(Supplier<Authentication> authentication, RequestAuthorizationContext object) {
//        return new AuthorizationDecision(ALLOWED_IP_ADDRESS_MATCHER.matches(object.getRequest()));
//    }
//
//    private AuthenticationFilter getAuthenticationFilter(AuthenticationManager authenticationManager) throws Exception {
//        return new AuthenticationFilter(authenticationManager, userService, env);
//    }
}
