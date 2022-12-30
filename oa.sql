/*
Navicat MySQL Data Transfer

Source Server         : 云点源泉
Source Server Version : 50722
Source Host           : localhost:3306
Source Database       : oa

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2021-11-18 17:28:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `claim_voucher`
-- ----------------------------
DROP TABLE IF EXISTS `claim_voucher`;
CREATE TABLE `claim_voucher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cause` varchar(100) DEFAULT NULL,
  `create_sn` char(5) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `next_deal_sn` char(5) DEFAULT NULL,
  `total_amount` double DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Reference_2` (`next_deal_sn`),
  KEY `FK_Reference_3` (`create_sn`),
  CONSTRAINT `FK_Reference_2` FOREIGN KEY (`next_deal_sn`) REFERENCES `employee` (`sn`),
  CONSTRAINT `FK_Reference_3` FOREIGN KEY (`create_sn`) REFERENCES `employee` (`sn`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of claim_voucher
-- ----------------------------
INSERT INTO `claim_voucher` VALUES ('21', '住宿', '10006', '2021-11-18 11:35:54', null, '300', '已终止');
INSERT INTO `claim_voucher` VALUES ('22', '住宿', '10005', '2021-11-18 11:48:58', null, '200', '已终止');
INSERT INTO `claim_voucher` VALUES ('23', '出差', '10001', '2021-11-18 15:14:10', '10001', '2300', '新创建');
INSERT INTO `claim_voucher` VALUES ('24', '应酬', '10004', '2021-11-18 15:26:33', null, '450', '已打款');
INSERT INTO `claim_voucher` VALUES ('25', '应酬', '10003', '2021-11-18 16:20:21', '10002', '3000', '已审核');
INSERT INTO `claim_voucher` VALUES ('27', '应酬', '10005', '2021-11-18 17:17:55', '10002', '6000', '已审核');

-- ----------------------------
-- Table structure for `claim_voucher_item`
-- ----------------------------
DROP TABLE IF EXISTS `claim_voucher_item`;
CREATE TABLE `claim_voucher_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `claim_voucher_id` int(11) DEFAULT NULL,
  `item` varchar(20) DEFAULT NULL,
  `amount` double DEFAULT NULL,
  `comment` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Reference_4` (`claim_voucher_id`),
  CONSTRAINT `FK_Reference_4` FOREIGN KEY (`claim_voucher_id`) REFERENCES `claim_voucher` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of claim_voucher_item
-- ----------------------------
INSERT INTO `claim_voucher_item` VALUES ('30', '21', '交通', '100', '地铁公交');
INSERT INTO `claim_voucher_item` VALUES ('31', '21', '餐饮', '200', '睡的好');
INSERT INTO `claim_voucher_item` VALUES ('32', '22', '交通', '100', '');
INSERT INTO `claim_voucher_item` VALUES ('33', '22', '住宿', '100', '');
INSERT INTO `claim_voucher_item` VALUES ('34', '23', '交通', '1000', '高铁');
INSERT INTO `claim_voucher_item` VALUES ('35', '23', '住宿', '1000', '全季酒店');
INSERT INTO `claim_voucher_item` VALUES ('36', '23', '餐饮', '300', '早餐午餐');
INSERT INTO `claim_voucher_item` VALUES ('37', '24', '交通', '50', '油费');
INSERT INTO `claim_voucher_item` VALUES ('38', '24', '餐饮', '400', '好吃的');
INSERT INTO `claim_voucher_item` VALUES ('42', '27', '餐饮', '1000', '吃饭');
INSERT INTO `claim_voucher_item` VALUES ('43', '27', '住宿', '5000', '北京饭店');

-- ----------------------------
-- Table structure for `deal_record`
-- ----------------------------
DROP TABLE IF EXISTS `deal_record`;
CREATE TABLE `deal_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `claim_voucher_id` int(11) DEFAULT NULL,
  `deal_sn` char(5) DEFAULT NULL,
  `deal_time` datetime DEFAULT NULL,
  `deal_way` varchar(20) DEFAULT NULL,
  `deal_result` varchar(20) DEFAULT NULL,
  `comment` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Reference_5` (`claim_voucher_id`),
  KEY `FK_Reference_6` (`deal_sn`),
  CONSTRAINT `FK_Reference_5` FOREIGN KEY (`claim_voucher_id`) REFERENCES `claim_voucher` (`id`),
  CONSTRAINT `FK_Reference_6` FOREIGN KEY (`deal_sn`) REFERENCES `employee` (`sn`)
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of deal_record
-- ----------------------------
INSERT INTO `deal_record` VALUES ('53', '21', '10006', '2021-11-18 11:36:23', '提交', '已提交', '无');
INSERT INTO `deal_record` VALUES ('54', '22', '10005', '2021-11-18 12:18:22', '提交', '已提交', '无');
INSERT INTO `deal_record` VALUES ('55', '24', '10004', '2021-11-18 15:28:07', '提交', '已提交', '无');
INSERT INTO `deal_record` VALUES ('56', '24', '10003', '2021-11-18 15:46:11', '打回', '已打回', '油费自报');
INSERT INTO `deal_record` VALUES ('57', '24', '10004', '2021-11-18 15:48:51', '提交', '已提交', '无');
INSERT INTO `deal_record` VALUES ('58', '24', '10003', '2021-11-18 15:49:55', '通过', '已审核', '');
INSERT INTO `deal_record` VALUES ('59', '24', '10002', '2021-11-18 15:54:48', '打款', '已打款', '');
INSERT INTO `deal_record` VALUES ('67', '21', '10003', '2021-11-18 17:14:22', '拒绝', '已终止', '');
INSERT INTO `deal_record` VALUES ('68', '27', '10005', '2021-11-18 17:18:10', '提交', '已提交', '无');
INSERT INTO `deal_record` VALUES ('69', '27', '10003', '2021-11-18 17:18:44', '通过', '待复审', '');
INSERT INTO `deal_record` VALUES ('70', '27', '10001', '2021-11-18 17:20:43', '通过', '已审核', '');

-- ----------------------------
-- Table structure for `department`
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `sn` char(5) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`sn`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('10001', '总经理办公室', '火星');
INSERT INTO `department` VALUES ('10002', '财务部', '火星');
INSERT INTO `department` VALUES ('10003', '事业部', '火星');
INSERT INTO `department` VALUES ('10004', '保安科', '火星');
INSERT INTO `department` VALUES ('10005', '销售部', '火星');

-- ----------------------------
-- Table structure for `employee`
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `sn` char(5) NOT NULL,
  `password` varchar(20) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `department_sn` char(5) DEFAULT NULL,
  `post` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`sn`),
  KEY `FK_Reference_1` (`department_sn`),
  CONSTRAINT `FK_Reference_1` FOREIGN KEY (`department_sn`) REFERENCES `department` (`sn`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('10001', '123', '栾桑', '10001', '总经理');
INSERT INTO `employee` VALUES ('10002', '123', '刘桑', '10002', '财务');
INSERT INTO `employee` VALUES ('10003', '123', '吴桑', '10003', '部门经理');
INSERT INTO `employee` VALUES ('10004', '123', '小佳丽', '10003', '员工');
INSERT INTO `employee` VALUES ('10005', '123', '小雯雯', '10003', '员工');
INSERT INTO `employee` VALUES ('10006', '123', '小成成', '10003', '员工');
