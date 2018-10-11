package ru.agladyshev.restaurant.repository;

import ru.agladyshev.restaurant.entity.Order;

public interface OrderRepository {
     void save(Order order);
     void delete(int id);
     Order findOne(int id);
}
