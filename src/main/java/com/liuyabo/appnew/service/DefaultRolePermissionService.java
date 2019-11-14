package com.liuyabo.appnew.service;

import com.liuyabo.appnew.entity.Boss;
import com.liuyabo.appnew.entity.Customer;
import com.liuyabo.appnew.repository.BossRepository;
import com.liuyabo.appnew.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import static com.liuyabo.appnew.utils.Constants.INACTIVE;

public class DefaultRolePermissionService implements RolePermissionService {
    @Autowired
    private BossRepository bossRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Boss createBossWithPermissions(Boss boss) {
        return bossRepository.save(boss);
    }

    @Override
    public Boss findBossWithPermissionsByPhone(String phone) {
        return bossRepository.findByPhone(phone);
    }

    @Override
    public void remvoeBossFromPermissions(Boss boss) {
        bossRepository.deactiveBoseById(boss.getId(), INACTIVE);
    }

    @Override
    public Boss findBossWithPermissions(Boss boss) {
        return bossRepository.findById(boss.getId());
    }

    @Override
    public Customer createCustomerRole(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void removeCustomerRole(Customer customer) {
        //TODO
    }

    @Override
    public Customer findCustomerRoleById(Customer customer) {
        return customerRepository.getCustomerById(customer.getId());
    }
}
