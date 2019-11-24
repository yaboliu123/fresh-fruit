package com.liuyabo.appnew.component;

import com.liuyabo.appnew.entity.UserInfo;
import com.liuyabo.appnew.service.RolePermissionService;
import com.liuyabo.appnew.spi.UserInfoHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("permissionValidator")
public class PermissionValidator {

    private UserInfoHolder userInfoHolder;

    private final RolePermissionService rolePermissionService;

    @Autowired
    public PermissionValidator(final RolePermissionService rolePermissionService) {
        this.rolePermissionService = rolePermissionService;
    }

    public boolean isAllowed() {
        UserInfo userInfo = userInfoHolder.getUser();

        return userInfo != null;

    }

}
