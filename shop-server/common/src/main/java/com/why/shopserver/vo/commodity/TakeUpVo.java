package com.why.shopserver.vo.commodity;

import io.lettuce.core.output.VoidOutput;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品上架传输实体
 *
 * @author why
 * @create 2022-05-14 22:28
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TakeUpVo {
    private String commodityName;
    private boolean delivery;
    private Date date;
    private Date time;
    private String category;
    private String shipAddress;
    private String desc;
    private Integer stock;
    private BigDecimal price;
}
