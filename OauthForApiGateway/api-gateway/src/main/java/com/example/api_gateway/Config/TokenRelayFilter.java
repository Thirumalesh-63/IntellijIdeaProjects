package com.example.api_gateway.Config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

@Component
public class TokenRelayFilter implements WebFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        // Extract the authentication token from the context or request
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getCredentials() instanceof OAuth2AccessToken) {
            OAuth2AccessToken token = (OAuth2AccessToken) authentication.getCredentials();
            System.err.println((token));
            System.err.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

            exchange.getRequest().mutate()
                    .header("Authorization", "Bearer " + token.getTokenValue())
                    .build();
        }
        return chain.filter(exchange);
    }
}
