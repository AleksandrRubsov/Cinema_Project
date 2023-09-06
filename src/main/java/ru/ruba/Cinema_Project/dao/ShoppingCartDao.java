package ru.ruba.Cinema_Project.dao;

import ru.ruba.Cinema_Project.model.ShoppingCart;
import ru.ruba.Cinema_Project.model.User;

public interface ShoppingCartDao {
    ShoppingCart add(ShoppingCart shoppingCart);

    ShoppingCart getByUser(User user);

    ShoppingCart update(ShoppingCart shoppingCart);
}
