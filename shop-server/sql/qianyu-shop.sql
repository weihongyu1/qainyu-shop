/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80026
 Source Host           : localhost:3306
 Source Schema         : qianyu-shop

 Target Server Type    : MySQL
 Target Server Version : 80026
 File Encoding         : 65001

 Date: 27/05/2022 19:03:15
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for commodity
-- ----------------------------
DROP TABLE IF EXISTS `commodity`;
CREATE TABLE `commodity`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `commodity_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '商品名称',
  `commodity_describe` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '商品描述',
  `stock` int NOT NULL COMMENT '商品库存',
  `ship_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '发货地址',
  `take_down` int NULL DEFAULT NULL COMMENT '是否已下架',
  `take_up_time` date NULL DEFAULT NULL COMMENT '商品上架时间',
  `sale_time` date NULL DEFAULT NULL COMMENT '商品销售时间',
  `category` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '商品分类',
  `price` decimal(10, 2) NULL DEFAULT NULL COMMENT '商品价格',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of commodity
-- ----------------------------
INSERT INTO `commodity` VALUES (1, '半亩花田-磨砂膏', '洗护用品', 11, '浙江省金华市', 0, '2022-05-03', '2022-05-04', '生活家居', 256.00);
INSERT INTO `commodity` VALUES (2, 'oppo-r17', '充电5分钟，通话两小时', 7, '浙江省杭州市', 0, '2022-05-09', '2022-05-09', '数码产品', 3467.00);
INSERT INTO `commodity` VALUES (3, '李宁', '轻巧回弹', 21, '浙江省温州市', 0, '2022-05-15', '2022-05-14', '潮流服饰', 288.00);
INSERT INTO `commodity` VALUES (4, '小米手机', '1亿像素，照亮你的美', 100, '江苏省镇江市', 1, '2022-05-17', '2022-05-16', '数码产品', 3299.00);
INSERT INTO `commodity` VALUES (5, 'vivo iQOO Neo6 SE', '12GB+256GB 星际 高通骁龙870 双电芯80W闪充 OIS光学防抖 双模5G全网通手机iqooneo6se', 11, '浙江省杭州市', 0, '2022-05-15', '2022-05-14', '数码产品', 2499.00);
INSERT INTO `commodity` VALUES (6, '荣耀Play6T', '6.74英寸高刷护眼屏 侧边指纹解锁 5000mAh大电池 全网通 5G手机 8GB+128GB 钛空银', 20, '浙江省杭州市', 0, '2022-05-24', '2022-05-23', '数码产品', 1199.00);
INSERT INTO `commodity` VALUES (7, 'Redmi Note 9 Pro', '5G 一亿像素 骁龙750G 33W快充 120Hz刷新率 静默星空 8GB+256GB 智能手机 小米 红米', 20, '浙江省杭州市', 0, '2022-05-24', '2022-05-23', '数码产品', 1399.00);
INSERT INTO `commodity` VALUES (8, 'Redmi K50', '天玑8100 2K柔性直屏 OIS光学防抖 67W快充 5500mAh大电量 墨羽 12GB+256GB 5G智能手机 小米 红米', 97, '浙江省杭州市', 0, '2022-05-21', '2022-05-20', '潮流服饰', 2599.00);
INSERT INTO `commodity` VALUES (9, 'Hi nova 9z', '5G全网通 6400万像素超清摄影 66W疾速快充 6.67英寸120Hz原彩屏 8+256GB 亮黑色5G手机', 999, '江苏省南京市', 0, '2022-05-23', '2022-05-22', '数码产品', 1999.00);
INSERT INTO `commodity` VALUES (10, '小米收集', '1亿像素，照亮你的美', 100, '江苏省镇江市', 1, '2022-05-26', '2022-05-17', '数码产品', 3299.00);

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `role` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '权限',
  `role_describe` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '权限描述',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `sy_permission`(`role`) USING BTREE COMMENT '角色名称唯一'
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES (1, 'admin', '管理员');
INSERT INTO `permission` VALUES (4, 'tourists', '游客，未登录用户');
INSERT INTO `permission` VALUES (5, 'general_user', '普通的登录游客');

