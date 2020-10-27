-- phpMyAdmin SQL Dump
-- version 4.1.5
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Oct 27, 2020 at 10:30 AM
-- Server version: 5.6.15
-- PHP Version: 5.5.38

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `Gateways`
--

-- --------------------------------------------------------

--
-- Table structure for table `gateway`
--

CREATE TABLE IF NOT EXISTS `gateway` (
  `serialnum` varchar(255) COLLATE utf8_bin NOT NULL,
  `ipv4` varchar(255) COLLATE utf8_bin NOT NULL,
  `name` varchar(255) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`serialnum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `gateway`
--

INSERT INTO `gateway` (`serialnum`, `ipv4`, `name`) VALUES
('Gateway1', '255.255.255.1', 'Musala1'),
('Gateway2', '255.255.255.5', 'Musala2'),
('Gateway3', '255.255.255.311', 'Musala2'),
('Gateway4', '255.255.255.311', 'Musala4'),
('Gateway5', '1.2.3.6', 'Musala5'),
('Gateway6', '1.2.3.6', 'Musala5');

-- --------------------------------------------------------

--
-- Table structure for table `peripheral`
--

CREATE TABLE IF NOT EXISTS `peripheral` (
  `id` bigint(20) NOT NULL,
  `date_created` date DEFAULT NULL,
  `status` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `vendor` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `serialnum` varchar(255) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKbwvk7dayo1lnlenck5mg7nka2` (`serialnum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `peripheral`
--

INSERT INTO `peripheral` (`id`, `date_created`, `status`, `vendor`, `serialnum`) VALUES
(1, '2020-10-25', 'online', 'Sysco 1', 'Gateway1'),
(2, '2020-10-25', 'offline', 'Sysco 2', 'Gateway1'),
(3, '2020-10-26', 'online', 'Sysco 3', 'Gateway2'),
(4, '2020-10-26', 'offline', 'Sysco 4', 'Gateway2'),
(5, '2020-10-26', 'offline', 'Sysco 5', 'Gateway2'),
(7, '2020-10-27', 'online', 'Nysco 1', 'Gateway1'),
(9, '2020-10-26', 'online', 'Sysco 1', 'Gateway2'),
(10, '2020-10-26', 'online', 'Sysco 3', 'Gateway3'),
(11, '2020-10-26', 'offline', 'Sysco 4', 'Gateway3'),
(12, '2020-10-26', 'online', 'Sysco 5', 'Gateway3'),
(13, '2020-10-26', 'online', 'Sysco 6', 'Gateway3'),
(14, '2020-10-26', 'online', 'Sysco 8', 'Gateway3'),
(16, '2020-10-26', 'online', 'Sysco 1', 'Gateway4'),
(20, '2020-10-26', 'online', 'Sysco 3', 'Gateway4'),
(21, '2020-10-26', 'offline', 'Sysco 4', 'Gateway4'),
(22, '2020-10-26', 'online', 'Sysco 5', 'Gateway4'),
(23, '2020-10-26', 'online', 'Sysco 6', 'Gateway4'),
(25, '2020-10-27', 'online', 'Nysco 1', 'Gateway4'),
(30, '2020-10-27', 'online', 'Sysco 3', 'Gateway5'),
(31, '2020-10-27', 'offline', 'Sysco 4', 'Gateway5'),
(32, '2020-10-27', 'online', 'Sysco 30', 'Gateway5'),
(33, '2020-10-27', 'online', 'Nysco 1', 'Gateway5'),
(40, '2020-10-27', 'online', 'Sysco 3', 'Gateway6'),
(41, '2020-10-27', 'offline', 'Sysco 4', 'Gateway6'),
(42, '2020-10-27', 'online', 'Sysco 30', 'Gateway6'),
(43, '2020-10-27', 'online', 'Sysco 30', 'Gateway6');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `peripheral`
--
ALTER TABLE `peripheral`
  ADD CONSTRAINT `FKbwvk7dayo1lnlenck5mg7nka2` FOREIGN KEY (`serialnum`) REFERENCES `gateway` (`serialnum`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
