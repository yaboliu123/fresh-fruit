package com.liuyabo.appnew.component;

import com.liuyabo.appnew.service.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("permissionValidator")
public class PermissionValidator {
    private final RolePermissionService rolePermissionService;

    @Autowired
    public PermissionValidator(final RolePermissionService rolePermissionService) {
        this.rolePermissionService = rolePermissionService;
    }



}
