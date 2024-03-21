package com.example.mytakeout.security;

import java.io.IOException;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;

public class MyAuthenticationFailureHandler implements AuthenticationFailureHandler {
    private String url;
    private boolean isRedirect;

    public MyAuthenticationFailureHandler(String url, boolean isRedirect) {
        this.url = url;
        this.isRedirect = isRedirect;
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            AuthenticationException e) throws IOException, ServletException {
        if (isRedirect) {
            httpServletResponse.sendRedirect(url);
        } else {
            httpServletRequest.getRequestDispatcher(url).forward(httpServletRequest, httpServletResponse);
        }
    }

    // 不是必要的
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isRedirect() {
        return isRedirect;
    }

    public void setRedirect(boolean redirect) {
        isRedirect = redirect;
    }

}