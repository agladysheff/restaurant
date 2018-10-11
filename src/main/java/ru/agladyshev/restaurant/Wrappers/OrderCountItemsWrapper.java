package ru.agladyshev.restaurant.Wrappers;

import ru.agladyshev.restaurant.entity.Item;
import ru.agladyshev.restaurant.entity.Order;

import java.math.BigDecimal;
import java.util.Set;

public class OrderCountItemsWrapper {

    private int id;
    private BigDecimal sales;
    private BigDecimal discount;
    private int items;

    public OrderCountItemsWrapper(Order order) {
        Set<Item> setItems = order.getItems();
        this.id = order.getId();
        this.sales = order.getSales();
        this.discount = order.getDiscount();
        if (setItems != null) {
            this.items = setItems.size();
        }

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getSales() {
        return sales;
    }

    public void setSales(BigDecimal sales) {
        this.sales = sales;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public int getItems() {
        return items;
    }

    public void setItems(int items) {
        this.items = items;
    }
}
