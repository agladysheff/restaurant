package ru.agladyshev.restaurant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.agladyshev.restaurant.entity.History;
import ru.agladyshev.restaurant.entity.Order;
import ru.agladyshev.restaurant.repository.HistoryRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class HistoryServiceImpl implements HistoryService {

    private HistoryRepository historyRepository;

    @Autowired
    public HistoryServiceImpl(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }


    public void saveHistory(Order order, byte statusChange) {
        History res = new History(order.getId(), LocalDateTime.now(), statusChange, order.getSales(), order.getItems().size());
        historyRepository.save(res);
    }

    public List<History> getHistory(int orderId) {
        return historyRepository.getHistory(orderId);
    }


}
