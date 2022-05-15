package com.why.shopServer.service;

import com.why.shopserver.commodity.pojo.Commodity;
import com.why.shopserver.vo.commodity.CommodityVo;
import com.why.shopserver.vo.commodity.TakeUpVo;

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
     * @param commodityVo
     */
    void commodityTakeUp(CommodityVo commodityVo);

    /**
     * 商品上架
     * @param takeUpVo
     */
    void commodityTakeUp(TakeUpVo takeUpVo);

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
    List<CommodityVo> getAllCommodity();

    /**
     * 根据商品名称搜索商品
     * @param commodityName
     * @return
     */
    List<Commodity> findCommodityByName(String commodityName);
}
