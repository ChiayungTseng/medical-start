CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL DEFAULT '' COMMENT '用户名',
  `password` varchar(50) NOT NULL DEFAULT '' COMMENT '密码',
  `phone_number` varchar(50) NOT NULL DEFAULT '' COMMENT '电话号码',
  `e_mail` varchar(50) NOT NULL DEFAULT '' COMMENT '邮箱',
  `status` varchar(2) NOT NULL DEFAULT '0' COMMENT '状态,1-注册成功',
  `image_url` varchar(255) NOT NULL DEFAULT '' COMMENT '头像地址',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_username` (`username`) USING BTREE,
  KEY `idx_phone_number` (`phone_number`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='用户表';