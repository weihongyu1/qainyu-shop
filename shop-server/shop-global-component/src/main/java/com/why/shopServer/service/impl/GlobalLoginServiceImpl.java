package com.why.shopServer.service.impl;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import com.why.shopServer.service.GlobalLoginService;
import com.why.shopServer.user.pojo.UserLoginList;
import com.why.shopServer.user.repository.UserLoginListRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * 全局登录业务处理接口实现类
 *
 * @author why
 * @create 2022-05-26 15:10
 **/
@Service
@Slf4j
public class GlobalLoginServiceImpl implements GlobalLoginService {

    @Autowired
    private UserLoginListRepository userLoginListRepository;
    @Override
    @Transactional
    public void ExpiredLogin() {
        List<UserLoginList> userLoginLists = userLoginListRepository.findAll();
        Iterator<UserLoginList> iterator = userLoginLists.iterator();
        Date nowDate = new Date();
        while (iterator.hasNext()) {
            UserLoginList userLoginList = iterator.next();
            long betweenmills = DateUtil.between(nowDate, userLoginList.getLoginTime(), DateUnit.SECOND);
            //删除登录状态
            if (betweenmills >= 3600) {
                userLoginListRepository.deleteByUId(userLoginList.getUId());
            }
        }
    }
}
