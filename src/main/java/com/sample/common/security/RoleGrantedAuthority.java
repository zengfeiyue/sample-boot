package com.sample.common.security;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.security.core.GrantedAuthority;

/**
 * 自定义权限对象
 *
 * @author zengfeiyue
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RoleGrantedAuthority implements GrantedAuthority {

    private String roleName;

    public RoleGrantedAuthority() {
    }

    public RoleGrantedAuthority(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String getAuthority() {
        return roleName;
    }
}
