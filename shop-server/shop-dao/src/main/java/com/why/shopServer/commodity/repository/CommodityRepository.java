package com.why.shopServer.commodity.repository;

import com.why.shopServer.commodity.pojo.Commodity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 * @InterfaceName：Commodity
 * @Description：商品数据操作
 * @Author: why
 * @create 2022-04-26 14:30
 **/
public interface CommodityRepository extends JpaRepository<Commodity,Integer> {

    final String table = "commodity";
    final String field = "commodity_name, commodity_describe, stock, ship_address, take_down, take_up_time";

    Commodity findCommodityByCommodityName(String commodityName);

    Commodity findCommodityById(Integer id);

    List<Commodity> findCommoditiesByCategory(String category);
}
