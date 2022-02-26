CREATE TABLE `pref` (
  `prefCode` int(11) NOT NULL,
  `prefName` varchar(50) NOT NULL,
  `disFlag` int(11) DEFAULT '1',
  PRIMARY KEY (`prefCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8