package com.why.shopServer.vo.commodity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 商品分类传输实体
 *
 * @author why
 * @create 2022-05-25 17:09
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommodityListVo {
    private List<CommodityVo> commodityVos;
    private String tag;
}
