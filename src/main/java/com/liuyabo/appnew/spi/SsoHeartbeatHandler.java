package com.liuyabo.appnew.spi;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface SsoHeartbeatHandler {
    void doHeartbeat(HttpServletRequest request, HttpServletResponse response);
}
