package com.bookapp.orderservice;

import com.bookapp.orderservice.dao.Order;
import com.bookapp.orderservice.dto.OrderReceipt;
import com.bookapp.orderservice.dto.OrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping
    public List<Order> findAllOrders(){
        return orderRepository.findAll();
    }

    @PostMapping
    public OrderReceipt orderReceiptGiver(@RequestBody OrderRequest orderRequest){
        Order order = new Order(orderRequest.getBookIsbn(), orderRequest.getQuantity(), orderRequest.getUserEmail());
        order = orderRepository.save(order);
        return new OrderReceipt(order.getBookIsbn(), order.getQuantity(), order.getUserEmail(), order.getOrderId(), "In progress");
    }
}
