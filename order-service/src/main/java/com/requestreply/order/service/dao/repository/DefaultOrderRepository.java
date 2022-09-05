package com.requestreply.order.service.dao.repository;

import com.requestreply.order.service.dao.model.Order;
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
}
