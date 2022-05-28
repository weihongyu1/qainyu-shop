package com.why.shopServer.service.impl;

import com.why.shopServer.service.GlobalLoginService;
import com.why.shopServer.user.pojo.UserLoginList;
import com.why.shopServer.user.repository.UserLoginListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

/**
 * 全局登录业务处理接口实现类
 *
 * @author why
 * @create 2022-05-26 15:10
 **/
@Service
public class GlobalLoginServiceImpl implements GlobalLoginService {

    @Autowired
    private UserLoginListRepository userLoginListRepository;
    @Override
    public void ExpiredLogin() {
        List<UserLoginList> userLoginLists = userLoginListRepository.findAll();
        Iterator<UserLoginList> iterator = userLoginLists.iterator();
        while (iterator.hasNext()) {
            UserLoginList userLoginList = iterator.next();

        }
    }
}
