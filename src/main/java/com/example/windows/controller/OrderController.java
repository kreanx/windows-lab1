package com.example.windows.controller;

import com.example.windows.entity.Order;
import com.example.windows.model.OrderModel;
import com.example.windows.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.windows.dto.PageDto;
import org.springframework.data.domain.Page;

@AllArgsConstructor
@Controller
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        return new ResponseEntity<>(orderService.getOrderById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Page<Order>> getOrders(PageDto pageDto) {
        return new ResponseEntity<>(orderService.getOrders(pageDto), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Order> addOrder(@RequestBody OrderModel orderModel) {
        return new ResponseEntity<>(orderService.addOrder(orderModel), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable Long id, @RequestBody OrderModel orderModel) {
        return new ResponseEntity<>(orderService.updateOrder(id, orderModel), HttpStatus.OK);
    }

    /*@DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteOrderById(@PathVariable Long id) {
        orderService.deleteOrderById(id);
    }*/
}
