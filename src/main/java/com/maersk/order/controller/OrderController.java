package com.maersk.order.controller;

import com.maersk.order.bo.AvailabilityResponse;
import com.maersk.order.bo.OrderRequest;
import com.maersk.order.bo.OrderResponse;
import com.maersk.order.service.impl.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/bookings")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping(value = "checkAvailable")
    public ResponseEntity<Mono<AvailabilityResponse>> checkAvailable(@RequestBody OrderRequest orderRequest){
        return new ResponseEntity<>(orderService.checkAvailable(orderRequest), HttpStatus.OK);
    }

    @PostMapping(value = "order")
    public ResponseEntity<Mono<OrderResponse>> order(@RequestBody OrderRequest orderRequest){
        return new ResponseEntity<>(orderService.order(orderRequest), HttpStatus.OK);
    }


}
