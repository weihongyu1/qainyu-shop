package com.why.shopServer.service;

import com.why.shopserver.commodity.pojo.Commodity;

import java.util.List;

/**
 * @InterfaceName：CommodityService
 * @Description：
 * @Author: why
 * @create 2022-04-26 14:33
 **/
public interface CommodityService {
    /**
     * 商品上架
     * @param commodity
     */
    void commodityTakeUp(Commodity commodity);

    /**
     * 商品下架
     * @param commodity
     */
    void commodityTakeDown(Commodity commodity);

    /**
     * 修改商品信息
     * @param commodity
     */
    void commodityUpdateInfo(Commodity commodity);

    /**
     * 获取所有商品
     * @return
     */
    List<Commodity> getAllCommodity();

    /**
     * 根据商品名称搜索商品
     * @param commodityName
     * @return
     */
    List<Commodity> findCommodityByName(String commodityName);
}
