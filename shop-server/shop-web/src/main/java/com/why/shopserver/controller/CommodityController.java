package com.why.shopServer.controller;

import com.why.shopServer.commodity.pojo.Commodity;
import com.why.shopServer.commonenum.StatusEnum;
import com.why.shopServer.service.impl.CommodityServiceImpl;
import com.why.shopServer.vo.ResultVo;
import com.why.shopServer.vo.commodity.CommodityVo;
import com.why.shopServer.vo.commodity.TakeUpVo;
import io.lettuce.core.dynamic.annotation.Param;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 商品数据接口
 *
 * @author why
 * @create 2022-04-26 15:05
 **/
@RestController
@RequestMapping("/commodity")
@Slf4j
public class CommodityController {
    @Autowired
    private CommodityServiceImpl commodityService;

    /**
     * 商品上架接口
     * @param commodityVo
     * @return
     */
    @PostMapping("/take_up_list")
    public ResultVo commodityTakeUp(@RequestBody CommodityVo commodityVo){
        commodityService.commodityTakeUp(commodityVo);
        return ResultVo.success(StatusEnum.COMMODITY_TAKE_UP_SUCCESS);
    }

    /**
     * 商品上架接口
     * @param takeUpVo
     * @return
     */
    @PostMapping("/take_up_form")
    public ResultVo commodityTakeUp(@RequestBody TakeUpVo takeUpVo){
        commodityService.commodityTakeUp(takeUpVo);
        return ResultVo.success(StatusEnum.COMMODITY_TAKE_UP_SUCCESS);
    }

    /**
     * 商品下架接口
     * @param commodity
     * @return
     */
    @PostMapping("/take_down")
    public ResultVo commodityTakeDown(@RequestBody Commodity commodity){
        log.info(commodity.toString());
        commodityService.commodityTakeDown(commodity);
        return ResultVo.success(StatusEnum.COMMODITY_TAKE_DOWN_SUCCESS);
    }

    /**
     * 更新商品数据
     * @param commodity
     * @return
     */
    @PostMapping("/update_info")
    public ResultVo commodityUpdateInfo(@RequestBody Commodity commodity){
        commodityService.commodityUpdateInfo(commodity);
        return ResultVo.success(StatusEnum.COMMODITY_UPDATE_INFO_SUCCESS);
    }

    /**
     * 获取所有商品
     * @return
     */
    @Deprecated
    @GetMapping("/get_all")
    public ResultVo getAllCommodity(){
        log.info(commodityService.getAllCommodity().toString());
        return ResultVo.success(StatusEnum.COMMODITY_GET_ALL_SUCCESS,commodityService.getAllCommodity());
    }

    @GetMapping("/get_all_commodity")
    public ResultVo getAllCommodities(){
        return ResultVo.success(StatusEnum.COMMODITY_GET_ALL_SUCCESS,commodityService.getAllCommodities());
    }

    /**
     * 根据商品名称搜索商品
     * @param commodityName
     * @return
     */
    @GetMapping("/search")
    public ResultVo findCommodityByName(@Param("commodity") String commodityName){
        return ResultVo.success(StatusEnum.COMMODITY_SEARCH_BY_NAME_SUCCESS,commodityService.findCommodityByName(commodityName));
    }

    @GetMapping("/get_commodity")
    public ResultVo getCommodity(@Param("commodityId") Integer commodityId){
        return ResultVo.success(StatusEnum.COMMODITY_GET_BY_ID_SUCCESS, commodityService.findCommodityById(commodityId));
    }
}
