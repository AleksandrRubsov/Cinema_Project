package ru.ruba.Cinema_Project.service;

import ru.ruba.Cinema_Project.model.User;
import java.util.Optional;

public interface UserService {
    User add(User user);

    User get(Long id);

    Optional<User> findByEmail(String email);
}