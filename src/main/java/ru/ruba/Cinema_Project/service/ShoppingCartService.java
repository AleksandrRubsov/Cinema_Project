package ru.ruba.Cinema_Project.service;

import ru.ruba.Cinema_Project.model.MovieSession;
import ru.ruba.Cinema_Project.model.ShoppingCart;
import ru.ruba.Cinema_Project.model.User;

public interface ShoppingCartService {
    void addSession(MovieSession movieSession, User user);

    ShoppingCart getByUser(User user);

    void registerNewShoppingCart(User user);

    void clear(ShoppingCart shoppingCart);
}