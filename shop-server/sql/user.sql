-- 创建user_login数据表
CREATE TABLE `user_login` (
                              `u_id` int NOT NULL AUTO_INCREMENT COMMENT '用户id，主键',
                              `account` varchar(50) NOT NULL COMMENT '用户名',
                              `pass_word` varchar(255) NOT NULL COMMENT '密码',
                              `permission` varchar(20) DEFAULT NULL COMMENT '权限',
                              PRIMARY KEY (`u_id`),
                              UNIQUE KEY `unique_account` (`account`) USING BTREE COMMENT '用户名唯一索引'
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- 创建user_info数据表
CREATE TABLE `user_info` (
                             `id` int NOT NULL AUTO_INCREMENT COMMENT '用户信息 id',
                             `phone_number` varchar(11) DEFAULT NULL COMMENT '电话号码',
                             `email` varchar(30) DEFAULT NULL COMMENT '邮箱地址',
                             `address` varchar(255) DEFAULT NULL COMMENT '家庭住址',
                             `u_id` int DEFAULT NULL,
                             PRIMARY KEY (`id`),
                             KEY `fk_uid` (`u_id`),
                             CONSTRAINT `fk_uid` FOREIGN KEY (`u_id`) REFERENCES `user_login` (`u_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 商品表
CREATE TABLE `commodity` (
                             `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
                             `commodity_name` varchar(50) NOT NULL COMMENT '商品名称',
                             `commodity_describe` varchar(255) NOT NULL COMMENT '商品描述',
                             `stock` int NOT NULL COMMENT '商品库存',
                             `ship_address` varchar(255) NOT NULL COMMENT '发货地址',
                             `take_down` int DEFAULT NULL COMMENT '是否已下架',
                             `take_up_time` date DEFAULT NULL COMMENT '商品上架时间',
                             PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- 订单表
CREATE TABLE `order` (
                         `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
                         `c_id` int NOT NULL COMMENT '商品id',
                         `u_id` int NOT NULL COMMENT '用户id',
                         `recipient` varchar(255) NOT NULL COMMENT '收件人',
                         `recive_phone` varchar(11) NOT NULL COMMENT '收件电话',
                         `recive_address` varchar(255) NOT NULL COMMENT '收件地址',
                         `pay` int DEFAULT NULL COMMENT '是否已支付',
                         PRIMARY KEY (`id`),
                         KEY `fk_cid` (`c_id`),
                         KEY `fk_uer_login` (`u_id`),
                         CONSTRAINT `fk_cid` FOREIGN KEY (`c_id`) REFERENCES `commodity` (`id`),
                         CONSTRAINT `fk_uer_login` FOREIGN KEY (`u_id`) REFERENCES `user_login` (`u_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;