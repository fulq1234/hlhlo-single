/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50722
Source Host           : localhost:3306
Source Database       : hlhlo-job2

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2018-09-17 12:41:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for industryzhilian
-- ----------------------------
DROP TABLE IF EXISTS `industryzhilian`;
CREATE TABLE `industryzhilian` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `key` varchar(1000) DEFAULT NULL,
  `value` varchar(1000) DEFAULT NULL,
  `zlkey` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=83 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of industryzhilian
-- ----------------------------
INSERT INTO `industryzhilian` VALUES ('1', '通信/网络设备', null, '通信/电信/网络设备');
INSERT INTO `industryzhilian` VALUES ('2', '互联网/IT/电子/通信', null, '通信/电信运营');
INSERT INTO `industryzhilian` VALUES ('3', '运营商/增值服务', null, '增值服务');
INSERT INTO `industryzhilian` VALUES ('6', '证券/期货', null, '基金/证券/期货/投资');
INSERT INTO `industryzhilian` VALUES ('7', '房地产/建筑', null, '房地产/建筑/建材/工程');
INSERT INTO `industryzhilian` VALUES ('8', '媒体', null, '媒体/出版/影视/文化传播');
INSERT INTO `industryzhilian` VALUES ('9', '互联网/IT/电子/通信', null, '互联网/电子商务');
INSERT INTO `industryzhilian` VALUES ('10', '消费品', null, '耐用消费品（服饰/纺织/皮革/家具/家电）');
INSERT INTO `industryzhilian` VALUES ('11', '旅游', '101103', '旅游/度假');
INSERT INTO `industryzhilian` VALUES ('12', '其他行业', null, '其他');
INSERT INTO `industryzhilian` VALUES ('13', '医疗/护理/卫生', null, '医疗/护理/美容/保健/卫生服务');
INSERT INTO `industryzhilian` VALUES ('15', '游戏', null, '网络游戏');
INSERT INTO `industryzhilian` VALUES ('16', '地产经纪/中介', null, '中介服务');
INSERT INTO `industryzhilian` VALUES ('17', '教育培训', null, '教育/培训/院校');
INSERT INTO `industryzhilian` VALUES ('18', '数据服务', null, 'IT服务(系统/数据/维护)');
INSERT INTO `industryzhilian` VALUES ('19', '广告/公关/会展', null, '广告/会展/公关');
INSERT INTO `industryzhilian` VALUES ('20', '家具/家电/家居', null, '家居/室内设计/装饰装潢');
INSERT INTO `industryzhilian` VALUES ('21', '物业服务', null, '物业管理/商业中心');
INSERT INTO `industryzhilian` VALUES ('22', '租赁/拍卖/典当/担保', null, '租赁服务');
INSERT INTO `industryzhilian` VALUES ('23', '酒店', null, '酒店/餐饮');
INSERT INTO `industryzhilian` VALUES ('24', '检测/认证', null, '检验/检测/认证');
INSERT INTO `industryzhilian` VALUES ('26', '电子/半导体/集成电路', null, '电子技术/半导体/集成电路');
INSERT INTO `industryzhilian` VALUES ('27', '消费品', null, '快速消费品（食品/饮料/烟酒/日化）');
INSERT INTO `industryzhilian` VALUES ('28', '人力资源服务', '100604', '专业服务/咨询(财会/法律/人力资源等)');
INSERT INTO `industryzhilian` VALUES ('29', '文化/体育/娱乐', null, '娱乐/体育/休闲');
INSERT INTO `industryzhilian` VALUES ('31', '玩具/礼品', null, '医药/生物工程');
INSERT INTO `industryzhilian` VALUES ('34', '政府/公共事业', null, '政府/公共事业/非盈利机构');
INSERT INTO `industryzhilian` VALUES ('35', '机械设备/机电/重工', null, '大型设备/机电设备/重工业');
INSERT INTO `industryzhilian` VALUES ('36', '计算机服务', null, '外包服务');
INSERT INTO `industryzhilian` VALUES ('37', '石油/石化', null, '石油/石化/化工');
INSERT INTO `industryzhilian` VALUES ('38', '批发/零售', null, '零售/批发');
INSERT INTO `industryzhilian` VALUES ('42', '租赁/拍卖/典当/担保', null, '信托/担保/拍卖/典当');
INSERT INTO `industryzhilian` VALUES ('45', '汽车', '100800', '汽车/摩托车');
INSERT INTO `industryzhilian` VALUES ('76', '玩具/礼品', null, '礼品/玩具/工艺美术/收藏品/奢侈品');
INSERT INTO `industryzhilian` VALUES ('77', '原材料及加工/模具', null, '加工制造（原料加工/模具）');
INSERT INTO `industryzhilian` VALUES ('78', '其他行业', null, '跨领域经营');
INSERT INTO `industryzhilian` VALUES ('79', '电力/热力/燃气/水利', null, '电气/电力/水利');
INSERT INTO `industryzhilian` VALUES ('80', '船舶/航空/航天', null, '航空/航天研究与制造');
INSERT INTO `industryzhilian` VALUES ('81', '采掘/冶炼', null, '能源/矿产/采掘/冶炼');
INSERT INTO `industryzhilian` VALUES ('82', '仪器仪表/工业自动化', null, '仪器仪表及工业自动化');
