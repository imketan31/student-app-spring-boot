-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               8.0.16 - MySQL Community Server - GPL
-- Server OS:                    Win64
-- HeidiSQL Version:             11.0.0.6013
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for studentdb
DROP DATABASE IF EXISTS `studentdb`;
CREATE DATABASE IF NOT EXISTS `studentdb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `studentdb`;

-- Dumping structure for table studentdb.class_teacher
DROP TABLE IF EXISTS `class_teacher`;
CREATE TABLE IF NOT EXISTS `class_teacher` (
  `id` int(11) NOT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `pass` varchar(255) DEFAULT NULL,
  `roll` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table studentdb.class_teacher: ~0 rows (approximately)
DELETE FROM `class_teacher`;
/*!40000 ALTER TABLE `class_teacher` DISABLE KEYS */;
INSERT INTO `class_teacher` (`id`, `first_name`, `last_name`, `pass`, `roll`, `status`, `user_name`) VALUES
	(1, 'Admin', 'Admin', 'Admin', 'Admin', 'Active', 'Admin');
/*!40000 ALTER TABLE `class_teacher` ENABLE KEYS */;

-- Dumping structure for table studentdb.student
DROP TABLE IF EXISTS `student`;
CREATE TABLE IF NOT EXISTS `student` (
  `id` int(11) NOT NULL,
  `division` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `last_year_per` varchar(255) DEFAULT NULL,
  `roll_no` varchar(255) DEFAULT NULL,
  `standard` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `pass` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `class_teacher_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKr35irlo7ed62tepmccekda43i` (`class_teacher_id`),
  CONSTRAINT `FKr35irlo7ed62tepmccekda43i` FOREIGN KEY (`class_teacher_id`) REFERENCES `class_teacher` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table studentdb.student: ~2 rows (approximately)
DELETE FROM `student`;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` (`id`, `division`, `first_name`, `last_name`, `last_year_per`, `roll_no`, `standard`, `status`, `pass`, `user_name`, `class_teacher_id`) VALUES
	(1, 'A', 'Ketan', 'Kulkarni', '80 %', '01', '10', 'Active', 'vish', 'Ketan', 1),
	(2, 'A', 'Ketan2', 'Kulkarni2', '80 %', '01', '10', 'Active', 'vish', 'Ketan', 1);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
