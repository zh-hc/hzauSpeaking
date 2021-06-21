/*
 Navicat Premium Data Transfer

 Source Server         : aliyun
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : rm-2zej1pi96x442bux5bo.mysql.rds.aliyuncs.com:3306
 Source Schema         : tieba

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 17/06/2021 19:59:57
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for attend
-- ----------------------------
DROP TABLE IF EXISTS `attend`;
CREATE TABLE `attend`  (
  `attend_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `message_id` int(11) NOT NULL,
  PRIMARY KEY (`attend_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of attend
-- ----------------------------
INSERT INTO `attend` VALUES (12, 25, 27);
INSERT INTO `attend` VALUES (13, 24, 27);
INSERT INTO `attend` VALUES (14, 26, 26);
INSERT INTO `attend` VALUES (15, 27, 27);
INSERT INTO `attend` VALUES (16, 25, 28);
INSERT INTO `attend` VALUES (17, 29, 28);
INSERT INTO `attend` VALUES (18, 27, 28);
INSERT INTO `attend` VALUES (19, 26, 34);

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `category_image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`category_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES (1, '失物招领', 'https://pic.imgdb.cn/item/60c24b41844ef46bb29b6381.png');
INSERT INTO `category` VALUES (2, '交友墙', 'https://pic.imgdb.cn/item/60c24cc4844ef46bb2b8c54c.png');
INSERT INTO `category` VALUES (3, '拼车', 'https://pic.imgdb.cn/item/60c24ce3844ef46bb2bb030d.png');
INSERT INTO `category` VALUES (4, '兼职', 'https://pic.imgdb.cn/item/60c24d1b844ef46bb2bf2cda.png');
INSERT INTO `category` VALUES (5, '闲置交易', 'https://pic.imgdb.cn/item/60c24d3d844ef46bb2c1b1a9.png');
INSERT INTO `category` VALUES (6, '相约学习', 'https://pic.imgdb.cn/item/60c24d75844ef46bb2c5c81a.png');
INSERT INTO `category` VALUES (7, '校园活动', 'https://pic.imgdb.cn/item/60c24e13844ef46bb2d17957.png');
INSERT INTO `category` VALUES (8, '吐槽专区', 'https://pic.imgdb.cn/item/60c24e5c844ef46bb2d69d73.png');
INSERT INTO `category` VALUES (9, '资源分享', 'https://pic.imgdb.cn/item/60c24e92844ef46bb2da6be3.png');
INSERT INTO `category` VALUES (10, '我想要的', 'https://pic.imgdb.cn/item/60c24ea8844ef46bb2dc1563.png');
INSERT INTO `category` VALUES (11, '最新消息', 'https://pic.imgdb.cn/item/60c24ec3844ef46bb2de01d8.png');
INSERT INTO `category` VALUES (12, '问题反馈', 'https://pic.imgdb.cn/item/60c24ee4844ef46bb2e067d7.png');
INSERT INTO `category` VALUES (13, '问题解答', 'https://pic.imgdb.cn/item/60c24f09844ef46bb2e2fa80.png');

-- ----------------------------
-- Table structure for collect
-- ----------------------------
DROP TABLE IF EXISTS `collect`;
CREATE TABLE `collect`  (
  `collect_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `message_id` int(11) NOT NULL,
  PRIMARY KEY (`collect_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of collect
-- ----------------------------
INSERT INTO `collect` VALUES (11, 24, 26);
INSERT INTO `collect` VALUES (13, 27, 26);
INSERT INTO `collect` VALUES (14, 27, 28);
INSERT INTO `collect` VALUES (16, 26, 34);

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `comment_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `message_id` int(11) NOT NULL,
  `comment_detail` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `comment_creat_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`comment_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 38 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES (31, 25, 27, '这是啥', '2021-06-10 09:40:34');
INSERT INTO `comment` VALUES (32, 26, 26, '嗯~~', '2021-06-11 01:10:37');
INSERT INTO `comment` VALUES (33, 27, 27, '好可爱', '2021-06-11 15:33:16');
INSERT INTO `comment` VALUES (34, 25, 28, '这是哪位小可爱发的小图片呀？', '2021-06-11 15:42:16');
INSERT INTO `comment` VALUES (37, 26, 34, '111', '2021-06-11 19:52:05');

-- ----------------------------
-- Table structure for comment_reply
-- ----------------------------
DROP TABLE IF EXISTS `comment_reply`;
CREATE TABLE `comment_reply`  (
  `comment_reply_id` int(11) NOT NULL AUTO_INCREMENT,
  `comment_id` int(11) NOT NULL,
  `comment_user_id` int(11) NOT NULL,
  `replay_user_id` int(11) NOT NULL,
  `replay_user_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `receive_user_id` int(11) NOT NULL,
  `receive_user_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `reply_detail` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `reply_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`comment_reply_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of comment_reply
-- ----------------------------
INSERT INTO `comment_reply` VALUES (5, 11, 21, 21, '勿忘我', 21, '勿忘我', 'asdasdasdasdasdasdasdasdas', '2019-08-17 16:32:05');
INSERT INTO `comment_reply` VALUES (11, 11, 21, 21, '勿忘我', 21, '勿忘我', '我我关心你??????', '2019-08-17 16:54:06');
INSERT INTO `comment_reply` VALUES (18, 31, 25, 24, '小白', 25, 'Totora6', '???', '2021-06-10 20:43:58');
INSERT INTO `comment_reply` VALUES (19, 34, 25, 25, 'Totora6', 25, 'Totora6', '哦！原来是我自己', '2021-06-11 15:42:30');
INSERT INTO `comment_reply` VALUES (20, 34, 25, 29, '伊始', 25, 'Totora6', '？？？', '2021-06-11 15:44:57');
INSERT INTO `comment_reply` VALUES (21, 34, 25, 27, 'HUI子', 25, 'Totora6', '哈哈哈哈哈哈哈', '2021-06-11 17:01:03');

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message`  (
  `message_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id_anonymity` int(11) NOT NULL DEFAULT 0,
  `user_id` int(11) NOT NULL,
  `category_id` int(11) NOT NULL,
  `user_phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `user_major` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `user_level` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `message_detail` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `message_share` int(11) NOT NULL DEFAULT 0,
  `message_comment` int(11) NOT NULL DEFAULT 0,
  `message_watch` int(11) NOT NULL DEFAULT 0,
  `message_creat_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`message_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 40 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES (26, 0, 24, 2, '13211111111', '信息专业', '19', '嘿嘿嘿', 0, 1, 19, '2021-06-09 23:09:42');
INSERT INTO `message` VALUES (27, 0, 25, 2, '15611111111', '信息专业', '18', '额呵呵呵护', 2, 2, 46, '2021-06-10 09:40:12');
INSERT INTO `message` VALUES (28, 0, 25, 10, '15211111111', '计算机科学与技术', '19', '哈尔的移动城堡', 2, 1, 35, '2021-06-11 15:41:33');
INSERT INTO `message` VALUES (29, 0, 24, 2, '13211111111', '信息学院专业', '19', 'test', 0, 0, 8, '2021-06-11 18:28:55');
INSERT INTO `message` VALUES (30, 0, 26, 2, '13217874312', '计科专业', '18', 'hello', 0, 0, 8, '2021-06-11 18:44:06');
INSERT INTO `message` VALUES (31, 0, 25, 1, '15211113333', '计算机科学', '19', '大家好！', 0, 0, 4, '2021-06-11 19:10:49');
INSERT INTO `message` VALUES (32, 0, 25, 2, '15233335555', '华农说叭专业', '19', '华农说叭yyds', 0, 0, 0, '2021-06-11 19:11:26');
INSERT INTO `message` VALUES (33, 0, 25, 7, '15233335555', '信息学院', '19', '华农说叭上线啦', 0, 0, 5, '2021-06-11 19:14:16');
INSERT INTO `message` VALUES (34, 0, 24, 11, '18264510000', '计算机', '18', '定向越野地图', 0, 1, 14, '2021-06-11 19:15:37');
INSERT INTO `message` VALUES (35, 1, 25, 2, '15263555461', '数据库吧', '18', '我匿名啦！猜猜我是谁嗷', 0, 0, 9, '2021-06-11 19:15:38');
INSERT INTO `message` VALUES (36, 1, 25, 3, '15233335555', '信息学院', '18', '有同学去逸夫楼嘛？', 0, 0, 5, '2021-06-11 19:19:43');
INSERT INTO `message` VALUES (37, 1, 25, 8, '15222222554', '信息学院', '19', '6月份跑南湖好累哇😭 ', 0, 0, 14, '2021-06-11 19:21:22');
INSERT INTO `message` VALUES (38, 0, 24, 11, '18264518955', '计算机', '19', '云服务器 云数据库 test', 0, 0, 10, '2021-06-16 16:25:58');
INSERT INTO `message` VALUES (39, 0, 33, 6, '13522225632', '计算机科学与技术', '19', '今天计组实验考试呜呜呜呜呜呜', 0, 0, 15, '2021-06-17 09:28:00');

-- ----------------------------
-- Table structure for message_images
-- ----------------------------
DROP TABLE IF EXISTS `message_images`;
CREATE TABLE `message_images`  (
  `image_id` int(11) NOT NULL AUTO_INCREMENT,
  `message_id` int(11) NOT NULL,
  `image_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`image_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 40 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of message_images
-- ----------------------------
INSERT INTO `message_images` VALUES (29, 26, 'images/2021/06/09 23:09:42/162325138234129.png');
INSERT INTO `message_images` VALUES (30, 27, 'images/2021/06/10 09:40:13/162328921327687.png');
INSERT INTO `message_images` VALUES (31, 28, 'images/2021/06/11 15:41:33/162339729382249.png');
INSERT INTO `message_images` VALUES (32, 29, 'images/2021/06/11 18:28:57/162340733722456.png');
INSERT INTO `message_images` VALUES (33, 30, 'images/2021/06/11 18:44:07/1623408247696140.png');
INSERT INTO `message_images` VALUES (34, 31, 'images/2021/06/11 19:10:51/162340985123928.png');
INSERT INTO `message_images` VALUES (35, 33, 'images/2021/06/11 19:14:18/162341005816985.png');
INSERT INTO `message_images` VALUES (36, 34, 'images/2021/06/11 19:15:39/162341013948622.png');
INSERT INTO `message_images` VALUES (37, 35, 'images/2021/06/11 19:15:40/162341014041139.png');
INSERT INTO `message_images` VALUES (38, 38, 'images/2021/06/16 16:25:58/1623831958064133.png');
INSERT INTO `message_images` VALUES (39, 39, 'images/2021/06/17 09:27:59/162389327984768.png');

-- ----------------------------
-- Table structure for new_message
-- ----------------------------
DROP TABLE IF EXISTS `new_message`;
CREATE TABLE `new_message`  (
  `new_message_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `new_message_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `new_message_type` int(11) NOT NULL,
  `message_id` int(11) NOT NULL,
  `new_message_detail` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`new_message_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 38 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of new_message
-- ----------------------------
INSERT INTO `new_message` VALUES ('2021-06-10 09:41:11', 28, 25, 2, 27, '这是留言呀傻瓜');
INSERT INTO `new_message` VALUES ('2021-06-10 20:43:58', 29, 25, 2, 27, '???');
INSERT INTO `new_message` VALUES ('2021-06-11 01:10:37', 31, 24, 1, 26, '嗯~~');
INSERT INTO `new_message` VALUES ('2021-06-11 15:33:16', 32, 25, 1, 27, '好可爱');
INSERT INTO `new_message` VALUES ('2021-06-11 15:44:57', 33, 25, 2, 28, '？？？');
INSERT INTO `new_message` VALUES ('2021-06-11 16:07:27', 34, 25, 1, 28, 'nice');
INSERT INTO `new_message` VALUES ('2021-06-11 16:32:42', 35, 25, 1, 28, '哈哈哈哈哈哈哈');
INSERT INTO `new_message` VALUES ('2021-06-11 17:01:03', 36, 25, 2, 28, '哈哈哈哈哈哈哈');
INSERT INTO `new_message` VALUES ('2021-06-11 19:52:05', 37, 24, 1, 34, '111');

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice`  (
  `notice_id` int(11) NOT NULL AUTO_INCREMENT,
  `notice_detail` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`notice_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO `notice` VALUES (1, 'hazuSpeaking内测开始啦');
INSERT INTO `notice` VALUES (2, '欢迎大家使用');
INSERT INTO `notice` VALUES (3, '如果有问题，请联系我~');

-- ----------------------------
-- Table structure for shop
-- ----------------------------
DROP TABLE IF EXISTS `shop`;
CREATE TABLE `shop`  (
  `shop_id` int(11) NOT NULL AUTO_INCREMENT,
  `shop_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `shop_intro` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `shop_phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `shop_avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `shop_latitude` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `shop_longitude` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `shop_creat_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`shop_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of shop
-- ----------------------------
INSERT INTO `shop` VALUES (1, '某某商店', '一段描述', '123456789000', 'https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=457057301,2957259415&fm=26&gp=0.jpg', '108.9431762695', '34.2679987360', '2019-08-15 19:00:00');
INSERT INTO `shop` VALUES (2, '某某商店', '一段描述', '666666666666', 'https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=457057301,2957259415&fm=26&gp=0.jpg', '108', '34', '2019-08-15 20:25:33');

-- ----------------------------
-- Table structure for shop_business
-- ----------------------------
DROP TABLE IF EXISTS `shop_business`;
CREATE TABLE `shop_business`  (
  `business_id` int(11) NOT NULL AUTO_INCREMENT,
  `shop_id` int(11) NOT NULL,
  `shop_goods_image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `shop_goods_title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `shop_goods_price` decimal(10, 2) NOT NULL,
  PRIMARY KEY (`business_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of shop_business
-- ----------------------------
INSERT INTO `shop_business` VALUES (1, 1, 'https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=457057301,2957259415&fm=26&gp=0.jpg', '盖饭', 15.00);
INSERT INTO `shop_business` VALUES (2, 1, 'https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=457057301,2957259415&fm=26&gp=0.jpg', '测试', 20.00);
INSERT INTO `shop_business` VALUES (3, 2, 'https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=457057301,2957259415&fm=26&gp=0.jpg', '测试', 15.00);
INSERT INTO `shop_business` VALUES (4, 2, 'https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=457057301,2957259415&fm=26&gp=0.jpg', '米饭', 10.00);

-- ----------------------------
-- Table structure for shop_images
-- ----------------------------
DROP TABLE IF EXISTS `shop_images`;
CREATE TABLE `shop_images`  (
  `shop_detail_id` int(11) NOT NULL AUTO_INCREMENT,
  `shop_id` int(11) NOT NULL,
  `shop_images` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`shop_detail_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of shop_images
-- ----------------------------
INSERT INTO `shop_images` VALUES (1, 1, 'https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=457057301,2957259415&fm=26&gp=0.jpg');
INSERT INTO `shop_images` VALUES (2, 1, 'https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=457057301,2957259415&fm=26&gp=0.jpg');
INSERT INTO `shop_images` VALUES (3, 2, 'https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=457057301,2957259415&fm=26&gp=0.jpg');
INSERT INTO `shop_images` VALUES (4, 2, 'https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=457057301,2957259415&fm=26&gp=0.jpg');

-- ----------------------------
-- Table structure for swiper
-- ----------------------------
DROP TABLE IF EXISTS `swiper`;
CREATE TABLE `swiper`  (
  `swiper_id` int(11) NOT NULL AUTO_INCREMENT,
  `swiper_image_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`swiper_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of swiper
-- ----------------------------
INSERT INTO `swiper` VALUES (1, 'http://img0.imgtn.bdimg.com/it/u=424233641,3202817263&fm=15&gp=0.jpg');
INSERT INTO `swiper` VALUES (2, 'http://img4.imgtn.bdimg.com/it/u=285866535,754232053&fm=15&gp=0.jpg');
INSERT INTO `swiper` VALUES (3, 'http://img0.imgtn.bdimg.com/it/u=4147480226,3583698002&fm=15&gp=0.jpg');
INSERT INTO `swiper` VALUES (4, 'http://img0.imgtn.bdimg.com/it/u=1055990694,1882863912&fm=15&gp=0.jpg');
INSERT INTO `swiper` VALUES (5, 'http://img0.imgtn.bdimg.com/it/u=3585502864,1315933428&fm=15&gp=0.jpg');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_openid` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `user_gender` int(11) NOT NULL,
  `user_avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `user_nickname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `user_is_admin` int(11) NOT NULL DEFAULT 1,
  `user_allow` int(11) NOT NULL DEFAULT 1,
  `user_creat_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 34 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (24, 'oYb0H5dMEaCK6LuWIN4MZFX_cVy4', 0, 'https://thirdwx.qlogo.cn/mmopen/vi_32/C1sP4jZ4KvcoKmic1G9X7YW935eATy1G0pBSGcC0ricLSmbJJEc67qKSyx3PiaBBWxJ9FibbuKBp7Rlalib3LYsEZWQ/132', '小白', 2, 1, '2021-06-09 23:06:01');
INSERT INTO `user` VALUES (25, 'oYb0H5X01i9gJLPB8xWSgoB_JIno', 2, 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKjpazPz4xaMGhlweoYvumP0s0f6w0SXOUCHEEFjSc4ov665Fu47HW5D8f0AN91U3WZ9we8m9gedA/132', 'Totora6', 1, 1, '2021-06-10 09:37:16');
INSERT INTO `user` VALUES (26, 'oYb0H5dld4Tiv_K-j7YOJgSTNeFE', 0, 'https://thirdwx.qlogo.cn/mmopen/vi_32/tCfsbRgTxbrbAbNh4CTTruH5SpXPUQJYibkoLx0ialuSTM5GgviaAiaichYGicSFvRLc7LdAvXyqxKA7px6mJIRPFC9w/132', '小白177', 2, 1, '2021-06-11 01:10:17');
INSERT INTO `user` VALUES (27, 'o3RBE5YVQ_lJNeQ6RiBmXspiaX4s', 2, 'https://thirdwx.qlogo.cn/mmopen/vi_32/ibKoXvoCmeqN6gwrlefh9FcNjTrbMISug2BvHlfrtOVOgqXYR64OQrFVx86mdJ8ZV7VeT5NXkvLKCm162QxOJicg/132', 'HUI子', 2, 1, '2021-06-11 15:12:52');
INSERT INTO `user` VALUES (28, 'o3RBE5SdeEPOnoLnUGwXS88OnTdE', 2, 'https://thirdwx.qlogo.cn/mmopen/vi_32/M82ndQ3p4dHiaJjWjJWCJnOlMvpbHn6COkfnFmlEsW1gsUehesDjbHtfcIbT1ic0NNRqEHbYHY7GyxZO0MpWrmlQ/132', '跃迁的海狸子', 1, 1, '2021-06-11 15:16:33');
INSERT INTO `user` VALUES (29, 'oYb0H5SrD0J1Dhe_Z9G-cmVu_LXU', 2, 'https://thirdwx.qlogo.cn/mmopen/vi_32/6ajyJKqQ5x45t9FVPVW0IQv604xIdsPEWH9Hb9f0M7Kvjx9STYow1n2J8n9IROGbaHWHeF8G9ublSGajhwIC3Q/132', '伊始', 1, 1, '2021-06-11 15:44:09');
INSERT INTO `user` VALUES (33, 'oYb0H5fdw95Yjyquc52e6tPUXQ98', 1, 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTL0t7yhQWgibtgVKgheIiaCn5HxNO7nh39ksu1dQJgeUAKCiaRCe7gr3uUJ5sCw2q6yyToRRicz9icibOYQ/132', '勇敢的心', 1, 1, '2021-06-17 09:25:16');

SET FOREIGN_KEY_CHECKS = 1;
