CREATE TABLE `sys_permission`
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
    `status`      TINYINT(1) DEFAULT 0COMMENT '权限状态（0正常 1停用）',
    `perms`       varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '权限标识',
    `icon`        varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT '#' COMMENT '图标',
    `create_by`   varchar(64) COLLATE utf8mb4_unicode_ci  DEFAULT '' COMMENT '创建者',
    `create_time` datetime                                DEFAULT NULL COMMENT '创建时间',
    `update_by`   varchar(64) COLLATE utf8mb4_unicode_ci  DEFAULT '' COMMENT '更新者',
    `update_time` datetime                                DEFAULT NULL COMMENT '更新时间',
    `remark`      varchar(500) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '备注',
    PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='系统权限表';