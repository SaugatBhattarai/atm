-- phpMyAdmin SQL Dump
-- version 4.0.4.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jul 24, 2015 at 07:49 PM
-- Server version: 5.5.32
-- PHP Version: 5.4.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `atm`
--
CREATE DATABASE IF NOT EXISTS `atm` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `atm`;

-- --------------------------------------------------------

--
-- Table structure for table `pindetails`
--

CREATE TABLE IF NOT EXISTS `pindetails` (
  `accountNumber` int(11) NOT NULL,
  `pinNumber` int(11) NOT NULL,
  `accountBalance` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pindetails`
--

INSERT INTO `pindetails` (`accountNumber`, `pinNumber`, `accountBalance`) VALUES
(0, 5482, 904094),
(9090, 6357, 900000),
(7874, 3539, 999999),
(9090, 7625, 898989),
(4630, 2622, 343434);

-- --------------------------------------------------------

--
-- Table structure for table `useraccountdetail`
--

CREATE TABLE IF NOT EXISTS `useraccountdetail` (
  `accountType` varchar(255) NOT NULL,
  `firstName` varchar(255) DEFAULT NULL,
  `lastName` varchar(255) DEFAULT NULL,
  `accountNumber` int(11) NOT NULL DEFAULT '0',
  `accountBalance` double DEFAULT NULL,
  PRIMARY KEY (`accountNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `useraccountdetail`
--

INSERT INTO `useraccountdetail` (`accountType`, `firstName`, `lastName`, `accountNumber`, `accountBalance`) VALUES
('', NULL, NULL, 0, NULL),
('Current', 'Saugat', 'Bhattarai', 1234, 2334434),
('Current', 'Krishna', 'sahani', 3456, 4848844),
('Current', 'Pradip', 'Silwal', 4630, 343434),
('Saving', 'Saugat', 'Bhattarai', 5840, 904094),
('Saving', 'RamKrishna', 'Bhattarai', 7874, 999999),
('Current', 'Saugat', 'Bhattarai', 8585, 393983),
('Saving', 'Krishna', 'Sahani', 9090, 900000);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
