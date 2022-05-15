package com.why.shopserver.filter;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import com.why.shopserver.service.impl.UserDetailServiceImpl;
import com.why.shopserver.util.JwtUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 在用户名和密码校验前添加的过滤器，
 * 如果请求中有jwt的token且有效，
 * 会取出token中的用户名，
 * 然后调用SpringSecurity的API进行登录操作。
 *
 * @author why
 * @create 2022-04-22 18:19
 **/
@Slf4j
@Component
@AllArgsConstructor
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {
    private final UserDetailServiceImpl userDetailService;
    private final JwtUtil jwtUtil;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String jwt = jwtUtil.getToken(request);
        if(!StrUtil.isEmpty(jwt)){
            //根据jwt获取用户名
            String username = jwtUtil.getUserNameFromToken(jwt);
            //如果可以正确从JWT中提取用户信息，并且该用户未被授权
            if(!StrUtil.isEmpty(username) && SecurityContextHolder.getContext().getAuthentication()==null){
                UserDetails userDetails = this.userDetailService.loadUserByUsername(username);
                if(jwtUtil.validateToken(jwt,userDetails)){
                    //给使用该JWT令牌的用户进行授权
                    UsernamePasswordAuthenticationToken authenticationToken
                            = new UsernamePasswordAuthenticationToken(userDetails,null,
                            userDetails.getAuthorities());
                    authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                }
            }
        }
        filterChain.doFilter(request, response);
    }
}
