CREATE TABLE `post` (
  `post_id` int(100) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) CHARACTER SET utf8 NOT NULL,
  `topic` varchar(45) CHARACTER SET utf8 NOT NULL,
  `text` varchar(10000) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`post_id`),
  KEY `username` (`username`),
  CONSTRAINT `post_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

CREATE TABLE `user_roles` (
  `user_role_id` int(100) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `role` varchar(45) NOT NULL,
  PRIMARY KEY (`user_role_id`),
  UNIQUE KEY `uni_username_role` (`role`,`username`),
  KEY `fk_username_idx` (`username`),
  CONSTRAINT `fk_username` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

CREATE TABLE `users` (
  `user_id` int(100) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `enabled` tinyint(4) NOT NULL DEFAULT '1',
  `image` mediumblob NOT NULL,
  PRIMARY KEY (`username`),
  UNIQUE KEY `user_id` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

INSERT INTO users(username,password,enabled)
VALUES ('szymon','chodor', true);
INSERT INTO users(username,password,enabled)
VALUES ('kruncz','12345', true);

INSERT INTO user_roles (username, role)
VALUES ('szymon', 'ROLE_USER');
INSERT INTO user_roles (username, role)
VALUES ('szymon', 'ROLE_ADMIN');
INSERT INTO user_roles (username, role)
VALUES ('kruncz', 'ROLE_USER');