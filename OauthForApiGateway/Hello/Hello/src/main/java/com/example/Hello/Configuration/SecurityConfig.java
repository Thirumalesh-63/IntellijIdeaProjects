//package com.example.Hello.Configuration;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.oauth2.jwt.JwtDecoder;
//import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .addFilterBefore(new JwtLoggingFilter(), UsernamePasswordAuthenticationFilter.class)
//                .authorizeRequests(authorizeRequests ->
//                        authorizeRequests
//                                .anyRequest().authenticated() // Require authentication for all requests
//                )
//                .oauth2ResourceServer(oauth2 -> oauth2
//                        .opaqueToken(token -> token
//                                .introspectionUri("https://oauth2.googleapis.com/tokeninfo")
//                                .introspectionClientCredentials("8527103455-mk5j8ernqoh5v8k70ti3p2q6ejm5u6jk.apps.googleusercontent.com", "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") // Use client credentials if needed
//
//                        )
//                );
//
//        return http.build();
//    }
//}