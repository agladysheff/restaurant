package ru.agladyshev.restaurant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.agladyshev.restaurant.entity.Order;
import ru.agladyshev.restaurant.repository.ItemRepository;
import ru.agladyshev.restaurant.repository.OrderRepository;

@Service
@Transactional
public class OrderServiceImpl implements OrderSevice {

    private OrderRepository orderRepository;
    private ItemRepository itemRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, ItemRepository itemRepository) {
        this.orderRepository = orderRepository;
        this.itemRepository = itemRepository;
    }

    public void delete(int id) {
        orderRepository.delete(id);
    }

    public Order findOne(int id) {
        return orderRepository.findOne(id);
    }

    public void save(Order order) {
        orderRepository.save(order);
        order.getItems().forEach(item -> {
            item.setOrder(order);
            itemRepository.save(item);
        });
    }

}
