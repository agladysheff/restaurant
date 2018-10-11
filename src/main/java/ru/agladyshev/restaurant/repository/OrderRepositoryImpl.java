package ru.agladyshev.restaurant.repository;

import org.springframework.stereotype.Repository;
import ru.agladyshev.restaurant.entity.Order;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class OrderRepositoryImpl implements OrderRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(Order order) {
        if (order.getId() == 0) {
            em.persist(order);
        } else {
            em.merge(order);
        }
    }

    public void delete(int id) {
        Order ref = em.getReference(Order.class, id);
        em.remove(ref);
    }

    public Order findOne(int id){
        return em.find(Order.class,id);
    }

}
