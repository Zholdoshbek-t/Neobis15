package com.tilek.spring.neobis.model.enums;

import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static com.tilek.spring.neobis.model.enums.Permission.*;
public enum Role {

    DIRECTOR(Sets.newHashSet(WAREHOUSE_READ,WAREHOUSE_WRITE,PRODUCT_READ,PRODUCT_WRITE,
            ORDER_READ,ORDER_WRITE,USER_READ,USER_WRITE)),
    ADMINISTRATOR(Sets.newHashSet(WAREHOUSE_READ,PRODUCT_READ,PRODUCT_WRITE,
            ORDER_READ,ORDER_WRITE, USER_READ)),
    MANAGER(Sets.newHashSet(WAREHOUSE_READ,PRODUCT_READ,ORDER_READ,ORDER_WRITE)),
    USER(Sets.newHashSet(PRODUCT_READ,ORDER_WRITE));

    private final Set<Permission> permissions;

    Role(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getAuthorities() {
        Set<SimpleGrantedAuthority> authorities = getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return authorities;
    }
}
