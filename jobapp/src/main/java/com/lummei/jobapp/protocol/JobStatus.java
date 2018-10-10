package com.lummei.jobapp.protocol;

/**
 * 求职状态
 * @author songxincong
 */
public class JobStatus extends DataDictionary {

    private static final long serialVersionUID = 203890490216720034L;

    public static JobStatus ALL_TIME = new JobStatus("离职-随时到岗", "001", "离职-随时到岗", 1);

    public static JobStatus NO_CONSIDER = new JobStatus("在职-暂不考虑", "002", "在职-暂不考虑", 2);

    public static JobStatus CONSIDER = new JobStatus("在职-考虑机会", "003", "在职-考虑机会", 3);

    public static JobStatus MONTH_ARRIVE = new JobStatus("在职-月内到岗", "004", "在职-月内到岗", 4);

    private JobStatus(String key, String value, String description, int displayOrder) {
        super(key, value, description, displayOrder);
    }
}
