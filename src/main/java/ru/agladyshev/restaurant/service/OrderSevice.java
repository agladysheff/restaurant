package ru.agladyshev.restaurant.service;

import ru.agladyshev.restaurant.entity.Order;

public interface OrderSevice {

    void save(Order order);

    void delete(int id);

    Order findOne(int id);
}
