package ru.agladyshev.restaurant.repository;

import org.springframework.stereotype.Repository;
import ru.agladyshev.restaurant.entity.History;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class HistoryRepositoryImpl implements HistoryRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(History history) {
        if (history.getId() == 0) {
            em.persist(history);
        } else {
            em.merge(history);
        }
    }

    public List<History> getHistory(int orderId) {
        return em.createQuery("SELECT h  FROM History h WHERE h.orderId= :id order by h.date").setParameter("id", orderId).getResultList();
    }
}
