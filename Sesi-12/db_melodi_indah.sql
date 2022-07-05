-- Database PT Melodi Indah

SET NAMES utf8;
SET time_zone = '+00:00';
SET foreign_key_checks = 0;
SET sql_mode = 'NO_AUTO_VALUE_ON_ZERO';

SET NAMES utf8mb4;

DROP DATABASE IF EXISTS `db_melodi_indah`;
CREATE DATABASE `db_melodi_indah` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `db_melodi_indah`;

DROP VIEW IF EXISTS `instrumen_musisi`;
CREATE TABLE `instrumen_musisi` (`nama` varchar(64), `alamat` varchar(64), `nama_instrumen` varchar(32), `kunci_musik` varchar(8));


DROP VIEW IF EXISTS `pengarang_album`;
CREATE TABLE `pengarang_album` (`judul` varchar(64), `pengarang` varchar(64), `nama_album` varchar(32), `tgl_copyright` date, `format` enum('cd','mc'), `id_album` int(11));


DROP TABLE IF EXISTS `tb_album`;
CREATE TABLE `tb_album` (
  `id_album` int(11) NOT NULL AUTO_INCREMENT,
  `nama_album` varchar(32) NOT NULL,
  `tgl_copyright` date NOT NULL,
  `format` enum('cd','mc') NOT NULL,
  `ssn` int(11) NOT NULL,
  PRIMARY KEY (`id_album`),
  KEY `ssn` (`ssn`),
  CONSTRAINT `tb_album_ibfk_1` FOREIGN KEY (`ssn`) REFERENCES `tb_musisi` (`ssn`) ON DELETE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

TRUNCATE `tb_album`;
INSERT INTO `tb_album` (`id_album`, `nama_album`, `tgl_copyright`, `format`, `ssn`) VALUES
(1,	'Black Love',	'2021-07-11',	'cd',	4),
(2,	'Sekai',	'2022-04-07',	'mc',	2),
(3,	'Dark Knive',	'2019-09-10',	'mc',	2),
(4,	'Replay',	'2018-10-14',	'cd',	4),
(5,	'Closer',	'2020-06-02',	'mc',	1);

DROP TABLE IF EXISTS `tb_combine_musik`;
CREATE TABLE `tb_combine_musik` (
  `id_combine` int(11) NOT NULL AUTO_INCREMENT,
  `ssn` int(11) NOT NULL,
  `id_instrumen` int(11) NOT NULL,
  PRIMARY KEY (`id_combine`),
  KEY `ssn` (`ssn`),
  KEY `id_instrumen` (`id_instrumen`),
  CONSTRAINT `tb_combine_musik_ibfk_1` FOREIGN KEY (`ssn`) REFERENCES `tb_musisi` (`ssn`) ON DELETE NO ACTION,
  CONSTRAINT `tb_combine_musik_ibfk_2` FOREIGN KEY (`id_instrumen`) REFERENCES `tb_instrumen` (`id_instrumen`) ON DELETE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4;

TRUNCATE `tb_combine_musik`;
INSERT INTO `tb_combine_musik` (`id_combine`, `ssn`, `id_instrumen`) VALUES
(1,	1,	1),
(2,	1,	3),
(3,	1,	5),
(4,	2,	2),
(5,	2,	3),
(6,	3,	6),
(7,	3,	5),
(8,	3,	3),
(9,	4,	4),
(10,	4,	5),
(11,	4,	8);

DROP TABLE IF EXISTS `tb_instrumen`;
CREATE TABLE `tb_instrumen` (
  `id_instrumen` int(11) NOT NULL AUTO_INCREMENT,
  `nama` varchar(32) NOT NULL,
  `kunci_musik` varchar(8) NOT NULL,
  PRIMARY KEY (`id_instrumen`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;

TRUNCATE `tb_instrumen`;
INSERT INTO `tb_instrumen` (`id_instrumen`, `nama`, `kunci_musik`) VALUES
(1,	'piano',	'b'),
(2,	'piano',	'c'),
(3,	'piano',	'd'),
(4,	'biola',	'f'),
(5,	'biola',	'g'),
(6,	'seruling',	'c'),
(7,	'seruling',	'g'),
(8,	'gendang',	'c#'),
(9,	'gitar',	'd'),
(10,	'gitar',	'g');

DROP TABLE IF EXISTS `tb_lagu`;
CREATE TABLE `tb_lagu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `judul` varchar(64) NOT NULL,
  `pengarang` varchar(64) NOT NULL,
  `id_album` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_album` (`id_album`),
  CONSTRAINT `tb_lagu_ibfk_1` FOREIGN KEY (`id_album`) REFERENCES `tb_album` (`id_album`) ON DELETE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

TRUNCATE `tb_lagu`;
INSERT INTO `tb_lagu` (`id`, `judul`, `pengarang`, `id_album`) VALUES
(1,	'More than Love',	'Adam Smith',	3),
(2,	'One Step Closer',	'Adam Smith',	3),
(3,	'Never',	'Karl Max',	1),
(4,	'Behinded',	'Scooper Gaban',	2),
(5,	'Late',	'Kamarun',	2);

DROP TABLE IF EXISTS `tb_musisi`;
CREATE TABLE `tb_musisi` (
  `ssn` int(11) NOT NULL AUTO_INCREMENT,
  `nama` varchar(64) NOT NULL,
  `alamat` varchar(64) NOT NULL,
  `nomor_telepon` varchar(64) NOT NULL,
  PRIMARY KEY (`ssn`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

TRUNCATE `tb_musisi`;
INSERT INTO `tb_musisi` (`ssn`, `nama`, `alamat`, `nomor_telepon`) VALUES
(1,	'Adam Smith',	'New York',	'14045'),
(2,	'Karl Max',	'Canberra',	'14022'),
(3,	'Scooper Gaban',	'Tokyo',	'14014'),
(4,	'Kamarun',	'New Delhi',	'14041');

DROP TABLE IF EXISTS `instrumen_musisi`;
CREATE ALGORITHM=UNDEFINED SQL SECURITY DEFINER VIEW `instrumen_musisi` AS select `tm`.`nama` AS `nama`,`tm`.`alamat` AS `alamat`,`ti`.`nama` AS `nama_instrumen`,`ti`.`kunci_musik` AS `kunci_musik` from ((`tb_combine_musik` `tcm` join `tb_instrumen` `ti` on(`ti`.`id_instrumen` = `tcm`.`id_instrumen`)) join `tb_musisi` `tm` on(`tm`.`ssn` = `tcm`.`ssn`));

DROP TABLE IF EXISTS `pengarang_album`;
CREATE ALGORITHM=UNDEFINED SQL SECURITY DEFINER VIEW `pengarang_album` AS select `tl`.`judul` AS `judul`,`tl`.`pengarang` AS `pengarang`,`ta`.`nama_album` AS `nama_album`,`ta`.`tgl_copyright` AS `tgl_copyright`,`ta`.`format` AS `format`,`ta`.`id_album` AS `id_album` from (`tb_lagu` `tl` join `tb_album` `ta` on(`ta`.`id_album` = `tl`.`id_album`));