package com.why.shopserver.service.impl;

import com.why.shopserver.user.pojo.UserLogin;
import com.why.shopserver.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
    private UserRepository userRepository;

    /**
     * 自定义登录逻辑
     * @param username 用户名
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("用户登录认证：" + username);
        if (StringUtils.isNotBlank(username)){
            //1. 根据用户名查询数据库
            log.info("find user in database");
            UserLogin user = userRepository.findByUsername(username);
            //2.根据查询对象比较密码
            log.info("Compare user passwords");
            String encode = user.getPassword();
            //3.根据查询的对象设置权限
            log.info("Setting auths");
            return new UserLogin(user.getId(), username,encode,user.getAuths());
        }

        return null;
    }
}