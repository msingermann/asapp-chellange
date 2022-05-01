package com.asapp.backend.challenge.application.filter;

import com.asapp.backend.challenge.application.exceptions.UnauthorizedException;
import com.asapp.backend.challenge.application.services.AuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Token Validation Filter.
 */
@Component
public class TokenValidatorFilter implements HandlerInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(TokenValidatorFilter.class);

    private AuthService authService;

    @Autowired
    public TokenValidatorFilter(AuthService authService) {
        this.authService = authService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        String authHeaderValue = request.getHeader(HttpHeaders.AUTHORIZATION);
        authService.validateToken(authHeaderValue);
        return true;
    }
}
