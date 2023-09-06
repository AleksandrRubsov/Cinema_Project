package ru.ruba.Cinema_Project.service;

import ru.ruba.Cinema_Project.model.Role;

public interface RoleService {
    Role add(Role role);

    Role getByName(String roleName);
}