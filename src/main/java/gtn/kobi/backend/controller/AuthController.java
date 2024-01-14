package gtn.kobi.backend.controller;

import gtn.kobi.backend.model.Users;
import gtn.kobi.backend.service.UserService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Controller
public class AuthController {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public AuthController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @MutationMapping
    public Users signUp(@Argument Users userInput) {
        System.out.println(userInput);
        return userService.signUp(userInput);
    }

    @MutationMapping
    public Users signIn(@Argument String username, @Argument String password) {
        return userService.signIn(username, password);
    }

}
