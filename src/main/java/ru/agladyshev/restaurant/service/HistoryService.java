package ru.agladyshev.restaurant.service;

import ru.agladyshev.restaurant.entity.History;
import ru.agladyshev.restaurant.entity.Order;

import java.util.List;

public interface HistoryService {


     void saveHistory(Order order, byte statusChange);
     List<History> getHistory (int orderId);
}
