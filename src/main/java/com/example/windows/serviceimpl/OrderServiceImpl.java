package com.example.windows.serviceimpl;

import com.example.windows.entity.*;
import com.example.windows.model.OrderModel;
import com.example.windows.repository.WindowRepository;
import com.example.windows.repository.CustomerRepository;
import com.example.windows.repository.OrderRepository;
import com.example.windows.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.windows.exception.ResourceNotFoundException;
import com.example.windows.dto.PageDto;
import org.springframework.data.domain.Page;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;
    private final WindowRepository windowRepository;
    private final CustomerRepository customerRepository;

    @Override
    public Order getOrderById(Long id) {
        return orderRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "The order with id " + id + " does not exist."));
    }

    @Override
    public Page<Order> getOrders(PageDto pageDto) {
        return orderRepository.findAll(pageDto.getPageable());
    }

    @Override
    public Order addOrder(OrderModel orderModel) {
        Window window = windowRepository
                .findById(orderModel.getWindowId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "The window with id " + orderModel.getWindowId() + " does not exist."));
        Customer customer = customerRepository
                .findById(orderModel.getCustomerId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "The customer with id " + orderModel.getCustomerId() + " does not exist."));

        Order order = Order.builder()
                .window(window)
                .customer(customer)
                .date(orderModel.getDate())
                .cost(orderModel.getCost())
                .build();
        orderRepository.save(order);
        return order;
    }

    @Override
    public Order updateOrder(Long id, OrderModel orderModel) {
        if (!orderRepository.existsById(id)) {
            throw new ResourceNotFoundException("The order with id " + id + " does not exist.");
        }

        Window window = windowRepository
                .findById(orderModel.getWindowId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "The window with id " + orderModel.getWindowId() + " does not exist."));
        Customer customer = customerRepository
                .findById(orderModel.getCustomerId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "The customer with id " + orderModel.getCustomerId() + " does not exist."));

        Order order = new Order(id,window,customer,orderModel.getDate(),orderModel.getCost());
        orderRepository.save(order);
        return order;
    }
}
