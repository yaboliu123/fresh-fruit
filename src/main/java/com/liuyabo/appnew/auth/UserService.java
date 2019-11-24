package com.liuyabo.appnew.auth;

import com.liuyabo.appnew.entity.UserInfo;
import com.liuyabo.appnew.model.UserRegistry;

public interface UserService {
    UserInfo findUserById(int id);

    void createOrUpdate(UserRegistry user);
}
