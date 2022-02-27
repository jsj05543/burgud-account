CREATE TABLE `authority` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `authority_kbn` varchar(10) NOT NULL,
  `authority_name` varchar(10) NOT NULL,
  `create_user` varchar(50) NOT NULL,
  `create_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_user` varchar(50) DEFAULT NULL,
  `update_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`,`authority_kbn`),
  UNIQUE KEY `idx_tab_kbn_authority_kbn` (`authority_kbn`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8