package itis.eventmaker.services;

import itis.eventmaker.model.User;

import java.util.Optional;

public interface UserService {

    Optional<User> findOneByEmail(String email);

    User getByEmail(String email);
}
