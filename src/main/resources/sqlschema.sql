CREATE TABLE `user_account` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,  
  `version` int(11) unsigned NOT NULL DEFAULT '0',
  `full_name` varchar(20) NOT NULL DEFAULT '',
  `password` varchar(20) NOT NULL DEFAULT '',
  `email` varchar(255) DEFAULT NULL,
  `last_password_change_date` DATETIME NULL DEFAULT NULL,
  `date_created` DATETIME NOT NULL,  
  `last_update_date` DATETIME NULL,
  
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `customer` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,  
  `version` int(11) unsigned NOT NULL DEFAULT '0',
  `name` varchar(20) NOT NULL DEFAULT '',  
  `email` varchar(255) DEFAULT NULL,
  `date_created` DATETIME NOT NULL,  
  `last_update_date` DATETIME NULL,
  `note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
