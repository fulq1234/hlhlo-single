package com.lummei.jobapp.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class IndustryZhilian  implements Serializable {
    private static final long serialVersionUID = -1590823625522943468L;
    private int id;
    private String key;
    private String value;
    private String zlkey;


}
