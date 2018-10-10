package com.lummei.jobapp.protocol;

public class UserStatus extends DataDictionary {
    private static final long serialVersionUID = 7509895595831253298L;
    private UserStatus(String codeName, String codeValue, String description, int displayOrder) {
        super(codeName, codeValue, description, displayOrder);
    }

    /**
     * 正常状态。
     */
    public static UserStatus NORMAL = new UserStatus("正常", "NORMAL", "正常状态", 1);

    public static UserStatus BLOCK = new UserStatus("禁止", "BLOCK", "禁止登录状态", 1);

}
