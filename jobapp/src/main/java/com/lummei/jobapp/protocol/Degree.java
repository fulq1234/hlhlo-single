package com.lummei.jobapp.protocol;

/**
 * 学历
 * @author songxincong
 */
public class Degree extends DataDictionary {

    private static final long serialVersionUID = 3780958642032612837L;

    public static Degree UNLIMITED = new Degree("不限", "001", "不限", 1);

    public static Degree MIDDLE = new Degree("初中", "002", "初中", 3);

    public static Degree HIGH = new Degree("高中", "003", "高中", 4);

    public static Degree SPECIALTY = new Degree("大专", "004", "大专", 5);

    public static Degree UNDERGRADUATE = new Degree("本科", "005", "本科", 6);

    public static Degree GRADUATE = new Degree("硕士", "006", "硕士", 7);

    public static Degree DOCTOR = new Degree("博士", "007", "博士", 8);

    public static Degree OTHERS = new Degree("其他", "008", "其他", 9);

    private Degree(String key, String value, String description, int displayOrder) {
        super(key, value, description, displayOrder);
    }
}
