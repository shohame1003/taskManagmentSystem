package com.example.taskmanagementsystem.user.entity;

import lombok.Getter;

import java.util.Set;

@Getter
public enum Role {
    USER(Set.of(Permission.CREATE, Permission.GET_ALL)),

    ADMIN(Set.of(Permission.GET_ALL, Permission.CREATE, Permission.DELETE,
            Permission.UPDATE, Permission.PATCH, Permission.GET_ID));

    private final Set<Permission> permissions;

    Role(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    }
