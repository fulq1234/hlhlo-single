/*
Navicat MySQL Data Transfer

Source Server         : 192.168.1.100
Source Server Version : 50722
Source Host           : 192.168.1.100:3306
Source Database       : hlhlo-job

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2018-09-17 17:57:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for careerobjective
-- ----------------------------
DROP TABLE IF EXISTS `careerobjective`;
CREATE TABLE `careerobjective` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '意向标识',
  `resumeId` bigint(20) NOT NULL COMMENT '简历标识',
  `desiredType` varchar(10) DEFAULT NULL COMMENT '工作性质',
  `function` varchar(10) DEFAULT NULL COMMENT '期望职位',
  `industry` varchar(20) DEFAULT NULL COMMENT '期望行业',
  `location` varchar(10) DEFAULT NULL COMMENT '工作城市',
  `salary` varchar(10) DEFAULT NULL COMMENT '薪资要求',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COMMENT='求职意向';

-- ----------------------------
-- Records of careerobjective
-- ----------------------------
INSERT INTO `careerobjective` VALUES ('1', '1', 'string', 'string', 'string', 'string', 'string');
INSERT INTO `careerobjective` VALUES ('2', '1', null, '全栈工程师', '电子商务,互联网', '石家庄', '5k-6k');
INSERT INTO `careerobjective` VALUES ('5', '2', null, '846', '100015,100007,100002', 'HIGH', 'FOUR2SIX');
INSERT INTO `careerobjective` VALUES ('6', '4', null, '464', '100008,100022,100026', 'BEIJING', 'UNDER_ONE');
INSERT INTO `careerobjective` VALUES ('7', '5', null, '661', '100021', 'SHANGHAI', 'FOUR2SIX');
INSERT INTO `careerobjective` VALUES ('8', '8', null, '2182', '100021', 'BEIJING', 'EIGHT2TEN');
INSERT INTO `careerobjective` VALUES ('9', '11', null, '15', '100012', 'SHANGHAI', 'UNDER_ONE');
INSERT INTO `careerobjective` VALUES ('10', '12', null, '2148', '100023', 'BEIJING', 'UNDER_ONE');
INSERT INTO `careerobjective` VALUES ('11', '13', null, '463', '100020', 'SHANGHAI', 'UNDER_ONE');
INSERT INTO `careerobjective` VALUES ('14', '14', null, '662', '100003,100015,100001', 'SHANGHAI', 'TOW2FOUR');
INSERT INTO `careerobjective` VALUES ('16', '15', null, '759', '100021', 'BEIJING', 'UNDER_ONE');
INSERT INTO `careerobjective` VALUES ('17', '16', null, '2040', '100006', 'SHANGHAI', '001');

-- ----------------------------
-- Table structure for certificate
-- ----------------------------
DROP TABLE IF EXISTS `certificate`;
CREATE TABLE `certificate` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '证书标识',
  `resumeid` bigint(20) NOT NULL COMMENT '简历标识',
  `certName` varchar(240) NOT NULL COMMENT '证书名称',
  `certFile` longtext COMMENT '证书附件',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='证书';

-- ----------------------------
-- Records of certificate
-- ----------------------------

-- ----------------------------
-- Table structure for company
-- ----------------------------
DROP TABLE IF EXISTS `company`;
CREATE TABLE `company` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '企业标识',
  `companyName` varchar(240) NOT NULL COMMENT '企业名称',
  `abbr` varchar(240) DEFAULT NULL COMMENT '公司简称',
  `industry` varchar(10) DEFAULT NULL COMMENT '所属行业',
  `finance` varchar(10) DEFAULT NULL COMMENT '融资阶段',
  `scale` varchar(10) DEFAULT NULL COMMENT '人员规模',
  `website` varchar(140) DEFAULT NULL COMMENT '公司官网',
  `info` varchar(1000) DEFAULT NULL COMMENT '公司简介',
  `nation` varchar(10) DEFAULT NULL COMMENT '所在国家',
  `province` varchar(10) DEFAULT NULL COMMENT '所在省',
  `city` varchar(10) DEFAULT NULL COMMENT '所在市',
  `district` varchar(10) DEFAULT NULL COMMENT '所在区',
  `address` varchar(240) DEFAULT NULL COMMENT '工作地点',
  `lng` decimal(20,17) DEFAULT NULL COMMENT '经度',
  `lat` decimal(20,17) DEFAULT NULL COMMENT '纬度',
  `logo` varchar(255) DEFAULT NULL COMMENT '公司logo',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='企业';

-- ----------------------------
-- Records of company
-- ----------------------------
INSERT INTO `company` VALUES ('1', '石家庄海伦人力资源有限公司', '海伦人力', '100022', 'ANGEL', 'LESS_1000', 'sina.c', 'fdsfsdfsdfsdfsd', '中国', '河北省', '石家庄市', '裕华区', '万达写字楼A座16楼', null, null, 'http://192.168.1.47/api/images/6bf83c9d-9371-4737-ba56-d665c9e9d971wxd538da45d1e5f0d1.o6zAJsw5dIe7OlqjaeQTP9ZABJig.nzvIfyFvmNnFe1cf494137659c7dfbd6e1d824ffb42e.png');
INSERT INTO `company` VALUES ('2', 'dddd', 'dd', '100022', 'NULL', 'LESS_20', '111', '111', null, null, null, null, null, null, null, null);
INSERT INTO `company` VALUES ('3', 'sfdf', 'sf', '100015', 'B', 'LESS_20', null, null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for education
-- ----------------------------
DROP TABLE IF EXISTS `education`;
CREATE TABLE `education` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '教育标识',
  `resumeid` bigint(20) NOT NULL COMMENT '简历标识',
  `startDate` date NOT NULL COMMENT '开始日期',
  `endDate` date NOT NULL COMMENT '结束日期',
  `school` varchar(240) NOT NULL COMMENT '学校名称',
  `major` varchar(45) NOT NULL COMMENT '专业名称',
  `degree` varchar(45) NOT NULL COMMENT '学历',
  `eduType` varchar(45) DEFAULT NULL COMMENT '教育类型',
  `schoolExp` varchar(300) DEFAULT NULL COMMENT '在校经历',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='教育经历';

-- ----------------------------
-- Records of education
-- ----------------------------
INSERT INTO `education` VALUES ('1', '1', '2015-01-01', '2019-01-01', '清华大学', '会计', '本科', null, '在校学习会计知识\n获得一等奖');
INSERT INTO `education` VALUES ('3', '2', '2013-01-01', '2014-01-01', 'aaaa', 'cccc', 'SPECIALTY', null, 'dddddddddd');
INSERT INTO `education` VALUES ('4', '4', '2018-01-01', '2018-01-01', 'sfsfsd', 'fdfdfd', 'UNLIMITED', null, 'agvxcvxcvxc');
INSERT INTO `education` VALUES ('5', '5', '2018-01-01', '2018-01-01', 'aaaaa', 'dfdfd', 'SPECIALTY', null, 'fdsfsfsdf');
INSERT INTO `education` VALUES ('6', '8', '1990-01-01', '1997-01-01', '仅供', '你你你', 'GRADUATE', null, 'ing明敏');
INSERT INTO `education` VALUES ('7', '11', '2018-01-01', '2018-01-01', 'fdfd', 'dfdf', 'UNLIMITED', null, 'fdfdfd');
INSERT INTO `education` VALUES ('8', '12', '2018-01-01', '2018-01-01', 'ddddd', 'ssssss', 'UNLIMITED', null, 'ccccccccccccc');
INSERT INTO `education` VALUES ('9', '13', '2018-01-01', '2018-01-01', '2222', '444', 'HIGH', null, '55555');
INSERT INTO `education` VALUES ('11', '14', '2018-01-01', '2019-01-01', 'fdf', 'dfdfd', 'SPECIALTY', null, 'gfgfgfg\nsfgdgdf');
INSERT INTO `education` VALUES ('12', '15', '2018-01-01', '2018-01-01', 'sdfd', 'vbvb', 'HIGH', null, 'hghfghfgh');

-- ----------------------------
-- Table structure for hrinfo
-- ----------------------------
DROP TABLE IF EXISTS `hrinfo`;
CREATE TABLE `hrinfo` (
  `id` bigint(20) NOT NULL COMMENT '招聘者标识',
  `companyId` bigint(20) DEFAULT NULL COMMENT '所在公司',
  `position` varchar(12) DEFAULT NULL COMMENT '我的职务',
  `hrStatus` varchar(20) DEFAULT NULL COMMENT 'HR认证状态',
  `teamInfo` varchar(140) DEFAULT NULL COMMENT '团队介绍',
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='招聘者信息';

-- ----------------------------
-- Records of hrinfo
-- ----------------------------
INSERT INTO `hrinfo` VALUES ('3', '1', 'HR', '004', '创业团队', null);
INSERT INTO `hrinfo` VALUES ('9', '1', 'HR', '004', '创业团队', '123');
INSERT INTO `hrinfo` VALUES ('25', '1', 'hr', '004', null, null);
INSERT INTO `hrinfo` VALUES ('28', '1', '33', '004', null, null);
INSERT INTO `hrinfo` VALUES ('29', '1', '111', '004', null, null);
INSERT INTO `hrinfo` VALUES ('30', '1', '开发人员', '004', null, null);
INSERT INTO `hrinfo` VALUES ('31', '1', '1111', '004', null, null);
INSERT INTO `hrinfo` VALUES ('32', null, null, null, null, null);
INSERT INTO `hrinfo` VALUES ('33', '1', 'fdgb', '004', null, null);
INSERT INTO `hrinfo` VALUES ('34', '1', '22', '004', null, null);
INSERT INTO `hrinfo` VALUES ('35', null, null, '004', null, null);
INSERT INTO `hrinfo` VALUES ('36', '1', 'dfdfd', '004', null, null);

-- ----------------------------
-- Table structure for im_history
-- ----------------------------
DROP TABLE IF EXISTS `im_history`;
CREATE TABLE `im_history` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '消息记录标识',
  `from_account` varchar(20) NOT NULL COMMENT '发送方账号',
  `to_account` varchar(20) NOT NULL COMMENT '接受方账号',
  `msg_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '发送消息时间',
  `msg_seq` bigint(20) DEFAULT NULL,
  `msg_random` bigint(20) DEFAULT NULL,
  `msg_type` varchar(20) NOT NULL,
  `msg_content` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of im_history
-- ----------------------------
INSERT INTO `im_history` VALUES ('1', 'JOB_34', 'HR_3', '2018-09-08 08:00:00', '12345566', '123455345', 'TIMTextElem', '213');
INSERT INTO `im_history` VALUES ('2', 'HR_4', 'JOB_34', '1970-01-19 02:46:33', '2088357501', '555107444', 'TIMTextElem', '你是个**');
INSERT INTO `im_history` VALUES ('3', 'HR_3', 'JOB_34', '1970-01-19 02:46:34', '2088357501', '555107444', 'TIMTextElem', '你是个**');
INSERT INTO `im_history` VALUES ('4', 'HR_3', 'JOB_34', '1970-01-19 02:46:35', '229436543', '1805341073', 'TIMTextElem', '你有病啊');
INSERT INTO `im_history` VALUES ('5', 'HR_33', 'JOB_30', '1970-01-19 02:46:40', '229436543', '1805341073', 'TIMTextElem', '你有病啊');
INSERT INTO `im_history` VALUES ('6', 'HR_33', 'JOB_30', '1970-01-19 02:46:40', '229436543', '1805341073', 'TIMTextElem', '你有病啊');

-- ----------------------------
-- Table structure for im_monitored
-- ----------------------------
DROP TABLE IF EXISTS `im_monitored`;
CREATE TABLE `im_monitored` (
  `user_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of im_monitored
-- ----------------------------

-- ----------------------------
-- Table structure for jobseeker
-- ----------------------------
DROP TABLE IF EXISTS `jobseeker`;
CREATE TABLE `jobseeker` (
  `id` bigint(20) NOT NULL COMMENT '个人标识',
  `jobStatus` varchar(10) DEFAULT NULL COMMENT '求职状态',
  `startWorkTime` date DEFAULT NULL COMMENT '参加工作时间',
  `marriage` varchar(10) DEFAULT NULL COMMENT '婚姻状况',
  `degree` varchar(10) DEFAULT NULL COMMENT '学历',
  `city` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='求职者信息';

-- ----------------------------
-- Records of jobseeker
-- ----------------------------
INSERT INTO `jobseeker` VALUES ('4', 'ALL_TIME', '2014-08-01', '已婚', '本科', 'SHANGHAI');
INSERT INTO `jobseeker` VALUES ('9', 'ALL_TIME', '2018-08-01', null, null, 'SHANGHAI');
INSERT INTO `jobseeker` VALUES ('19', null, null, null, null, null);
INSERT INTO `jobseeker` VALUES ('28', '在职 - 月内到岗', '2018-09-01', null, null, 'GUANGZHOU');
INSERT INTO `jobseeker` VALUES ('29', '离职 - 随时到岗', '2018-09-01', null, null, 'WUHAN');
INSERT INTO `jobseeker` VALUES ('30', 'ALL_TIME', '2018-09-13', null, null, 'WUHAN');
INSERT INTO `jobseeker` VALUES ('31', 'NO', '2018-09-01', null, null, 'WUHAN');
INSERT INTO `jobseeker` VALUES ('32', null, null, null, null, null);
INSERT INTO `jobseeker` VALUES ('33', '在职 - 月内到岗', '2018-09-01', null, null, 'SHANGHAI');
INSERT INTO `jobseeker` VALUES ('34', null, null, null, null, null);
INSERT INTO `jobseeker` VALUES ('35', null, null, null, null, null);
INSERT INTO `jobseeker` VALUES ('36', '001', '2018-09-01', null, null, 'SUZHOU');

-- ----------------------------
-- Table structure for oauth_client_details
-- ----------------------------
DROP TABLE IF EXISTS `oauth_client_details`;
CREATE TABLE `oauth_client_details` (
  `client_id` varchar(48) NOT NULL,
  `resource_ids` varchar(256) DEFAULT NULL,
  `client_secret` varchar(256) DEFAULT NULL,
  `scope` varchar(256) DEFAULT NULL,
  `authorized_grant_types` varchar(256) DEFAULT NULL,
  `web_server_redirect_uri` varchar(256) DEFAULT NULL,
  `authorities` varchar(256) DEFAULT NULL,
  `access_token_validity` int(11) DEFAULT NULL,
  `refresh_token_validity` int(11) DEFAULT NULL,
  `additional_information` varchar(4096) DEFAULT NULL,
  `autoapprove` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`client_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of oauth_client_details
-- ----------------------------
INSERT INTO `oauth_client_details` VALUES ('app', null, '{noop}app', 'app', 'password,refresh_token', null, null, null, null, null, null);
INSERT INTO `oauth_client_details` VALUES ('webApp', null, '{noop}webApp', 'app', 'authorization_code,password,refresh_token,client_credentials', null, null, null, null, null, null);

-- ----------------------------
-- Table structure for pic
-- ----------------------------
DROP TABLE IF EXISTS `pic`;
CREATE TABLE `pic` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '图片标识',
  `picType` varchar(20) NOT NULL COMMENT '图片类型',
  `picUrl` varchar(140) NOT NULL COMMENT '图片地址',
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8 COMMENT='图片';

-- ----------------------------
-- Records of pic
-- ----------------------------
INSERT INTO `pic` VALUES ('1', 'BUSINESS_CARD', '/images/eaf72826-c65a-4076-9a7f-63822eab9346wxce4e31f14994603d.o6zAJsw5dIe7OlqjaeQTP9ZABJig.xANSSBxiqwIhdd12a09cbbf73bdfe44697eb5150c850.png', '2018-09-05 16:53:46');
INSERT INTO `pic` VALUES ('2', 'BUSINESS_CARD', '/images/82a8eded-093f-49aa-994d-1cc664af7102wxce4e31f14994603d.o6zAJsw5dIe7OlqjaeQTP9ZABJig.aIge31uaFTMPdd12a09cbbf73bdfe44697eb5150c850.png', '2018-09-05 16:54:08');
INSERT INTO `pic` VALUES ('3', 'BUSINESS_CARD', '/images/0341f0fe-ae58-4373-9126-876496c19381wxce4e31f14994603d.o6zAJsw5dIe7OlqjaeQTP9ZABJig.MWeOMVWnIcnhdd12a09cbbf73bdfe44697eb5150c850.png', '2018-09-05 16:58:28');
INSERT INTO `pic` VALUES ('4', 'BUSINESS_CARD', '/images/9213677b-51f1-4edb-9c7f-e3e81b023baawxce4e31f14994603d.o6zAJsw5dIe7OlqjaeQTP9ZABJig.1C4hDaCYnPAbdd12a09cbbf73bdfe44697eb5150c850.png', '2018-09-05 16:59:41');
INSERT INTO `pic` VALUES ('5', 'BUSINESS_CARD', '/images/cc14abb1-6cb5-4406-ac8a-e427835b0306wxce4e31f14994603d.o6zAJsw5dIe7OlqjaeQTP9ZABJig.AJZ5eKjzCcQDdd12a09cbbf73bdfe44697eb5150c850.png', '2018-09-05 17:01:52');
INSERT INTO `pic` VALUES ('6', 'BUSINESS_CARD', '/images/1639e92f-30f2-4885-b859-8023aaa63b3bwxce4e31f14994603d.o6zAJsw5dIe7OlqjaeQTP9ZABJig.ZZbxPxFzLTOTdd12a09cbbf73bdfe44697eb5150c850.png', '2018-09-06 11:59:18');
INSERT INTO `pic` VALUES ('7', 'BUSINESS_CARD', '/images/62c85139-1385-40b3-812c-81a0b2ce499dwxce4e31f14994603d.o6zAJsw5dIe7OlqjaeQTP9ZABJig.RFBXPHKPh9wsdd12a09cbbf73bdfe44697eb5150c850.png', '2018-09-06 12:35:05');
INSERT INTO `pic` VALUES ('8', 'BUSINESS_CARD', '/images/544ca6e6-07d5-4f94-825f-7b425993bee3wxce4e31f14994603d.o6zAJsw5dIe7OlqjaeQTP9ZABJig.DmHSxSGV9UqKdd12a09cbbf73bdfe44697eb5150c850.png', '2018-09-06 12:35:36');
INSERT INTO `pic` VALUES ('9', 'BUSINESS_CARD', '/images/3a9bff0b-d7ea-46cc-a8dc-138ba3457653wxce4e31f14994603d.o6zAJsw5dIe7OlqjaeQTP9ZABJig.unV1eGZDrCeIdd12a09cbbf73bdfe44697eb5150c850.png', '2018-09-06 13:19:40');
INSERT INTO `pic` VALUES ('10', 'BUSINESS_CARD', '/images/eea64c97-689f-4f00-baa4-c3b96d7c3e54wxce4e31f14994603d.o6zAJsw5dIe7OlqjaeQTP9ZABJig.a59e0UC1CszDdd12a09cbbf73bdfe44697eb5150c850.png', '2018-09-06 14:48:58');
INSERT INTO `pic` VALUES ('11', 'LOGO', '/images/2b1b9fbb-1ce9-49e7-bebc-2bf8c049dd0awxce4e31f14994603d.o6zAJsw5dIe7OlqjaeQTP9ZABJig.2g8VPp6FFZvkdd12a09cbbf73bdfe44697eb5150c850.png', '2018-09-06 16:21:16');
INSERT INTO `pic` VALUES ('12', 'LOGO', '/images/fcdc2556-341f-4d7a-93f1-09fa6474d11bwxce4e31f14994603d.o6zAJsw5dIe7OlqjaeQTP9ZABJig.OndslmFXPJgR4d10415ce1f7fce4e3dd144fa0cfe84e.png', '2018-09-07 10:20:44');
INSERT INTO `pic` VALUES ('13', 'LOGO', '/images/a1e46823-adfc-4511-ad9b-722e7580cb8cwxce4e31f14994603d.o6zAJsw5dIe7OlqjaeQTP9ZABJig.TeSMUHH68RLY4d10415ce1f7fce4e3dd144fa0cfe84e.png', '2018-09-07 10:22:51');
INSERT INTO `pic` VALUES ('14', 'LOGO', '/images/a37e0fa1-7a21-4bdd-90cf-b725309f4571wxce4e31f14994603d.o6zAJsw5dIe7OlqjaeQTP9ZABJig.Yf0yNJTPcUdt4d10415ce1f7fce4e3dd144fa0cfe84e.png', '2018-09-07 10:25:33');
INSERT INTO `pic` VALUES ('15', 'LOGO', '/images/d5cc3b07-cab4-41ce-b618-2cd7bbf0e773wxce4e31f14994603d.o6zAJsw5dIe7OlqjaeQTP9ZABJig.eoWpdZNc3T9e4d10415ce1f7fce4e3dd144fa0cfe84e.png', '2018-09-07 10:30:18');
INSERT INTO `pic` VALUES ('16', 'LOGO', '/images/24febc9c-58fe-481d-8e93-baf0a8df8d7fwxce4e31f14994603d.o6zAJsw5dIe7OlqjaeQTP9ZABJig.obOx3axRgrHTdd12a09cbbf73bdfe44697eb5150c850.png', '2018-09-07 10:33:24');
INSERT INTO `pic` VALUES ('17', 'LOGO', '/images/23539402-2f46-476d-80d2-eb314fa65e0fwxce4e31f14994603d.o6zAJsw5dIe7OlqjaeQTP9ZABJig.zMCoqLBWKlrN0bfb9630dff05e851a9e43748c760467.jpg', '2018-09-07 10:33:38');
INSERT INTO `pic` VALUES ('18', 'LOGO', '/images/4816d5a6-ca34-45fc-8f0c-42fba760c937wxce4e31f14994603d.o6zAJsw5dIe7OlqjaeQTP9ZABJig.isVTGlODsVQh0bfb9630dff05e851a9e43748c760467.jpg', '2018-09-07 11:09:37');
INSERT INTO `pic` VALUES ('19', 'BUSINESS_CARD', '/images/40e1abf1-91e7-43f2-9b77-7483d806db00wxd538da45d1e5f0d1.o6zAJsw5dIe7OlqjaeQTP9ZABJig.razTqeDGlTFM4d10415ce1f7fce4e3dd144fa0cfe84e.png', '2018-09-07 17:03:24');
INSERT INTO `pic` VALUES ('20', 'BUSINESS_CARD', '/images/514a7f8a-0e1d-4378-8e93-cd56f522aaa0wxd538da45d1e5f0d1.o6zAJsw5dIe7OlqjaeQTP9ZABJig.LulnrxYMSHno0bfb9630dff05e851a9e43748c760467.jpg', '2018-09-10 09:54:02');
INSERT INTO `pic` VALUES ('21', 'BUSINESS_CARD', '/images/1942a6f9-1b3f-4b87-b181-8af52d8ba58ewxd538da45d1e5f0d1.o6zAJsw5dIe7OlqjaeQTP9ZABJig.NBl2WQVNzdFP37890979327ee8a3ae0fd9a190a64d0e.png', '2018-09-10 10:56:50');
INSERT INTO `pic` VALUES ('22', 'BUSINESS_CARD', '/images/c8e85740-0e7f-4f4b-89be-b13ad8b415c8wxd538da45d1e5f0d1.o6zAJsw5dIe7OlqjaeQTP9ZABJig.2OCg5c5QiTqa37890979327ee8a3ae0fd9a190a64d0e.png', '2018-09-10 14:26:45');
INSERT INTO `pic` VALUES ('23', 'LOGO', '/images/6bf83c9d-9371-4737-ba56-d665c9e9d971wxd538da45d1e5f0d1.o6zAJsw5dIe7OlqjaeQTP9ZABJig.nzvIfyFvmNnFe1cf494137659c7dfbd6e1d824ffb42e.png', '2018-09-11 13:44:41');
INSERT INTO `pic` VALUES ('24', 'BUSINESS_CARD', '/images/15368202223204bd47afe95324518ac07e271b3065558.png', '2018-09-13 14:30:22');
INSERT INTO `pic` VALUES ('25', 'BUSINESS_CARD', '/images/153683090674870e9884eb1234a29aef2e1500cfc9704.png', '2018-09-13 17:28:27');
INSERT INTO `pic` VALUES ('26', 'BUSINESS_CARD', '/images/153683180280724bebcb0163541c988cae8f445d199f6.jpg', '2018-09-13 17:43:23');
INSERT INTO `pic` VALUES ('27', '001', '/images/1536908162514291ac587831f4c01b1f2d9fb02910622.png', '2018-09-14 14:56:03');

-- ----------------------------
-- Table structure for picmap
-- ----------------------------
DROP TABLE IF EXISTS `picmap`;
CREATE TABLE `picmap` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '图片映射标识',
  `picType` varchar(20) NOT NULL COMMENT '图片类型',
  `picId` bigint(20) NOT NULL COMMENT '图片标识',
  `mapId` bigint(20) NOT NULL COMMENT '映射标识',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8 COMMENT='图片映射表';

-- ----------------------------
-- Records of picmap
-- ----------------------------
INSERT INTO `picmap` VALUES ('1', 'BUSINESS_CARD', '1', '9');
INSERT INTO `picmap` VALUES ('2', 'BUSINESS_CARD', '2', '9');
INSERT INTO `picmap` VALUES ('3', 'BUSINESS_CARD', '3', '9');
INSERT INTO `picmap` VALUES ('4', 'BUSINESS_CARD', '4', '9');
INSERT INTO `picmap` VALUES ('5', 'BUSINESS_CARD', '5', '9');
INSERT INTO `picmap` VALUES ('6', 'BUSINESS_CARD', '6', '9');
INSERT INTO `picmap` VALUES ('7', 'BUSINESS_CARD', '7', '9');
INSERT INTO `picmap` VALUES ('8', 'BUSINESS_CARD', '8', '9');
INSERT INTO `picmap` VALUES ('9', 'BUSINESS_CARD', '9', '9');
INSERT INTO `picmap` VALUES ('10', 'BUSINESS_CARD', '10', '9');
INSERT INTO `picmap` VALUES ('11', 'LOGO', '11', '2');
INSERT INTO `picmap` VALUES ('12', 'LOGO', '12', '1');
INSERT INTO `picmap` VALUES ('13', 'LOGO', '13', '1');
INSERT INTO `picmap` VALUES ('14', 'LOGO', '14', '1');
INSERT INTO `picmap` VALUES ('15', 'LOGO', '15', '1');
INSERT INTO `picmap` VALUES ('16', 'LOGO', '16', '1');
INSERT INTO `picmap` VALUES ('17', 'LOGO', '17', '1');
INSERT INTO `picmap` VALUES ('18', 'LOGO', '18', '1');
INSERT INTO `picmap` VALUES ('19', 'BUSINESS_CARD', '19', '25');
INSERT INTO `picmap` VALUES ('20', 'BUSINESS_CARD', '20', '28');
INSERT INTO `picmap` VALUES ('21', 'BUSINESS_CARD', '21', '29');
INSERT INTO `picmap` VALUES ('22', 'BUSINESS_CARD', '22', '31');
INSERT INTO `picmap` VALUES ('23', 'LOGO', '23', '1');
INSERT INTO `picmap` VALUES ('24', 'BUSINESS_CARD', '24', '33');
INSERT INTO `picmap` VALUES ('25', 'BUSINESS_CARD', '25', '34');
INSERT INTO `picmap` VALUES ('26', 'BUSINESS_CARD', '26', '30');
INSERT INTO `picmap` VALUES ('27', '001', '27', '36');

-- ----------------------------
-- Table structure for position
-- ----------------------------
DROP TABLE IF EXISTS `position`;
CREATE TABLE `position` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '职位标识',
  `companyId` bigint(20) NOT NULL COMMENT '企业标识',
  `userId` bigint(20) NOT NULL COMMENT '用户标识',
  `positionType` varchar(10) DEFAULT NULL COMMENT '职位类型',
  `positionName` varchar(40) NOT NULL COMMENT '职位名称',
  `nation` varchar(10) DEFAULT NULL COMMENT '所在国家',
  `province` varchar(10) DEFAULT NULL COMMENT '所在省',
  `city` varchar(20) DEFAULT NULL COMMENT '所在市',
  `district` varchar(10) DEFAULT NULL COMMENT '所在区',
  `address` varchar(240) DEFAULT NULL COMMENT '工作地点',
  `lng` decimal(20,17) DEFAULT NULL COMMENT '经度',
  `lat` decimal(20,17) DEFAULT NULL COMMENT '纬度',
  `jobType` varchar(10) DEFAULT NULL COMMENT '工作性质',
  `skill` varchar(10) DEFAULT NULL COMMENT '技能要求',
  `salary` varchar(20) DEFAULT NULL COMMENT '薪资范围',
  `experience` varchar(10) DEFAULT NULL COMMENT '经验要求',
  `degree` varchar(10) DEFAULT NULL COMMENT '最低学历',
  `positionDetail` varchar(1600) DEFAULT NULL COMMENT '职位描述',
  `status` varchar(20) DEFAULT NULL COMMENT '职位状态',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `submitTime` datetime DEFAULT NULL COMMENT '提交时间',
  `publishTime` datetime DEFAULT NULL COMMENT '发布时间',
  `refreshTime` datetime DEFAULT NULL COMMENT '刷新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COMMENT='职位';

-- ----------------------------
-- Records of position
-- ----------------------------
INSERT INTO `position` VALUES ('1', '1', '3', null, 'java高级工程师', null, null, '石家庄', null, '万达A座写字楼16楼', null, null, '全职', 'java,数据库', '006', 'THREE2FIVE', 'SPECIALTY', '精通java', '004', null, null, '2018-08-10 16:34:39', null);
INSERT INTO `position` VALUES ('2', '1', '3', '', 'java高级工程师', null, null, '北京', null, '万达A座写字楼16楼', null, null, '全职', 'java,数据库', '006', 'THREE2FIVE', 'SPECIALTY', '精通java', '004', '2018-08-20 10:39:37', '2018-08-20 10:39:43', '2018-08-10 16:34:39', '2018-08-20 10:39:49');
INSERT INTO `position` VALUES ('3', '1', '3', '', 'java高级工程师', null, null, '北京', null, '万达A座写字楼16楼', null, null, '全职', 'java,数据库', '006', 'THREE2FIVE', 'SPECIALTY', '精通java', '004', '2018-08-20 10:39:37', '2018-08-20 10:39:43', '2018-08-10 16:34:39', '2018-08-20 10:39:49');
INSERT INTO `position` VALUES ('4', '1', '3', '', '初级前端工程师', null, null, '北京', null, '万达A座写字楼16楼', null, null, '全职', 'vue,js,css', '006', 'THREE2FIVE', 'SPECIALTY', '熟练使用js和前端框架', '004', '2018-08-20 10:39:37', '2018-08-20 10:39:43', '2018-08-10 16:34:39', '2018-08-20 10:39:49');
INSERT INTO `position` VALUES ('5', '1', '3', '', '中级前端工程师', null, null, '北京', null, '万达A座写字楼16楼', null, null, '全职', 'vue,js,css', '006', 'THREE2FIVE', 'SPECIALTY', '精通js和前端框架', '004', '2018-08-20 10:39:37', '2018-08-20 10:39:43', '2018-08-10 16:34:39', '2018-08-20 10:39:49');
INSERT INTO `position` VALUES ('6', '1', '3', '', '高级前端工程师', null, null, '北京', null, '万达A座写字楼16楼', null, null, '全职', 'vue,js,css', '006', 'THREE2FIVE', 'SPECIALTY', '精通js和前端框架', '004', '2018-08-20 10:39:37', '2018-08-20 10:39:43', '2018-08-10 16:34:39', '2018-08-20 10:39:49');
INSERT INTO `position` VALUES ('7', '1', '3', '', 'UI设计', null, null, '北京', null, '万达A座写字楼16楼', null, null, '全职', 'ps', '006', 'THREE2FIVE', 'SPECIALTY', '熟练使用photoshop', '004', '2018-08-20 10:39:37', '2018-08-20 10:39:43', '2018-08-10 16:34:39', '2018-08-20 10:39:49');
INSERT INTO `position` VALUES ('8', '1', '3', '', '初级测试工程师', null, null, '北京', null, '万达A座写字楼16楼', null, null, '全职', '自动化测试', '006', 'THREE2FIVE', 'SPECIALTY', '精通js和前端框架', '004', '2018-08-20 10:39:37', '2018-08-20 10:39:43', '2018-08-10 16:34:39', '2018-08-20 10:39:49');
INSERT INTO `position` VALUES ('9', '1', '3', '', '中级测试工程师', null, null, '北京', null, '万达A座写字楼16楼', null, null, '全职', '自动化测试', '006', 'THREE2FIVE', 'SPECIALTY', '精通js和前端框架', '004', '2018-08-20 10:39:37', '2018-08-20 10:39:43', '2018-08-10 16:34:39', '2018-08-20 10:39:49');
INSERT INTO `position` VALUES ('10', '1', '9', '600', 'fdfdfd', null, null, 'SHANGHAI', null, 'asfsfsdfsdf', null, null, 'SCHOOL', '电子商务,互联网', '006', 'LESS_ONE', 'SPECIALTY', 'dfsfsdfsdfsdf', '004', null, null, '2018-09-04 11:10:44', null);
INSERT INTO `position` VALUES ('11', '1', '9', '311', 'java', null, null, 'HIGH', null, 'beijing', null, null, 'SCHOOL', null, '006', 'LESS_ONE', 'SPECIALTY', 'miaoshu', '004', null, null, null, null);
INSERT INTO `position` VALUES ('12', '1', '31', '462', '小q', null, null, 'SHENZHEN', null, 'dfdfdfdfdfd', null, null, 'PART_TIME', null, '006', 'LESS_ONE', 'SPECIALTY', 'ssssssssssssssscccccccccccccccccccccccccc', '004', null, null, null, null);
INSERT INTO `position` VALUES ('13', '1', '31', '2152', '111', null, null, 'GUANGZHOU', null, '111', null, null, 'UNLIMITED', null, '006', 'THREE2FIVE', 'UNLIMITED', '22222222222', '004', null, null, null, null);
INSERT INTO `position` VALUES ('14', '1', '30', '846', 'JJ', null, null, 'SHIJIAZHUANG', null, '万达', null, null, 'UNLIMITED', null, '006', 'UNLIMITED', 'UNLIMITED', '好', '004', null, null, null, null);

-- ----------------------------
-- Table structure for positionfavorite
-- ----------------------------
DROP TABLE IF EXISTS `positionfavorite`;
CREATE TABLE `positionfavorite` (
  `userId` bigint(20) DEFAULT NULL COMMENT '用户标识',
  `positionId` bigint(20) DEFAULT NULL COMMENT '职位标识',
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='求职者收藏职位';

-- ----------------------------
-- Records of positionfavorite
-- ----------------------------

-- ----------------------------
-- Table structure for positionnotinterest
-- ----------------------------
DROP TABLE IF EXISTS `positionnotinterest`;
CREATE TABLE `positionnotinterest` (
  `userId` bigint(20) DEFAULT NULL COMMENT '用户标识',
  `positionId` bigint(20) DEFAULT NULL COMMENT '职位标识',
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='求职者不感兴趣职位';

-- ----------------------------
-- Records of positionnotinterest
-- ----------------------------

-- ----------------------------
-- Table structure for positionview
-- ----------------------------
DROP TABLE IF EXISTS `positionview`;
CREATE TABLE `positionview` (
  `userId` bigint(20) DEFAULT NULL COMMENT '用户标识',
  `positionId` bigint(20) DEFAULT NULL COMMENT '职位标识',
  `viewTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后查看时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='求职者查看职位';

-- ----------------------------
-- Records of positionview
-- ----------------------------

-- ----------------------------
-- Table structure for projects
-- ----------------------------
DROP TABLE IF EXISTS `projects`;
CREATE TABLE `projects` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '项目标识',
  `resumeId` bigint(20) NOT NULL COMMENT '简历标识',
  `projectName` varchar(100) NOT NULL COMMENT '项目名称',
  `startDate` date NOT NULL COMMENT '开始时间',
  `endDate` date NOT NULL COMMENT '结束时间',
  `projectUrl` varchar(240) DEFAULT NULL COMMENT '项目URL',
  `projectRole` varchar(300) DEFAULT NULL COMMENT '项目角色',
  `projectExp` varchar(500) DEFAULT NULL COMMENT '项目描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='项目经验';

-- ----------------------------
-- Records of projects
-- ----------------------------
INSERT INTO `projects` VALUES ('1', '1', '张三', '2018-08-01', '2018-08-01', 'baidu.com', '角色', '项目\n描述\n换行');
INSERT INTO `projects` VALUES ('2', '8', '迷宫', '2018-09-01', '2018-09-01', 'hdjdjd', '狗狗', 'going');
INSERT INTO `projects` VALUES ('3', '14', 'aaaa', '2018-09-01', '2018-09-01', 'dcccdc', 'dddd', '方式登记反馈了三等奖逢狼时刻对接方式打开了房间圣诞快乐福建省的看法就是打开方式登记水电费了就是打开了附件是打开了附件是打开了飞机上的看法就是的适得府君书打了客服就是打开了飞机速度开了房间圣诞快乐上来看到飞机速度来看风景圣诞快乐福建省的速度快放假圣诞快乐福建省的看法水电费会计师的离');
INSERT INTO `projects` VALUES ('4', '14', '锅a', '2018-09-01', '2018-09-01', 'dcccdc', 'dddd', '方式登记反馈了三等奖逢狼时刻对接方式打开了房间圣诞快乐福建省的看法就是打开方式登记水电费了就是打开了附件是打开了附件是打开了飞机上的看法就是的适得府君书打了客服就是打开了飞机速度开了房间圣诞快乐上来看到飞机速度来看风景圣诞快乐福建省的速度快放假圣诞快乐福建省的看法水电费会计师的离fdf方法第三方方式对方水电费sffs是非得失发送到发送到\n发生的纠纷圣诞快乐\n方式快捷方式附近发生借款发生的f\n发生的看法就是的f\n速度快的副驾驶的fsd\n发生的看法就是的\n发生地方就是看了感觉\n水电费三季度');

-- ----------------------------
-- Table structure for resume
-- ----------------------------
DROP TABLE IF EXISTS `resume`;
CREATE TABLE `resume` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '简历标识',
  `userId` bigint(20) NOT NULL COMMENT '用户标识',
  `title` varchar(240) NOT NULL COMMENT '名称',
  `publishStatus` varchar(10) NOT NULL COMMENT '公开状态',
  `resumeType` varchar(10) DEFAULT NULL COMMENT '简历类型',
  `info` varchar(1000) DEFAULT NULL COMMENT '个人介绍',
  `deleteFlag` bit(1) NOT NULL DEFAULT b'0' COMMENT '删除标志',
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `updateTime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '最后更新时间',
  `refreshTime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '最后刷新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COMMENT='简历';

-- ----------------------------
-- Records of resume
-- ----------------------------
INSERT INTO `resume` VALUES ('1', '4', '某某的简历', 'PUBLIC', null, 'fdfdf\ndfdfg\nghjy\ndfdf', '\0', '2018-08-14 13:39:20', '2018-08-10 15:03:06', '2018-08-10 15:03:06');
INSERT INTO `resume` VALUES ('13', '30', '某某的简历', 'PUBLIC', null, null, '\0', '2018-09-13 15:55:19', '2018-09-10 10:58:22', '2018-09-10 10:58:22');
INSERT INTO `resume` VALUES ('14', '31', '某某的简历', 'PUBLIC', null, null, '\0', '2018-09-10 14:16:34', '2018-09-10 14:16:33', '2018-09-10 14:16:33');
INSERT INTO `resume` VALUES ('15', '33', '某某的简历', 'PUBLIC', null, null, '\0', '2018-09-13 14:42:03', '2018-09-13 14:42:04', '2018-09-13 14:42:04');
INSERT INTO `resume` VALUES ('16', '36', '某某的简历', 'PUBLIC', null, null, '\0', '2018-09-14 14:58:11', '2018-09-14 14:58:12', '2018-09-14 14:58:12');

-- ----------------------------
-- Table structure for resumeattach
-- ----------------------------
DROP TABLE IF EXISTS `resumeattach`;
CREATE TABLE `resumeattach` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '附件简历标识',
  `userId` bigint(20) NOT NULL COMMENT '用户标识',
  `fileName` varchar(30) NOT NULL COMMENT '文件名称',
  `resumeUrl` varchar(140) NOT NULL COMMENT '文件地址',
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '上传时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='附件简历';

-- ----------------------------
-- Records of resumeattach
-- ----------------------------
INSERT INTO `resumeattach` VALUES ('1', '6', '个人简历', '/resume/AIYA.jpg', '2018-08-14 14:01:46');
INSERT INTO `resumeattach` VALUES ('2', '4', '测试简历.docx', '/resume/23c382b8-ac13-412a-b6b0-fefb1f43651b测试简历.docx', '2018-08-15 18:02:36');

-- ----------------------------
-- Table structure for resumefavorite
-- ----------------------------
DROP TABLE IF EXISTS `resumefavorite`;
CREATE TABLE `resumefavorite` (
  `companyId` bigint(20) DEFAULT NULL COMMENT '企业标识',
  `positionId` bigint(20) DEFAULT NULL COMMENT '职位标识',
  `resumeId` bigint(20) NOT NULL COMMENT '简历标识',
  `userId` bigint(20) NOT NULL COMMENT '收藏人',
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '收藏时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='简历收藏';

-- ----------------------------
-- Records of resumefavorite
-- ----------------------------
INSERT INTO `resumefavorite` VALUES (null, null, '1', '9', '2018-08-24 15:13:12');

-- ----------------------------
-- Table structure for resumeview
-- ----------------------------
DROP TABLE IF EXISTS `resumeview`;
CREATE TABLE `resumeview` (
  `companyId` bigint(20) NOT NULL COMMENT '企业标识',
  `positionId` bigint(20) NOT NULL COMMENT '职位标识',
  `resumeId` bigint(20) NOT NULL COMMENT '简历标识',
  `viewStatus` varchar(10) DEFAULT NULL COMMENT '查看结果',
  `viewTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '查看时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='简历查看';

-- ----------------------------
-- Records of resumeview
-- ----------------------------

-- ----------------------------
-- Table structure for rp_page
-- ----------------------------
DROP TABLE IF EXISTS `rp_page`;
CREATE TABLE `rp_page` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '页面标识',
  `pageCode` varchar(60) DEFAULT NULL COMMENT '页面编码。用于查询地址。',
  `title` varchar(60) DEFAULT NULL COMMENT '页面标题',
  `tableName` varchar(2000) DEFAULT NULL COMMENT '在编辑和新增页面上使用的，要查询的表，与SQL语句中from后的表名写法一致。即可以是单个表名，也可以是多个表关联。',
  `queryCode` varchar(60) DEFAULT NULL COMMENT '查询编码。',
  `export` tinyint(1) DEFAULT NULL COMMENT '是否导出Excel。',
  `js` varchar(2000) DEFAULT NULL COMMENT '页面上要添加的js语句。',
  `description` varchar(2000) DEFAULT NULL COMMENT '页面描述。',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='查询页面。';

-- ----------------------------
-- Records of rp_page
-- ----------------------------
INSERT INTO `rp_page` VALUES ('1', 'resource', '资源管理', 'sys_menu', 'resource-search', '1', null, null);
INSERT INTO `rp_page` VALUES ('2', 'jobseeker', '求职者管理', null, 'jobseeker-search', '0', null, null);

-- ----------------------------
-- Table structure for rp_queryfield
-- ----------------------------
DROP TABLE IF EXISTS `rp_queryfield`;
CREATE TABLE `rp_queryfield` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '查询字段标识。',
  `pageId` int(11) NOT NULL COMMENT '页面标识。',
  `fieldType` varchar(10) NOT NULL COMMENT '字段类型。例：select,result,edit',
  `displayName` varchar(60) NOT NULL COMMENT '查询字段的显示名称。',
  `htmlName` varchar(60) DEFAULT NULL COMMENT '查询字段的html代码中的名称。',
  `htmlControl` varchar(60) NOT NULL DEFAULT 'text' COMMENT '查询字段的html控件类型。',
  `dbName` varchar(60) DEFAULT NULL COMMENT '此字段对应的数据库字段名。',
  `displayOrder` int(11) DEFAULT NULL COMMENT '显示顺序。',
  `isPK` tinyint(1) NOT NULL DEFAULT '0' COMMENT '此字段是否是数据库主键。',
  `dbAdd` tinyint(1) NOT NULL DEFAULT '1' COMMENT '此字段在添加新记录时是否需要添加。',
  `dbWhere` varchar(250) DEFAULT NULL COMMENT '查询字段的查询条件。写法与SQL写法相同。',
  `dbType` varchar(60) DEFAULT NULL COMMENT '暂未使用。',
  `dbOrder` int(11) DEFAULT NULL COMMENT 'SQL中查询条件顺序。',
  `initValueType` varchar(60) DEFAULT NULL COMMENT '初始化值类型。',
  `initValue` varchar(250) DEFAULT NULL COMMENT '初始值。',
  `initQueryCode` varchar(60) DEFAULT NULL COMMENT '初始值初始化使用的QueryCode。',
  `fieldClass` varchar(250) NOT NULL DEFAULT 'form-group col-lg-4' COMMENT '包含字段容器的CSS类。',
  `nameClass` varchar(250) NOT NULL DEFAULT 'control-label col-lg-4' COMMENT '字段标签的CSS类。',
  `valueWrapperClass` varchar(250) NOT NULL DEFAULT 'col-lg-8' COMMENT '包含录入控件容器的CSS类。',
  `valueClass` varchar(250) NOT NULL DEFAULT 'form-control' COMMENT '录入控件的CSS类。',
  `placeHolder` varchar(250) DEFAULT NULL COMMENT '当输入框是text类型时，显示的提示文字。',
  `halign` varchar(60) NOT NULL DEFAULT 'center' COMMENT 'bootstrapTable控件对应的属性。',
  `align` varchar(60) NOT NULL DEFAULT 'center' COMMENT 'bootstrapTable控件对应的属性。',
  `width` varchar(60) NOT NULL DEFAULT '10%' COMMENT 'bootstrapTable控件对应的属性。',
  `formatter` varchar(500) NOT NULL DEFAULT 'return value;' COMMENT 'bootstrapTable控件对应的属性。',
  `clickToSelect` tinyint(1) NOT NULL DEFAULT '0' COMMENT 'bootstrapTable控件对应的属性。',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8 COMMENT='页面的使用到的字段。';

-- ----------------------------
-- Records of rp_queryfield
-- ----------------------------
INSERT INTO `rp_queryfield` VALUES ('1', '1', 'result', '标识', 'id', 'text', 'id', '1', '1', '0', null, null, '1', null, null, null, 'form-group col-lg-4', 'control-label col-lg-4', 'col-lg-8', 'form-control', null, 'center', 'center', '10%', 'return value;', '0');
INSERT INTO `rp_queryfield` VALUES ('12', '1', 'result', '项目编码', 'serviceId', 'text', 'serviceId', '2', '0', '1', null, null, '2', null, null, null, 'form-group col-lg-4', 'control-label col-lg-4', 'col-lg-8', 'form-control', null, 'center', 'center', '10%', 'return value;', '0');
INSERT INTO `rp_queryfield` VALUES ('13', '1', 'result', '编码', 'code', 'text', 'code', '3', '0', '1', null, null, '3', null, null, null, 'form-group col-lg-4', 'control-label col-lg-4', 'col-lg-8', 'form-control', null, 'center', 'center', '10%', 'return value;', '0');
INSERT INTO `rp_queryfield` VALUES ('14', '1', 'result', '上级编码', 'p_Code', 'text', 'p_code', '4', '0', '1', null, null, '4', null, null, null, 'form-group col-lg-4', 'control-label col-lg-4', 'col-lg-8', 'form-control', null, 'center', 'center', '10%', 'return value;', '0');
INSERT INTO `rp_queryfield` VALUES ('15', '1', 'result', '上级标识', 'p_Id', 'text', 'p_id', '5', '0', '1', null, null, '5', null, null, null, 'form-group col-lg-4', 'control-label col-lg-4', 'col-lg-8', 'form-control', null, 'center', 'center', '10%', 'return value;', '0');
INSERT INTO `rp_queryfield` VALUES ('16', '1', 'result', '名称', 'name', 'text', 'name', '6', '0', '1', null, null, '6', null, null, null, 'form-group col-lg-4', 'control-label col-lg-4', 'col-lg-8', 'form-control', null, 'center', 'center', '10%', 'return value;', '0');
INSERT INTO `rp_queryfield` VALUES ('17', '1', 'result', '地址', 'url', 'text', 'url', '7', '0', '1', null, null, '7', null, null, null, 'form-group col-lg-4', 'control-label col-lg-4', 'col-lg-8', 'form-control', null, 'center', 'center', '10%', 'return value;', '0');
INSERT INTO `rp_queryfield` VALUES ('18', '1', 'result', '是否菜单', 'is_Menu', 'text', 'is_menu', '8', '0', '1', null, null, '8', null, null, null, 'form-group col-lg-4', 'control-label col-lg-4', 'col-lg-8', 'form-control', null, 'center', 'center', '10%', 'return value;', '0');
INSERT INTO `rp_queryfield` VALUES ('19', '1', 'result', '层级', 'level', 'text', 'level', '9', '0', '1', null, null, '9', null, null, null, 'form-group col-lg-4', 'control-label col-lg-4', 'col-lg-8', 'form-control', null, 'center', 'center', '10%', 'return value;', '0');
INSERT INTO `rp_queryfield` VALUES ('20', '1', 'result', '顺序', 'sort', 'text', 'sort', '10', '0', '1', null, null, '10', null, null, null, 'form-group col-lg-4', 'control-label col-lg-4', 'col-lg-8', 'form-control', null, 'center', 'center', '10%', 'return value;', '0');
INSERT INTO `rp_queryfield` VALUES ('21', '1', 'result', '图标', 'icon', 'text', 'icon', '11', '0', '1', null, null, '11', null, null, null, 'form-group col-lg-4', 'control-label col-lg-4', 'col-lg-8', 'form-control', null, 'center', 'center', '10%', 'return value;', '0');
INSERT INTO `rp_queryfield` VALUES ('22', '1', 'result', '状态', 'status', 'text', 'status', '12', '0', '1', null, null, '12', null, null, null, 'form-group col-lg-4', 'control-label col-lg-4', 'col-lg-8', 'form-control', null, 'center', 'center', '10%', 'return value;', '0');
INSERT INTO `rp_queryfield` VALUES ('23', '1', 'query', '项目编码', 'serviceId', 'text', 'serviceId', '1', '0', '1', 'serviceId like \'%#value#%\'', null, '1', null, null, null, 'form-group col-lg-4', 'control-label col-lg-4', 'col-lg-8', 'form-control', null, 'center', 'center', '10%', 'return value;', '0');
INSERT INTO `rp_queryfield` VALUES ('24', '1', 'result', '操作', null, 'text', null, '13', '0', '0', null, null, '13', null, null, null, 'form-group col-lg-4', 'control-label col-lg-4', 'col-lg-8', 'form-control', null, 'center', 'center', '10%', 'return \'<a href=\"/edit/\' + pageCode+ \"?id=\" + row.id + \'\"> 详情</a> \';', '0');
INSERT INTO `rp_queryfield` VALUES ('25', '1', 'edit', '标识', 'id', 'text', 'id', '1', '1', '0', null, 'long', '1', null, null, null, 'form-group col-lg-4', 'control-label col-lg-4', 'col-lg-8', 'form-control', null, 'center', 'center', '10%', 'return value;', '0');
INSERT INTO `rp_queryfield` VALUES ('26', '1', 'edit', '项目编码', 'serviceId', 'text', 'serviceId', '2', '0', '1', null, 'string', '2', null, null, null, 'form-group col-lg-4', 'control-label col-lg-4', 'col-lg-8', 'form-control', null, 'center', 'center', '10%', 'return value;', '0');
INSERT INTO `rp_queryfield` VALUES ('27', '1', 'edit', '编码', 'code', 'text', 'code', '3', '0', '1', null, 'string', '3', null, null, null, 'form-group col-lg-4', 'control-label col-lg-4', 'col-lg-8', 'form-control', null, 'center', 'center', '10%', 'return value;', '0');
INSERT INTO `rp_queryfield` VALUES ('28', '1', 'edit', '上级编码', 'p_Code', 'text', 'p_code', '4', '0', '1', null, 'string', '4', null, null, null, 'form-group col-lg-4', 'control-label col-lg-4', 'col-lg-8', 'form-control', null, 'center', 'center', '10%', 'return value;', '0');
INSERT INTO `rp_queryfield` VALUES ('29', '1', 'edit', '上级标识', 'p_Id', 'text', 'p_id', '5', '0', '1', null, 'long', '5', null, null, null, 'form-group col-lg-4', 'control-label col-lg-4', 'col-lg-8', 'form-control', null, 'center', 'center', '10%', 'return value;', '0');
INSERT INTO `rp_queryfield` VALUES ('30', '1', 'edit', '名称', 'name', 'text', 'name', '6', '0', '1', null, 'string', '6', null, null, null, 'form-group col-lg-4', 'control-label col-lg-4', 'col-lg-8', 'form-control', null, 'center', 'center', '10%', 'return value;', '0');
INSERT INTO `rp_queryfield` VALUES ('31', '1', 'edit', '地址', 'url', 'text', 'url', '7', '0', '1', null, 'string', '7', null, null, null, 'form-group col-lg-4', 'control-label col-lg-4', 'col-lg-8', 'form-control', null, 'center', 'center', '10%', 'return value;', '0');
INSERT INTO `rp_queryfield` VALUES ('32', '1', 'edit', '是否菜单', 'is_Menu', 'text', 'is_menu', '8', '0', '1', null, 'boolean', '8', null, null, null, 'form-group col-lg-4', 'control-label col-lg-4', 'col-lg-8', 'form-control', null, 'center', 'center', '10%', 'return value;', '0');
INSERT INTO `rp_queryfield` VALUES ('33', '1', 'edit', '层级', 'level', 'text', 'level', '9', '0', '1', null, 'int', '9', null, null, null, 'form-group col-lg-4', 'control-label col-lg-4', 'col-lg-8', 'form-control', null, 'center', 'center', '10%', 'return value;', '0');
INSERT INTO `rp_queryfield` VALUES ('34', '1', 'edit', '顺序', 'sort', 'text', 'sort', '10', '0', '1', null, 'int', '10', null, null, null, 'form-group col-lg-4', 'control-label col-lg-4', 'col-lg-8', 'form-control', null, 'center', 'center', '10%', 'return value;', '0');
INSERT INTO `rp_queryfield` VALUES ('35', '1', 'edit', '图标', 'icon', 'text', 'icon', '11', '0', '1', null, 'string', '11', null, null, null, 'form-group col-lg-4', 'control-label col-lg-4', 'col-lg-8', 'form-control', null, 'center', 'center', '10%', 'return value;', '0');
INSERT INTO `rp_queryfield` VALUES ('36', '1', 'edit', '状态', 'status', 'text', 'status', '12', '0', '1', null, 'string', '12', null, null, null, 'form-group col-lg-4', 'control-label col-lg-4', 'col-lg-8', 'form-control', null, 'center', 'center', '10%', 'return value;', '0');
INSERT INTO `rp_queryfield` VALUES ('37', '2', 'edit', '操作', null, 'text', null, '13', '0', '0', null, null, '13', null, null, null, 'form-group col-lg-4', 'control-label col-lg-4', 'col-lg-8', 'form-control', null, 'center', 'center', '10%', 'return \'<a href=\"\' + row.id + \'\"> 详情</a> \';', '0');
INSERT INTO `rp_queryfield` VALUES ('40', '2', 'result', '标识', 'id', 'text', 'id', '1', '1', '0', null, null, '1', null, null, null, 'form-group col-lg-4', 'control-label col-lg-4', 'col-lg-8', 'form-control', null, 'center', 'center', '10%', 'return value;', '0');
INSERT INTO `rp_queryfield` VALUES ('41', '2', 'result', '姓名', 'realName', 'text', 'realName', '2', '0', '1', null, null, '2', null, null, null, 'form-group col-lg-4', 'control-label col-lg-4', 'col-lg-8', 'form-control', null, 'center', 'center', '10%', 'return value;', '0');
INSERT INTO `rp_queryfield` VALUES ('42', '2', 'result', '性别', 'sex', 'text', 'sex', '3', '0', '1', null, null, '3', null, null, null, 'form-group col-lg-4', 'control-label col-lg-4', 'col-lg-8', 'form-control', null, 'center', 'center', '10%', 'return value;', '0');
INSERT INTO `rp_queryfield` VALUES ('43', '2', 'result', '生日', 'birthday', 'text', 'birthday', '4', '0', '1', null, null, '4', null, null, null, 'form-group col-lg-4', 'control-label col-lg-4', 'col-lg-8', 'form-control', null, 'center', 'center', '10%', 'return value;', '0');
INSERT INTO `rp_queryfield` VALUES ('44', '2', 'result', '求职状态', 'jobStatus', 'text', 'jobStatus', '5', '0', '1', null, null, '5', null, null, null, 'form-group col-lg-4', 'control-label col-lg-4', 'col-lg-8', 'form-control', null, 'center', 'center', '10%', 'return value;', '0');
INSERT INTO `rp_queryfield` VALUES ('45', '2', 'result', '开始工作时间', 'startWorkTime', 'text', 'startWorkTime', '6', '0', '1', null, null, '6', null, null, null, 'form-group col-lg-4', 'control-label col-lg-4', 'col-lg-8', 'form-control', null, 'center', 'center', '10%', 'return value;', '0');
INSERT INTO `rp_queryfield` VALUES ('46', '2', 'result', '现居城市', 'city', 'text', 'city', '7', '0', '1', null, null, '7', null, null, null, 'form-group col-lg-4', 'control-label col-lg-4', 'col-lg-8', 'form-control', null, 'center', 'center', '10%', 'return value;', '0');
INSERT INTO `rp_queryfield` VALUES ('47', '2', 'result', '手机号', 'mobile', 'text', 'mobile', '8', '0', '1', null, null, '8', null, null, null, 'form-group col-lg-4', 'control-label col-lg-4', 'col-lg-8', 'form-control', null, 'center', 'center', '10%', 'return value;', '0');
INSERT INTO `rp_queryfield` VALUES ('48', '2', 'result', '邮箱', 'email', 'text', 'email', '9', '0', '1', null, null, '9', null, null, null, 'form-group col-lg-4', 'control-label col-lg-4', 'col-lg-8', 'form-control', null, 'center', 'center', '10%', 'return value;', '0');
INSERT INTO `rp_queryfield` VALUES ('49', '2', 'result', '微信号', 'wxid', 'text', 'wxid', '10', '0', '1', null, null, '10', null, null, null, 'form-group col-lg-4', 'control-label col-lg-4', 'col-lg-8', 'form-control', null, 'center', 'center', '10%', 'return value;', '0');
INSERT INTO `rp_queryfield` VALUES ('50', '2', 'query', '手机号', 'mobile', 'text', 'mobile', '1', '0', '1', 'su.mobile LIKE \'%#value#%\'', null, '1', null, null, null, 'form-group col-lg-4', 'control-label col-lg-4', 'col-lg-8', 'form-control', null, 'center', 'center', '10%', 'return value;', '0');
INSERT INTO `rp_queryfield` VALUES ('51', '2', 'result', '操作', null, 'text', null, '11', '0', '0', null, null, '11', null, null, null, 'form-group col-lg-4', 'control-label col-lg-4', 'col-lg-8', 'form-control', null, 'center', 'center', '10%', 'return \'<a href=\"/\' + pageCode+ \"/downloadResume/\" + row.id + \'\"> 下载简历</a> \';', '0');

-- ----------------------------
-- Table structure for rp_queryitem
-- ----------------------------
DROP TABLE IF EXISTS `rp_queryitem`;
CREATE TABLE `rp_queryitem` (
  `queryCode` varchar(60) NOT NULL COMMENT '查询编码。',
  `queryType` varchar(60) DEFAULT NULL COMMENT 'SQL类型。暂未使用。',
  `queryField` varchar(2000) DEFAULT NULL COMMENT 'SQL中Select部分内容。',
  `tableName` varchar(2000) DEFAULT NULL COMMENT 'SQL中from部分内容。',
  `queryWhere` varchar(2000) DEFAULT NULL COMMENT 'SQL中where部分内容。',
  `queryGroup` varchar(2000) DEFAULT NULL COMMENT 'SQL中group by 部分内容。',
  `queryOrder` varchar(2000) DEFAULT NULL COMMENT 'SQL中order by 部分内容。',
  PRIMARY KEY (`queryCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='查询页面用的SQL。';

-- ----------------------------
-- Records of rp_queryitem
-- ----------------------------
INSERT INTO `rp_queryitem` VALUES ('jobseeker-search', null, 'js.id,su.realName,su.sex,su.birthday,js.jobStatus,js.startWorkTime,js.city,su.mobile,su.email,su.wxid', 'jobseeker js LEFT JOIN sys_user su ON js.id = su.id', '1 = 1', null, 'id');
INSERT INTO `rp_queryitem` VALUES ('resource-search', null, 'id,serviceId,code,p_code,p_id,name,url,is_menu,level,sort,icon,status,description,create_time,update_time', 'sys_menu', '1 = 1', null, 'serviceId, sort');

-- ----------------------------
-- Table structure for sendresume
-- ----------------------------
DROP TABLE IF EXISTS `sendresume`;
CREATE TABLE `sendresume` (
  `positionId` bigint(20) NOT NULL COMMENT '职位标识',
  `resumeId` bigint(20) NOT NULL COMMENT '简历标识',
  `sendResumeStatus` varchar(10) DEFAULT NULL COMMENT '投递结果',
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '投递时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='简历投递';

-- ----------------------------
-- Records of sendresume
-- ----------------------------

-- ----------------------------
-- Table structure for skill
-- ----------------------------
DROP TABLE IF EXISTS `skill`;
CREATE TABLE `skill` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '技能标识',
  `resumeid` bigint(20) NOT NULL COMMENT '简历标识',
  `skillName` varchar(240) DEFAULT NULL COMMENT '技能名称',
  `skillLevel` varchar(45) DEFAULT NULL COMMENT '技能等级',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='专业技能';

-- ----------------------------
-- Records of skill
-- ----------------------------

-- ----------------------------
-- Table structure for sys_data_dictionary
-- ----------------------------
DROP TABLE IF EXISTS `sys_data_dictionary`;
CREATE TABLE `sys_data_dictionary` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编码标识',
  `dataType` varchar(240) NOT NULL COMMENT '编码类型',
  `description` varchar(240) DEFAULT NULL,
  `codeName` varchar(240) NOT NULL COMMENT '编码名称',
  `codeValue` varchar(10) NOT NULL COMMENT '编码值',
  `parentValue` varchar(10) DEFAULT NULL COMMENT '上级编码值',
  `displayOrder` int(11) NOT NULL DEFAULT '0' COMMENT '显示顺序',
  `typeName` varchar(240) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='编码表';

-- ----------------------------
-- Records of sys_data_dictionary
-- ----------------------------

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '菜单标识',
  `serviceId` varchar(100) DEFAULT NULL COMMENT '所属服务',
  `code` varchar(255) DEFAULT NULL COMMENT '菜单编码',
  `p_code` varchar(255) DEFAULT NULL COMMENT '菜单父编码',
  `p_id` bigint(20) DEFAULT NULL COMMENT '父菜单ID',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `url` varchar(255) DEFAULT NULL COMMENT '请求地址',
  `is_menu` int(11) DEFAULT NULL COMMENT '是否菜单',
  `level` int(11) DEFAULT NULL COMMENT '菜单层级',
  `sort` int(11) DEFAULT NULL COMMENT '菜单排序',
  `icon` varchar(255) DEFAULT NULL COMMENT '菜单图标',
  `status` varchar(10) DEFAULT NULL COMMENT '菜单状态',
  `description` varchar(500) DEFAULT NULL COMMENT '描述',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `FK_CODE` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', 'hlhlo-api', 'hlhlo-api', null, null, '系统根目录', null, '0', '0', '1', null, '1', null, null, null);
INSERT INTO `sys_menu` VALUES ('2', 'hlhlo-api', 'resume', null, '0', '查看简历', '/resume/**', '0', '0', '2', null, '1', null, null, null);
INSERT INTO `sys_menu` VALUES ('3', 'hlhlo-api', 'swagger', null, '0', 'API文档', '/swagger-ui.html', '0', '0', '3', null, '1', null, null, null);
INSERT INTO `sys_menu` VALUES ('4', 'hlhlo-api', 'position', null, '0', '职位API', '/position/**', '0', '0', '4', null, '1', null, null, null);
INSERT INTO `sys_menu` VALUES ('5', 'hlhlo-admin', 'admin-index', null, null, '首页', '/', '0', '0', '1', null, '1', null, null, null);
INSERT INTO `sys_menu` VALUES ('6', 'hlhlo-admin', 'admin-sysconfig', 'admin-index', null, '系统设置', '#', '1', '1', '1', null, '1', null, null, null);
INSERT INTO `sys_menu` VALUES ('7', 'hlhlo-admin', 'admin-resource', 'admin-sysconfig', '6', '资源管理', '/list/resource/', '1', '2', '1', '', '1', null, null, null);
INSERT INTO `sys_menu` VALUES ('8', 'hlhlo-admin', 'admin-jobseeker', 'admin-sysconfig', '6', '求职者管理', '/list/jobseeker/', '1', '2', '2', null, '1', null, null, null);

-- ----------------------------
-- Table structure for sys_privilege
-- ----------------------------
DROP TABLE IF EXISTS `sys_privilege`;
CREATE TABLE `sys_privilege` (
  `role_id` bigint(20) NOT NULL COMMENT '角色标识',
  `menu_id` bigint(20) NOT NULL COMMENT '菜单标识',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`role_id`,`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单权限';

-- ----------------------------
-- Records of sys_privilege
-- ----------------------------
INSERT INTO `sys_privilege` VALUES ('1', '1', null);
INSERT INTO `sys_privilege` VALUES ('1', '2', null);
INSERT INTO `sys_privilege` VALUES ('2', '1', null);
INSERT INTO `sys_privilege` VALUES ('2', '2', null);
INSERT INTO `sys_privilege` VALUES ('2', '5', null);
INSERT INTO `sys_privilege` VALUES ('4', '1', null);
INSERT INTO `sys_privilege` VALUES ('4', '2', null);
INSERT INTO `sys_privilege` VALUES ('4', '3', null);
INSERT INTO `sys_privilege` VALUES ('4', '4', null);
INSERT INTO `sys_privilege` VALUES ('6', '3', null);
INSERT INTO `sys_privilege` VALUES ('7', '4', null);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色标识',
  `name` varchar(255) DEFAULT NULL COMMENT '角色名称',
  `value` varchar(255) DEFAULT NULL COMMENT '角色值',
  `tips` varchar(255) DEFAULT NULL COMMENT '角色说明',
  `status` varchar(10) NOT NULL COMMENT '角色状态',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `unique_role_name` (`name`),
  KEY `unique_role_value` (`value`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='角色';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '超级管理员', 'SUPER', null, '1', null, null);
INSERT INTO `sys_role` VALUES ('2', '管理员', 'ADMIN', null, '1', null, null);
INSERT INTO `sys_role` VALUES ('3', '用户', 'USER', null, '1', null, null);
INSERT INTO `sys_role` VALUES ('4', '求职者', 'JOB', null, '1', null, null);
INSERT INTO `sys_role` VALUES ('5', '招聘者-未认证', 'HR_UNAUTHORIZED', null, '1', null, null);
INSERT INTO `sys_role` VALUES ('6', '招聘者-已认证', 'HR_AUTHORIZED', null, '1', null, null);
INSERT INTO `sys_role` VALUES ('7', '匿名用户', 'ROLE_ANONYMOUS', null, '1', null, null);

-- ----------------------------
-- Table structure for sys_social
-- ----------------------------
DROP TABLE IF EXISTS `sys_social`;
CREATE TABLE `sys_social` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type` varchar(10) DEFAULT NULL,
  `token` varchar(100) DEFAULT NULL,
  `session_key` varchar(100) DEFAULT NULL,
  `uid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `AK_UK_SOCIAL_UUID` (`token`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8 COMMENT='社会化接入表';

-- ----------------------------
-- Records of sys_social
-- ----------------------------
INSERT INTO `sys_social` VALUES ('1', 'wx', '12', 'n814LhBT+fSiChIgtTbNnQ==', null);
INSERT INTO `sys_social` VALUES ('2', 'wx', '', 'n814LhBT+fSiChIgtTbNnQ==', null);
INSERT INTO `sys_social` VALUES ('3', 'wx', '', 'n814LhBT+fSiChIgtTbNnQ==', null);
INSERT INTO `sys_social` VALUES ('4', 'wx', '', 'n814LhBT+fSiChIgtTbNnQ==', null);
INSERT INTO `sys_social` VALUES ('44', 'wx', 'oiP5x0cXdLsiItTKdKus6gisW-60', '1KlEdk6UTsD3ObjzZeQwrg==', '30');
INSERT INTO `sys_social` VALUES ('45', 'wx', 'oiP5x0fc_i5-xGFs-o2YCzA8b3Vk', 'HGDrCYoIu34eM8RVWYlXpw==', null);
INSERT INTO `sys_social` VALUES ('53', 'wx', 'oiP5x0YOVQKWAZKGwhRMf5STip0Y', '6HwpwuDjz8rXaOogZVojqw==', '36');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户标识',
  `username` varchar(45) DEFAULT NULL COMMENT '登录名',
  `password` varchar(256) DEFAULT NULL COMMENT '密码',
  `salt` char(10) DEFAULT NULL COMMENT '放在密码明文后面一起加密。',
  `nickName` varchar(240) DEFAULT NULL COMMENT '昵称',
  `avatarUrl` varchar(255) DEFAULT NULL COMMENT '用户头像',
  `openId` varchar(240) DEFAULT NULL COMMENT 'openId',
  `unionId` varchar(240) DEFAULT NULL COMMENT 'unionId',
  `realName` varchar(45) DEFAULT NULL COMMENT '真实姓名',
  `birthday` datetime DEFAULT NULL COMMENT '出生日期',
  `sex` varchar(10) DEFAULT NULL COMMENT '性别',
  `email` varchar(45) DEFAULT NULL COMMENT '电子邮箱',
  `mobile` varchar(45) DEFAULT NULL COMMENT '手机号',
  `wxid` varchar(45) DEFAULT NULL COMMENT '微信号',
  `status` varchar(10) DEFAULT NULL COMMENT '用户状态',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `updateTime` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_USER_USERNAME` (`username`),
  UNIQUE KEY `UK_USER_MOBILE` (`mobile`),
  UNIQUE KEY `AK_UK_USER_WXID` (`wxid`),
  KEY `AK_UK_USER_EMAIL` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'super', '{bcrypt}$2a$10$cKRbR9IJktfmKmf/wShyo.5.J8IxO/7YVn8twuWFtvPgruAF8gtKq', null, '超级管理员', null, null, null, '王大锤', null, '1', null, null, null, '1', null, null);
INSERT INTO `sys_user` VALUES ('2', 'admin', '{bcrypt}$2a$10$cKRbR9IJktfmKmf/wShyo.5.J8IxO/7YVn8twuWFtvPgruAF8gtKq', null, '管理员', 'url', 'openid', 'unnionid', '王大锤', '1980-10-01 00:00:00', '0', 'admin@hlhlo.com', '158321886211', 'wxid', '1', '2018-08-08 11:51:06', '2018-08-08 11:51:06');
INSERT INTO `sys_user` VALUES ('3', 'zhaopin', '{bcrypt}$2a$10$cKRbR9IJktfmKmf/wShyo.5.J8IxO/7YVn8twuWFtvPgruAF8gtKq', null, '招聘者', null, null, null, '测试招聘者', '2018-08-01 08:00:00', '男', 'zhangsan@qq.com', '13313313315', null, '1', '2018-08-10 14:33:10', '2018-08-10 14:33:13');
INSERT INTO `sys_user` VALUES ('4', 'qiuzhi', '{bcrypt}$2a$10$cKRbR9IJktfmKmf/wShyo.5.J8IxO/7YVn8twuWFtvPgruAF8gtKq', null, '求职者', '/images/1534211965130wxce4e31f14994603d.o6zAJsw5dIe7OlqjaeQTP9ZABJig.cZ41IMyFmD43e882f8e76d17d79478df839674896cd2.png', null, null, '张三', '2013-09-01 08:00:00', '男', 'zhangsan@qq.com', '13313313316', 'wx13313313316', '1', '2018-08-10 14:33:10', '2018-08-10 14:33:13');
INSERT INTO `sys_user` VALUES ('5', 'yixing', '{bcrypt}$2a$10$cKRbR9IJktfmKmf/wShyo.5.J8IxO/7YVn8twuWFtvPgruAF8gtKq', null, '奕星', null, null, null, '奕星', '2018-08-14 13:40:49', '男', '1805639166@qq.com', '15732150001', 'wxin', '1', '2018-08-14 13:41:36', '2018-08-14 13:41:38');
INSERT INTO `sys_user` VALUES ('6', 'test', '{bcrypt}$2a$10$cKRbR9IJktfmKmf/wShyo.5.J8IxO/7YVn8twuWFtvPgruAF8gtKq', null, '泰斯特', null, null, null, '泰斯特', null, null, 'test@qq.com', 'test', null, '1', null, null);
INSERT INTO `sys_user` VALUES ('7', '15732150003', '{bcrypt}$2a$10$6B.656sDV4FNc6rXhf7WIOGGeF.k8xiDgh/nQQhO5MkS82YKvx1IK', 'EEGVNXKRRK', null, null, null, null, null, null, null, null, '15732150003', null, 'NORMAL', '2018-08-16 10:56:41', '2018-08-16 10:56:41');
INSERT INTO `sys_user` VALUES ('8', '15732150004', '{bcrypt}$2a$10$k3wjTTn1Y.4qwONvOeP/1uw9sM6J.ZpIcFvcQC1PSiOpZYLS9d0yq', '6FKAAATR8T', null, null, null, null, null, null, null, null, '15732150004', null, 'NORMAL', '2018-08-16 15:03:51', '2018-08-16 15:03:51');
INSERT INTO `sys_user` VALUES ('17', '15832188622', '{bcrypt}$2a$10$OQqQj10ZL9L37UrLGx5lpOxEITLbbS8IZJzT11GxdaZu0Lxq6L/5y', '6WWSFQ6DQL', '', '', '', '', '', '2018-09-12 13:15:28', '', '', '15832188622', '', 'NORMAL', '2018-09-07 11:56:21', '2018-09-07 11:56:21');
INSERT INTO `sys_user` VALUES ('19', '15832188621', '{bcrypt}$2a$10$OQqQj10ZL9L37UrLGx5lpOxEITLbbS8IZJzT11GxdaZu0Lxq6L/5y', '6WWSFQ6DQL', null, null, null, null, null, null, null, null, '15832188621', null, 'NORMAL', '2018-09-07 11:56:21', '2018-09-07 11:56:21');
INSERT INTO `sys_user` VALUES ('30', '15732158824', '{bcrypt}$2a$10$cKRbR9IJktfmKmf/wShyo.5.J8IxO/7YVn8twuWFtvPgruAF8gtKq', '243N73RDEM', null, null, null, null, '宋欣聪', null, '男', null, '15732158824', 'songxincong', 'NORMAL', '2018-09-10 11:31:33', '2018-09-10 11:31:33');
INSERT INTO `sys_user` VALUES ('36', '13011581270', '{bcrypt}$2a$10$I54u1k6NNwUaGkoAhJit4u89gTdHNAONsfVwBB3ptoLDsIKAOxIjG', '7FE7H4Q2MV', null, null, null, null, 'df', '2018-09-01 08:00:00', '男', 'fsdfsd', '13011581270', 'dfd', 'NORMAL', '2018-09-14 14:55:45', '2018-09-14 14:55:45');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户标识',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色标识',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(255) DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8 COMMENT='用户角色';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1', '1', '1', null, null);
INSERT INTO `sys_user_role` VALUES ('2', '2', '2', null, null);
INSERT INTO `sys_user_role` VALUES ('3', '9', '4', null, null);
INSERT INTO `sys_user_role` VALUES ('4', '4', '4', null, null);
INSERT INTO `sys_user_role` VALUES ('11', '19', '3', null, null);
INSERT INTO `sys_user_role` VALUES ('12', '19', '4', null, null);
INSERT INTO `sys_user_role` VALUES ('13', '19', '5', null, null);
INSERT INTO `sys_user_role` VALUES ('14', '20', '3', null, null);
INSERT INTO `sys_user_role` VALUES ('15', '20', '4', null, null);
INSERT INTO `sys_user_role` VALUES ('16', '20', '5', null, null);
INSERT INTO `sys_user_role` VALUES ('17', '21', '3', null, null);
INSERT INTO `sys_user_role` VALUES ('18', '21', '4', null, null);
INSERT INTO `sys_user_role` VALUES ('19', '21', '5', null, null);
INSERT INTO `sys_user_role` VALUES ('20', '22', '3', null, null);
INSERT INTO `sys_user_role` VALUES ('21', '22', '4', null, null);
INSERT INTO `sys_user_role` VALUES ('22', '22', '5', null, null);
INSERT INTO `sys_user_role` VALUES ('23', '23', '3', null, null);
INSERT INTO `sys_user_role` VALUES ('24', '23', '4', null, null);
INSERT INTO `sys_user_role` VALUES ('25', '23', '5', null, null);
INSERT INTO `sys_user_role` VALUES ('26', '24', '3', null, null);
INSERT INTO `sys_user_role` VALUES ('27', '24', '4', null, null);
INSERT INTO `sys_user_role` VALUES ('28', '24', '5', null, null);
INSERT INTO `sys_user_role` VALUES ('29', '25', '3', null, null);
INSERT INTO `sys_user_role` VALUES ('30', '25', '4', null, null);
INSERT INTO `sys_user_role` VALUES ('31', '25', '5', null, null);
INSERT INTO `sys_user_role` VALUES ('32', '26', '3', null, null);
INSERT INTO `sys_user_role` VALUES ('33', '26', '4', null, null);
INSERT INTO `sys_user_role` VALUES ('34', '26', '5', null, null);
INSERT INTO `sys_user_role` VALUES ('35', '27', '3', null, null);
INSERT INTO `sys_user_role` VALUES ('36', '27', '4', null, null);
INSERT INTO `sys_user_role` VALUES ('37', '27', '5', null, null);
INSERT INTO `sys_user_role` VALUES ('38', '28', '3', null, null);
INSERT INTO `sys_user_role` VALUES ('39', '28', '4', null, null);
INSERT INTO `sys_user_role` VALUES ('40', '28', '5', null, null);
INSERT INTO `sys_user_role` VALUES ('41', '29', '3', null, null);
INSERT INTO `sys_user_role` VALUES ('42', '29', '4', null, null);
INSERT INTO `sys_user_role` VALUES ('43', '29', '5', null, null);
INSERT INTO `sys_user_role` VALUES ('44', '30', '3', null, null);
INSERT INTO `sys_user_role` VALUES ('45', '30', '4', null, null);
INSERT INTO `sys_user_role` VALUES ('46', '30', '5', null, null);
INSERT INTO `sys_user_role` VALUES ('47', '31', '3', null, null);
INSERT INTO `sys_user_role` VALUES ('48', '31', '4', null, null);
INSERT INTO `sys_user_role` VALUES ('49', '31', '5', null, null);
INSERT INTO `sys_user_role` VALUES ('50', '32', '3', null, null);
INSERT INTO `sys_user_role` VALUES ('51', '32', '4', null, null);
INSERT INTO `sys_user_role` VALUES ('52', '32', '5', null, null);
INSERT INTO `sys_user_role` VALUES ('53', '33', '3', null, null);
INSERT INTO `sys_user_role` VALUES ('54', '33', '4', null, null);
INSERT INTO `sys_user_role` VALUES ('55', '33', '5', null, null);
INSERT INTO `sys_user_role` VALUES ('56', '34', '3', null, null);
INSERT INTO `sys_user_role` VALUES ('57', '34', '4', null, null);
INSERT INTO `sys_user_role` VALUES ('58', '34', '5', null, null);
INSERT INTO `sys_user_role` VALUES ('59', '35', '3', null, null);
INSERT INTO `sys_user_role` VALUES ('60', '35', '4', null, null);
INSERT INTO `sys_user_role` VALUES ('61', '35', '5', null, null);
INSERT INTO `sys_user_role` VALUES ('62', '36', '3', null, null);
INSERT INTO `sys_user_role` VALUES ('63', '36', '4', null, null);
INSERT INTO `sys_user_role` VALUES ('64', '36', '5', null, null);

-- ----------------------------
-- Table structure for tag
-- ----------------------------
DROP TABLE IF EXISTS `tag`;
CREATE TABLE `tag` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '标签标识',
  `tagType` varchar(10) NOT NULL COMMENT '标签类型',
  `tagName` varchar(240) NOT NULL COMMENT '标签名称',
  `tagNum` int(11) NOT NULL DEFAULT '0' COMMENT '引用个数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='标签';

-- ----------------------------
-- Records of tag
-- ----------------------------
INSERT INTO `tag` VALUES ('1', 'TEAM_TAG', '带薪年假', '0');
INSERT INTO `tag` VALUES ('2', 'TEAM_TAG', '年度旅游', '0');
INSERT INTO `tag` VALUES ('3', 'TEAM_TAG', '领导nice', '0');
INSERT INTO `tag` VALUES ('4', 'TEAM_TAG', '公司氛围好', '0');
INSERT INTO `tag` VALUES ('5', 'SKILL_TAG', '数据库', '0');
INSERT INTO `tag` VALUES ('6', 'SKILL_TAG', 'vue', '0');
INSERT INTO `tag` VALUES ('7', 'SKILL_TAG', 'js', '0');

-- ----------------------------
-- Table structure for tagmap
-- ----------------------------
DROP TABLE IF EXISTS `tagmap`;
CREATE TABLE `tagmap` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '标签映射标识',
  `tagType` varchar(10) NOT NULL COMMENT '标签类型',
  `tagId` bigint(20) NOT NULL COMMENT '标签标识',
  `mapId` bigint(20) NOT NULL COMMENT '映射标识',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8 COMMENT='标签映射表';

-- ----------------------------
-- Records of tagmap
-- ----------------------------
INSERT INTO `tagmap` VALUES ('33', 'SKILL_TAG', '5', '10');
INSERT INTO `tagmap` VALUES ('34', 'SKILL_TAG', '6', '10');
INSERT INTO `tagmap` VALUES ('47', 'TEAM_TAG', '1', '9');
INSERT INTO `tagmap` VALUES ('48', 'TEAM_TAG', '4', '9');
INSERT INTO `tagmap` VALUES ('49', 'SKILL_TAG', '6', '12');
INSERT INTO `tagmap` VALUES ('50', 'SKILL_TAG', '7', '12');
INSERT INTO `tagmap` VALUES ('55', 'SKILL_TAG', '7', '13');
INSERT INTO `tagmap` VALUES ('56', 'SKILL_TAG', '6', '13');
INSERT INTO `tagmap` VALUES ('57', 'SKILL_TAG', '6', '14');
INSERT INTO `tagmap` VALUES ('58', 'SKILL_TAG', '5', '14');

-- ----------------------------
-- Table structure for userblockcompany
-- ----------------------------
DROP TABLE IF EXISTS `userblockcompany`;
CREATE TABLE `userblockcompany` (
  `userId` bigint(20) DEFAULT NULL COMMENT '用户标识',
  `companyId` bigint(20) DEFAULT NULL COMMENT '企业标识',
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='屏蔽公司';

-- ----------------------------
-- Records of userblockcompany
-- ----------------------------

-- ----------------------------
-- Table structure for workexperience
-- ----------------------------
DROP TABLE IF EXISTS `workexperience`;
CREATE TABLE `workexperience` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '工作经验标识',
  `resumeId` bigint(20) NOT NULL COMMENT '简历标识',
  `startDate` date NOT NULL COMMENT '开始日期',
  `endDate` date NOT NULL COMMENT '结束日期',
  `companyName` varchar(240) NOT NULL COMMENT '公司名称',
  `department` varchar(240) DEFAULT NULL COMMENT '所属部门',
  `position` varchar(240) NOT NULL COMMENT '职位名称',
  `salary` varchar(45) DEFAULT NULL COMMENT '薪资待遇',
  `leaveReason` varchar(480) DEFAULT NULL COMMENT '离职原因',
  `jobExp` varchar(300) DEFAULT NULL COMMENT '工作经历',
  `industry` varchar(50) DEFAULT NULL,
  `positionType` varchar(10) NOT NULL COMMENT '职位类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='工作经验';

-- ----------------------------
-- Records of workexperience
-- ----------------------------
INSERT INTO `workexperience` VALUES ('1', '1', '2018-08-10', '2018-08-10', 'string', 'string', 'string', 'string', 'string', 'string', 'string', '607');
INSERT INTO `workexperience` VALUES ('2', '1', '2018-08-01', '2018-08-01', '腾讯科技', null, '全栈工程师', null, null, '全栈', '电子商务,互联网', '607');
INSERT INTO `workexperience` VALUES ('3', '1', '2018-08-01', '2018-08-01', '百度科技', null, '全栈工程师', null, null, '全栈', '电子商务,互联网', '607');
INSERT INTO `workexperience` VALUES ('4', '1', '2018-07-30', '2018-08-17', '测试最近公司', null, 'java工程师', null, null, null, null, '607');
INSERT INTO `workexperience` VALUES ('5', '1', '2018-06-07', '2018-08-18', '海伦人力', null, 'java开发工程师', null, null, null, null, '607');
INSERT INTO `workexperience` VALUES ('6', '2', '2015-08-01', '2016-08-01', '石药集团', null, '9', null, null, '11112222\n11112222333', '100009', '607');
INSERT INTO `workexperience` VALUES ('7', '4', '2018-09-01', '2018-09-01', 'cvcxvxcvcx', null, '661', null, null, 'bcvbcvbcvbcvbcv', '100022', '607');
INSERT INTO `workexperience` VALUES ('8', '4', '2018-09-01', '2018-09-01', 'cvcxvxcvcx', null, '661', null, null, 'bcvbcvbcvbcvbcv', '100022', '607');
INSERT INTO `workexperience` VALUES ('9', '4', '2018-09-01', '2018-09-01', 'cvcxvxcvcx', null, '661', null, null, 'bcvbcvbcvbcvbcv', '100022', '607');
INSERT INTO `workexperience` VALUES ('10', '7', '2018-09-01', '2018-01-01', '明年', null, '162', null, null, '红岭中学', '100011', '607');
INSERT INTO `workexperience` VALUES ('11', '8', '2018-09-01', '2018-09-01', 'going', null, '162', null, null, 'ing明敏', '100011', '607');
INSERT INTO `workexperience` VALUES ('13', '14', '2018-09-01', '2018-09-01', 'dfdfdfd', null, '0', null, null, 'sfsdfsdfsd', '100022', '607');
INSERT INTO `workexperience` VALUES ('14', '15', '2018-09-01', '2018-09-01', 'bjnbnbn', null, '607', null, null, 'gjfgdf', '100015', '607');
INSERT INTO `workexperience` VALUES ('15', '16', '2018-09-01', '2018-09-01', 'fg', null, 'vbvb', null, null, 'ghghg', '100019', '6');
