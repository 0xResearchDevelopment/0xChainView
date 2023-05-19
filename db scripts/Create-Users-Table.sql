CREATE TABLE chainviewdb.`users` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `client_id` varchar(50) DEFAULT NULL,
  `firstname` varchar(50) DEFAULT NULL,
  `lastname` varchar(50) DEFAULT NULL,
  `display_name` varchar(50) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `password` varchar(500) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `location` varchar(50) DEFAULT NULL,
  `dob` varchar(20) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  `created_ts` varchar(100) DEFAULT NULL,
  `updated_ts` varchar(100) DEFAULT NULL,
  `notes` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
)

ALTER TABLE chainviewdb.`users` AUTO_INCREMENT=101;
