package ru.agladyshev.restaurant.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;


@Entity
@Table(name = "history")
public class History {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "order_id")
    private int orderId;

    @Column(name = "date")
    private LocalDateTime date;

    @Column(name = "status_change")
    private byte statusChange;

    // В соответствии с требованием доп. условия № 3
    @Column(name = "sales")
    private BigDecimal sales;

    @Column( name = "count_items")
    private int countItems;

    public History() {
    }

    public History(int orderId, LocalDateTime date, byte statusChange, BigDecimal sales, int countItems) {
        this.orderId = orderId;
        this.date = date;
        this.statusChange = statusChange;
        this.sales = sales;
        this.countItems = countItems;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public byte getStatusChange() {
        return statusChange;
    }

    public void setStatusChange(byte statusChange) {
        this.statusChange = statusChange;
    }

    public BigDecimal getSales() {
        return sales;
    }

    public void setSales(BigDecimal sales) {
        this.sales = sales;
    }

    public int getCountItems() {
        return countItems;
    }

    public void setCountItems(int countItems) {
        this.countItems = countItems;
    }
}
