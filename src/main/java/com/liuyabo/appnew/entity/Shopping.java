package com.liuyabo.appnew.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "Shopping")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Shopping implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int customerId;
    private Date createdTime;
    private float amount;
}
