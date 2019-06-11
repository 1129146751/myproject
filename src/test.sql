/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50634
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 50634
 File Encoding         : 65001

 Date: 11/06/2019 16:48:20
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for c_class
-- ----------------------------
DROP TABLE IF EXISTS `c_class`;
CREATE TABLE `c_class`  (
  `id` int(10) NULL DEFAULT NULL,
  `class_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  INDEX `indexName`(`class_name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '班级表\r\n' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of c_class
-- ----------------------------
INSERT INTO `c_class` VALUES (11, '1班');
INSERT INTO `c_class` VALUES (22, '2班');

-- ----------------------------
-- Table structure for dic
-- ----------------------------
DROP TABLE IF EXISTS `dic`;
CREATE TABLE `dic`  (
  `code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of dic
-- ----------------------------
INSERT INTO `dic` VALUES ('1001', '重庆', 'ARA');
INSERT INTO `dic` VALUES ('1002', '上海', 'ARA');
INSERT INTO `dic` VALUES ('1003', '北京', 'ARA');

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee`  (
  `emp_id` int(10) NOT NULL AUTO_INCREMENT,
  `emp_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gender` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `d_id` int(10) NULL DEFAULT NULL,
  `state` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`emp_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 55 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES (1, '张三', '1', '123@qq.com', 22, '1');
INSERT INTO `employee` VALUES (2, '李四', '1', 'lisi@qq.com', 22, '1');
INSERT INTO `employee` VALUES (3, '小明', '1', 'xiaoming@', 22, '1');
INSERT INTO `employee` VALUES (4, '小红', '1', 'xiaohong', 44, '1');
INSERT INTO `employee` VALUES (5, '小刚', '1', 'xiaogang', 22, '1');
INSERT INTO `employee` VALUES (6, '小文', '1', 'xiaoli', 441, '1');
INSERT INTO `employee` VALUES (11, 'self', '1', NULL, NULL, '1');
INSERT INTO `employee` VALUES (12, 'jj', '1', NULL, NULL, '1');
INSERT INTO `employee` VALUES (13, 'gg', '1', NULL, NULL, '1');
INSERT INTO `employee` VALUES (14, NULL, '1', NULL, NULL, '1');
INSERT INTO `employee` VALUES (15, 'self', '2', NULL, NULL, '1');
INSERT INTO `employee` VALUES (16, 'gg', '2', NULL, NULL, '1');
INSERT INTO `employee` VALUES (17, 'self', '2', NULL, NULL, '1');
INSERT INTO `employee` VALUES (18, 'gg', '2', NULL, NULL, '1');
INSERT INTO `employee` VALUES (19, 'self', '2', NULL, NULL, '1');
INSERT INTO `employee` VALUES (20, 'gg', '2', NULL, NULL, '1');
INSERT INTO `employee` VALUES (21, 'self', '2', NULL, NULL, '1');
INSERT INTO `employee` VALUES (22, 'gg', '2', NULL, NULL, '1');
INSERT INTO `employee` VALUES (23, '小明', '2', 'xiaoming@', NULL, '1');
INSERT INTO `employee` VALUES (24, '小红', '2', 'xiaohong', NULL, '1');
INSERT INTO `employee` VALUES (25, '小明', '2', 'xiaoming@', NULL, '1');
INSERT INTO `employee` VALUES (26, '小红', '2', 'xiaohong', NULL, '1');
INSERT INTO `employee` VALUES (27, '1', NULL, 'xiaoming@', NULL, '1');
INSERT INTO `employee` VALUES (28, '2', NULL, 'xiaohong', NULL, '1');
INSERT INTO `employee` VALUES (29, '测试', '1', 'xiaoming@', NULL, '1');
INSERT INTO `employee` VALUES (30, '测试2', '2', 'xiaohong', NULL, '1');
INSERT INTO `employee` VALUES (31, '测试', '1', 'xiaoming@', NULL, '1');
INSERT INTO `employee` VALUES (32, '测试2', '2', 'xiaohong', NULL, '1');
INSERT INTO `employee` VALUES (33, '王老师', '1', NULL, NULL, '1');
INSERT INTO `employee` VALUES (34, '张老师', '1', NULL, NULL, '1');
INSERT INTO `employee` VALUES (35, '王老师', '1', NULL, NULL, '1');
INSERT INTO `employee` VALUES (36, '张老师', '1', NULL, NULL, '1');
INSERT INTO `employee` VALUES (37, '王老师', '1', NULL, NULL, '1');
INSERT INTO `employee` VALUES (38, '张老师', '1', NULL, NULL, '1');
INSERT INTO `employee` VALUES (39, '王老师', '1', NULL, NULL, '1');
INSERT INTO `employee` VALUES (40, '张老师', '1', NULL, NULL, '1');
INSERT INTO `employee` VALUES (41, '王老师', '1', NULL, NULL, '1');
INSERT INTO `employee` VALUES (42, '张老师', '1', NULL, NULL, '1');
INSERT INTO `employee` VALUES (43, '1', NULL, 'xiaoming@', NULL, '1');
INSERT INTO `employee` VALUES (44, '2', NULL, 'xiaohong', NULL, '1');
INSERT INTO `employee` VALUES (45, '哈哈哈', '1', 'xiaoming@', NULL, '1');
INSERT INTO `employee` VALUES (46, '呵呵呵', '2', 'xiaohong', NULL, '1');
INSERT INTO `employee` VALUES (47, '小明', '1', 'xiaoming@', NULL, '1');
INSERT INTO `employee` VALUES (48, '小红', '2', 'xiaohong', NULL, '1');
INSERT INTO `employee` VALUES (49, 'ceshi', '1', 'xiaoming@', NULL, '1');
INSERT INTO `employee` VALUES (50, 'rrrr', '1', 'xiaohong', NULL, '1');
INSERT INTO `employee` VALUES (51, 'hao老师', '1', NULL, NULL, '1');
INSERT INTO `employee` VALUES (52, 'hao老师', '1', NULL, NULL, '1');
INSERT INTO `employee` VALUES (53, 'hao老师', '1', NULL, NULL, '1');
INSERT INTO `employee` VALUES (54, 'hao老师', '1', NULL, NULL, '1');

-- ----------------------------
-- Table structure for login_log
-- ----------------------------
DROP TABLE IF EXISTS `login_log`;
CREATE TABLE `login_log`  (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录人',
  `user_ip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录的电脑ip地址',
  `tiime` timestamp(6) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '登录时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 76 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '祖师' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of login_log
-- ----------------------------
INSERT INTO `login_log` VALUES (1, '张三', 'C64-20190315BSR/192.168.44.201', NULL);
INSERT INTO `login_log` VALUES (2, '张三', 'C64-20190315BSR/192.168.44.201', '2019-06-06 10:23:58.870000');
INSERT INTO `login_log` VALUES (3, '张三', 'C64-20190315BSR/192.168.44.201', '2019-06-06 10:32:20.934000');
INSERT INTO `login_log` VALUES (4, '张三', 'C64-20190315BSR/192.168.44.201', '2019-06-06 10:35:11.601000');
INSERT INTO `login_log` VALUES (5, '张三', 'C64-20190315BSR/192.168.44.201', '2019-06-06 10:42:16.334000');
INSERT INTO `login_log` VALUES (6, '张三', 'C64-20190315BSR/192.168.44.201', '2019-06-06 10:46:06.013000');
INSERT INTO `login_log` VALUES (7, '张三', 'C64-20190315BSR/192.168.44.201', '2019-06-06 11:13:53.011000');
INSERT INTO `login_log` VALUES (8, '张三', 'C64-20190315BSR/192.168.44.201', '2019-06-06 11:18:57.875000');
INSERT INTO `login_log` VALUES (9, '张三', 'C64-20190315BSR/192.168.44.201', '2019-06-06 11:21:03.080000');
INSERT INTO `login_log` VALUES (10, '张三', 'C64-20190315BSR/192.168.44.201', '2019-06-06 12:33:45.914000');
INSERT INTO `login_log` VALUES (11, '张三', 'C64-20190315BSR/192.168.44.201', '2019-06-06 13:16:46.417000');
INSERT INTO `login_log` VALUES (12, '张三', 'C64-20190315BSR/192.168.44.201', '2019-06-06 14:28:16.309000');
INSERT INTO `login_log` VALUES (13, '张三', 'C64-20190315BSR/192.168.44.201', '2019-06-06 14:32:14.372000');
INSERT INTO `login_log` VALUES (14, '张三', 'C64-20190315BSR/192.168.44.201', '2019-06-06 14:44:10.093000');
INSERT INTO `login_log` VALUES (15, '张三', 'C64-20190315BSR/192.168.44.201', '2019-06-06 14:49:46.151000');
INSERT INTO `login_log` VALUES (16, '张三', 'C64-20190315BSR/192.168.44.201', '2019-06-06 14:52:01.816000');
INSERT INTO `login_log` VALUES (17, '张三', 'C64-20190315BSR/192.168.44.201', '2019-06-06 15:02:20.801000');
INSERT INTO `login_log` VALUES (18, '张三', 'C64-20190315BSR/192.168.44.201', '2019-06-06 15:21:50.117000');
INSERT INTO `login_log` VALUES (19, '张三', 'C64-20190315BSR/192.168.44.201', '2019-06-06 15:30:37.012000');
INSERT INTO `login_log` VALUES (20, '张三', 'C64-20190315BSR/192.168.44.201', '2019-06-06 15:42:22.813000');
INSERT INTO `login_log` VALUES (21, '张三', 'C64-20190315BSR/192.168.44.201', '2019-06-06 15:49:53.686000');
INSERT INTO `login_log` VALUES (22, '张三', 'C64-20190315BSR/192.168.44.201', '2019-06-06 16:11:54.824000');
INSERT INTO `login_log` VALUES (23, '张三', 'C64-20190315BSR/192.168.44.201', '2019-06-06 16:27:39.768000');
INSERT INTO `login_log` VALUES (24, '张三', 'C64-20190315BSR/192.168.44.201', '2019-06-06 16:49:04.374000');
INSERT INTO `login_log` VALUES (25, '张三', 'C64-20190315BSR/192.168.44.201', '2019-06-06 17:11:46.422000');
INSERT INTO `login_log` VALUES (26, '张三', 'C64-20190315BSR/192.168.44.201', '2019-06-06 17:37:06.475000');
INSERT INTO `login_log` VALUES (27, '张三', 'C64-20190315BSR/192.168.44.201', '2019-06-06 17:49:09.346000');
INSERT INTO `login_log` VALUES (28, '张三', 'C64-20190315BSR/192.168.44.201', '2019-06-06 17:52:28.279000');
INSERT INTO `login_log` VALUES (29, '张三', 'C64-20190315BSR/192.168.44.201', '2019-06-06 17:54:17.440000');
INSERT INTO `login_log` VALUES (30, '张三', 'C64-20190315BSR/192.168.44.201', '2019-06-06 17:59:07.016000');
INSERT INTO `login_log` VALUES (31, '张三', 'C64-20190315BSR/192.168.44.201', '2019-06-06 18:01:45.935000');
INSERT INTO `login_log` VALUES (32, '张三', 'C64-20190315BSR/192.168.44.201', '2019-06-06 18:08:15.279000');
INSERT INTO `login_log` VALUES (33, '张三', 'C64-20190315BSR/192.168.44.201', '2019-06-06 18:08:45.106000');
INSERT INTO `login_log` VALUES (34, '张三', 'C64-20190315BSR/192.168.44.201', '2019-06-10 13:30:01.051000');
INSERT INTO `login_log` VALUES (35, '张三', 'C64-20190315BSR/192.168.44.201', '2019-06-10 13:41:35.000000');
INSERT INTO `login_log` VALUES (36, '张三', 'C64-20190315BSR/192.168.44.201', '2019-06-10 13:49:35.144000');
INSERT INTO `login_log` VALUES (37, '张三', 'C64-20190315BSR/192.168.44.201', '2019-06-10 14:15:11.288000');
INSERT INTO `login_log` VALUES (38, '张三', 'C64-20190315BSR/192.168.44.201', '2019-06-10 14:17:01.973000');
INSERT INTO `login_log` VALUES (39, '张三', 'C64-20190315BSR/192.168.44.201', '2019-06-10 14:46:42.354000');
INSERT INTO `login_log` VALUES (40, '张三', 'C64-20190315BSR/192.168.44.201', '2019-06-10 15:05:48.001000');
INSERT INTO `login_log` VALUES (41, '张三', 'C64-20190315BSR/192.168.44.201', '2019-06-10 15:20:12.759000');
INSERT INTO `login_log` VALUES (42, '张三', 'C64-20190315BSR/192.168.44.201', '2019-06-10 15:58:59.264000');
INSERT INTO `login_log` VALUES (43, '张三', 'C64-20190315BSR/192.168.44.201', '2019-06-10 16:02:29.524000');
INSERT INTO `login_log` VALUES (44, '张三', 'C64-20190315BSR/192.168.44.201', '2019-06-10 16:04:19.819000');
INSERT INTO `login_log` VALUES (45, '张三', 'C64-20190315BSR/192.168.44.201', '2019-06-10 16:08:24.555000');
INSERT INTO `login_log` VALUES (46, '张三', 'C64-20190315BSR/192.168.44.201', '2019-06-10 16:29:23.957000');
INSERT INTO `login_log` VALUES (47, '张三', 'C64-20190315BSR/192.168.44.201', '2019-06-10 16:36:25.113000');
INSERT INTO `login_log` VALUES (48, '张三', 'C64-20190315BSR/192.168.44.201', '2019-06-10 16:39:57.160000');
INSERT INTO `login_log` VALUES (49, '张三', 'C64-20190315BSR/192.168.44.201', '2019-06-10 16:51:07.373000');
INSERT INTO `login_log` VALUES (50, '张三', 'C64-20190315BSR/192.168.44.201', '2019-06-10 17:12:20.724000');
INSERT INTO `login_log` VALUES (51, '张三', 'C64-20190315BSR/192.168.44.201', '2019-06-10 17:48:54.584000');
INSERT INTO `login_log` VALUES (52, '张三', 'C64-20190315BSR/192.168.44.201', '2019-06-10 17:58:26.715000');
INSERT INTO `login_log` VALUES (53, '张三', 'C64-20190315BSR/192.168.44.201', '2019-06-11 10:06:14.896000');
INSERT INTO `login_log` VALUES (54, '张三', 'C64-20190315BSR/192.168.44.201', '2019-06-11 10:07:37.309000');
INSERT INTO `login_log` VALUES (55, '张三', 'C64-20190315BSR/192.168.44.201', '2019-06-11 10:28:31.293000');
INSERT INTO `login_log` VALUES (56, '张三', 'C64-20190315BSR/192.168.44.201', '2019-06-11 10:51:45.540000');
INSERT INTO `login_log` VALUES (57, '张三', 'C64-20190315BSR/192.168.44.201', '2019-06-11 11:03:42.951000');
INSERT INTO `login_log` VALUES (58, '张三', 'C64-20190315BSR/192.168.44.201', '2019-06-11 13:28:23.253000');
INSERT INTO `login_log` VALUES (59, '张三', 'C64-20190315BSR/192.168.44.201', '2019-06-11 13:34:37.370000');
INSERT INTO `login_log` VALUES (60, '张三', 'C64-20190315BSR/192.168.44.201', '2019-06-11 13:52:15.662000');
INSERT INTO `login_log` VALUES (61, '张三', 'C64-20190315BSR/192.168.44.201', '2019-06-11 14:08:23.237000');
INSERT INTO `login_log` VALUES (62, '张三', 'C64-20190315BSR/192.168.44.201', '2019-06-11 14:15:38.574000');
INSERT INTO `login_log` VALUES (63, '张三', 'C64-20190315BSR/192.168.44.201', '2019-06-11 14:43:49.026000');
INSERT INTO `login_log` VALUES (64, '张三', 'C64-20190315BSR/192.168.44.201', '2019-06-11 14:46:12.291000');
INSERT INTO `login_log` VALUES (65, '张三', 'C64-20190315BSR/192.168.44.201', '2019-06-11 14:46:54.163000');
INSERT INTO `login_log` VALUES (66, '张三', 'C64-20190315BSR/192.168.44.201', '2019-06-11 14:48:29.404000');
INSERT INTO `login_log` VALUES (67, '张三', 'C64-20190315BSR/192.168.44.201', '2019-06-11 14:54:41.122000');
INSERT INTO `login_log` VALUES (68, '张三', 'C64-20190315BSR/192.168.44.201', '2019-06-11 14:55:34.950000');
INSERT INTO `login_log` VALUES (69, '张三', 'C64-20190315BSR/192.168.44.201', '2019-06-11 15:10:23.803000');
INSERT INTO `login_log` VALUES (70, '张三', 'C64-20190315BSR/192.168.44.201', '2019-06-11 15:13:16.776000');
INSERT INTO `login_log` VALUES (71, '张三', 'C64-20190315BSR/192.168.44.201', '2019-06-11 15:16:11.239000');
INSERT INTO `login_log` VALUES (72, '张三', 'C64-20190315BSR/192.168.44.201', '2019-06-11 15:33:54.925000');
INSERT INTO `login_log` VALUES (73, '张三', 'C64-20190315BSR/192.168.44.201', '2019-06-11 15:51:56.446000');
INSERT INTO `login_log` VALUES (74, '张三', 'C64-20190315BSR/192.168.44.201', '2019-06-11 15:53:59.236000');
INSERT INTO `login_log` VALUES (75, '张三', 'C64-20190315BSR/192.168.44.201', '2019-06-11 15:59:40.405000');

-- ----------------------------
-- Table structure for role_resource
-- ----------------------------
DROP TABLE IF EXISTS `role_resource`;
CREATE TABLE `role_resource`  (
  `role_id` int(20) NULL DEFAULT NULL,
  `resource_id` int(20) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of role_resource
-- ----------------------------
INSERT INTO `role_resource` VALUES (1, 1);
INSERT INTO `role_resource` VALUES (2, 2);
INSERT INTO `role_resource` VALUES (1, 2);
INSERT INTO `role_resource` VALUES (1, 3);
INSERT INTO `role_resource` VALUES (1, 4);

-- ----------------------------
-- Table structure for s_student
-- ----------------------------
DROP TABLE IF EXISTS `s_student`;
CREATE TABLE `s_student`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `age` int(11) NULL DEFAULT NULL,
  `class_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `time` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of s_student
-- ----------------------------
INSERT INTO `s_student` VALUES (1, 'mapper', '1', 1, '11', '2019-03-21 10:51:02');
INSERT INTO `s_student` VALUES (2, '李四', '1', 2, '22', '2019-04-09 13:24:47');
INSERT INTO `s_student` VALUES (3, '小敏', '1', 1, '11', NULL);
INSERT INTO `s_student` VALUES (4, '小南国', '1', 1, '11', NULL);
INSERT INTO `s_student` VALUES (5, '张三', '1', 1, '11', '2019-03-21 10:51:02');

-- ----------------------------
-- Table structure for shiro_confige
-- ----------------------------
DROP TABLE IF EXISTS `shiro_confige`;
CREATE TABLE `shiro_confige`  (
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `roles` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`url`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of shiro_confige
-- ----------------------------
INSERT INTO `shiro_confige` VALUES ('/user/getVerify', 'anon');

-- ----------------------------
-- Table structure for sys_attach
-- ----------------------------
DROP TABLE IF EXISTS `sys_attach`;
CREATE TABLE `sys_attach`  (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `file_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件类型',
  `file_old_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '原文件名',
  `file_sys_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '现文件名',
  `file_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件存储路径',
  `operate_user` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '上传者',
  `create_time` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '上传时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_attach
-- ----------------------------
INSERT INTO `sys_attach` VALUES (1, NULL, 'generatorConfig.xml', '20190507151715.xml', 'd:\\usr\\java\\uploadfile\\20190507151715.xml', '??', NULL);
INSERT INTO `sys_attach` VALUES (2, NULL, 'pom.xml', '20190507151926.xml', 'd:\\usr\\java\\uploadfile\\20190507151926.xml', '张三', NULL);
INSERT INTO `sys_attach` VALUES (3, NULL, 'WinSCP-5.14.4.RC-Setup.exe', '20190507152036.exe', 'd:\\usr\\java\\uploadfile\\20190507152036.exe', '张三', NULL);
INSERT INTO `sys_attach` VALUES (4, NULL, '.springBeans', '20190507153932.springBeans', '/usr/java/uploadfile/20190507153932.springBeans', '张三', NULL);
INSERT INTO `sys_attach` VALUES (5, NULL, '.project', '20190507162613.project', '\\usr\\java\\uploadfile\\20190507162613.project', '张三', NULL);
INSERT INTO `sys_attach` VALUES (6, NULL, '.classpath', '20190507162815.classpath', '\\usr\\java\\uploadfile\\20190507162815.classpath', '张三', NULL);
INSERT INTO `sys_attach` VALUES (7, NULL, 'EmployeeMapper.java', '20190507163230.java', '\\usr\\java\\uploadfile\\20190507163230.java', '张三', NULL);
INSERT INTO `sys_attach` VALUES (8, NULL, 'EmployeeMapper.java', '20190507163415.java', '\\usr\\java\\uploadfile\\20190507163415.java', '张三', NULL);
INSERT INTO `sys_attach` VALUES (9, NULL, 'generatorConfig.xml', '20190517172824.xml', '/usr/java/uploadfile/20190517172824.xml', '张三', NULL);
INSERT INTO `sys_attach` VALUES (10, NULL, 'generatorConfig.xml', '20190517172942.xml', '/usr/java/uploadfile/20190517172942.xml', '张三', NULL);
INSERT INTO `sys_attach` VALUES (11, NULL, 'pom.xml', '20190517173050.xml', '\\usr\\java\\uploadfile\\20190517173050.xml', '张三', NULL);
INSERT INTO `sys_attach` VALUES (12, NULL, 'pom.xml', '20190517173127.xml', '\\usr\\java\\uploadfile\\20190517173127.xml', '张三', NULL);
INSERT INTO `sys_attach` VALUES (13, NULL, 'pom.xml', '20190517173234.xml', '\\usr\\java\\uploadfile\\20190517173235.xml', '张三', NULL);
INSERT INTO `sys_attach` VALUES (14, NULL, 'generatorConfig.xml', '20190517173436.xml', '/usr/java/uploadfile/20190517173436.xml', '张三', NULL);
INSERT INTO `sys_attach` VALUES (15, NULL, '软件说明.txt', '20190517173625.txt', '/usr/java/uploadfile/20190517173625.txt', '张三', NULL);
INSERT INTO `sys_attach` VALUES (16, NULL, '.classpath', '20190517173728.classpath', '/usr/java/uploadfile/20190517173728.classpath', '张三', NULL);

-- ----------------------------
-- Table structure for sys_resource
-- ----------------------------
DROP TABLE IF EXISTS `sys_resource`;
CREATE TABLE `sys_resource`  (
  `resource_id` int(20) NOT NULL,
  `parent_id` int(11) NULL DEFAULT NULL COMMENT '没有父类，parentid等于0',
  `resource_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `resource_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `resource_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`resource_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_resource
-- ----------------------------
INSERT INTO `sys_resource` VALUES (1, 0, '课程管理', 'user/courseManger', 'papapa');
INSERT INTO `sys_resource` VALUES (2, 0, '教师管理', 'user/teacherManger', 'papapa');
INSERT INTO `sys_resource` VALUES (3, 0, '学生管理', NULL, 'papapa');
INSERT INTO `sys_resource` VALUES (4, 3, '男学生管理', 'user/manManger', 'papapa');
INSERT INTO `sys_resource` VALUES (5, 3, '女学生管理', 'user/womanManger', 'papapa');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `role_id` int(20) NOT NULL,
  `role_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, 'admin');
INSERT INTO `sys_role` VALUES (2, 'user');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `user_id` int(20) NOT NULL,
  `user_longin_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户登陆名',
  `user_sys_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户系统名',
  `user_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户密码',
  `user_lock` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否锁定 1是 0否',
  `user_error_times` int(10) NULL DEFAULT NULL COMMENT '错误次数 达到5次 自动锁定',
  `user_salt` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '加密盐',
  `state` int(1) NULL DEFAULT NULL COMMENT '用户是否启用 1启用',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, '张三', 'admin', 'e10adc3949ba59abbe56e057f20f883e', '0', 1, 'user', 1);
INSERT INTO `sys_user` VALUES (2, '李四', 'user', 'e10adc3949ba59abbe56e057f20f883e', '0', 1, 'user', 1);

-- ----------------------------
-- Table structure for tab_adress
-- ----------------------------
DROP TABLE IF EXISTS `tab_adress`;
CREATE TABLE `tab_adress`  (
  `id` int(11) NOT NULL COMMENT '主键',
  `name` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `adress` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tab_adress
-- ----------------------------
INSERT INTO `tab_adress` VALUES (1, '张三333333', '1001', '1');
INSERT INTO `tab_adress` VALUES (2, '历史', '1003', '2');
INSERT INTO `tab_adress` VALUES (3, '小明', '1100', '1');

-- ----------------------------
-- Table structure for tab_teacher
-- ----------------------------
DROP TABLE IF EXISTS `tab_teacher`;
CREATE TABLE `tab_teacher`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `teacher_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `teacher_sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `teacher_course` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tab_teacher
-- ----------------------------
INSERT INTO `tab_teacher` VALUES (1, '王老师', '1', '数学', NULL);
INSERT INTO `tab_teacher` VALUES (2, '陈老师', '2', '英语', NULL);
INSERT INTO `tab_teacher` VALUES (3, '王老师', '1', '数学', NULL);
INSERT INTO `tab_teacher` VALUES (4, '张老师', '1', '体育', NULL);
INSERT INTO `tab_teacher` VALUES (5, 'hao老师', '1', '数学', NULL);

-- ----------------------------
-- Table structure for tab_test
-- ----------------------------
DROP TABLE IF EXISTS `tab_test`;
CREATE TABLE `tab_test`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `t_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tab_test
-- ----------------------------
INSERT INTO `tab_test` VALUES (1, '张三');
INSERT INTO `tab_test` VALUES (2, '小李');
INSERT INTO `tab_test` VALUES (3, '路人乙');
INSERT INTO `tab_test` VALUES (4, '路人甲');

-- ----------------------------
-- Table structure for updownload_log
-- ----------------------------
DROP TABLE IF EXISTS `updownload_log`;
CREATE TABLE `updownload_log`  (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `operater` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '下载文件人',
  `file_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件名字',
  `java_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'java类',
  `java_method` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'java方法',
  `ip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'ip地址',
  `time` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '时间',
  `file_type` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件类型 1  上传  2 下载',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '上传下载日志表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(30) NOT NULL AUTO_INCREMENT,
  `u_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `u_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `note` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20190329105711 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (3, '123', '123', '是对方的模式');
INSERT INTO `user` VALUES (11, '张三', '1234567', '十多年福克斯');
INSERT INTO `user` VALUES (22, '修改名', NULL, NULL);
INSERT INTO `user` VALUES (20190329103342, '小明', '5440', '表示今天放假了');
INSERT INTO `user` VALUES (20190329104434, '小刚', '5440', '表示今天放假了');
INSERT INTO `user` VALUES (20190329104851, '小红', '5440', '表示今天放假了');
INSERT INTO `user` VALUES (20190329105214, '小哥', '5440', '表示今天放假了');
INSERT INTO `user` VALUES (20190329105241, '小心', '5440', '表示今天放假了');
INSERT INTO `user` VALUES (20190329105707, '小天', '5440', '表示今天放假了');
INSERT INTO `user` VALUES (20190329105708, 'java', NULL, NULL);
INSERT INTO `user` VALUES (20190329105709, '修改名', NULL, NULL);
INSERT INTO `user` VALUES (20190329105710, '修改名', NULL, NULL);

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `user_id` int(20) NULL DEFAULT NULL,
  `role_id` int(20) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (1, 1);
INSERT INTO `user_role` VALUES (2, 2);

SET FOREIGN_KEY_CHECKS = 1;
