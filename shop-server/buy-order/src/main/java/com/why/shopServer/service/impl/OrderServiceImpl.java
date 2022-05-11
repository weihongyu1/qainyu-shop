package com.why.shopServer.service.impl;

import com.why.shopServer.service.OrderService;
import com.why.shopserver.order.pojo.Order;
import com.why.shopserver.order.repository.OrderRepository;
import com.why.shopserver.user.pojo.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 订单接口实现类
 *
 * @author why
 * @create 2022-04-26 14:34
 **/
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order placeOrder(Order order) {
        orderRepository.save(order);
        return order;
    }

    @Override
    public Order updateOrder(Order order) {
        orderRepository.save(order);
        return order;
    }

    @Override
    public void deleteOrder(Order order) {
        orderRepository.delete(order);
    }

    @Override
    public List<Order> getOrderByUser(UserLogin userLogin) {
        Integer id = userLogin.getId();
        return orderRepository.findByuId(id);
    }

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }
}