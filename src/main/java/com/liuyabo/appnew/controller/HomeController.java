package com.liuyabo.appnew.controller;

import com.liuyabo.appnew.model.SearchEntity;
import com.liuyabo.appnew.model.UserRegistry;
import com.liuyabo.appnew.service.BossRegistryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class HomeController {

    @Autowired
    private BossRegistryService bossRegistryService;

    @GetMapping({"/", "/home"})
    public String home(Model model) {
        SearchEntity searchEntity = new SearchEntity();
        model.addAttribute("searchEntity", searchEntity);

        return "home";
    }

    @PostMapping({"/home"})
    public String search(@ModelAttribute SearchEntity searchEntity, Model model) {
        return "home";
    }

    @GetMapping({"/registry"})
    public String registry(Model model) {
        UserRegistry userRegistry = new UserRegistry();
        model.addAttribute("userRegistry", userRegistry);
        return "registry";
    }

    @PostMapping({"/registry"})
    public String registry(@ModelAttribute UserRegistry userRegistry, Model model) {
        String info = bossRegistryService.addNewBoss(userRegistry);
        model.addAttribute("registryInfo", info);
        return "registry";
    }
}
