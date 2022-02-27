CREATE TABLE `login_session` (
  `user_cd` varchar(50) NOT NULL,
  `session_id` varchar(50) NOT NULL,
  `login_at` datetime DEFAULT NULL,
  `logout_at` datetime DEFAULT NULL,
  PRIMARY KEY (`user_cd`),
  CONSTRAINT `user_cd` FOREIGN KEY (`user_cd`) REFERENCES `user` (`user_cd`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8