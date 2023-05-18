package com.powernode.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.powernode.vo.HttpResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 认证成功就会调用该接口里的方法
 */
@Component
@Slf4j
public class AppAutheticationSuccessHandler implements AuthenticationSuccessHandler {
    @Resource
    private ObjectMapper objectMapper;  //可以进行序列化（json）和反序列化，
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        HttpResult httpResult=HttpResult.builder()
                .code(1)
                .msg("登录成功")
                .build();
        String responseJson = objectMapper.writeValueAsString(httpResult);

        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.println(responseJson);
        writer.flush();
    }
}
