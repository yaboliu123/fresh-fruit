package com.liuyabo.appnew.defaultImpl;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DefaultLogoutHandler implements LogoutHandler {

  @Override
  public void logout(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) {
    try {
      httpServletResponse.sendRedirect("/");
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
