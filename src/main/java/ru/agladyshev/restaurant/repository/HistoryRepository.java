package ru.agladyshev.restaurant.repository;

import ru.agladyshev.restaurant.entity.History;

import java.util.List;

public interface HistoryRepository {

     void save(History history);
     List<History> getHistory (int orderId);
}
