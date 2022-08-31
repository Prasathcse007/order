package com.maersk.order.repo;

import com.maersk.order.entity.Order;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends ReactiveCassandraRepository<Order, Integer> {
}
