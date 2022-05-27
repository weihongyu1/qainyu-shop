package com.why.shopServer.service.impl;

import cn.hutool.core.date.DateUtil;
import com.why.shopServer.dto.OrderDTO;
import com.why.shopServer.service.OrderService;
import com.why.shopServer.commodity.pojo.Commodity;
import com.why.shopServer.commodity.repository.CommodityRepository;
import com.why.shopServer.order.pojo.Order;
import com.why.shopServer.order.repository.OrderRepository;
import com.why.shopServer.user.pojo.UserLogin;
import com.why.shopServer.user.repository.UserLoginRepository;
import com.why.shopServer.vo.order.PlaceOrderVo;
import com.why.shopServer.vo.order.UpdateVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

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

    private final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private final String DATE_FORMAT = "yyyy-MM-dd";
    private final String SPACE = " ";

    @Override
    @Transactional
    public Order placeOrder(PlaceOrderVo orderVo) {
        Commodity commodity = commodityRepository.findCommodityByCommodityName(orderVo.getCommodityName());
        if(commodity.getStock() <= 0){
            return null;
        }
        UserLogin user = userLoginRepository.findByUsername(orderVo.getUsername());

        String options = Arrays.toString(orderVo.getSelectedOptions());
        Integer paymentStatus = 0;
        if (orderVo.isPaymentStatus()){
            paymentStatus = 1;
        }
        String dateTime = DateUtil.format(orderVo.getDate(), DATE_FORMAT) + SPACE + DateUtil.format(orderVo.getTime(), DATE_TIME_FORMAT).substring(11);

        Order order = new Order(null, commodity.getId(), user.getId(), orderVo.getRecipient(),
                orderVo.getPhoneNumber(), options, orderVo.getAddress(), paymentStatus, new Date(),
                DateUtil.parse(dateTime, DATE_TIME_FORMAT), orderVo.getDesc());

        commodity.setStock(commodity.getStock() - 1);
        commodityRepository.save(commodity);
        orderRepository.save(order);
        return order;
    }

    @Override
    @Transactional
    public void updateOrder(UpdateVo updateVo) {
        orderRepository.update(updateVo);
    }

    @Override
    public void deleteOrder(Integer orderId) {
        orderRepository.deleteById(orderId);
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
        while (orderIterator.hasNext()) {
            OrderDTO orderDTO = new OrderDTO();
            Order order = orderIterator.next();
            Commodity commodity = commodityRepository.findCommodityById(order.getCId());
            UserLogin userLogin = userLoginRepository.findUserLoginById(order.getUId());

            orderDTO.setOrderId(order.getId());
            orderDTO.setCommodityId(order.getUId());
            orderDTO.setRecipient(order.getRecipient());
            orderDTO.setAddress(order.getReciveAddress());
            orderDTO.setDate(DateUtil.format(order.getOrderDate(),DATE_TIME_FORMAT));

            //未支付
            if (order.getPaymentStatus() == 0){
                orderDTO.setPaymentStatus("未支付");
            } else {
                orderDTO.setPaymentStatus("已支付");
            }

            orderDTO.setCommodityName(commodity.getCommodityName());
            orderDTO.setCategory(commodity.getCategory());
            orderDTO.setDesc(commodity.getDesc());
            orderDTO.setDeliveryTime(order.getDeliveryTime());
            orderDTO.setPhoneNumber(order.getRecivePhone());
            orderDTO.setUsername(userLogin.getUsername());
            orderDTO.setOrderDesc(order.getOrderDesc());
            if (order.getOptions() != null){
                orderDTO.setOptions(order.getOptions().split(","));
            }

            orderDTOS.add(orderDTO);
        }
        return orderDTOS;
    }

    @Override
    public boolean getPayStatus(Integer id) {
        if (orderRepository.getById(id).getPaymentStatus() == 1) {
            return true;
        }
        return false;
    }
}
