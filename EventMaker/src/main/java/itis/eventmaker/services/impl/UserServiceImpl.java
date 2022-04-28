package itis.eventmaker.services.impl;

import itis.eventmaker.exceptions.NotFoundException;
import itis.eventmaker.model.User;
import itis.eventmaker.repositories.UserRepository;
import itis.eventmaker.services.UserService;
import itis.eventmaker.utils.ResponseCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl extends ResponseCreator implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<User> findOneByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User getByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new NotFoundException("User with email " + email + " not found"));
    }
}
