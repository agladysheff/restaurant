package ru.agladyshev.restaurant.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;



    @Entity
    @Table(name = "items")
    public class Item {

        @Id
        @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;


        @Column(name = "price")
        private BigDecimal price;

        @Column (name= "discount")
        private BigDecimal discount;

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "order_id")
        @JsonIgnore
        private Order order;

        public Item() {
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public BigDecimal getPrice() {
            return price;
        }

        public void setPrice(BigDecimal price) {
            this.price = price;
        }

        public BigDecimal getDiscount() {
            return discount;
        }

        public void setDiscount(BigDecimal discount) {
            this.discount = discount;
        }

        public Order getOrder() {
            return order;
        }

        public void setOrder(Order order) {
            this.order = order;
        }
    }
