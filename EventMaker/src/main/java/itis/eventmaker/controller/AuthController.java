package itis.eventmaker.controller;

import itis.eventmaker.dto.in.SignInDto;
import itis.eventmaker.dto.in.SignUpDto;
import itis.eventmaker.dto.in.TokenDto;
import itis.eventmaker.model.User;
import itis.eventmaker.security.JwtHelper;
import itis.eventmaker.services.AuthService;
import itis.eventmaker.services.CategoryService;
import itis.eventmaker.services.UserService;
import itis.eventmaker.utils.ErrorEntity;
import itis.eventmaker.utils.ResponseCreator;
import itis.eventmaker.utils.Validator;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class AuthController extends ResponseCreator {
    @Autowired
    private JwtHelper jwtHelper;
    @Autowired
    private UserService userService;
    @Autowired
    private AuthService authService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private Validator validator;

    private boolean isFirst = true;

    @PostMapping("/sign-up")
    ResponseEntity registrationUser(@RequestBody SignUpDto signUpDto) {
        Optional<ErrorEntity> errorEntity = validator.getUserRegisterFormError(signUpDto);
        if(errorEntity.isPresent()) {
            return createErrorResponse(errorEntity.get());
        }
        if (isFirst) {
            categoryService.createDefaultCategories();
            isFirst = false;
        }
        return createGoodResponse(authService.userRegistration(signUpDto));
    }

    @PostMapping("/sign-in")
    ResponseEntity loginUser(@RequestBody SignInDto signInDto) {
        User user = userService.getByEmail(signInDto.getEmail());
        return createGoodResponse(new TokenDto(jwtHelper.generateToken(user)));
    }
}