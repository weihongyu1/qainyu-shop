package com.why.shopServer.service.impl;

import com.why.shopServer.user.pojo.UserLogin;
import com.why.shopServer.user.pojo.UserLoginList;
import com.why.shopServer.user.repository.UserLoginListRepository;
import com.why.shopServer.user.repository.UserLoginRepository;
import com.why.shopServer.util.JwtUtil;
import com.why.shopServer.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 用户登录、注册业务接口实现类
 *
 * @author why
 * @create 2022-04-22 17:22
 **/
@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDetailServiceImpl userDetailService;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserLoginRepository userLoginRepository;
    @Autowired
    private UserLoginListRepository userLoginListRepository;

    @Override
    public String login(String username, String password) throws AuthenticationException{
        //根据用户名获取 用户信息
        UserDetails userDetails = userDetailService.loadUserByUsername(username);
        if(!passwordEncoder.matches(password,userDetails.getPassword())){
            throw new BadCredentialsException("密码不正确");
        }
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
        SecurityContextHolder.getContext().setAuthentication(token);

        Integer uId = userLoginRepository.findByUsername(username).getId();
        Integer loginListId = userLoginListRepository.findUserLoginListByUId(uId).getId();
        userLoginListRepository.save(new UserLoginList(loginListId, uId, new Date()));
        //生成JWT
        return jwtUtil.generateToken(userDetails);
    }

    @Override
    public void register(String username, String password, String auths) {
        userLoginRepository.save(new UserLogin(null, username, password, auths));
    }

    @Override
    public String refreshToken(String oldToken) {
        if (!jwtUtil.isTokenExpired(oldToken)) {
            return jwtUtil.refreshToken(oldToken);
        }
        return null;
    }
}
