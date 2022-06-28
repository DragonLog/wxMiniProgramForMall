/*
Navicat MySQL Data Transfer

Source Server         : MySQL_local
Source Server Version : 80026
Source Host           : 192.168.212.128:3306
Source Database       : wxMiniApp

Target Server Type    : MYSQL
Target Server Version : 80026
File Encoding         : 65001

Date: 2022-03-21 20:25:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `carousel`
-- ----------------------------
DROP TABLE IF EXISTS `carousel`;
CREATE TABLE `carousel` (
  `carousel_id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`carousel_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of carousel
-- ----------------------------
INSERT INTO `carousel` VALUES ('1', '青春动漫周', '/images/0/a.jpg');
INSERT INTO `carousel` VALUES ('2', '读客大牌日', '/images/0/b.jpg');
INSERT INTO `carousel` VALUES ('3', '学海无涯书作舟', '/images/0/c.jpg');

-- ----------------------------
-- Table structure for `cart`
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart` (
  `cart_id` int NOT NULL AUTO_INCREMENT,
  `nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `tel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `good_id` int DEFAULT NULL,
  `checked` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `number` int DEFAULT NULL,
  PRIMARY KEY (`cart_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of cart
-- ----------------------------

-- ----------------------------
-- Table structure for `category`
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `category_id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', '言情类');
INSERT INTO `category` VALUES ('2', '科幻类');
INSERT INTO `category` VALUES ('3', '技术类');

-- ----------------------------
-- Table structure for `comment`
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `comment_id` int NOT NULL AUTO_INCREMENT,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `score` int DEFAULT NULL,
  `user_image_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `comment_image_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`comment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('1', '神的记事本', '2021-05-19 12:04:41', '5', '/images/user/user_1.jpg', '爱丽丝', '/images/comment/comment_1.jpg');
INSERT INTO `comment` VALUES ('2', '我的青春恋爱物语果然有问题', '2021-08-19 12:09:17', '5', '/images/user/user_2.jpg', '雪之下雪乃', '/images/comment/comment_2.jpg');
INSERT INTO `comment` VALUES ('3', '欢迎来到实力主义至上的教室', '2022-03-03 12:10:48', '5', '/images/user/user_3.jpg', '崛北铃音', '/images/comment/comment_3.jpg');
INSERT INTO `comment` VALUES ('4', '真恋 寄语枫秋', '2021-03-29 12:12:00', '5', '/images/user/user_4.jpg', '唐海音', '/images/comment/comment_4.jpg');
INSERT INTO `comment` VALUES ('5', '冰菓', '2022-01-03 12:13:24', '5', '/images/user/user_5.jpg', '千反田爱瑠', '/images/comment/comment_5.jpg');
INSERT INTO `comment` VALUES ('6', '缘之空', '2021-11-30 12:14:29', '5', '/images/user/user_6.jpg', '春日野穹', '/images/comment/comment_6.jpg');

-- ----------------------------
-- Table structure for `description`
-- ----------------------------
DROP TABLE IF EXISTS `description`;
CREATE TABLE `description` (
  `description_id` int NOT NULL AUTO_INCREMENT,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `good_id` int DEFAULT NULL,
  PRIMARY KEY (`description_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of description
-- ----------------------------
INSERT INTO `description` VALUES ('1', '/images/1/introduction_1.jpg', '1');
INSERT INTO `description` VALUES ('2', '/images/2/introduction_1.jpg', '2');
INSERT INTO `description` VALUES ('3', '/images/2/introduction_2.jpg', '2');
INSERT INTO `description` VALUES ('4', '/images/3/introduction_1.jpg', '3');
INSERT INTO `description` VALUES ('5', '/images/3/introduction_2.jpg', '3');
INSERT INTO `description` VALUES ('6', '/images/3/introduction_3.jpg', '3');
INSERT INTO `description` VALUES ('7', '/images/3/introduction_4.jpg', '3');
INSERT INTO `description` VALUES ('8', '/images/4/introduction_1.jpg', '4');
INSERT INTO `description` VALUES ('9', '/images/5/introduction_1.jpg', '5');
INSERT INTO `description` VALUES ('10', '/images/6/introduction_1.jpg', '6');
INSERT INTO `description` VALUES ('11', '/images/7/introduction_1.jpg', '7');
INSERT INTO `description` VALUES ('12', '/images/8/introduction_1.jpg', '8');

-- ----------------------------
-- Table structure for `good`
-- ----------------------------
DROP TABLE IF EXISTS `good`;
CREATE TABLE `good` (
  `good_id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `category_id` int DEFAULT NULL,
  `feature` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `price` int DEFAULT NULL,
  `good_comment` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `poster` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`good_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of good
-- ----------------------------
INSERT INTO `good` VALUES ('1', '《初晨，是我故意忘记你》', '1', '印刷质量很好，字体清晰。比书店便宜', '18', '85%', '/images/1/poster.jpg');
INSERT INTO `good` VALUES ('2', '《海底两万里》', '2', '海底两万里 原著无删减 七年级下册课外名著阅读书 温儒敏 人民教育出版社', '29', '85%', '/images/2/poster.jpg');
INSERT INTO `good` VALUES ('3', '《Java语言程序设计与数据结构》', '3', '(套装共2册） [Introduction to Java Programming and Data Structures]', '169', '75%', '/images/3/poster.jpg');
INSERT INTO `good` VALUES ('4', '《MySQL 8 Cookbook》', '3', '（中文版）(博文视点出品)', '100', '85%', '/images/4/poster.jpg');
INSERT INTO `good` VALUES ('5', '《Tomcat与Java Web开发技术详解》', '3', '（第3版）（含DVD光盘1张）', '129', '65%', '/images/5/poster.jpg');
INSERT INTO `good` VALUES ('6', '《深入浅出MyBatis技术原理与实战》', '3', '(博文视点出品)', '46', '75%', '/images/6/poster.jpg');
INSERT INTO `good` VALUES ('7', '《Spring Boot编程思想》', '3', '（核心篇）(博文视点出品)', '98', '95%', '/images/7/poster.jpg');
INSERT INTO `good` VALUES ('8', '《Spring Cloud Alibaba微服务原理与实战》', '3', '(京东定制 限量书签 随机发放)(博文视点出品)', '88', '90%', '/images/8/poster.jpg');

-- ----------------------------
-- Table structure for `slide`
-- ----------------------------
DROP TABLE IF EXISTS `slide`;
CREATE TABLE `slide` (
  `slide_id` int NOT NULL AUTO_INCREMENT,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `good_id` int DEFAULT NULL,
  PRIMARY KEY (`slide_id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of slide
-- ----------------------------
INSERT INTO `slide` VALUES ('1', '/images/1/detail_1.jpg', '1');
INSERT INTO `slide` VALUES ('2', '/images/1/detail_2.jpg', '1');
INSERT INTO `slide` VALUES ('3', '/images/2/detail_1.jpg', '2');
INSERT INTO `slide` VALUES ('4', '/images/2/detail_2.jpg', '2');
INSERT INTO `slide` VALUES ('5', '/images/2/detail_3.jpg', '2');
INSERT INTO `slide` VALUES ('6', '/images/2/detail_4.jpg', '2');
INSERT INTO `slide` VALUES ('7', '/images/3/detail_1.jpg', '3');
INSERT INTO `slide` VALUES ('8', '/images/3/detail_2.jpg', '3');
INSERT INTO `slide` VALUES ('9', '/images/4/detail_1.jpg', '4');
INSERT INTO `slide` VALUES ('10', '/images/4/detail_2.jpg', '4');
INSERT INTO `slide` VALUES ('11', '/images/4/detail_3.jpg', '4');
INSERT INTO `slide` VALUES ('12', '/images/4/detail_4.jpg', '4');
INSERT INTO `slide` VALUES ('13', '/images/5/detail_1.jpg', '5');
INSERT INTO `slide` VALUES ('14', '/images/5/detail_2.jpg', '5');
INSERT INTO `slide` VALUES ('15', '/images/5/detail_3.jpg', '5');
INSERT INTO `slide` VALUES ('16', '/images/5/detail_4.jpg', '5');
INSERT INTO `slide` VALUES ('17', '/images/6/detail_1.jpg', '6');
INSERT INTO `slide` VALUES ('18', '/images/6/detail_2.jpg', '6');
INSERT INTO `slide` VALUES ('19', '/images/6/detail_3.jpg', '6');
INSERT INTO `slide` VALUES ('20', '/images/6/detail_4.jpg', '6');
INSERT INTO `slide` VALUES ('21', '/images/7/detail_1.jpg', '7');
INSERT INTO `slide` VALUES ('22', '/images/7/detail_2.jpg', '7');
INSERT INTO `slide` VALUES ('23', '/images/7/detail_3.jpg', '7');
INSERT INTO `slide` VALUES ('24', '/images/7/detail_4.jpg', '7');
INSERT INTO `slide` VALUES ('25', '/images/8/detail_1.jpg', '8');
INSERT INTO `slide` VALUES ('26', '/images/8/detail_2.jpg', '8');
INSERT INTO `slide` VALUES ('27', '/images/8/detail_3.jpg', '8');
INSERT INTO `slide` VALUES ('28', '/images/8/detail_4.jpg', '8');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `gender` int DEFAULT NULL,
  `language` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `city` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `province` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `country` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `avatar_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `tel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of user
-- ----------------------------

-- ----------------------------
-- Table structure for `user_test`
-- ----------------------------
DROP TABLE IF EXISTS `user_test`;
CREATE TABLE `user_test` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of user_test
-- ----------------------------
INSERT INTO `user_test` VALUES ('22', 'zcx', '888888');
