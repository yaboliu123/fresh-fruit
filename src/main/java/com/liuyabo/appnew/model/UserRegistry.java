package com.liuyabo.appnew.model;

import lombok.Data;

@Data
public class UserRegistry extends ErrorModel{

    private String username;

    private String phonenumber;

    private String password;

    private String confirm_password;

    private String idCard;
}
