package com.maersk.order.service.impl;

import com.maersk.order.bo.AvailabilityResponse;
import com.maersk.order.bo.OrderRequest;
import com.maersk.order.bo.OrderResponse;
import reactor.core.publisher.Mono;

public interface OrderService {
    Mono<AvailabilityResponse> checkAvailable(OrderRequest orderRequest);

    Mono<OrderResponse> order(OrderRequest orderRequest);
}
