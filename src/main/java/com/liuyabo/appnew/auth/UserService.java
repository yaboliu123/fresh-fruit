package com.liuyabo.appnew.auth;

import com.liuyabo.appnew.entity.UserInfo;

public interface UserService {
    UserInfo findUserById(int id);
}