-- ----------------------------
-- Table structure for sign_in
-- ----------------------------
DROP TABLE IF EXISTS `sign_in`;
CREATE TABLE `sign_in`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '登录id',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名',
  `login_date` date NULL DEFAULT NULL COMMENT '登录时间',
  `u_id` int NULL DEFAULT NULL COMMENT '外键',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `sy_name`(`name`) USING BTREE COMMENT '用户名索引',
  INDEX `fk_u_id`(`u_id`) USING BTREE,
  CONSTRAINT `fk_u_id` FOREIGN KEY (`u_id`) REFERENCES `user_login` (`u_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sign_in
-- ----------------------------

-- ----------------------------
-- Table structure for tbl_order
-- ----------------------------
DROP TABLE IF EXISTS `tbl_order`;
CREATE TABLE `tbl_order`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `c_id` int NOT NULL COMMENT '商品id',
  `u_id` int NOT NULL COMMENT '用户id',
  `recipient` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '收件人',
  `recive_phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '收件电话',
  `options` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '省市value',
  `recive_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '收件地址',
  `payment_status` int NULL DEFAULT NULL COMMENT '是否已支付',
  `order_date` datetime NULL DEFAULT NULL COMMENT '订单创建时间',
  `delivery_time` datetime NULL DEFAULT NULL COMMENT '发货时间',
  `order_desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '订单描述',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_cid`(`c_id`) USING BTREE,
  INDEX `fk_uer_login`(`u_id`) USING BTREE,
  CONSTRAINT `fk_cid` FOREIGN KEY (`c_id`) REFERENCES `commodity` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_uer_login` FOREIGN KEY (`u_id`) REFERENCES `user_login` (`u_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 30 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_order
-- ----------------------------
INSERT INTO `tbl_order` VALUES (1, 1, 2, 'wyy', '15337086013', NULL, '江苏省镇江市京口区学府路301号', 1, '2022-05-12 00:00:00', '2022-05-13 00:00:00', NULL);
INSERT INTO `tbl_order` VALUES (2, 1, 2, 'why', '17826078022', NULL, '甘肃省兰州市榆中县', 1, '2022-05-12 00:00:00', '2022-05-13 00:00:00', NULL);
INSERT INTO `tbl_order` VALUES (5, 1, 2, 'wyy', '15337086013', '[320000, 321100]', '京口区学府路301号', 1, '2022-05-14 00:00:00', '2022-05-14 00:00:00', '请保持电话畅通，及时收货。');
INSERT INTO `tbl_order` VALUES (6, 1, 2, 'cjl', '17826078022', '[140000, 140100]', '太原理工大学', 1, '2022-05-14 00:00:00', '2022-05-14 00:00:00', '请保持电话通畅');
INSERT INTO `tbl_order` VALUES (7, 1, 2, 'lrx', '15678925843', '[370000, 370100]', '中国重汽', 1, '2022-05-14 00:00:00', '2022-05-14 00:00:00', '请保持电话畅通');
INSERT INTO `tbl_order` VALUES (9, 1, 2, 'wyy', '15337086013', '[]', '甘肃省兰州市', 1, '2022-05-14 00:00:00', '2022-05-14 00:00:00', 'desc');
INSERT INTO `tbl_order` VALUES (10, 1, 2, 'wyy', '15337086013', '[]', '河北省石家庄', 1, '2022-05-14 09:58:01', '2022-05-14 09:57:56', 'desc');
INSERT INTO `tbl_order` VALUES (11, 2, 2, 'ywl', '15117274416', '[]', '甘肃省兰州市七里河区龚家湾兰州理工大学西校区', 1, '2022-05-15 05:49:59', '2022-05-15 05:49:41', '已拍，加急');
INSERT INTO `tbl_order` VALUES (12, 2, 2, '李四', '15337086013', '[]', '北京市市辖区', 1, '2022-05-15 06:09:44', '2022-05-15 06:02:12', '已拍，加急');
INSERT INTO `tbl_order` VALUES (13, 2, 2, 'why', '12315351864', '[320000, 321100]', '江苏省镇江市京口区江苏大学', 0, '2022-05-25 13:38:03', '2022-05-25 13:38:03', '已拍，加急！');
INSERT INTO `tbl_order` VALUES (14, 1, 2, 'why', '17856134523', '[]', '浙江省杭州市余杭区五常街道301', 0, '2022-05-25 13:39:28', '2022-05-25 13:39:27', '请尽快发货');
INSERT INTO `tbl_order` VALUES (15, 5, 2, 'why', '15345627612', '[]', '甘肃省兰州市七里河区', 0, '2022-05-25 13:50:56', '2022-05-25 13:50:55', '已拍加急');
INSERT INTO `tbl_order` VALUES (16, 5, 2, 'why', '15345627612', '[]', '甘肃省兰州市七里河区', 0, '2022-05-25 13:50:59', '2022-05-25 13:50:58', '已拍加急');
INSERT INTO `tbl_order` VALUES (17, 5, 2, 'why', '15345627612', '[]', '甘肃省兰州市七里河区', 0, '2022-05-25 13:55:45', '2022-05-25 13:55:44', '已拍加急');
INSERT INTO `tbl_order` VALUES (18, 5, 2, 'why', '15334520486', '[]', '甘肃省兰州市七里河区', 0, '2022-05-25 14:03:17', '2022-05-25 14:03:17', '加急');
INSERT INTO `tbl_order` VALUES (19, 5, 2, 'why', '15334520486', '[]', '甘肃省兰州市七里河区', 0, '2022-05-25 14:04:19', '2022-05-25 14:04:17', '加急');
INSERT INTO `tbl_order` VALUES (20, 5, 2, '', '', '[]', '', 0, '2022-05-25 14:04:40', '2022-05-25 14:04:40', '');
INSERT INTO `tbl_order` VALUES (21, 5, 2, 'why', '15378254631', '[]', '江苏省镇江市京口区学府路301号', 1, '2022-05-25 14:15:57', '2022-05-25 14:15:57', '已拍，加急！');
INSERT INTO `tbl_order` VALUES (22, 1, 2, 'why', '12385648203', '[]', '甘肃省兰州市', 1, '2022-05-26 06:37:11', '2022-05-26 06:37:10', '加急');
INSERT INTO `tbl_order` VALUES (23, 5, 2, 'cjl', '13549254064', '[]', '江苏省镇江市', 1, '2022-05-26 06:48:15', '2022-05-26 06:48:14', '加急');
INSERT INTO `tbl_order` VALUES (24, 5, 2, 'cjl', '12564894236', '[]', '江苏省镇江市', 1, '2022-05-26 06:49:32', '2022-05-26 06:49:31', '加急');
INSERT INTO `tbl_order` VALUES (25, 8, 2, 'wyq', '15345206912', '[]', '江苏省镇江市', 1, '2022-05-26 06:53:00', '2022-05-26 06:52:59', '加急');
INSERT INTO `tbl_order` VALUES (26, 8, 2, 'lrx', '17856245963', '[]', '浙江省杭州市', 1, '2022-05-26 06:55:09', '2022-05-26 06:55:08', '加急');
INSERT INTO `tbl_order` VALUES (27, 8, 2, 'xch', '13854692654', '[]', '陕西省西安市', 1, '2022-05-26 06:57:22', '2022-05-26 06:57:21', '加急');
INSERT INTO `tbl_order` VALUES (28, 9, 2, 'why', '14523695203', '[]', '甘肃省兰州市', 1, '2022-05-26 07:03:01', '2022-05-26 07:03:00', '加急');
INSERT INTO `tbl_order` VALUES (29, 2, 2, 'why', '15762595302', '[]', '甘肃省兰州市', 1, '2022-05-27 08:11:23', '2022-05-27 08:11:22', '加急');

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '用户信息 id',
  `phone_number` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '电话号码',
  `email` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '邮箱地址',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '家庭住址',
  `u_id` int NULL DEFAULT NULL COMMENT '用户登录id',
  `introduction` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '介绍',
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户头像url',
  `create_date` date NULL DEFAULT NULL COMMENT '账户创建日期',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_uid`(`u_id`) USING BTREE,
  CONSTRAINT `fk_uid` FOREIGN KEY (`u_id`) REFERENCES `user_login` (`u_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES (1, '15337086013', '488009667@qq.com', '江苏省镇江市京口区象山街道学府路301号', 2, '计算机程序员', 'https://gitee.com/vvwhyyy/pic/raw/master/img/202205121233899.png', '2022-05-15');

-- ----------------------------
-- Table structure for user_login
-- ----------------------------
DROP TABLE IF EXISTS `user_login`;
CREATE TABLE `user_login`  (
  `u_id` int NOT NULL AUTO_INCREMENT COMMENT '用户id，主键',
  `account` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名',
  `pass_word` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码',
  `role` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '权限',
  PRIMARY KEY (`u_id`) USING BTREE,
  UNIQUE INDEX `unique_account`(`account`) USING BTREE COMMENT '用户名唯一索引',
  INDEX `fk_role`(`role`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_login
-- ----------------------------
INSERT INTO `user_login` VALUES (2, 'why', '123', 'admin');

-- ----------------------------
-- Table structure for user_login_list
-- ----------------------------
DROP TABLE IF EXISTS `user_login_list`;
CREATE TABLE `user_login_list`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `u_id` int NULL DEFAULT NULL COMMENT '用户登录id',
  `login_time` datetime NULL DEFAULT NULL COMMENT '登录时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_login_list
-- ----------------------------
INSERT INTO `user_login_list` VALUES (2, 2, '2022-05-27 08:10:53');

SET FOREIGN_KEY_CHECKS = 1;
