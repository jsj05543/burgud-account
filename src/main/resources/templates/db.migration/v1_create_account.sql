CREATE TABLE `account` (
  `accountCd` varchar(50) NOT NULL,
  `accountUsedName` varchar(50) NOT NULL,
  `usedDetail` varchar(50) DEFAULT NULL,
  `accountName` varchar(50) NOT NULL,
  `accountPassword` varchar(50) NOT NULL,
  `countryKbn` varchar(10) NOT NULL,
  `facilityKbn` varchar(10) NOT NULL,
  `query1` varchar(10) DEFAULT NULL,
  `answer1` varchar(10) DEFAULT NULL,
  `query2` varchar(10) DEFAULT NULL,
  `answer2` varchar(10) DEFAULT NULL,
  `query3` varchar(10) DEFAULT NULL,
  `answer3` varchar(10) DEFAULT NULL,
  `oldPassword1` varchar(50) DEFAULT NULL,
  `oldPassword2` varchar(50) DEFAULT NULL,
  `oldPassword3` varchar(50) DEFAULT NULL,
  `biko` varchar(100) DEFAULT NULL,
  `createUser` varchar(50) DEFAULT NULL,
  `createDateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updateUser` varchar(50) DEFAULT NULL,
  `updateDateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`accountCd`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8