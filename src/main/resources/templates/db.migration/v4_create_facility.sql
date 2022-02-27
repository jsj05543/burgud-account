CREATE TABLE `facility` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `facility_kbn` varchar(10) NOT NULL,
  `facility_name` varchar(10) NOT NULL,
  `create_user` varchar(50) NOT NULL,
  `create_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_user` varchar(50) DEFAULT NULL,
  `update_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_tab_kbn_facility_kbn` (`facility_kbn`)
) ENGINE=InnoDB AUTO_INCREMENT=86 DEFAULT CHARSET=utf8