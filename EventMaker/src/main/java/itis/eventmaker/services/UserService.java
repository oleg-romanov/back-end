package itis.eventmaker.services;

import itis.eventmaker.dto.in.ProfileUpdateDto;
import itis.eventmaker.dto.in.UserDto;
import itis.eventmaker.model.User;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface UserService {
    UserDto save(User user);

    User getByEmail(String email);

    UserDto getByAuthToken(String authToken);

    Optional<User> findOneByEmail(String email);

    Optional<User> findOneById(Long id);

    boolean update(User user);

    boolean delete(User user);

    UserDto getUserProfileInfo(String authorization);

    ResponseEntity changePassword(String authorization, ProfileUpdateDto profileUpdateDto);

    ResponseEntity changeUserName(String authorization, ProfileUpdateDto profileUpdateDto);
}
