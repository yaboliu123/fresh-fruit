package com.liuyabo.appnew.controller;

import com.liuyabo.appnew.entity.Boss;
import com.liuyabo.appnew.model.LogInModel;
import com.liuyabo.appnew.service.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

@Controller
public class SignInController {

    @Autowired
    private RolePermissionService rolePermissionService;

    @GetMapping("/signin")
    public String login(@RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "logout", required = false) String logout) {
        return "login";
    }

    @GetMapping("/hello")
    public String sayHi() {
        return "login";
    }

    @PostMapping(value="/signin")
    public String postLogin(@ModelAttribute LogInModel login, Model model) {
        if(StringUtils.isEmpty(login.getUsername()) || StringUtils.isEmpty(login.getPassword()))
            return "login";
//        Boss existing = rolePermissionService.findBossWithPermissionsByPhone(login.getUsername());
//        if(existing == null || !existing.getPassword().equalsIgnoreCase(login.getPassword()))
//            return "login";

        return "home";
    }
}
