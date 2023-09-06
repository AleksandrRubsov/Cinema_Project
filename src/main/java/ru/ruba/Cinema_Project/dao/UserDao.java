package ru.ruba.Cinema_Project.dao;

import ru.ruba.Cinema_Project.model.User;
import java.util.Optional;

public interface UserDao {
    User add(User user);

    Optional<User> get(Long id);

    Optional<User> findByEmail(String email);
}