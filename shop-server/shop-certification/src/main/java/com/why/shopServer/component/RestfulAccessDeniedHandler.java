package com.why.shopServer.component;

import cn.hutool.json.JSONUtil;
import com.why.shopServer.commonenum.StatusEnum;
import com.why.shopServer.vo.ResultVo;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 当访问接口没有权限时，自定义的返回结果。
 *
 * @author why
 * @create 2022-04-22 18:21
 **/
@Component
public class RestfulAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request,
                       HttpServletResponse response,
                       AccessDeniedException e) throws IOException, ServletException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.getWriter().println(JSONUtil.parse(ResultVo.error(StatusEnum.AUTHENTICATION_ERROR)));
        response.getWriter().flush();
    }
}
