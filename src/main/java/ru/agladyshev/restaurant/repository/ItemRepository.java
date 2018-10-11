package ru.agladyshev.restaurant.repository;

import ru.agladyshev.restaurant.entity.Item;

public interface ItemRepository {
    void save(Item item);
}
