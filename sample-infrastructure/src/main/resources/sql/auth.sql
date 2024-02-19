CREATE TABLE `auth_user`
(
    `id`          BIGINT(20)  NOT NULL AUTO_INCREMENT COMMENT '主键',
    `account`   VARCHAR(64) NOT NULL DEFAULT 'NULL' COMMENT '用户名',
    `user_name`   VARCHAR(64) NOT NULL DEFAULT 'NULL' COMMENT '用户名',
    `nick_name`   VARCHAR(64) NOT NULL DEFAULT 'NULL' COMMENT '昵称',
    `password`    VARCHAR(64) NOT NULL DEFAULT 'NULL' COMMENT '密码',
    `status`      TINYINT(1)           DEFAULT 0 COMMENT '账号状态（0正常 1停用）',
    `phone`       VARCHAR(32)          DEFAULT NULL COMMENT '手机号',
    `sex`         TINYINT(1)           DEFAULT NULL COMMENT '用户性别（0男，1女，2未知）',
    `avatar_url`  VARCHAR(128)         DEFAULT NULL COMMENT '头像',
    `create_by`   BIGINT(20)           DEFAULT NULL COMMENT '创建人的用户id',
    `create_time` DATETIME             DEFAULT NULL COMMENT '创建时间',
    `update_by`   BIGINT(20)           DEFAULT NULL COMMENT '更新人',
    `update_time` DATETIME             DEFAULT NULL COMMENT '更新时间',
    `del_flag`    TINYINT(1)           DEFAULT 0 COMMENT '删除标志（0代表未删除，1代表已删除）',
    PRIMARY KEY (`id`)
) ENGINE = INNODB
  AUTO_INCREMENT = 2
  DEFAULT CHARSET = utf8mb4 COMMENT ='用户表';


CREATE TABLE `auth_role`
(
    `id`          BIGINT(20)  NOT NULL AUTO_INCREMENT COMMENT '主键',
    `role_name`   VARCHAR(64) NOT NULL DEFAULT 'NULL' COMMENT '角色名称',
    `status`      TINYINT(1)           DEFAULT 0 COMMENT '角色状态（0正常 1停用）',
    `create_by`   BIGINT(20)           DEFAULT NULL COMMENT '创建人的用户id',
    `create_time` DATETIME             DEFAULT NULL COMMENT '创建时间',
    `update_by`   BIGINT(20)           DEFAULT NULL COMMENT '更新人',
    `update_time` DATETIME             DEFAULT NULL COMMENT '更新时间',
    `del_flag`    TINYINT(1)           DEFAULT 0 COMMENT '删除标志（0代表未删除，1代表已删除）',
    PRIMARY KEY (`id`)
) ENGINE = INNODB
  AUTO_INCREMENT = 2
  DEFAULT CHARSET = utf8mb4 COMMENT ='角色表';

CREATE TABLE `auth_user_role`
(
    `id`          BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `user_id`     BIGINT(20) NOT NULL COMMENT '创建人的用户id',
    `role_id`     BIGINT(20) NOT NULL COMMENT '角色id',
    `create_by`   BIGINT(20) DEFAULT NULL COMMENT '更新人',
    `create_time` DATETIME   DEFAULT NULL COMMENT '创建时间',
    `update_by`   BIGINT(20) DEFAULT NULL COMMENT '更新人',
    `update_time` DATETIME   DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = INNODB
  AUTO_INCREMENT = 2
  DEFAULT CHARSET = utf8mb4 COMMENT ='用户角色表';

CREATE TABLE `auth_permission`
(
    `id`          bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `name`        varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '权限名称',
    `parent_id`   bigint(20) DEFAULT '0' COMMENT '父ID',
    `order_num`   int(4) DEFAULT '0' COMMENT '显示顺序',
    `path`        varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '权限地址',
    `query`       varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '路由参数',
    `is_frame`    TINYINT(1) DEFAULT 0 COMMENT '是否为外链（0是 1否）',
    `type`        TINYINT(1) DEFAULT 0 COMMENT '权限类型（1菜单 2按钮）',
    `visible`     TINYINT(1) DEFAULT 0 COMMENT '显示状态（0显示 1隐藏）',
    `status`      TINYINT(1) DEFAULT 0 COMMENT '权限状态（0正常 1停用）',
    `perms`       varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '权限标识',
    `icon`        varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT '#' COMMENT '图标',
    `create_by`   varchar(64) COLLATE utf8mb4_unicode_ci  DEFAULT '' COMMENT '创建者',
    `create_time` datetime                                DEFAULT NULL COMMENT '创建时间',
    `update_by`   varchar(64) COLLATE utf8mb4_unicode_ci  DEFAULT '' COMMENT '更新者',
    `update_time` datetime                                DEFAULT NULL COMMENT '更新时间',
    `remark`      varchar(500) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '备注',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='系统权限表';
