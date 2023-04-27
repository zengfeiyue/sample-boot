CREATE TABLE `sys_user_role`
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
  DEFAULT CHARSET = utf8mb4 COMMENT ='用户角色表'
