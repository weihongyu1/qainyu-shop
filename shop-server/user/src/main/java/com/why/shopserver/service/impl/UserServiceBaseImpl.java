package com.why.shopserver.service.impl;

import cn.hutool.log.Log;
import com.why.shopserver.dto.UserInfoDTO;
import com.why.shopserver.service.UserServiceBase;
import com.why.shopserver.user.pojo.UserInfo;
import com.why.shopserver.user.pojo.UserLogin;
import com.why.shopserver.user.repository.UserInfoRepository;
import com.why.shopserver.user.repository.UserLoginRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户业务接口实现类
 *
 * @author why
 * @create 2022-04-26 15:46
 **/
@Service
@Slf4j
public class UserServiceBaseImpl implements UserServiceBase {

    @Autowired
    private UserLoginRepository userLoginRepository;
    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    public void updateUserLogin(UserLogin userLogin) {
        userLoginRepository.save(userLogin);
    }

    @Override
    public boolean updateUserInfo(UserInfo userInfo) {
        UserLogin userLogin = userLoginRepository.getById(userInfo.getUId());
        if (userLogin == null){
            return false;
        }
        userInfoRepository.save(userInfo);
        return true;
    }

    @Override
    public UserInfoDTO getUserInfo(String username) {
        UserLogin userLogin = userLoginRepository.findByUsername(username);

        UserInfoDTO userInfoDTO = new UserInfoDTO();
        userInfoDTO.setName(username);

        //设置权限
        String[] rolesArr = userLogin.getRole().split(",");
        userInfoDTO.setRoles(rolesArr);

        userInfoDTO.setId(userLogin.getId());

        UserInfo userInfo = userInfoRepository.findUserInfo(userLogin.getId());
        userInfoDTO.setIntroduction(userInfo.getIntroduction());
        userInfoDTO.setAvatar(userInfo.getAvatar());

        return userInfoDTO;
    }
}
