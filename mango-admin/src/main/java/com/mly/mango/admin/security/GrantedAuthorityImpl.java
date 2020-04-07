package com.mly.mango.admin.security;

import org.springframework.security.core.GrantedAuthority;

/**
 * @author wyn
 * @Description 权限封装
 * @date 2020-04-06 0:15
 */
public class GrantedAuthorityImpl implements GrantedAuthority {
    private static final long serialVersionUID = 1L;

    private String authority;


    public GrantedAuthorityImpl(String authority){
        this.authority = authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return this.authority;
    }
}
