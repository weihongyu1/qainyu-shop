package com.why.shopServer.service.impl;

import cn.hutool.core.date.DateUtil;
import com.why.shopServer.dto.UserInfoDTO;
import com.why.shopServer.order.repository.OrderRepository;
import com.why.shopServer.service.UserServiceBase;
import com.why.shopServer.user.pojo.UserInfo;
import com.why.shopServer.user.pojo.UserLogin;
import com.why.shopServer.user.pojo.UserLoginList;
import com.why.shopServer.user.repository.UserInfoRepository;
import com.why.shopServer.user.repository.UserLoginListRepository;
import com.why.shopServer.user.repository.UserLoginRepository;
import com.why.shopServer.vo.UserListVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    @Autowired
    private UserLoginListRepository userLoginListRepository;
    @Autowired
    private OrderRepository orderRepository;

    private static final String INITIAL_PASSWORD = "888888";

    @Override
    public void updateUserLogin(UserLogin userLogin) {
        userLoginRepository.save(userLogin);
    }

    @Override
    @Transactional
    public boolean updateUserInfo(UserListVo userListVo) {
        UserLogin userLogin = userLoginRepository.findByUsername(userListVo.getUsername());
        userLogin.setUsername(userListVo.getUsername());
        userLogin.setRole(userListVo.getRole());
        UserInfo userInfo = userInfoRepository.findUserInfo(userLogin.getId());
        if (userInfo == null){
            userInfo = new UserInfo(
                    null, userListVo.getPhoneNumber(), null, userListVo.getAddress(),
                    userListVo.getUserId(), userListVo.getIntroduction(), null, new Date()
            );
        }else {
            userInfo = new UserInfo(
                    userInfo.getId(), userListVo.getPhoneNumber(), userInfo.getEmail(), userListVo.getAddress(),
                    userListVo.getUserId(), userListVo.getIntroduction(), userInfo.getAvatar(), DateUtil.parseDate(userListVo.getDate())
            );
        }
        userLogin.setPassword(INITIAL_PASSWORD);
        userLoginRepository.save(userLogin);
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

    @Override
    public List<UserListVo> getUserList() {
        List<UserLogin> userLogins = userLoginRepository.findAll();
        List<UserListVo> userListVos = new ArrayList<>(userLogins.size());
        for (int i = 0; i < userLogins.size(); i++) {
            UserListVo userListVo = new UserListVo();
            UserInfo userInfo = userInfoRepository.findUserInfo(userLogins.get(i).getId());
            UserLoginList userLoginList = userLoginListRepository.findUserLoginListByUId(userLogins.get(i).getId());

            userListVo.setUserId(userLogins.get(i).getId());
            userListVo.setUsername(userLogins.get(i).getUsername());
            if (userInfo != null){
                if (StringUtils.isNotBlank(userInfo.getAddress())){
                    userListVo.setAddress(userInfo.getAddress());
                }
                if (StringUtils.isNotBlank(userInfo.getPhoneNumber())){
                    userListVo.setPhoneNumber(userInfo.getPhoneNumber());
                }
                if (StringUtils.isNotBlank(userLogins.get(i).getRole())){
                    userListVo.setRole(userLogins.get(i).getRole());
                }
                if (userInfo.getAccountDate() != null){
                    userListVo.setDate(DateUtil.formatDate(userInfo.getAccountDate()));
                }
                if (StringUtils.isNotBlank(userInfo.getIntroduction())){
                    userListVo.setIntroduction(userInfo.getIntroduction());
                }
            }

            if (userLoginList != null){
                userListVo.setLoginStatus("已登录");
            } else {
                userListVo.setLoginStatus("未登录");
            }
            userListVos.add(userListVo);
        }

        return userListVos;
    }

    @Override
    @Transactional
    public void delUser(Integer uId) {
        userInfoRepository.deleteUserInfoByUId(uId);
        userLoginListRepository.deleteByUId(uId);
        orderRepository.deleteByUId(uId);
        userLoginRepository.deleteByUId(uId);
    }
}
