package com.liuyabo.appnew.defaultImpl;

import com.liuyabo.appnew.spi.SsoHeartbeatHandler;
import lombok.extern.log4j.Log4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DefaultSsoHeartbeatHandler implements SsoHeartbeatHandler {
    @Override
    public void doHeartbeat(HttpServletRequest request, HttpServletResponse response) {
        try{
            response.sendRedirect("default_sso_heartbeat.html");
        } catch (IOException e)
        {

        }
    }
}
