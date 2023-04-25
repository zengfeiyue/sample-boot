package com.sample.config;

import com.sample.common.security.PwdAuthenticationFilter;
import com.sample.common.security.RequestAuthorizationManager;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * spring security配置
 *
 * @author zengfeiyue
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    @Resource
    private RequestAuthorizationManager authorizationManager;

    @Resource
    private AuthenticationProvider authenticationProvider;

    @Resource
    private AuthenticationSuccessHandler authenticationSuccessHandler;

    @Resource
    private AuthenticationFailureHandler authenticationFailureHandler;

    @Resource
    private AuthenticationEntryPoint authenticationEntryPoint;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeHttpRequests((requests) -> requests
                .requestMatchers("/**","/login")
                .permitAll()
                .anyRequest()
                .access(authorizationManager));
        http.addFilterBefore(processingFilter(),UsernamePasswordAuthenticationFilter.class);
        http.exceptionHandling().authenticationEntryPoint(authenticationEntryPoint);
        return http.build();
    }

    @Bean
    public PwdAuthenticationFilter processingFilter() {
        PwdAuthenticationFilter authenticationFilter = new PwdAuthenticationFilter();
        ProviderManager providerManager = new ProviderManager(authenticationProvider);
        authenticationFilter.setAuthenticationManager(providerManager);
        authenticationFilter.setAuthenticationSuccessHandler(authenticationSuccessHandler);
        authenticationFilter.setAuthenticationFailureHandler(authenticationFailureHandler);
        return authenticationFilter;
    }

}
