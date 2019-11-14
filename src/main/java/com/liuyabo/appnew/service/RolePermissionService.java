package com.liuyabo.appnew.service;

import com.liuyabo.appnew.entity.Boss;
import com.liuyabo.appnew.entity.Customer;

public interface RolePermissionService {

    Boss createBossWithPermissions(Boss boss);

    void remvoeBossFromPermissions(Boss boss);

    Boss findBossWithPermissions(Boss boss);

    Boss findBossWithPermissionsByPhone(String phone);

    Customer createCustomerRole(Customer customer);

    void removeCustomerRole(Customer customer);

    Customer findCustomerRoleById(Customer customer);
}
