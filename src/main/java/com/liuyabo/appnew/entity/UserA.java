package com.liuyabo.appnew.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Users")
public class UserA {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;
    @Column(name = "Username", nullable = false)
    private String username;
    @Column(name = "Password", nullable = false)
    private String password;
    @Column(name = "Email", nullable = false)
    private String email;
    @Column(name = "Enabled", nullable = false)
    private int enabled;


}
