package com.liuyabo.appnew.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "Customer")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int bossId;
    private String bossName;
    private String customerName;
    private String phone;
    private Date createdTime;
    private String lastModifiedBy;
    private Date lastModifiedTime;
    private String status;
    private float account;
}
