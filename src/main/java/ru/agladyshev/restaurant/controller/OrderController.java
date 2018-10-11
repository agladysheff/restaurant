package ru.agladyshev.restaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.agladyshev.restaurant.Const;
import ru.agladyshev.restaurant.Wrappers.IdWrapper;
import ru.agladyshev.restaurant.Wrappers.OrderCountItemsWrapper;
import ru.agladyshev.restaurant.Wrappers.StatusWrapper;
import ru.agladyshev.restaurant.Wrappers.WithPosWrapper;
import ru.agladyshev.restaurant.entity.History;
import ru.agladyshev.restaurant.entity.Item;
import ru.agladyshev.restaurant.entity.Order;
import ru.agladyshev.restaurant.repository.HistoryRepository;
import ru.agladyshev.restaurant.service.HistoryService;
import ru.agladyshev.restaurant.service.HistoryServiceImpl;
import ru.agladyshev.restaurant.service.ItemServiceImpl;
import ru.agladyshev.restaurant.service.OrderSevice;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/order")
public class OrderController {


    private OrderSevice orderSevice;
    private HistoryService historyService;

    @Autowired
    public OrderController(OrderSevice orderSevice, HistoryService historyService) {
        this.orderSevice = orderSevice;
        this.historyService = historyService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public void create(@RequestBody Order order) {
        Set<Item> items = order.getItems();
        order.setStatus(Const.STATUS_CREATED);

        if (items != null && items.size() > 0) {
            orderSevice.save(order);
            historyService.saveHistory(order,Const.STATUS_CREATED);
        }
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void update (@RequestBody Order order){
        Set<Item> items = order.getItems();
        Order orderOld = orderSevice.findOne(order.getId());
        if (items!=null && items.size()>0 && orderOld !=null && orderOld.getStatus()== Const.STATUS_CREATED) {
            orderSevice.save(order);
            historyService.saveHistory(order,order.getStatus());
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public void delete(@RequestBody IdWrapper id) {
        orderSevice.delete(id.getId());
    }

    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public Object find(@RequestBody WithPosWrapper wrapper) {
        Order order = orderSevice.findOne(wrapper.getId());
        return wrapper.isWithpositions() ? order : new OrderCountItemsWrapper(order);
    }


    @RequestMapping(value = "/getHistory", method = RequestMethod.POST)
    public List<History> getHistory(@RequestBody IdWrapper wrapper) {
        return historyService.getHistory(wrapper.getId());
    }


}
