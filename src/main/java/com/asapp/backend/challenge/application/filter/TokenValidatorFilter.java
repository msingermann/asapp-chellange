package com.asapp.backend.challenge.application.filter;

import com.asapp.backend.challenge.application.exceptions.UnauthorizedException;
import org.springframework.http.HttpHeaders;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TokenValidatorFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authHeaderValue = request.getHeader(HttpHeaders.AUTHORIZATION);
//        if(!StringUtils.hasLength(authHeaderValue)) {
//            throw new UnauthorizedException();
//        }
        filterChain.doFilter(request, response);
    }
}
