package ru.ruba.Cinema_Project.service;

import ru.ruba.Cinema_Project.model.User;

public interface AuthenticationService {
    User register(String email, String password);
}
