CREATE TABLE `facility` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `facilityKbn` varchar(10) NOT NULL,
  `facilityName` varchar(10) NOT NULL,
  `createUser` varchar(50) DEFAULT NULL,
  `createDateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updateUser` varchar(50) DEFAULT NULL,
  `updateDateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8