package com.lummei.jobapp.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Menu implements Serializable {
	private static final long serialVersionUID = 4429209044473811179L;
	private Long id;
	private String serviceId;
	private String code;
	private String pCode;
	private Long pId;
	private String name;
	private String url;
	private Boolean isMenu;
	private Integer level;
	private Integer sort;
	private String icon;
	private String status;
	private Date createTime;
	private Date updateTime;
}
