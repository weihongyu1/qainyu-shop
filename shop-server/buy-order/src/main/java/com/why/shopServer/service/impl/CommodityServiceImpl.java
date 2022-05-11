package com.why.shopServer.service.impl;

import com.why.shopServer.service.CommodityService;
import com.why.shopserver.commodity.pojo.Commodity;
import com.why.shopserver.commodity.repository.CommodityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品业务接口实现类
 *
 * @author why
 * @create 2022-04-26 14:33
 **/
@Service
public class CommodityServiceImpl implements CommodityService {

    @Autowired
    private CommodityRepository commodityRepository;

    @Override
    public void commodityTakeUp(Commodity commodity) {
        commodityRepository.save(commodity);
    }

    @Override
    public void commodityTakeDown(Commodity commodity) {
        commodity.setTakeDown(1);
        commodityUpdateInfo(commodity);
    }

    @Override
    public void commodityUpdateInfo(Commodity commodity) {
        commodityRepository.save(commodity);
    }

    @Override
    public List<Commodity> getAllCommodity() {
        return commodityRepository.findAll();
    }

    @Override
    public List<Commodity> findCommodityByName(String commodityName) {
        return commodityRepository.findCommoditiesByCommodityName(commodityName);
    }
}