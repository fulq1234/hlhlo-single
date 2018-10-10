package com.lummei.jobapp.protocol;

/**
 * 薪资
 * @author songxincong
 */
public class Salary extends DataDictionary {

    private static final long serialVersionUID = 6233816280267500339L;

    public static Salary LESS_ONE = new Salary("1k以下", "001", "1k以下", 1);

    public static Salary ONE2TWO = new Salary("1k-2k", "002", "1k-2k", 2);

    public static Salary TOW2FOUR = new Salary("2k-4k", "003", "2k-4k", 3);

    public static Salary FOUR2SIX = new Salary("4k-6k", "004", "4k-6k", 4);

    public static Salary SIX2EIGHT = new Salary("6k-8k", "005", "6k-8k", 5);

    public static Salary EIGHT2TEN = new Salary("8k-10k", "006", "8k-10k", 6);

    public static Salary TEN2FIFTEEN = new Salary("10k-15k", "007", "10k-15k", 7);

    public static Salary MORE_FIFTEEN = new Salary("15k以上", "008", "15k以上", 8);

    private Salary(String key, String value, String description, int displayOrder) {
        super(key, value, description, displayOrder);
    }
}
