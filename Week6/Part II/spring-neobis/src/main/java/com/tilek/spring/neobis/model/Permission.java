package com.tilek.spring.neobis.model;

public enum Permission {
    PRODUCT_READ("product:read"),
    PRODUCT_WRITE("product:write"),
    ORDER_READ("order:read"),
    ORDER_WRITE("order:write"),
    WAREHOUSE_READ("warehouse:read"),
    WAREHOUSE_WRITE("warehouse:write"),
    USER_READ("user:read"),
    USER_WRITE("user:write");

    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
