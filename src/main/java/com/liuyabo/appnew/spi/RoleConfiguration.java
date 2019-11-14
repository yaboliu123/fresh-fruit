package com.liuyabo.appnew.spi;

import com.liuyabo.appnew.service.DefaultRolePermissionService;
import com.liuyabo.appnew.service.RolePermissionService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RoleConfiguration {

    @Bean
    public RolePermissionService rolePermissionService() {
        return new DefaultRolePermissionService();
    }

}
