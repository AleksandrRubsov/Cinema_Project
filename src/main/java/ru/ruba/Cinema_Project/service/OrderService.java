package ru.ruba.Cinema_Project.service;

import ru.ruba.Cinema_Project.model.Order;
import ru.ruba.Cinema_Project.model.ShoppingCart;
import ru.ruba.Cinema_Project.model.User;
import java.util.List;

public interface OrderService {
    Order completeOrder(ShoppingCart shoppingCart);

    List<Order> getOrdersHistory(User user);
}