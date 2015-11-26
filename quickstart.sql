/*
Navicat MySQL Data Transfer

Source Server         : ange
Source Server Version : 50624
Source Host           : 192.168.6.8:3306
Source Database       : quickstart

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2015-11-26 14:12:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_login_history
-- ----------------------------
DROP TABLE IF EXISTS `t_login_history`;
CREATE TABLE `t_login_history` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `login_info` varchar(25) DEFAULT NULL COMMENT '登陆信息(账号、邮箱、手机等)',
  `login_ip` varchar(15) DEFAULT NULL COMMENT '登陆IP',
  `login_time` datetime DEFAULT NULL COMMENT '登陆时间',
  `province` varchar(20) DEFAULT NULL COMMENT 'IP所在省',
  `city` varchar(20) DEFAULT NULL COMMENT 'IP所在市',
  `district` varchar(20) DEFAULT NULL COMMENT 'IP所在区',
  `logout_time` datetime DEFAULT NULL COMMENT '退出时间',
  `time_length` int(11) DEFAULT NULL COMMENT '登陆时长(分)',
  `logout_type` tinyint(2) DEFAULT NULL COMMENT '退出类型(1:主动退出，2:会话过期)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='登陆记录表';

-- ----------------------------
-- Records of t_login_history
-- ----------------------------

-- ----------------------------
-- Table structure for t_operate_log
-- ----------------------------
DROP TABLE IF EXISTS `t_operate_log`;
CREATE TABLE `t_operate_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `account` varchar(20) DEFAULT NULL COMMENT '账号',
  `nickname` varchar(20) DEFAULT NULL COMMENT '昵称',
  `content` varchar(1000) DEFAULT NULL COMMENT '操作内容',
  `operate_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '操作时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='操作日志表';

-- ----------------------------
-- Records of t_operate_log
-- ----------------------------

-- ----------------------------
-- Table structure for t_sequence
-- ----------------------------
DROP TABLE IF EXISTS `t_sequence`;
CREATE TABLE `t_sequence` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(20) DEFAULT NULL COMMENT '名称',
  `code` varchar(250) DEFAULT NULL COMMENT '编码',
  `value` bigint(20) DEFAULT NULL COMMENT '序列值',
  `last_update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='生成序列号表';

-- ----------------------------
-- Records of t_sequence
-- ----------------------------
INSERT INTO `t_sequence` VALUES ('1', '全局序列值', 'seq_global_id', '10000', '2015-11-26 14:09:52');

-- ----------------------------
-- Table structure for t_user_account
-- ----------------------------
DROP TABLE IF EXISTS `t_user_account`;
CREATE TABLE `t_user_account` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `username` varchar(20) DEFAULT NULL COMMENT '账号',
  `nickname` varchar(20) DEFAULT NULL COMMENT '昵称',
  `password` varchar(200) DEFAULT NULL COMMENT '密码',
  `mobile` varchar(20) DEFAULT NULL COMMENT '手机',
  `email` varchar(25) DEFAULT NULL COMMENT '邮箱',
  `qq` varchar(12) DEFAULT NULL COMMENT 'QQ',
  `last_land_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '最后登陆时间',
  `last_land_ip` varchar(15) DEFAULT NULL COMMENT '最后登陆IP',
  `is_account_non_expired` tinyint(1) DEFAULT NULL COMMENT '用户账户是否过期',
  `is_account_non_locked` tinyint(1) DEFAULT NULL COMMENT '用户账户是否锁定',
  `is_credentials_non_expired` tinyint(1) DEFAULT NULL COMMENT '用户密码是否过期',
  `is_enabled` tinyint(1) DEFAULT NULL COMMENT '用户是否可用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='用户登陆表';

-- ----------------------------
-- Records of t_user_account
-- ----------------------------
INSERT INTO `t_user_account` VALUES ('1', 'admin', 'admin', '$2a$12$g/jlazodA3G7LZgchwOqm.BRraM61j3HnjNi055molmwStosghyXm', '13100000000', '123@163.com', '12345678', '2015-11-16 15:40:17', '127.0.0.1', '1', '1', '1', '1');
INSERT INTO `t_user_account` VALUES ('2', 'asdf', 'asdf', '$2a$12$rSR.JHX9fpzq5llX32SgwOTS36XFuZFo6dMlS6th4JzA7em23fP7C', 'asdfas', null, null, null, null, '0', '0', '0', '0');

-- ----------------------------
-- Table structure for t_user_account_related_group
-- ----------------------------
DROP TABLE IF EXISTS `t_user_account_related_group`;
CREATE TABLE `t_user_account_related_group` (
  `user_account_id` bigint(20) NOT NULL COMMENT '用户登陆表主键',
  `user_group_id` bigint(20) NOT NULL COMMENT '用户组表主键',
  PRIMARY KEY (`user_account_id`,`user_group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户关联用户组表';

-- ----------------------------
-- Records of t_user_account_related_group
-- ----------------------------

-- ----------------------------
-- Table structure for t_user_account_related_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_user_account_related_menu`;
CREATE TABLE `t_user_account_related_menu` (
  `user_account_id` bigint(20) NOT NULL COMMENT '用户ID',
  `user_menu_id` bigint(20) NOT NULL COMMENT '用户菜单ID',
  PRIMARY KEY (`user_account_id`,`user_menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户关联菜单表';

-- ----------------------------
-- Records of t_user_account_related_menu
-- ----------------------------

-- ----------------------------
-- Table structure for t_user_authority
-- ----------------------------
DROP TABLE IF EXISTS `t_user_authority`;
CREATE TABLE `t_user_authority` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(20) DEFAULT NULL COMMENT '名称',
  `code` varchar(20) DEFAULT NULL COMMENT '编码',
  `remarks` varchar(250) DEFAULT NULL COMMENT '备注',
  `status` tinyint(1) DEFAULT NULL COMMENT '状态（true：可用，false：不可用）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户权限表';

-- ----------------------------
-- Records of t_user_authority
-- ----------------------------

-- ----------------------------
-- Table structure for t_user_group
-- ----------------------------
DROP TABLE IF EXISTS `t_user_group`;
CREATE TABLE `t_user_group` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(25) DEFAULT NULL COMMENT '名称',
  `code` varchar(20) DEFAULT NULL COMMENT '编码',
  `status` tinyint(1) DEFAULT NULL COMMENT '状态（true：可用，false：不可用）',
  `remarks` varchar(250) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户组表';

-- ----------------------------
-- Records of t_user_group
-- ----------------------------

-- ----------------------------
-- Table structure for t_user_group_related_authority
-- ----------------------------
DROP TABLE IF EXISTS `t_user_group_related_authority`;
CREATE TABLE `t_user_group_related_authority` (
  `user_group_id` bigint(20) NOT NULL COMMENT '用户组表主键',
  `user_authority_id` bigint(20) NOT NULL COMMENT '权限表主键',
  PRIMARY KEY (`user_group_id`,`user_authority_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户组关联权限表';

-- ----------------------------
-- Records of t_user_group_related_authority
-- ----------------------------

-- ----------------------------
-- Table structure for t_user_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_user_menu`;
CREATE TABLE `t_user_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(20) DEFAULT NULL COMMENT '名称',
  `level` tinyint(2) DEFAULT NULL COMMENT '级别(0:根节点，1、2、3)',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父节点',
  `status` tinyint(1) DEFAULT NULL COMMENT '状态(true:可用,false:不可用)',
  `is_can_visit` tinyint(1) DEFAULT NULL COMMENT '是否可访问(true:有访问链接,false:无访问链接)',
  `visit_url` varchar(250) DEFAULT NULL COMMENT '访问链接(菜单对应的访问url)',
  `is_spread` tinyint(1) DEFAULT NULL COMMENT '是否展开子节点(true:子节点展开,false:子节点合并)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户菜单表';

-- ----------------------------
-- Records of t_user_menu
-- ----------------------------
