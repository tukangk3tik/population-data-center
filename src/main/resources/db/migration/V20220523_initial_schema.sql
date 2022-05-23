CREATE TABLE IF NOT EXISTS `persons` (
    `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `email` varchar(50),
    `password` varchar(100)
)ENGINE=InnoDB DEFAULT CHARSET=UTF8;

CREATE TABLE IF NOT EXISTS `persons` (
    `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` varchar(50),
    `email` varchar(50),
    `phone_number` varchar(50),
    `created_at` timestamp,
    `updated_at` timestamp,
    `deleted_at` timestamp
)ENGINE=InnoDB DEFAULT CHARSET=UTF8;