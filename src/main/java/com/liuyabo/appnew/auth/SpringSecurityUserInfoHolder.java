package com.liuyabo.appnew.auth;

import com.liuyabo.appnew.entity.UserInfo;
import com.liuyabo.appnew.spi.UserInfoHolder;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.security.Principal;

public class SpringSecurityUserInfoHolder implements UserInfoHolder {

  @Override
  public UserInfo getUser() {
    UserInfo userInfo = new UserInfo();
    userInfo.setUserId(getCurrentUsername());
    return userInfo;
  }

  private String getCurrentUsername() {
    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    if (principal instanceof UserDetails) {
      return ((UserDetails) principal).getUsername();
    }
    if (principal instanceof Principal) {
      return ((Principal) principal).getName();
    }
    return String.valueOf(principal);
  }

}
