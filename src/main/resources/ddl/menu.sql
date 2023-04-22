CREATE TABLE `sys_menu`
(
    `menu_id`     bigint(20) NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
    `menu_name`   varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '菜单名称',
    `parent_id`   bigint(20) DEFAULT '0' COMMENT '父菜单ID',
    `order_num`   int(4) DEFAULT '0' COMMENT '显示顺序',
    `path`        varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '路由地址',
    `component`   varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '组件路径',
    `query`       varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '路由参数',
    `is_frame`    int(1) DEFAULT '1' COMMENT '是否为外链（0是 1否）',
    `is_cache`    int(1) DEFAULT '0' COMMENT '是否缓存（0缓存 1不缓存）',
    `menu_type`   char(1) COLLATE utf8mb4_unicode_ci      DEFAULT '' COMMENT '菜单类型（M目录 C菜单 F按钮）',
    `visible`     char(1) COLLATE utf8mb4_unicode_ci      DEFAULT '0' COMMENT '菜单状态（0显示 1隐藏）',
    `status`      char(1) COLLATE utf8mb4_unicode_ci      DEFAULT '0' COMMENT '菜单状态（0正常 1停用）',
    `perms`       varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '权限标识',
    `icon`        varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT '#' COMMENT '菜单图标',
    `create_by`   varchar(64) COLLATE utf8mb4_unicode_ci  DEFAULT '' COMMENT '创建者',
    `create_time` datetime                                DEFAULT NULL COMMENT '创建时间',
    `update_by`   varchar(64) COLLATE utf8mb4_unicode_ci  DEFAULT '' COMMENT '更新者',
    `update_time` datetime                                DEFAULT NULL COMMENT '更新时间',
    `remark`      varchar(500) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '备注',
    PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3054 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='菜单权限表';