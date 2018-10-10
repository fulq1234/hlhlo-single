package com.lummei.jobapp.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserRole implements Serializable {
    private static final long serialVersionUID = -9150245774952661744L;
    private Long id;
    private Long userId;
    private Long roleId;
    private Date createTime;
    private String createBy;
}
