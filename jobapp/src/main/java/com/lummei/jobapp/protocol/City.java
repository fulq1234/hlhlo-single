package com.lummei.jobapp.protocol;

/**
 * 城市
 * @author songxincong
 */
public class City extends DataDictionary {

    private static final long serialVersionUID = 6201635004619220573L;

    public static City CHINA = new City("全国", "China", "全国", 1);

    public static City BEIJING = new City("北京", "BEIJING", "北京", 2);

    public static City SHANGHAI = new City("上海", "SHANGHAI", "上海", 3);

    public static City HANGZHOU = new City("杭州", "HANGZHOU", "杭州", 4);

    public static City SHENZHEN = new City("深圳", "SHENZHEN", "深圳", 5);

    public static City GUANGZHOU = new City("广州", "GUANGZHOU", "广州", 6);

    public static City CHENGDU = new City("成都", "CHENGDU", "成都", 7);

    public static City NANJING = new City("南京", "NANJING", "南京", 8);

    public static City WUHAN = new City("武汉", "WUHAN", "武汉", 9);

    public static City TIANJIN = new City("天津", "TIANJIN", "天津", 10);

    public static City XIAN = new City("西安", "XIAN", "西安", 11);

    public static City SUZHOU = new City("苏州", "SUZHOU", "苏州", 12);

    public static City SHIJIAZHUANG = new City("石家庄", "SJZ", "石家庄", 13);

    private City(String key, String value, String description, int displayOrder) {
        super(key, value, description, displayOrder);
    }
}
