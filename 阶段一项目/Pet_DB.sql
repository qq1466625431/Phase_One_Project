/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80026
 Source Host           : localhost:3306
 Source Schema         : Pet_DB

 Target Server Type    : MySQL
 Target Server Version : 80026
 File Encoding         : 65001

 Date: 23/08/2021 20:30:25
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for merchant
-- ----------------------------
DROP TABLE IF EXISTS `merchant`;
CREATE TABLE `merchant`  (
  `Mid` int NOT NULL AUTO_INCREMENT,
  `musername` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `mpassword` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `balance` double NULL DEFAULT NULL,
  `moldusername` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`Mid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 101 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of merchant
-- ----------------------------
INSERT INTO `merchant` VALUES (100, 'zhangsan', '123456', 100, '张三宠物店');
INSERT INTO `merchant` VALUES (101, 'lisi', '123456', 5700, NULL);
INSERT INTO `merchant` VALUES (102, 'xiaogang', '123456', 10600, NULL);
INSERT INTO `merchant` VALUES (103, 'test', 'test', NULL, NULL);

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `Oid` int NOT NULL AUTO_INCREMENT,
  `O_type` int NOT NULL,
  `Pet_id` int NOT NULL,
  `Seller_id` int NOT NULL,
  `Buyer_id` int NULL DEFAULT NULL,
  `Price` double NOT NULL,
  `Deal_Time` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`Oid`) USING BTREE,
  INDEX `Pet_id`(`Pet_id`) USING BTREE,
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`Pet_id`) REFERENCES `pet` (`Pid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 10013007 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES (10013006, 2, 3001, 1001, 100, 300, '2021-08-21 02:48:53');
INSERT INTO `orders` VALUES (10013008, 1, 3002, 101, 1001, 200, '2021-08-23 03:42:25');
INSERT INTO `orders` VALUES (10013009, 1, 3003, 101, 1001, 500, '2021-08-23 03:46:27');
INSERT INTO `orders` VALUES (10013010, 2, 3001, 1001, 100, 300, '2021-08-23 06:06:59');
INSERT INTO `orders` VALUES (10013011, 2, 3002, 1001, 100, 200, '2021-08-23 06:10:29');
INSERT INTO `orders` VALUES (10013012, 1, 3001, 100, 1008, 300, '2021-08-23 07:01:40');
INSERT INTO `orders` VALUES (10013013, 1, 3002, 100, 1001, 200, '2021-08-23 08:23:08');
INSERT INTO `orders` VALUES (10013014, 1, 3004, 102, 1001, 600, '2021-08-23 12:28:51');

-- ----------------------------
-- Table structure for pet
-- ----------------------------
DROP TABLE IF EXISTS `pet`;
CREATE TABLE `pet`  (
  `Pid` int NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `pet_type` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `health` int NULL DEFAULT 60,
  `love` int NULL DEFAULT 0,
  `Birthday` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  `User_id` int NULL DEFAULT NULL,
  `Merchant_id` int NOT NULL,
  `Exchange` int NULL DEFAULT 1,
  `PET_PRICE` double NULL DEFAULT 500,
  PRIMARY KEY (`Pid`) USING BTREE,
  UNIQUE INDEX `name`(`name`) USING BTREE,
  INDEX `Merchant_id`(`Merchant_id`) USING BTREE,
  INDEX `User_id`(`User_id`) USING BTREE,
  CONSTRAINT `pet_ibfk_1` FOREIGN KEY (`Merchant_id`) REFERENCES `merchant` (`Mid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `pet_ibfk_2` FOREIGN KEY (`User_id`) REFERENCES `user` (`Uid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 3012 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of pet
-- ----------------------------
INSERT INTO `pet` VALUES (3001, '小灰', 'dog', 75, 15, '2021-08-18 11:08:41', 1008, 100, 2, 300);
INSERT INTO `pet` VALUES (3002, '小黑', 'cat', 60, 0, '2021-08-18 11:08:41', 1001, 100, 2, 200);
INSERT INTO `pet` VALUES (3003, '小黄', '鸟', 77, 0, '2021-08-19 10:55:03', 1001, 101, 2, 500);
INSERT INTO `pet` VALUES (3004, '小青', '蛇', 65, 5, '2021-08-19 12:31:59', 1001, 102, 2, 600);
INSERT INTO `pet` VALUES (3005, '小红', '猪', 60, 0, '2021-08-19 12:32:19', NULL, 101, 1, 760);
INSERT INTO `pet` VALUES (3006, '小绿', '蜥蜴', 60, 0, '2021-08-19 12:32:32', NULL, 102, 1, 450);
INSERT INTO `pet` VALUES (3007, '小紫', '蝴蝶', 60, 0, '2021-08-19 12:33:15', NULL, 101, 1, 209);
INSERT INTO `pet` VALUES (3008, '小橙', '乌龟', 60, 20, '2021-08-20 02:02:28', NULL, 101, 1, 99);
INSERT INTO `pet` VALUES (3013, 'siri', '狗狗', 90, 30, '2021-08-23 06:51:16', NULL, 100, 1, 100);
INSERT INTO `pet` VALUES (3014, 'test', 'tset', 100, 20, '2021-08-23 08:26:00', NULL, 100, 1, 100);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `Uid` int NOT NULL AUTO_INCREMENT,
  `username` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `money` double NOT NULL DEFAULT 0,
  `oldusername` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`Uid`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1000, 'admin6', '1111111', 5000, 'admin');
INSERT INTO `user` VALUES (1001, 'admin', '111111', 9200, 'admin');
INSERT INTO `user` VALUES (1002, 'admin3', '123456', 0, NULL);
INSERT INTO `user` VALUES (1003, 'admin4', '123456', 0, NULL);
INSERT INTO `user` VALUES (1004, 'admin11', '111111', 0, 'admin');
INSERT INTO `user` VALUES (1008, 'zhaowu', '11111', 700, NULL);
INSERT INTO `user` VALUES (1009, 'test11', '1111', 0, NULL);

SET FOREIGN_KEY_CHECKS = 1;
