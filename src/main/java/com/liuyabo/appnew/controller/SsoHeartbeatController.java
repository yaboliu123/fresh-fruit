package com.liuyabo.appnew.controller;

import com.liuyabo.appnew.spi.SsoHeartbeatHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/sso_heartbeat")
public class SsoHeartbeatController {

    private SsoHeartbeatHandler handler;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public void heartbeat(HttpServletRequest request, HttpServletResponse response) {
        handler.doHeartbeat(request, response);
    }
}
