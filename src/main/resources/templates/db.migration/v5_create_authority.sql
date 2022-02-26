CREATE TABLE `authority` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `authorityKbn` varchar(10) NOT NULL,
  `authorityName` varchar(10) NOT NULL,
  `createUser` varchar(50) DEFAULT NULL,
  `createDateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updateUser` varchar(50) DEFAULT NULL,
  `updateDateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`,`authorityKbn`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8