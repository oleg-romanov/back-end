package itis.eventmaker.dto.mapper;

import itis.eventmaker.dto.out.UserDtoOut;
import itis.eventmaker.model.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    public UserDtoOut toUserDtoOut(User user) {
        UserDtoOut userDtoOut = new UserDtoOut();
        userDtoOut.setName(user.getName());
        return userDtoOut;
    }

    public List<UserDtoOut> toUserDtoList(List<User> users) {
        return users
                .stream()
                .map(this::toUserDtoOut)
                .collect(Collectors.toList());
    }
}