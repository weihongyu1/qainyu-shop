package com.why.shopserver.vo.commodity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品视图传输实体
 *
 * @author why
 * @create 2022-05-14 20:34
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommodityVo {
    private Integer id;
    private String commodityName;
    private String category;
    private String saleDate;
    private String takeUpDate;
    private String shipAddress;
    private String desc;
    private Integer stock;
    private BigDecimal price;
}
