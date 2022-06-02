package com.why.shopServer.filter;

import cn.hutool.http.server.HttpServerRequest;
import cn.hutool.http.server.HttpServerResponse;
import cn.hutool.http.server.filter.HttpFilter;
import com.sun.net.httpserver.Filter;
import com.why.shopServer.user.pojo.UserLogin;
import com.why.shopServer.user.pojo.UserLoginList;
import com.why.shopServer.user.repository.UserInfoRepository;
import com.why.shopServer.user.repository.UserLoginListRepository;
import com.why.shopServer.user.repository.UserLoginRepository;
import com.why.shopServer.util.IpUtil;
import com.why.shopServer.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * 日志过滤器
 *
 * @author why
 * @create 2022-05-28 14:59
 **/
@Component
@Slf4j
public class LoggerFilter implements javax.servlet.Filter {

    @Autowired
    private UserLoginListRepository userLoginListRepository;
    @Autowired
    private UserLoginRepository userLoginRepository;
    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String realIP = IpUtil.getRealIP(request);
        String requestURI = request.getRequestURI();
        log.info(realIP + " 正在访问：" + requestURI);

        //刷新登录
        String username = jwtUtil.getUserNameFromToken(jwtUtil.getToken(request));
        if (!StringUtils.isBlank(username)){
            UserLogin userLogin = userLoginRepository.findByUsername(username);
            log.info(userLogin.toString());
            if (userLoginListRepository.findUserLoginListByUId(userLogin.getId()) == null){
                userLoginListRepository.save(new UserLoginList(null, userLogin.getId(), new Date()));
            } else {
                userLoginListRepository.save(new UserLoginList(
                        userLoginListRepository.findUserLoginListByUId(userLogin.getId()).getId(),
                        userLogin.getId(), new Date()));
            }
        }

        filterChain.doFilter(request, response);
    }
}
