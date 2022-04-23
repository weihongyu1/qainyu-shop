package com.why.shopserver.service.impl;

import com.why.shopserver.service.UserService;
import com.why.shopserver.user.pojo.UserLogin;
import com.why.shopserver.user.repository.UserRepository;
import com.why.shopserver.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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
    private UserRepository userRepository;

    @Override
    public String login(String username, String password) {
        try{
            //根据用户名获取 用户信息
            UserDetails userDetails = userDetailService.loadUserByUsername(username);
            if(!passwordEncoder.matches(password,userDetails.getPassword())){
                throw new BadCredentialsException("密码不正确");
            }
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
            SecurityContextHolder.getContext().setAuthentication(token);
        }catch (AuthenticationException e){
            log.error("用户名或者密码不正确");
        }
        //生成JWT
        UserDetails userDetails = userDetailService.loadUserByUsername(username);
        return jwtUtil.generateToken(userDetails);
    }

    @Override
    public void register(String username, String password, String auths) {
        userRepository.save(new UserLogin(null, username, password, auths));
    }

    @Override
    public String refreshToken(String oldToken) {
        if (!jwtUtil.isTokenExpired(oldToken)) {
            return jwtUtil.refreshToken(oldToken);
        }
        return null;
    }
}