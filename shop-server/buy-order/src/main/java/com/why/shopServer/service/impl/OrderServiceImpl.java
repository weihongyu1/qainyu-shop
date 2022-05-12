package com.why.shopServer.service.impl;

import com.why.shopServer.dto.OrderDTO;
import com.why.shopServer.service.OrderService;
import com.why.shopserver.commodity.pojo.Commodity;
import com.why.shopserver.commodity.repository.CommodityRepository;
import com.why.shopserver.order.pojo.Order;
import com.why.shopserver.order.repository.OrderRepository;
import com.why.shopserver.user.pojo.UserLogin;
import com.why.shopserver.user.repository.UserLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
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
    @Autowired
    private CommodityRepository commodityRepository;
    @Autowired
    private UserLoginRepository userLoginRepository;

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
    public List<OrderDTO> getAll() {
        List<OrderDTO> orderDTOS = new ArrayList<>();
        List<Order> orders = orderRepository.findAll();
        Iterator<Order> orderIterator = orders.iterator();
        OrderDTO orderDTO = new OrderDTO();
        while (orderIterator.hasNext()) {
            Order order = orderIterator.next();
            Commodity commodity = commodityRepository.findCommodityById(order.getCId());
            UserLogin userLogin = userLoginRepository.findUserLoginById(order.getUId());

            orderDTO.setOrderId(order.getId());
            orderDTO.setCommodityId(order.getUId());
            orderDTO.setRecipient(order.getRecipient());
            orderDTO.setAddress(order.getReciveAddress());
            orderDTO.setDate(order.getOrderDate());

            //未支付
            if (order.getPaymentStatus() == 0){
                orderDTO.setPaymentStatus("未支付");
            } else {
                orderDTO.setPaymentStatus("已支付");
            }

            orderDTO.setCommodityName(commodity.getCommodityName());
            orderDTO.setCategory(commodity.getCategory());
            orderDTO.setDesc(commodity.getCommodityDescribe());
            orderDTO.setDeliveryTime(order.getDeliveryTime());
            orderDTO.setPhoneNumber(order.getRecivePhone());
            orderDTO.setUsername(userLogin.getUsername());

            orderDTOS.add(orderDTO);
        }
        return orderDTOS;
    }
}
