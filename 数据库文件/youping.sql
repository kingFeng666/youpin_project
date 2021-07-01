/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : localhost:3306
 Source Schema         : youping

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 25/03/2021 21:35:47
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`  (
  `id` char(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键(商品id)',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '商品标题',
  `descp` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '商品描述',
  `origin_price` bigint NULL DEFAULT NULL COMMENT '商品原价(分)',
  `current_price` bigint NULL DEFAULT NULL COMMENT '商品现价(分)',
  `image_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '商品图片地址',
  `detail` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '商品详情',
  `status` tinyint UNSIGNED NOT NULL DEFAULT 0 COMMENT '商品状态 0:待审批  1:以上架  2:已拒绝',
  `c_id` char(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '商品分类id',
  `gmt_create` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '商品创建时间',
  `gmt_modify` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '商品修改日期',
  PRIMARY KEY (`id`) USING BTREE,
  FULLTEXT INDEX `ft_title`(`title`) WITH PARSER `ngram` COMMENT '全文索引使用的分词器为ngram'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('1374355959134326786', '来个offer', '来个offer', 2100, 999, '353926ae8f7a43fe9c587d17b3a2c305_来个offer.png', NULL, 0, NULL, '2021-03-23 21:42:49', '2021-03-23 21:42:49');
INSERT INTO `goods` VALUES ('1374356514195935233', '机械革命code01', '机械革命CODE 01是机械革命推出的一款笔记本电脑', 473900, 499900, 'bb68a1a56f3d45d6920fd51f6f5e7072_c8177f3e6709c93ddeca253ebbec36dad0005412.jpeg', NULL, 0, NULL, '2021-03-23 21:45:01', '2021-03-23 21:45:01');
INSERT INTO `goods` VALUES ('1374356924755382273', '漱口水', '防蛀牙', 412900, 100, '41dea4b27b98482ba99474425c84cc63_4E3F3011F726C4FF93B4B3A148DE6F11.jpg', NULL, 1, NULL, '2021-03-23 21:46:39', '2021-03-25 20:34:46');
INSERT INTO `goods` VALUES ('1374357140900450306', 'OppoReno5', 'Reno5 星河入梦', 266600, 269900, '2adea9fa00014375bf635b94a5822158_reno5.png', NULL, 0, NULL, '2021-03-23 21:47:31', '2021-03-23 21:47:31');
INSERT INTO `goods` VALUES ('1374357227210838018', 'OPPO 智能电视 R1 55英寸 ', 'OPPO 智能电视 R1 55英寸 ', 273900, 271900, 'ffe4f4a1b7d94f97a304b3cd62763326_TV.png', NULL, 0, NULL, '2021-03-23 21:47:51', '2021-03-23 21:47:51');
INSERT INTO `goods` VALUES ('1374357337449730049', 'OPPO Reno5 Pro 星河入梦 12G+256G', '6400万水光人像四摄，65W超级闪充，30个月流畅护航。', 4899, 3799, 'bbf175cd4f4f4fc68fa2f3bcb2f5d086_测试.png', NULL, 0, NULL, '2021-03-23 21:48:18', '2021-03-23 21:48:18');
INSERT INTO `goods` VALUES ('1374357540558901250', 'OPPO Find X3 镜黑 8G+128G', '①以旧换新最高补贴3800元（老用户有专享补贴哦）； ②抢前1000名晒单赠5000积分；③普卡及以上会员享1年4次免费贴膜服务；④OPPO Care+焕新版尊享服务限时8折购；⑤耳机套餐立减100元；⑥加1元购一拖三数据线。', 460000, 500000, 'ce89289560494569907f2da7520672b7_findx3.webp', NULL, 0, NULL, '2021-03-23 21:49:06', '2021-03-23 21:49:06');
INSERT INTO `goods` VALUES ('1374357670360027138', 'OPPO Enco X 真无线降噪耳机 蓝调', 'OPPO X 丹拿联合打造，DBEE3.0声音系统，双重主动降噪，支持通透模式，蓝牙5.2低延时双传告别卡顿。适配多款手机型号。', 99900, 99900, '1355b1c2801544828509ce0f676b580e_20210311070331604a0407941e9.webp', NULL, 0, NULL, '2021-03-23 21:49:37', '2021-03-23 21:49:37');
INSERT INTO `goods` VALUES ('1374357741197627394', 'OPPO 智能电视 R1 55英寸 ', '4K悬浮全面屏超清画质，四核疾速处理器秒开秒看，NFC一碰闪投，杜比音效带来影院级的观影体验。', 499900, 488800, 'b41ab9f262624ab4b488d203b5333476_TV.png', NULL, 0, NULL, '2021-03-23 21:49:54', '2021-03-23 21:49:54');
INSERT INTO `goods` VALUES ('1374358411959111682', '漱口水', '防蛀牙', 9922, 100, '6b8911888d9549a199ee371ce08d956f_4E3F3011F726C4FF93B4B3A148DE6F11.jpg', NULL, 0, NULL, '2021-03-23 21:52:34', '2021-03-23 21:52:34');
INSERT INTO `goods` VALUES ('1374358637537169410', 'OPPO Find X3', 'OPPO Find X3', 4499, 4299, '73d2c43cc8fd46ac8bc2c407bf9c4117_cc.jpg', NULL, 0, NULL, '2021-03-23 21:53:28', '2021-03-23 21:53:28');
INSERT INTO `goods` VALUES ('1374358878118252546', 'OPPO Watch 41mm 雅黑 ', '支持NFC门禁卡，AMOLED屏，双擎动力续航，长续航模式21天，运动健康伴侣，Watch VOOC闪充', 499900, 488800, '26720a6884714d1193945e442abd9f4c_aa.png', NULL, 0, NULL, '2021-03-23 21:54:25', '2021-03-23 21:54:25');
INSERT INTO `goods` VALUES ('1375074655096070145', '小米手机1', '小米手机采用nfc最新功能', 12000, 11000, '6e89eea0ce5f4ed2b2026e3200dfd75e_mm.jpg', NULL, 0, NULL, '2021-03-25 21:18:40', '2021-03-25 21:18:40');
INSERT INTO `goods` VALUES ('1375074833635069954', '小米手机1', '小米手机采用nfc最新功能', 12000, 11000, '88e94179d50f44b8b734b9c3bbf65c6a_mm.jpg', 'https://dsfs.oppo.com/archives/202010/202010310410315f9d1a8f2e00e.jpg,https://dsfs.oppo.com/archives/202010/202010310410355f9d1a93e92f2.jpg,https://dsfs.oppo.com/archives/202010/202010310410405f9d1a98cfb61.jpg', 0, NULL, '2021-03-25 21:19:22', '2021-03-25 21:19:22');
INSERT INTO `goods` VALUES ('1375077954910281729', '小米手机1', '小米手机采用nfc最新功能', 12000, 11000, 'cd99f4fee3ba447eb7371ac02c9c313f_mm.jpg', 'https://dsfs.oppo.com/archives/202010/202010310410315f9d1a8f2e00e.jpg,https://dsfs.oppo.com/archives/202010/202010310410355f9d1a93e92f2.jpg,https://dsfs.oppo.com/archives/202010/202010310410405f9d1a98cfb61.jpg', 0, '1375077547123269633', '2021-03-25 21:31:46', '2021-03-25 21:31:46');

-- ----------------------------
-- Table structure for goods_category
-- ----------------------------
DROP TABLE IF EXISTS `goods_category`;
CREATE TABLE `goods_category`  (
  `id` char(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '商品类别id',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '类别标题',
  `descp` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '类别描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods_category
-- ----------------------------
INSERT INTO `goods_category` VALUES ('1375077469990019073', '母婴用品', '母婴用的商品分类');
INSERT INTO `goods_category` VALUES ('1375077547123269633', '电子商品', '高科技电子产品');

-- ----------------------------
-- Table structure for goods_spec
-- ----------------------------
DROP TABLE IF EXISTS `goods_spec`;
CREATE TABLE `goods_spec`  (
  `id` char(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '商品规格id',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '规格名称',
  `g_id` char(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '商品id',
  `g_title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '商品标题',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods_spec
-- ----------------------------
INSERT INTO `goods_spec` VALUES ('1375071594525024258', '黑色', '1375071594415972354', '小米手机1');
INSERT INTO `goods_spec` VALUES ('1375071594525024259', '蓝色', '1375071594415972354', '小米手机1');
INSERT INTO `goods_spec` VALUES ('1375071594592133121', '红色', '1375071594415972354', '小米手机1');
INSERT INTO `goods_spec` VALUES ('1375074552469839874', '黑色', '1375074552469839873', '小米手机1');
INSERT INTO `goods_spec` VALUES ('1375074552469839875', '蓝色', '1375074552469839873', '小米手机1');
INSERT INTO `goods_spec` VALUES ('1375074552469839876', '红色', '1375074552469839873', '小米手机1');
INSERT INTO `goods_spec` VALUES ('1375074655096070146', '黑色', '1375074655096070145', '小米手机1');
INSERT INTO `goods_spec` VALUES ('1375074655096070147', '蓝色', '1375074655096070145', '小米手机1');
INSERT INTO `goods_spec` VALUES ('1375074655096070148', '红色', '1375074655096070145', '小米手机1');
INSERT INTO `goods_spec` VALUES ('1375074833840590850', '黑色', '1375074833635069954', '小米手机1');
INSERT INTO `goods_spec` VALUES ('1375074833840590851', '蓝色', '1375074833635069954', '小米手机1');
INSERT INTO `goods_spec` VALUES ('1375074833840590852', '红色', '1375074833635069954', '小米手机1');
INSERT INTO `goods_spec` VALUES ('1375077954977390594', '黑色', '1375077954910281729', '小米手机1');
INSERT INTO `goods_spec` VALUES ('1375077954977390595', '蓝色', '1375077954910281729', '小米手机1');
INSERT INTO `goods_spec` VALUES ('1375077954977390596', '红色', '1375077954910281729', '小米手机1');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` char(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键',
  `nickname` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `password` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户密码',
  `sex` tinyint NULL DEFAULT NULL COMMENT '用户性别',
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户头像',
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '手机号码',
  `gmt_create` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `gmt_modify` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `nickname`(`nickname`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` char(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键',
  `nickname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '管理员昵称',
  `password` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '管理员密码 ',
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '管理员头像',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '普通用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1374325809885773826', 'adminmm', 'b5e4d6c9d1745071a8eeef78175c38f1', NULL);
INSERT INTO `user` VALUES ('1374345804833390593', 'admin', '0192023a7bbd73250516f069df18b500', NULL);

SET FOREIGN_KEY_CHECKS = 1;
