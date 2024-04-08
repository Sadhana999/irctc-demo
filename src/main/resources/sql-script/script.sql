CREATE DATABASE irctc;

use irctc;
CREATE TABLE `user` (
  `user_id` varchar(255) NOT NULL,
  `user_name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `phone_number` varchar(255) NOT NULL,
  `created_by` varchar(255) NOT NULL,
  `created_date` timestamp NULL DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_date` timestamp NULL DEFAULT NULL,
  `status` varchar(255) NOT NULL,
  `role` varchar(255) DEFAULT NULL,
  `isLoggedIn` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_name_UNIQUE` (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `train` (
  `train_id` varchar(255) NOT NULL,
  `train_number` varchar(255) NOT NULL,
  `train_name` varchar(255) NOT NULL,
  `source` varchar(255) NOT NULL,
  `destination` varchar(255) NOT NULL,
  `created_by` varchar(255) NOT NULL,
  `created_date` timestamp NULL DEFAULT NULL,
  `modified_by` varchar(255) NOT NULL,
  `modified_date` timestamp NULL DEFAULT NULL,
  `status` varchar(255) NOT NULL,
  PRIMARY KEY (`train_id`),
  UNIQUE KEY `train_number` (`train_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `seat` (
  `seat_id` varchar(255) NOT NULL,
  `seat_number` varchar(255) NOT NULL,
  `status` varchar(255) NOT NULL,
  PRIMARY KEY (`seat_id`),
  UNIQUE KEY `seat_number_UNIQUE` (`seat_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `booking` (
  `booking_id` varchar(255) NOT NULL,
  `train_id` varchar(255) NOT NULL,
  `seat_id` varchar(255) NOT NULL,
  `user_id` varchar(255) NOT NULL,
  `status` varchar(255) NOT NULL,
  `created_by` varchar(255) NOT NULL,
  `created_date` timestamp NULL DEFAULT NULL,
  `modified_by` varchar(255) NOT NULL,
  `modified_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`booking_id`),
  KEY `booking.train_id` (`train_id`),
  KEY `booking.seat_id` (`seat_id`),
  CONSTRAINT `booking.seat_id` FOREIGN KEY (`seat_id`) REFERENCES `seat` (`seat_id`),
  CONSTRAINT `booking.train_id` FOREIGN KEY (`train_id`) REFERENCES `train` (`train_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



