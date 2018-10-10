package com.lummei.jobapp.protocol;

/**
 * 行业
 * @author songxincong
 */
public class Industry extends DataDictionary {

    private static final long serialVersionUID = 3229984289253472198L;

    public static Industry UNLIMITED = new Industry("不限", "UNLIMITED", "不限", 0);
    public static Industry INTERNET_PARENT = new Industry("互联网/IT/电子/通信", "100000", "互联网/IT/电子/通信", 1);
    public static Industry ELECTRONIC_COMMERCE = new Industry("电子商务", "100001", "电子商务", 11, "100000");
    public static Industry GAME = new Industry("游戏", "100002", "游戏", 12, "100000");
    public static Industry MEDIA = new Industry("媒体", "100003", "媒体", 13, "100000");
    public static Industry ADVERTISEMENT = new Industry("广告营销", "100004", "广告营销", 14, "100000");
    public static Industry DATA_SERVICE = new Industry("数据服务", "100005", "数据服务", 15, "100000");
    public static Industry HEALTHCARE = new Industry("医疗健康", "100006", "医疗健康", 16, "100000");
    public static Industry MEDICAL_HEALTH = new Industry("生活服务", "100007", "生活服务", 17, "100000");
    public static Industry O2O = new Industry("O2O", "100008", "O2O", 18, "100000");
    public static Industry TRAVEL = new Industry("旅游", "100009", "旅游", 19, "100000");
    public static Industry CLASSIFICATION = new Industry("分类信息", "100010", "分类信息", 110, "100000");
    public static Industry MUSIC = new Industry("音乐/视频/阅读", "100011", "音乐/视频/阅读", 111, "100000");
    public static Industry EDUCATION = new Industry("在线教育", "100012", "在线教育", 112, "100000");
    public static Industry SOCIAL_CONTACT = new Industry("社交网络", "100013", "社交网络", 113, "100000");
    public static Industry HUMAN_RESOURCES = new Industry("人力资源服务", "100014", "人力资源服务", 114, "100000");
    public static Industry COMPANY_SERVICE = new Industry("企业服务", "100015", "企业服务", 115, "100000");
    public static Industry INFORMATION_SAFETY = new Industry("信息安全", "100016", "信息安全", 116, "100000");
    public static Industry NEW_RETAIL = new Industry("新零售", "100017", "新零售", 117, "100000");
    public static Industry INTELLIGENT_HARDWARE = new Industry("智能硬件", "100018", "智能硬件", 118, "100000");
    public static Industry MOBILE_INTERNET = new Industry("移动互联网", "100019", "移动互联网", 119, "100000");
    public static Industry INTERNET = new Industry("互联网", "100020", "互联网", 120, "100000");
    public static Industry COMPUTER_SOFTWARE = new Industry("计算机软件", "100021", "计算机软件", 121, "100000");
    public static Industry COMPUTER_HARDWARE = new Industry("计算机硬件", "100022", "计算机硬件", 122, "100000");
    public static Industry COMPUTER_SERVICE = new Industry("计算机服务", "100023", "计算机服务", 123, "100000");
    public static Industry SIGNAL_COMMUNICATION = new Industry("通信/网络设备", "100024", "通信/网络设备", 124, "100000");
    public static Industry OPERATOR = new Industry("运营商/增值服务", "100025", "运营商/增值服务", 125, "100000");
    public static Industry ELECTRONICS = new Industry("电子/半导体/集成电路", "100026", "电子/半导体/集成电路", 126, "100000");
    public static Industry ADVERTISEMENT_MEDIA = new Industry("广告/传媒/文化/体育", "100100", "广告/传媒/文化/体育", 2);
    public static Industry PUBLIC_RELATIONS = new Industry("广告/公关/会展", "100101", "广告/公关/会展", 21, "100100");
    public static Industry JOURNALISM = new Industry("新闻/出版", "100102", "新闻/出版", 22, "100100");
    public static Industry RADIO_BROADCAST = new Industry("广播/影视", "100103", "广播/影视", 23, "100100");
    public static Industry CULTURE = new Industry("文化/体育/娱乐", "100104", "文化/体育/娱乐", 24, "100100");
    public static Industry FINANCE = new Industry("金融", "100200", "金融", 3);
    public static Industry BANK = new Industry("银行", "100201", "银行", 31, "100200");
    public static Industry INSURANCE = new Industry("保险", "100202", "保险", 32, "100200");
    public static Industry NEGOTIABLE_SECURITY = new Industry("证券/期货", "100203", "证券/期货", 33, "100200");
    public static Industry FUND = new Industry("基金", "100204", "基金", 34, "100200");
    public static Industry TRUST = new Industry("信托", "100205", "信托", 35, "100200");
    public static Industry ONLINE_FINANCE = new Industry("互联网金融", "100206", "互联网金融", 36, "100200");
    public static Industry INVERSTMENT = new Industry("投资/融资", "100207", "投资/融资", 37, "100200");
    public static Industry LEASE = new Industry("租赁/拍卖/典当/担保", "100208", "租赁/拍卖/典当/担保", 38, "100200");
    public static Industry TRAINING = new Industry("教育培训", "100300", "教育培训", 4);
    public static Industry PRESCHOOL_EDUCATION = new Industry("学前教育", "100301", "学前教育", 41, "100300");
    public static Industry UNIVERSITIES = new Industry("院校", "100302", "院校", 42, "100300");
    public static Industry TRAINING_INSTITUTION = new Industry("培训机构", "100303", "培训机构", 43, "100300");
    public static Industry LEARNING = new Industry("学术/科研", "100304", "学术/科研", 44, "100300");
    public static Industry MEDICAL_CARE = new Industry("制药/医疗", "100400", "制药/医疗", 5);
    public static Industry PHARMACY = new Industry("制药", "100401", "制药", 51, "100400");
    public static Industry NURSING = new Industry("医疗/护理/卫生", "100402", "医疗/护理/卫生", 52, "100400");
    public static Industry MEDICAL_EQUIPMENT = new Industry("医疗设备/器械", "100403", "医疗设备/器械", 53, "100400");
    public static Industry LOGISTICS = new Industry("交通/物流/贸易/零售", "100500", "交通/物流/贸易/零售", 6);
    public static Industry TRANSPORT = new Industry("交通/运输", "100501", "交通/运输", 61, "100500");
    public static Industry STORAGE = new Industry("物流/仓储", "100502", "物流/仓储", 62, "100500");
    public static Industry WHOLESALE = new Industry("批发/零售", "100503", "批发/零售", 63, "100500");
    public static Industry TRADE = new Industry("贸易/进出口", "100504", "贸易/进出口", 64, "100500");
    public static Industry PROFESSIONAL_SERVICE = new Industry("专业服务", "100600", "专业服务", 7);
    public static Industry CONSULTATION = new Industry("咨询", "100601", "咨询", 71, "100600");
    public static Industry LAW = new Industry("法律", "100602", "法律", 72, "100600");
    public static Industry TRANSLATE = new Industry("翻译", "100603", "翻译", 73, "100600");
    public static Industry HUMAN_RESOURCES_SERVICE = new Industry("人力资源服务", "100604", "人力资源服务", 74, "100600");
    public static Industry TAX = new Industry("财务/审计/税务", "100605", "财务/审计/税务", 75, "100600");
    public static Industry TESTING = new Industry("检测/认证", "100606", "检测/认证", 76, "100600");
    public static Industry PATENT = new Industry("专利/商标/知识产权", "100607", "专利/商标/知识产权", 77, "100600");
    public static Industry OTHER_PROFESSIONAL_SERVICE = new Industry("其他专业服务", "100608", "其他专业服务", 78, "100600");
    public static Industry REAL_ESTATE = new Industry("房地产/建筑", "100700", "房地产/建筑", 8);
    public static Industry ENGINEERING = new Industry("工程施工", "100702", "工程施工", 82, "100700");
    public static Industry ARCHITECTURAL_DESIGN = new Industry("建筑设计", "100703", "建筑设计", 83, "100700");
    public static Industry RENOVATION = new Industry("装修装饰", "100704", "装修装饰", 84, "100700");
    public static Industry BUILDING_MATERIAL = new Industry("建材", "100705", "建材", 85, "100700");
    public static Industry INTERMEDIARY = new Industry("地产经纪/中介", "100706", "地产经纪/中介", 86, "100700");
    public static Industry PROPERTY_SERVICE = new Industry("物业服务", "100707", "物业服务", 87, "100700");
    public static Industry CAR = new Industry("汽车", "100800", "汽车", 9);
    public static Industry CAR_PRODUCTION = new Industry("汽车生产", "100801", "汽车生产", 91, "100800");
    public static Industry AUTO_PARTS = new Industry("汽车零部件", "100802", "汽车零部件", 92, "100800");
    public static Industry POST_MARKET = new Industry("4S店/后市场", "100803", "4S店/后市场", 93, "100800");
    public static Industry MECHANICS = new Industry("机械/制造", "100900", "机械/制造", 10);
    public static Industry ELECTROMECHANICAL = new Industry("机械设备/机电/重工", "100901", "机械设备/机电/重工", 101, "100900");
    public static Industry INDUSTRIAL_AUTOMATION = new Industry("仪器仪表/工业自动化", "100902", "仪器仪表/工业自动化", 102, "100900");
    public static Industry MOULD = new Industry("原材料及加工/模具", "100903", "原材料及加工/模具", 103, "100900");
    public static Industry PRINTING = new Industry("印刷/包装/造纸", "100904", "印刷/包装/造纸", 104, "100900");
    public static Industry SHIP = new Industry("船舶/航空/航天", "100905", "船舶/航空/航天", 105, "100900");
    public static Industry CONSUMER_GOODS = new Industry("消费品", "101000", "消费品", 11);
    public static Industry FOOD = new Industry("食品/饮料/烟酒", "101001", "食品/饮料/烟酒", 111, "101000");
    public static Industry MAKE_UP = new Industry("日化", "101002", "日化", 112, "101000");
    public static Industry CLOTHING = new Industry("服装/纺织/皮革", "101003", "服装/纺织/皮革", 113, "101000");
    public static Industry FURNITURE = new Industry("家具/家电/家居", "101004", "家具/家电/家居", 114, "101000");
    public static Industry TOY = new Industry("玩具/礼品", "101005", "玩具/礼品", 115, "101000");
    public static Industry JEWELLERY = new Industry("珠宝/首饰", "101006", "珠宝/首饰", 116, "101000");
    public static Industry CRAFT = new Industry("工艺品/收藏品", "101007", "工艺品/收藏品", 117, "101000");
    public static Industry OFFICE_SUPPLIES = new Industry("办公用品及设备", "101008", "办公用品及设备", 118, "101000");
    public static Industry SERVICE = new Industry("服务业", "101100", "服务业", 12);
    public static Industry RESTAURANT = new Industry("餐饮", "101101", "餐饮", 121, "101100");
    public static Industry HOTEL = new Industry("酒店", "101102", "酒店", 122, "101100");
    public static Industry TRAVEL2 = new Industry("旅游", "101103", "旅游", 123, "101100");
    public static Industry COSMETOLOGY = new Industry("美容/美发", "101104", "美容/美发", 124, "101100");
    public static Industry PHOTOGRAPHY = new Industry("婚庆/摄影", "101105", "婚庆/摄影", 125, "101100");
    public static Industry OTHER_SERVICE = new Industry("其他服务业", "101106", "其他服务业", 126, "101100");
    public static Industry ENERGY = new Industry("能源/化工/环保", "101200", "能源/化工/环保", 13);
    public static Industry PETROLEUM = new Industry("石油/石化", "101201", "石油/石化", 131, "101200");
    public static Industry CHEMICAL = new Industry("化工", "101202", "化工", 132, "101200");
    public static Industry GEOLOGY = new Industry("矿产/地质", "101203", "矿产/地质", 133, "101200");
    public static Industry EXCAVATE = new Industry("采掘/冶炼", "101204", "采掘/冶炼", 134, "101200");
    public static Industry POWER = new Industry("电力/热力/燃气/水利", "101205", "电力/热力/燃气/水利", 135, "101200");
    public static Industry NEW_ENERGY = new Industry("新能源", "101206", "新能源", 136, "101200");
    public static Industry ENVIRONMENTAL_PROTECTION = new Industry("环保", "101207", "环保", 137, "101200");
    public static Industry GOVERNMENT = new Industry("政府/非盈利机构/其他", "101300", "政府/非盈利机构/其他", 14);
    public static Industry PUBLIC_SERVICE = new Industry("政府/公共事业", "101301", "政府/公共事业", 141, "101300");
    public static Industry NON_PROFIT_ORGANIZATION = new Industry("非盈利机构", "101302", "非盈利机构", 142, "101300");
    public static Industry AGRICULTURE = new Industry("农/林/牧/渔", "101303", "农/林/牧/渔", 143, "101300");
    public static Industry OTHERS = new Industry("其他行业", "101304", "其他行业", 144, "101300");

    private Industry(String key, String value, String description, int displayOrder) {
        super(key, value, description, displayOrder);
    }

    private Industry(String key, String value, String description, int displayOrder, String parentValue) {
        super(key, value, description, displayOrder, parentValue);
    }
}
