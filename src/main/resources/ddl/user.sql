CREATE TABLE `sys_user`
(
    `id`          BIGINT(20)  NOT NULL AUTO_INCREMENT COMMENT '主键',
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
  DEFAULT CHARSET = utf8mb4 COMMENT ='用户表'
