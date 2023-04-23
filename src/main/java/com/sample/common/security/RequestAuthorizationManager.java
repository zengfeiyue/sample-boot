package com.sample.common.security;

import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.AuthorizationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.access.intercept.RequestAuthorizationContext;
import org.springframework.stereotype.Component;
import java.util.Collection;
import java.util.Objects;
import java.util.function.Supplier;

/**
 * 自定义鉴权
 *
 * @author zengfeiyue
 */
@Component
public class RequestAuthorizationManager implements AuthorizationManager<RequestAuthorizationContext> {


    @Override
    public AuthorizationDecision check(Supplier<Authentication> authentication, RequestAuthorizationContext request) {
        String url = request.getRequest().getRequestURI();
        String method = request.getRequest().getMethod();
        Authentication authentication1 = authentication.get();
        //取出用户权限
        Collection<? extends GrantedAuthority> authorities = authentication1.getAuthorities();
        if (Objects.equals(authentication1.getPrincipal().toString(),"zfy")){
            return new AuthorizationDecision(true);
        }
        return new AuthorizationDecision(false);
    }
}
