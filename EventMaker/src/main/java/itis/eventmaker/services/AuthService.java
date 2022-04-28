package itis.eventmaker.services;

import itis.eventmaker.dto.in.SignUpDto;
import itis.eventmaker.dto.in.TokenDto;

public interface AuthService {
    TokenDto userRegistration(SignUpDto signUpDto);
}
