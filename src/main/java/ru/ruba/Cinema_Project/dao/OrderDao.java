package ru.ruba.Cinema_Project.dao;

import ru.ruba.Cinema_Project.model.Order;
import ru.ruba.Cinema_Project.model.User;
import java.util.List;

public interface OrderDao {
    Order add(Order order);

    List<Order> getOrdersHistory(User user);
}