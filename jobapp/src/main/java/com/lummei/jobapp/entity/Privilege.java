package com.lummei.jobapp.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Privilege implements Serializable {
	private static final long serialVersionUID = 6206499928956662425L;
	private Long roleId;
	private Long menuId;
	private Date createTime;
}
