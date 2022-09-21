package com.requestreply.order.dao.repository;

import com.requestreply.order.model.entity.Order;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class DefaultOrderRepository implements OrderRepository {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Order findByOriginalOrderId(String originalOrderId) {
        return entityManager.createQuery("SELECT o FROM Order o WHERE o.originalOrderId = ?1", Order.class)
                .setParameter(1, originalOrderId)
                .getSingleResult();
    }

    @Override
    public Order update(Order order) {
        entityManager.merge(order);
        return order;
    }
}
