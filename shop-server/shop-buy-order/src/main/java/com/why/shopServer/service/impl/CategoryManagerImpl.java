package com.why.shopServer.service.impl;

import com.why.shopServer.service.CategoryManger;
import com.why.shopServer.commodity.pojo.Commodity;
import com.why.shopServer.commodity.repository.CommodityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * 商品标签管理器实现类
 *
 * @author why
 * @create 2022-05-25 17:36
 **/
@Component
public class CategoryManagerImpl implements CategoryManger {

    @Autowired
    private CommodityRepository commodityRepository;

    @Override
    public Set<String> init() {
        List<Commodity> commodities = commodityRepository.findAll();
        Iterator<Commodity> iterator = commodities.iterator();
        Set<String> set = new HashSet<>();
        while (iterator.hasNext()) {
            Commodity next = iterator.next();
            set.add(next.getCategory());
        }
        return set;
    }
}
