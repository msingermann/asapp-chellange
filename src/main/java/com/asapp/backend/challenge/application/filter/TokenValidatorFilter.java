package com.asapp.backend.challenge.application.filter;

import com.asapp.backend.challenge.application.exceptions.UnauthorizedException;
import com.asapp.backend.challenge.application.services.DefaultAuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TokenValidatorFilter extends OncePerRequestFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(TokenValidatorFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authHeaderValue = request.getHeader(HttpHeaders.AUTHORIZATION);
        if(!StringUtils.hasLength(authHeaderValue)) {
            LOGGER.debug("Authorization token is not present or empty.");
            throw new UnauthorizedException();
        }
        LOGGER.debug("Authorization token is present.");
        filterChain.doFilter(request, response);
    }
}
