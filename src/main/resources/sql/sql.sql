CREATE TABLE `alipay_open_auth_token` (
  `id` bigint(20) NOT NULL,

  `appAuthToken` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商户授权令牌',
  `userId` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '授权者的PID',
  `authAppId` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '授权商户的AppId',
  `expiresIn` bigint(20) DEFAULT NULL COMMENT '令牌有效期',
  `expiresInDateTime` datetime DEFAULT NULL COMMENT '令牌有效期日期类型',
  `reExpiresIn` bigint(20) DEFAULT NULL COMMENT '刷新令牌有效期',
  `reExpiresInDateTime` datetime DEFAULT NULL COMMENT '刷新令牌有效期日期类型',
  `appRefreshToken` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '刷新令牌时使用',

  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='支付宝第三方应用授权信息';


CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL,
 
  `phone` varchar(13) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `userName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `userType` int(1) DEFAULT NULL COMMENT '用户类型：1普通用户，2管理员，3系统管理员',
  `sex` int(1) DEFAULT NULL COMMENT '性别',
  `idCard` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证号',
  `namePinyin` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮件地址',
  `address` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '住址',
  `weixin` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '微信',
  `birthDate` datetime DEFAULT NULL COMMENT '出生日期',
  `emergencyContact`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '紧急联系人',
  `emergencyPhone` varchar(13) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '紧急联系人手机号',
  `employDate` datetime DEFAULT NULL COMMENT '雇用日期',
  `titleId` bigint(20) DEFAULT NULL COMMENT '职务ID',
  `managerId` bigint(20) DEFAULT NULL COMMENT '上级主管ID',

  PRIMARY KEY (`id`),
  UNIQUE KEY `sys_user_phone_uindex` (`phone`),
  UNIQUE KEY `sys_user_userName_uindex` (`userName`),
  UNIQUE KEY `sys_user_idCard_uindex` (`idCard`)
) ENGINE=InnoDB DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='用户信息';

CREATE TABLE `sys_session` (
  `id` bigint(20) NOT NULL,
  
  `sessionId`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
  `account`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
  `ip`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
  `startTime`  datetime NOT NULL ,

PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='会话管理';



CREATE TABLE `sys_job_title` (
  `id` bigint(20) NOT NULL,
  `name` VARCHAR(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
  `parentTitleId` bigint(20) DEFAULT NULL,

  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  COMMENT='职务';

CREATE TABLE `sys_menu` (
`id`  bigint(20) NOT NULL COMMENT '菜单编号' ,
`menuName`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单名称' ,
`menuType`  smallint(2) NULL DEFAULT 2 COMMENT '菜单类型(0:CURD;1:系统菜单;2:业务菜单;)' ,
`parentId`  bigint(20) NULL DEFAULT NULL COMMENT '上级菜单编号' ,
`iconcls`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '节点图标CSS类名' ,
`request`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '请求地址' ,
`expand`  tinyint(1) NOT NULL DEFAULT 0 COMMENT '展开状态(1:展开;0:收缩)' ,
`sortNo`  int(2) NULL DEFAULT NULL COMMENT '排序号' ,
`isShow`  tinyint(1) NOT NULL DEFAULT 1 COMMENT '叶子节点(0:树枝节点;1:叶子节点)' ,
`permission`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限标识' ,
`remark`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注' ,
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='菜单';


CREATE TABLE `sys_role` (
`id`  bigint(20) NOT NULL ,

`roleName`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名称' ,
`roleType`  int(1) NOT NULL DEFAULT 1 COMMENT '角色类型(1:业务角色;2:管理角色 ;3:系统内置角色)' ,

`remark`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注' ,

PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='角色信息表';

CREATE TABLE `sys_role_menu` (
`id`  bigint(20) NOT NULL ,

`roleId`  bigint(20) NOT NULL ,
`menuId`  bigint(20) NOT NULL ,
`permission`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '权限标识' ,

`remark`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注' ,
PRIMARY KEY (`id`),
UNIQUE INDEX `sys_role_menu_key1` (`roleId`, `menuId`, `permission`) USING BTREE 
) ENGINE=InnoDB DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='角色授权表';

CREATE TABLE `sys_user_menu` (
`id`  bigint(20) NOT NULL ,

`userId`  bigint(20) NOT NULL ,
`menuId`  bigint(20) NOT NULL ,
`permission`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '权限标识' ,

`remark`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注' ,


PRIMARY KEY (`id`),
UNIQUE INDEX `sys_user_menu_key1` (`userId`, `menuId`, `permission`) USING BTREE 
) ENGINE=InnoDB DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='用户授权表';

CREATE TABLE `sys_user_role` (
`id`  bigint(20) NOT NULL ,

`userId`  bigint(20) NOT NULL ,
`roleId`  bigint(20) NOT NULL ,
`remark`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注' ,

PRIMARY KEY (`id`),
UNIQUE INDEX `user_id_role_id` (`userId`, `roleId`) USING BTREE 
) ENGINE=InnoDB DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='用户授权表';


INSERT INTO `cash`.`sys_user` (`id`, `phone`, `password`, `userName`, `userType`, `sex`, `idCard`, `namePinyin`, `email`, `address`, `weixin`, `birthDate`, `emergencyContact`, `emergencyPhone`, `employDate`, `titleId`, `enable`, `remark`) VALUES ('1', '13776346982', 'OyUHgt21gTP2/5uFgbKZtq==', 'songqi', '1', '1', '421126198406013851', '宋祁', '289330245@qq.com', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `cash`.`sys_user` (`id`, `phone`, `password`, `userName`, `userType`, `sex`, `idCard`, `namePinyin`, `email`, `address`, `weixin`, `birthDate`, `emergencyContact`, `emergencyPhone`, `employDate`, `titleId`, `enable`, `remark`) VALUES ('2', '13888888888', 'OyUHgt21gTP2/5uFgbKZtq==', 'admin', '2', '1', NULL, '管理员', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);



INSERT INTO `cash`.`sys_job_title` (`id`, `name`, `parentTitleId`, `enable`, `remark`, `createBy`, `createTime`, `updateBy`, `updateTime`) VALUES ('1', '总经理', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `cash`.`sys_job_title` (`id`, `name`, `parentTitleId`, `enable`, `remark`, `createBy`, `createTime`, `updateBy`, `updateTime`) VALUES ('2', '总监', '1', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `cash`.`sys_job_title` (`id`, `name`, `parentTitleId`, `enable`, `remark`, `createBy`, `createTime`, `updateBy`, `updateTime`) VALUES ('3', '业务经理', '2', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `cash`.`sys_job_title` (`id`, `name`, `parentTitleId`, `enable`, `remark`, `createBy`, `createTime`, `updateBy`, `updateTime`) VALUES ('4', '业务员', '3', NULL, NULL, NULL, NULL, NULL, NULL);
