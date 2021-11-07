package com.example.windows.service;

import com.example.windows.entity.Order;
import com.example.windows.model.OrderModel;
import com.example.windows.dto.PageDto;
import org.springframework.data.domain.Page;

public interface OrderService {
    Order getOrderById(Long id);

    Page<Order> getOrders(PageDto pageDto);

    Order addOrder(OrderModel orderModel);

    Order updateOrder(Long id, OrderModel orderModel);

    void deleteOrderById(Long id);
}
