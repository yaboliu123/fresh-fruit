package com.liuyabo.appnew.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "Boss")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Boss implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String bossName;
    private String address;
    private String phone;
    private Date createdTime;
    private String lastModifiedBy;
    private Date lastModifiedTime;
    private String status;

    public UserInfo toUserInfo() {
        UserInfo userInfo = new UserInfo();
        userInfo.setName(this.getBossName());
        userInfo.setUserId(String.valueOf(this.getId()));
        return userInfo;
    }
}
