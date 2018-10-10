/*
Navicat MySQL Data Transfer

Source Server         : 192.168.1.100
Source Server Version : 50722
Source Host           : 192.168.1.100:3306
Source Database       : translation

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2018-10-10 11:14:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for dict_en_zhcn
-- ----------------------------
DROP TABLE IF EXISTS `dict_en_zhcn`;
CREATE TABLE `dict_en_zhcn` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `source` varchar(255) NOT NULL,
  `tran` varchar(255) NOT NULL,
  `example` varchar(255) DEFAULT NULL,
  `scene` varchar(255) DEFAULT NULL,
  `createUser` bigint(20) NOT NULL DEFAULT '0',
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updateUser` bigint(20) NOT NULL DEFAULT '0',
  `updateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `source_UNIQUE` (`source`),
  UNIQUE KEY `tran_UNIQUE` (`tran`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='英中对照表。';

-- ----------------------------
-- Records of dict_en_zhcn
-- ----------------------------
INSERT INTO `dict_en_zhcn` VALUES ('1', 'english', '英语', '英语', '使用英语', '1', '2018-09-12 19:15:22', '1', '2018-09-12 19:15:22');
INSERT INTO `dict_en_zhcn` VALUES ('2', 'english good', '英语好', '英语好', '使用英语好', '1', '2018-09-12 19:15:54', '1', '2018-09-12 19:18:44');
INSERT INTO `dict_en_zhcn` VALUES ('3', '7', '6', '7', '6', '0', '2018-09-28 17:07:49', '0', '2018-09-28 17:07:49');
INSERT INTO `dict_en_zhcn` VALUES ('4', 'ttt', '<p>dddee</p>', '<p>rrrr</p>', '<p>rrrr</p>', '0', '2018-09-29 09:23:14', '0', '2018-09-29 09:53:18');
INSERT INTO `dict_en_zhcn` VALUES ('6', 'gggg', '<ol><li><em>yyyyytttyy</em></li><li><em>tt</em></li></ol><p><em>yyyy</em></p>', '<p><a href=\"http://baidu.com\">kjdkldlkdlk</a></p>', '', '0', '2018-09-29 10:07:09', '0', '2018-09-29 10:07:09');
