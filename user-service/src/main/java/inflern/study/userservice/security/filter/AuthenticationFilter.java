package inflern.study.userservice.security.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import inflern.study.userservice.dto.RequestDto;
import inflern.study.userservice.dto.vo.UserVo;
import inflern.study.userservice.service.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;
import java.util.ArrayList;

@Slf4j
public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private final UserService userService;
    private final Environment env;

    public AuthenticationFilter(AuthenticationManager authenticationManager,
                                UserService userService,
                                Environment env) {
        super(authenticationManager);
        this.userService = userService;
        this.env = env;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res)
            throws AuthenticationException {
        try {
            RequestDto.LoginDto loginInfo = new ObjectMapper().readValue(req.getInputStream(), RequestDto.LoginDto.class);

            return getAuthenticationManager().authenticate(
                    new UsernamePasswordAuthenticationToken(loginInfo.getEmail(),
                                                            loginInfo.getPwd(),
                                                            new ArrayList<>()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain,
                                            Authentication auth) throws IOException, ServletException {

        String email = ((User) auth.getPrincipal()).getUsername();
        UserVo.UserItem userDetails = this.userService.getUserDetailsByEmail(email).getUser();

    }
}
