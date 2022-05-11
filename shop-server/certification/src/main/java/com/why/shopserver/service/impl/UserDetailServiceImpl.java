package com.why.shopserver.service.impl;

import com.why.shopserver.user.pojo.UserLogin;
import com.why.shopserver.user.repository.UserLoginRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * 自定义用户验证接口
 *
 * @author why
 * @create 2022-04-22 16:33
 **/
@Service
@Slf4j
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private UserLoginRepository userLoginRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * 自定义登录逻辑
     * @param username 用户名
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (StringUtils.isNotBlank(username)){
            //1. 根据用户名查询数据库
            UserLogin user = userLoginRepository.findByUsername(username);
            //2.根据查询对象比较密码
            String encode = passwordEncoder.encode(user.getPassword());
            //3.根据查询的对象设置权限
            return new UserLogin(user.getId(), username,encode,user.getRole());
        }

        return null;
    }
}