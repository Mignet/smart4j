/*
 DDL
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tsys_menus
-- ----------------------------
DROP TABLE IF EXISTS `tsys_menus`;
CREATE TABLE `tsys_menus` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `menu_name` varchar(100) NOT NULL COMMENT '菜单名称',
  `menu_url` varchar(500) NOT NULL,
  `parent_id` int(11) NOT NULL,
  `is_disable` smallint(6) DEFAULT NULL COMMENT '是否禁用: 1=禁用,0=启用',
  `sort` int(11) DEFAULT NULL,
  `add_time` datetime DEFAULT NULL,
  `permission_sign` varchar(200) DEFAULT NULL,
  `menu_icon` varchar(200) DEFAULT NULL COMMENT '图标字体',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COMMENT='运营平台-菜单管理表';

-- ----------------------------
-- Records of tsys_menus
-- ----------------------------
INSERT INTO `tsys_menus` VALUES ('1', '系统管理', 'javascript:;', '0', '0', '10', '2016-06-23 10:42:31', 'sys-permission:*', 'fa-cogs');
INSERT INTO `tsys_menus` VALUES ('2', '用户管理', 'rest/user', '1', '0', '25', '2016-06-23 10:42:50', 'sys-user:create', 'fa-group');
INSERT INTO `tsys_menus` VALUES ('3', '角色管理', 'rest/role', '1', '0', '26', '2016-06-23 10:43:31', 'sys-role:create', 'fa-group');
INSERT INTO `tsys_menus` VALUES ('4', '权限管理', 'rest/permissions/list', '1', '0', '27', '2016-06-23 10:44:15', 'sys-permission:*', 'fa-group');
INSERT INTO `tsys_menus` VALUES ('5', '菜单管理', 'rest/menus/list', '1', '0', '28', '2016-06-23 10:44:35', 'sys-permission:*', 'fa-group');
INSERT INTO `tsys_menus` VALUES ('6', '个人中心', 'javascipt:;', '0', '0', '11', '2016-06-23 10:46:01', '', 'fa-user-secret');
INSERT INTO `tsys_menus` VALUES ('7', '个人信息', 'rest/page/blank', '6', '0', '29', '2016-06-23 10:46:21', '', 'fa-group');
INSERT INTO `tsys_menus` VALUES ('8', '密码修改', 'rest/user/toresetpwd', '6', '0', '30', '2016-06-23 10:47:06', '', 'fa-group');
-- ----------------------------
-- Table structure for tsys_role
-- ----------------------------
DROP TABLE IF EXISTS `tsys_role`;
CREATE TABLE `tsys_role` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `role_name` varchar(32) DEFAULT NULL COMMENT '角色名',
  `role_sign` varchar(128) DEFAULT NULL COMMENT '角色标识,程序中判断使用,如"admin"',
  `description` varchar(256) DEFAULT NULL COMMENT '角色描述,UI界面显示使用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of tsys_role
-- ----------------------------
INSERT INTO `tsys_role` VALUES ('1', '管理员', 'admin', '管理员');

-- ----------------------------
-- Table structure for tsys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `tsys_role_permission`;
CREATE TABLE `tsys_role_permission` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '表id',
  `role_id` bigint(20) unsigned DEFAULT NULL COMMENT '角色id',
  `permission_id` bigint(20) unsigned DEFAULT NULL COMMENT '权限id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='角色与权限关联表';

-- ----------------------------
-- Records of tsys_role_permission
-- ----------------------------
INSERT INTO `tsys_role_permission` VALUES ('1', '1', '1');
INSERT INTO `tsys_role_permission` VALUES ('2', '1', '2');
INSERT INTO `tsys_role_permission` VALUES ('3', '1', '3');

-- ----------------------------
-- Table structure for tsys_permission
-- ----------------------------
DROP TABLE IF EXISTS `tsys_permission`;
CREATE TABLE `tsys_permission` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '权限id',
  `permission_name` varchar(32) DEFAULT NULL COMMENT '权限名',
  `permission_sign` varchar(128) DEFAULT NULL COMMENT '权限标识,程序中判断使用,如"user:create"',
  `description` varchar(256) DEFAULT NULL COMMENT '权限描述,UI界面显示使用',
  `permission_category` varchar(128) DEFAULT NULL COMMENT '分类',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='权限表';

-- ----------------------------
-- Records of tsys_permission
-- ----------------------------
INSERT INTO `tsys_permission` VALUES ('1', '用户管理', 'sys-user:create', '页面浏览权限', '系统');
INSERT INTO `tsys_permission` VALUES ('2', '角色管理', 'sys-role:create', '页面浏览权限', '系统');
INSERT INTO `tsys_permission` VALUES ('3', '权限管理', 'sys-permission:*', '页面浏览权限', '系统');

-- ----------------------------
-- Table structure for tsys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `tsys_user_role`;
CREATE TABLE `tsys_user_role` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '表id',
  `user_id` bigint(20) unsigned DEFAULT NULL COMMENT '用户id',
  `role_id` bigint(20) unsigned DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户与角色关联表';

-- ----------------------------
-- Records of tsys_user_role
-- ----------------------------
INSERT INTO `tsys_user_role` VALUES ('1', '1', '1');

-- ----------------------------
-- Table structure for tsys_user
-- ----------------------------
DROP TABLE IF EXISTS `tsys_user`;
CREATE TABLE `tsys_user` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(50) DEFAULT NULL COMMENT '用户名',
  `password` char(200) DEFAULT NULL COMMENT '密码',
  `state` varchar(32) DEFAULT NULL COMMENT '状态',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `description` varchar(256) DEFAULT NULL COMMENT '用户描述,UI界面显示使用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of tsys_user
-- ----------------------------
INSERT INTO `tsys_user` VALUES ('1', 'kermit', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', 'Y', '2014-07-17 12:59:08', '我是创始人');

-- ----------------------------
-- Table structure for tsys_config
-- ----------------------------
DROP TABLE IF EXISTS `tsys_config`;
CREATE TABLE `tsys_config` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '流水号',
  `config_name` varchar(50) DEFAULT NULL COMMENT '名称',
  `config_type` varchar(50) DEFAULT NULL COMMENT '类别',
  `config_key` varchar(64) DEFAULT NULL COMMENT '键',
  `config_value` varchar(255) DEFAULT NULL COMMENT '值',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `crt_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `app_type` int(11) NOT NULL DEFAULT '0' COMMENT '应用类别:0全局，1理财师，2投资者',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniq_key` (`app_type`,`config_type`,`config_key`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='系统配置';

-- ----------------------------
-- Records of tsys_config
-- ----------------------------
INSERT INTO `tsys_config` VALUES ('1', '注册验证短信模板', null, 'reg_vcode_format', '注册验证码%s,15分钟内有效。', null, '2015-08-18 10:29:35', '0');
