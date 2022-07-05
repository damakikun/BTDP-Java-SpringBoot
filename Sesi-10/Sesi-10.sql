-- Adminer 4.8.1 MySQL 5.5.5-10.4.24-MariaDB dump

SET NAMES utf8;
SET time_zone = '+00:00';
SET foreign_key_checks = 0;
SET sql_mode = 'NO_AUTO_VALUE_ON_ZERO';

DROP VIEW IF EXISTS `data_gaji`;
CREATE TABLE `data_gaji` (`id_pegawai` int(11), `nama_pegawai` varchar(50), `jabatan` enum('Staff','Supervisor'), `gaji` int(10), `tgl_gaji` date);


DROP VIEW IF EXISTS `data_transaksi`;
CREATE TABLE `data_transaksi` (`id_transaksi` int(11), `nama_pembeli` varchar(50), `nama_menu` varchar(50), `nama_pegawai` varchar(50), `tgl_transaksi` date);


SET NAMES utf8mb4;

DROP TABLE IF EXISTS `tb_gaji`;
CREATE TABLE `tb_gaji` (
  `id_gaji` int(11) NOT NULL AUTO_INCREMENT,
  `id_pegawai` int(11) NOT NULL,
  `gaji` int(10) NOT NULL,
  `tgl_gaji` date NOT NULL,
  PRIMARY KEY (`id_gaji`),
  KEY `id_pegawai` (`id_pegawai`),
  CONSTRAINT `tb_gaji_ibfk_1` FOREIGN KEY (`id_pegawai`) REFERENCES `tb_pegawai` (`id_pegawai`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

TRUNCATE `tb_gaji`;
INSERT INTO `tb_gaji` (`id_gaji`, `id_pegawai`, `gaji`, `tgl_gaji`) VALUES
(1,	3,	7000000,	'2022-06-20'),
(2,	1,	4000000,	'2022-06-20'),
(3,	2,	5000000,	'2022-06-20');

DROP TABLE IF EXISTS `tb_menu`;
CREATE TABLE `tb_menu` (
  `id_menu` int(11) NOT NULL AUTO_INCREMENT,
  `nama_menu` varchar(50) NOT NULL,
  `jenis` varchar(50) NOT NULL,
  `harga` int(11) NOT NULL,
  PRIMARY KEY (`id_menu`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

TRUNCATE `tb_menu`;
INSERT INTO `tb_menu` (`id_menu`, `nama_menu`, `jenis`, `harga`) VALUES
(1,	'Makanan',	'Ayam',	8000),
(2,	'Minuman',	'Thai Tea',	5000),
(3,	'Kue',	'Blackforest',	100000);

DROP TABLE IF EXISTS `tb_pegawai`;
CREATE TABLE `tb_pegawai` (
  `id_pegawai` int(11) NOT NULL AUTO_INCREMENT,
  `nama_pegawai` varchar(50) NOT NULL,
  `alamat` text NOT NULL,
  `jenis_kelamin` enum('Laki-laki','Perempuan') NOT NULL,
  `tgl_lahir` date NOT NULL,
  `status` enum('Aktif','Tidak Aktif') NOT NULL,
  `no_tlp` varchar(13) NOT NULL,
  `jabatan` enum('Staff','Supervisor') NOT NULL,
  PRIMARY KEY (`id_pegawai`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

TRUNCATE `tb_pegawai`;
INSERT INTO `tb_pegawai` (`id_pegawai`, `nama_pegawai`, `alamat`, `jenis_kelamin`, `tgl_lahir`, `status`, `no_tlp`, `jabatan`) VALUES
(1,	'Hachiman',	'Chiba',	'Laki-laki',	'1998-06-04',	'Aktif',	'085156512320',	'Supervisor'),
(2,	'Yukinoshita',	'Chiba',	'Perempuan',	'1998-08-20',	'Aktif',	'081212312412',	'Staff'),
(3,	'Yuigahama',	'Chiba',	'Perempuan',	'1998-01-02',	'Aktif',	'085821205941',	'Staff');

DROP TABLE IF EXISTS `tb_pembeli`;
CREATE TABLE `tb_pembeli` (
  `id_pembeli` int(11) NOT NULL AUTO_INCREMENT,
  `nama_pembeli` varchar(50) NOT NULL,
  `alamat` text NOT NULL,
  `jenis_kelamin` enum('Laki-laki','Perempuan') NOT NULL,
  `tgl_lahir` date NOT NULL,
  `status` enum('Aktif','Tidak Aktif') NOT NULL,
  `no_hp` int(13) NOT NULL,
  `pekerjaan` varchar(50) NOT NULL,
  PRIMARY KEY (`id_pembeli`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

TRUNCATE `tb_pembeli`;
INSERT INTO `tb_pembeli` (`id_pembeli`, `nama_pembeli`, `alamat`, `jenis_kelamin`, `tgl_lahir`, `status`, `no_hp`, `pekerjaan`) VALUES
(1,	'Goku',	'Planet Saiyan',	'Laki-laki',	'1970-05-13',	'Aktif',	14045,	'Bapak'),
(2,	'Gohan',	'Planet Saiyan',	'Laki-laki',	'1998-04-15',	'Aktif',	14022,	'Anak'),
(3,	'Goten',	'OhaPlanet Saiyanra',	'Laki-laki',	'2005-06-08',	'Aktif',	14041,	'Cucu');

DROP TABLE IF EXISTS `tb_transaksi`;
CREATE TABLE `tb_transaksi` (
  `id_transaksi` int(11) NOT NULL AUTO_INCREMENT,
  `id_pembeli` int(11) NOT NULL,
  `id_menu` int(11) NOT NULL,
  `id_pegawai` int(11) NOT NULL,
  `tgl_transaksi` date NOT NULL,
  PRIMARY KEY (`id_transaksi`),
  KEY `id_pembeli` (`id_pembeli`),
  KEY `id_menu` (`id_menu`),
  KEY `id_pegawai` (`id_pegawai`),
  CONSTRAINT `tb_transaksi_ibfk_1` FOREIGN KEY (`id_pembeli`) REFERENCES `tb_pembeli` (`id_pembeli`),
  CONSTRAINT `tb_transaksi_ibfk_2` FOREIGN KEY (`id_menu`) REFERENCES `tb_menu` (`id_menu`),
  CONSTRAINT `tb_transaksi_ibfk_3` FOREIGN KEY (`id_pegawai`) REFERENCES `tb_pegawai` (`id_pegawai`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

TRUNCATE `tb_transaksi`;
INSERT INTO `tb_transaksi` (`id_transaksi`, `id_pembeli`, `id_menu`, `id_pegawai`, `tgl_transaksi`) VALUES
(1,	1,	1,	1,	'2022-06-20'),
(2,	2,	2,	2,	'2022-06-20'),
(3,	3,	3,	3,	'0000-00-00');

DROP TABLE IF EXISTS `data_gaji`;
CREATE ALGORITHM=UNDEFINED SQL SECURITY DEFINER VIEW `data_gaji` AS select `tp`.`id_pegawai` AS `id_pegawai`,`tp`.`nama_pegawai` AS `nama_pegawai`,`tp`.`jabatan` AS `jabatan`,`tg`.`gaji` AS `gaji`,`tg`.`tgl_gaji` AS `tgl_gaji` from (`tb_pegawai` `tp` join `tb_gaji` `tg` on(`tg`.`id_pegawai` = `tp`.`id_pegawai`)) order by `tp`.`id_pegawai`;

DROP TABLE IF EXISTS `data_transaksi`;
CREATE ALGORITHM=UNDEFINED SQL SECURITY DEFINER VIEW `data_transaksi` AS select `tr`.`id_transaksi` AS `id_transaksi`,`tpl`.`nama_pembeli` AS `nama_pembeli`,`tm`.`nama_menu` AS `nama_menu`,`tp`.`nama_pegawai` AS `nama_pegawai`,`tr`.`tgl_transaksi` AS `tgl_transaksi` from (((`tb_transaksi` `tr` join `tb_pembeli` `tpl` on(`tr`.`id_pembeli` = `tpl`.`id_pembeli`)) join `tb_menu` `tm` on(`tr`.`id_menu` = `tm`.`id_menu`)) join `tb_pegawai` `tp` on(`tr`.`id_pegawai` = `tp`.`id_pegawai`));

-- 2022-06-20 07:51:45