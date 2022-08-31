package com.maersk.order.service.impl;

import com.maersk.order.bo.AvailabilityResponse;
import com.maersk.order.bo.OrderRequest;
import com.maersk.order.bo.OrderResponse;
import com.maersk.order.entity.Order;
import com.maersk.order.repo.OrderRepository;
import com.maersk.order.rest.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.maersk.order.service.impl.OrderService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class OrderServiceImpl implements OrderService {

    private RestClient restClient;
    private OrderRepository orderRepository;

    public OrderServiceImpl(RestClient restClient, OrderRepository orderRepository) {
        this.restClient = restClient;
        this.orderRepository = orderRepository;
    }

    @Override
    public Mono<AvailabilityResponse> checkAvailable(OrderRequest orderRequest) {
        Integer available = restClient.checkAvailable(orderRequest);
        if(available != 0){
            return Mono.just(AvailabilityResponse.builder().available(true).build());
        }
        return Mono.just(AvailabilityResponse.builder().available(false).build());
    }

    @Override
    public Mono<OrderResponse> order(OrderRequest orderRequest) {
        Order order = new Order();
        order.setContainerSize(orderRequest.getContainerSize());
        order.setOrigin(orderRequest.getOrigin());
        order.setContainerType(orderRequest.getContainerType());
        order.setDestination(orderRequest.getDestination());
        order.setQuantity(orderRequest.getQuantity());
        order.setTimestamp(orderRequest.getTimestamp());
        Integer bookingRef = orderRepository.save(order).block().getId();
        return Mono.just(OrderResponse.builder().bookingRef(bookingRef).build());
    }
}
