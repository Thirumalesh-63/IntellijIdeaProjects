package com.example.api_gateway.Config;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class JwtLoggingFilter extends OncePerRequestFilter {
    private static final Logger logger = LoggerFactory.getLogger(JwtLoggingFilter.class);


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            String token = authorizationHeader.substring(7);  // Remove "Bearer " prefix
            logger.info("JWT Token: {}", token);  // Log the JWT token
            System.err.println((token));
            System.err.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        }
        filterChain.doFilter(request, response);
    }
}
