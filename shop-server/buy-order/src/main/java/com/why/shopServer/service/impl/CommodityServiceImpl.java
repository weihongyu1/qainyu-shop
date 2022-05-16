package com.why.shopServer.service.impl;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.why.shopServer.service.CommodityService;
import com.why.shopserver.commodity.pojo.Commodity;
import com.why.shopserver.commodity.repository.CommodityRepository;
import com.why.shopserver.vo.commodity.CommodityVo;
import com.why.shopserver.vo.commodity.TakeUpVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 商品业务接口实现类
 *
 * @author why
 * @create 2022-04-26 14:33
 **/
@Service
@Slf4j
public class CommodityServiceImpl implements CommodityService {

    @Autowired
    private CommodityRepository commodityRepository;
    private final Integer TAKE_DOWN = 1;
    private final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private final String DATE_FORMAT = "yyyy-MM-dd";
    private final String SPACE = " ";

    @Override
    public void commodityTakeUp(CommodityVo commodityVo) {

        Date takeUpDate = DateUtil.parseDate(commodityVo.getTakeUpDate());
        DateTime saleDate = DateUtil.parseDate(commodityVo.getSaleDate());

        commodityRepository.save(
                new Commodity(commodityVo.getId(), commodityVo.getCommodityName(), commodityVo.getDesc(),
                commodityVo.getStock(), commodityVo.getShipAddress(), 0, takeUpDate, saleDate,
                commodityVo.getCategory(), commodityVo.getPrice())
        );
    }

    @Override
    public void commodityTakeUp(TakeUpVo takeUpVo) {

        Date saleDate = new Date();
        if (takeUpVo.isDelivery()){
            saleDate = DateUtil.parseDate(DateUtil.format(takeUpVo.getDate(), DATE_FORMAT) + SPACE +
                    DateUtil.format(takeUpVo.getTime(), DATE_TIME_FORMAT).substring(11));
        }

        commodityRepository.save(
                new Commodity(null, takeUpVo.getCommodityName(), takeUpVo.getDesc(), takeUpVo.getStock(),
                takeUpVo.getShipAddress(), 0, new Date(), saleDate, takeUpVo.getCategory(), takeUpVo.getPrice())
        );
    }

    @Override
    public void commodityTakeDown(Commodity commodity) {
        commodity.setTakeDown(TAKE_DOWN);
        commodityUpdateInfo(commodity);
    }

    @Override
    public void commodityUpdateInfo(Commodity commodity) {
        commodityRepository.save(commodity);
    }

    @Override
    public List<CommodityVo> getAllCommodity() {
        List<Commodity> commodities = commodityRepository.findAll();
        List<CommodityVo> commodityList = new ArrayList<>(commodities.size());
        for (int i = 0; i < commodities.size(); i++) {
            Commodity commodity = commodities.get(i);
            if (commodity.getTakeDown() == 1){
                continue;
            }
            String saleDate = DateUtil.formatDate(commodity.getSaleDate());
            String takeUpDate = DateUtil.formatDate(commodity.getTakeUpDate());

            commodityList.add(
                    new CommodityVo(commodity.getId(), commodity.getCommodityName(), commodity.getCategory(),
                    saleDate, takeUpDate, commodity.getShipAddress(), commodity.getDesc(), commodity.getStock(), commodity.getPrice())
            );
        }
        return commodityList;
    }

    @Override
    public List<Commodity> findCommodityByName(String commodityName) {
        return null;
    }
}
