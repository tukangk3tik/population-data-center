CREATE TABLE IF NOT EXISTS `persons` (
    `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `email` varchar(50),
    `password` varchar(100)
)ENGINE=InnoDB DEFAULT CHARSET=UTF8;

CREATE TABLE IF NOT EXISTS `persons` (
    `id_number` int NOT NULL PRIMARY KEY,
    `full_name` varchar(50) NOT NULL,
    `place_of_birth` varchar(100),
    `date_of_birth` date,
    `gender` smallint(50) NOT NULL,
    `blood_group` varchar(5),
    `address` text NOT NULL,
    `religion` varchar(50),
    `marital_status` varchar(20),
    `profession` varchar(50),
    `citizenship` varchar(50),
    `phone_number` varchar(20),
    `created_at` timestamp,
    `updated_at` timestamp,
    `deleted_at` timestamp
)ENGINE=InnoDB DEFAULT CHARSET=UTF8;