package ru.ruba.Cinema_Project.dao;

import ru.ruba.Cinema_Project.model.Role;
import java.util.Optional;

public interface RoleDao {
    Role add(Role role);

    Optional<Role> getByName(String roleName);
}