package com.example.windows.service;

import com.example.windows.entity.Order;
import com.example.windows.model.OrderModel;

public interface OrderService {
    Order getOrderById(Long id);

    //Page<Book> getBooks(PageDto pageDto);

    Order addOrder(OrderModel orderModel);

    Order updateOrder(Long id, OrderModel orderModel);

    void deleteOrderById(Long id);
}
