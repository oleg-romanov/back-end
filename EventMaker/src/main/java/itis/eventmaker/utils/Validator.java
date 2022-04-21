package itis.eventmaker.utils;


import itis.eventmaker.dto.in.SignUpDto;
import itis.eventmaker.services.UserService;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.regex.Pattern;

@Component
public class Validator extends ResponseCreator {

    private final int MIN_PASSWORD_LENGTH = 5;
    private final Pattern emailPattern = Pattern.compile("^(.+)@(.+)$");
    private final UserService userService;

    public Validator(UserService userService) {
        this.userService = userService;
    }

    public Optional<ErrorEntity> getUserRegisterFormError(SignUpDto signUpDto) {
        if (signUpDto.getEmail() == null || emailPattern.matcher(signUpDto.getEmail()).matches() == false) {
            return Optional.of(ErrorEntity.INVALID_EMAIL);
        }
        if (signUpDto.getPassword() == null || signUpDto.getPassword().length() < MIN_PASSWORD_LENGTH) {
            return Optional.of(ErrorEntity.PASSWORD_TOO_SHORT);
        }
        if (userService.findOneByEmail(signUpDto.getEmail()).isPresent()) {
            return Optional.of(ErrorEntity.EMAIL_ALREADY_TAKEN);
        }
        return Optional.empty();
    }
}