package com.liuyabo.appnew.service;

import com.liuyabo.appnew.auth.UserService;
import com.liuyabo.appnew.entity.Boss;
import com.liuyabo.appnew.model.UserRegistry;
import com.liuyabo.appnew.repository.BossRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BossRegistryService {

    @Autowired
    private UserService userService;

    @Autowired
    private BossRepository bossRepository;

    public String addNewBoss(final UserRegistry user) {

        log.info("Check Boss existing or not");

        Boss existing = bossRepository.findByUserName(user.getUsername());
        if (existing != null)
            return "对不起！改用户名已经存在";

        existing = bossRepository.findByPhone(user.getPhonenumber());

        if (existing != null)
            return "对不起！该手机号已经被注册";

        log.info("Starting to add new Boss: username=" + user.getUsername() + ", phonenumber = " + user.getPhonenumber());

        Boss newBoss = bossRepository.save(new Boss().fromUserRegistry(user));

        if (newBoss == null) {
            log.error("Error happened while creating new account!!!");
            return "注册失败！";
        } else {
            userService.createOrUpdate(user);
        }

        return "注册成功！请返回登录界面";
    }
}
