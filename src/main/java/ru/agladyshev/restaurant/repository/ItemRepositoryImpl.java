package ru.agladyshev.restaurant.repository;

import org.springframework.stereotype.Repository;
import ru.agladyshev.restaurant.entity.Item;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class ItemRepositoryImpl implements ItemRepository {

    @PersistenceContext
    private EntityManager em;


    public void save(Item item) {
        if (item.getId() == 0) {
            em.persist(item);
        } else {
            em.merge(item);
        }
    }
}
