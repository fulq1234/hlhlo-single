/*
Navicat MySQL Data Transfer

Source Server         : 192.168.1.100
Source Server Version : 50722
Source Host           : 192.168.1.100:3306
Source Database       : knowledge

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2018-10-09 14:50:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for directory
-- ----------------------------
DROP TABLE IF EXISTS `directory`;
CREATE TABLE `directory` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `fatherid` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of directory
-- ----------------------------
INSERT INTO `directory` VALUES ('9', '词汇库', '0');
INSERT INTO `directory` VALUES ('11', 'FBA 概述及库存', '9');
INSERT INTO `directory` VALUES ('16', 'mat1', '11');
INSERT INTO `directory` VALUES ('18', 'sdfdfs', '11');
INSERT INTO `directory` VALUES ('20', '库存/订单', '9');
INSERT INTO `directory` VALUES ('22', 'FBA 订单', '9');
INSERT INTO `directory` VALUES ('23', '货件', '9');
INSERT INTO `directory` VALUES ('24', 'FBA 费用', '9');
INSERT INTO `directory` VALUES ('28', 'knowledge', '0');
INSERT INTO `directory` VALUES ('29', '新业务', '28');
INSERT INTO `directory` VALUES ('30', '包子铺', '28');
INSERT INTO `directory` VALUES ('31', 'Hot', '0');
INSERT INTO `directory` VALUES ('33', '重要流程', '31');
INSERT INTO `directory` VALUES ('34', 'case注意事项', '31');
INSERT INTO `directory` VALUES ('35', '相关流程', '28');
INSERT INTO `directory` VALUES ('36', 'IT', '0');
INSERT INTO `directory` VALUES ('37', '分类1', '36');
