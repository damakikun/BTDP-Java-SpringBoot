-- Database Company

SET NAMES utf8;
SET time_zone = '+00:00';
SET foreign_key_checks = 0;
SET sql_mode = 'NO_AUTO_VALUE_ON_ZERO';

SET NAMES utf8mb4;

DROP DATABASE IF EXISTS `db_company`;
CREATE DATABASE `db_company` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `db_company`;

DROP TABLE IF EXISTS `dept_location`;
CREATE TABLE `dept_location` (
  `id_dept_location` int(11) NOT NULL AUTO_INCREMENT,
  `dept_no` int(11) NOT NULL,
  `department_location` varchar(32) NOT NULL,
  PRIMARY KEY (`id_dept_location`),
  KEY `dept_no` (`dept_no`),
  CONSTRAINT `dept_location_ibfk_1` FOREIGN KEY (`dept_no`) REFERENCES `tb_department` (`id_dept`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

TRUNCATE `dept_location`;
INSERT INTO `dept_location` (`id_dept_location`, `dept_no`, `department_location`) VALUES
(1,	1,	'1st floor'),
(2,	2,	'2nd floor'),
(3,	3,	'3nd floor'),
(4,	4,	'4nd floor'),
(5,	5,	'5th floor');

DROP TABLE IF EXISTS `tb_department`;
CREATE TABLE `tb_department` (
  `id_dept` int(11) NOT NULL AUTO_INCREMENT,
  `id_ssn` int(11) NOT NULL,
  `department_name` varchar(64) NOT NULL,
  `manager_start_date` date NOT NULL,
  PRIMARY KEY (`id_dept`),
  KEY `id_ssn` (`id_ssn`),
  CONSTRAINT `tb_department_ibfk_2` FOREIGN KEY (`id_ssn`) REFERENCES `tb_employee` (`id_ssn`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;

TRUNCATE `tb_department`;
INSERT INTO `tb_department` (`id_dept`, `id_ssn`, `department_name`, `manager_start_date`) VALUES
(1,	3,	'Management',	'2014-06-26'),
(2,	4,	'IT',	'2005-09-12'),
(3,	2,	'Finance',	'2015-10-27'),
(4,	1,	'Accounting',	'2020-06-04'),
(5,	5,	'HR',	'2012-04-15');

DROP TABLE IF EXISTS `tb_dependent`;
CREATE TABLE `tb_dependent` (
  `id_dependent` int(11) NOT NULL AUTO_INCREMENT,
  `id_ssn` int(11) NOT NULL,
  `dependent_name` varchar(64) NOT NULL,
  `sex` enum('male','female') NOT NULL,
  `bdate` date NOT NULL,
  `relationship` enum('staff','lead','head') NOT NULL,
  PRIMARY KEY (`id_dependent`),
  KEY `id_ssn` (`id_ssn`),
  CONSTRAINT `tb_dependent_ibfk_1` FOREIGN KEY (`id_ssn`) REFERENCES `tb_employee` (`id_ssn`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;

TRUNCATE `tb_dependent`;
INSERT INTO `tb_dependent` (`id_dependent`, `id_ssn`, `dependent_name`, `sex`, `bdate`, `relationship`) VALUES
(1,	2,	'naruto',	'male',	'1998-12-12',	'head'),
(2,	3,	'sasuke',	'male',	'1998-05-08',	'head'),
(3,	4,	'tsunade',	'female',	'1981-04-05',	'lead'),
(4,	2,	'jiraiya',	'male',	'1980-01-07',	'staff'),
(5,	1,	'conan',	'female',	'1996-07-05',	'lead'),
(6,	3,	'neji',	'male',	'1998-10-02',	'staff'),
(7,	4,	'tenten',	'female',	'1999-12-06',	'head');

DROP TABLE IF EXISTS `tb_employee`;
CREATE TABLE `tb_employee` (
  `id_ssn` int(11) NOT NULL AUTO_INCREMENT,
  `fname` varchar(64) NOT NULL,
  `mname` varchar(64) DEFAULT NULL,
  `lname` varchar(64) NOT NULL,
  `bdate` date NOT NULL,
  `address` varchar(32) NOT NULL,
  `sex` enum('male','female') NOT NULL,
  `salary` float NOT NULL,
  `id_dept` int(11) NOT NULL,
  PRIMARY KEY (`id_ssn`),
  KEY `id_dept` (`id_dept`),
  CONSTRAINT `tb_employee_ibfk_1` FOREIGN KEY (`id_dept`) REFERENCES `tb_department` (`id_dept`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;

TRUNCATE `tb_employee`;
INSERT INTO `tb_employee` (`id_ssn`, `fname`, `mname`, `lname`, `bdate`, `address`, `sex`, `salary`, `id_dept`) VALUES
(1,	'adam',	'damaki',	'ghufron',	'1998-06-04',	'jakarta',	'male',	25000000,	1),
(2,	'monkey',	'd',	'luffy',	'1981-08-24',	'east blue',	'male',	22000000,	2),
(3,	'monkey',	'd',	'garp',	'1879-11-22',	'hq navy',	'male',	500000,	4),
(4,	'nico',	'',	'robin',	'1990-04-12',	'ohara',	'female',	15000000,	3),
(5,	'nami',	'',	'chan',	'1991-01-20',	'fuusha',	'female',	23000000,	1),
(6,	'dragon',	'd',	'wind',	'1977-09-25',	'east blue',	'male',	5000000,	4),
(7,	'rudes',	'neferi',	'caesar',	'2000-05-13',	'isekai',	'male',	12000000,	5),
(8,	'kratos',	'',	'war',	'1906-06-16',	'yunani',	'male',	25000000,	4);

DROP TABLE IF EXISTS `tb_project`;
CREATE TABLE `tb_project` (
  `id_project` int(11) NOT NULL AUTO_INCREMENT,
  `id_dept` int(11) NOT NULL,
  `project_name` varchar(64) NOT NULL,
  `project_location` varchar(32) NOT NULL,
  PRIMARY KEY (`id_project`),
  KEY `id_dept` (`id_dept`),
  CONSTRAINT `tb_project_ibfk_1` FOREIGN KEY (`id_dept`) REFERENCES `tb_department` (`id_dept`) ON DELETE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

TRUNCATE `tb_project`;
INSERT INTO `tb_project` (`id_project`, `id_dept`, `project_name`, `project_location`) VALUES
(1,	1,	'mencari berkah',	'bandung'),
(2,	2,	'ennichisai',	'jakarta'),
(3,	2,	'afaid',	'jakarta'),
(4,	2,	'revolusi mental',	'solo'),
(5,	5,	'bootcamp',	'jakarta'),
(6,	4,	'ojt',	'banten');

DROP TABLE IF EXISTS `tb_works_on`;
CREATE TABLE `tb_works_on` (
  `id_works` int(11) NOT NULL AUTO_INCREMENT,
  `id_ssn` int(11) NOT NULL,
  `id_project` int(11) NOT NULL,
  `hours` int(16) NOT NULL,
  PRIMARY KEY (`id_works`),
  KEY `id_ssn` (`id_ssn`),
  KEY `id_project` (`id_project`),
  CONSTRAINT `tb_works_on_ibfk_1` FOREIGN KEY (`id_ssn`) REFERENCES `tb_employee` (`id_ssn`),
  CONSTRAINT `tb_works_on_ibfk_2` FOREIGN KEY (`id_project`) REFERENCES `tb_project` (`id_project`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4;

TRUNCATE `tb_works_on`;
INSERT INTO `tb_works_on` (`id_works`, `id_ssn`, `id_project`, `hours`) VALUES
(1,	1,	2,	40),
(2,	3,	3,	30),
(3,	3,	4,	15),
(4,	5,	2,	50),
(5,	5,	5,	100),
(6,	4,	1,	50),
(7,	4,	2,	100),
(8,	5,	3,	10),
(9,	6,	1,	170),
(10,	8,	2,	100),
(11,	8,	1,	35),
(12,	8,	4,	35),
(13,	2,	1,	50),
(14,	2,	2,	60);