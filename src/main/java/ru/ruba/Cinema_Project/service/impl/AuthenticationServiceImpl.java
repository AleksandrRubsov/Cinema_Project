package ru.ruba.Cinema_Project.service.impl;

import ru.ruba.Cinema_Project.model.Role;
import ru.ruba.Cinema_Project.model.User;
import ru.ruba.Cinema_Project.service.AuthenticationService;
import ru.ruba.Cinema_Project.service.RoleService;
import ru.ruba.Cinema_Project.service.ShoppingCartService;
import ru.ruba.Cinema_Project.service.UserService;
import java.util.HashSet;
import java.util.Set;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserService userService;
    private final ShoppingCartService shoppingCartService;
    private final RoleService roleService;

    public AuthenticationServiceImpl(UserService userService,
                                     ShoppingCartService shoppingCartService,
                                     RoleService roleService) {
        this.userService = userService;
        this.shoppingCartService = shoppingCartService;
        this.roleService = roleService;
    }

    @Override
    public User register(String email, String password) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        Set<Role> roles = new HashSet<>();
        roles.add(roleService.getByName(Role.RoleName.USER.name()));
        user.setRoles(roles);
        userService.add(user);
        shoppingCartService.registerNewShoppingCart(user);
        return user;
    }
}
