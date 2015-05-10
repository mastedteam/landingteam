-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versione server:              5.6.15-log - MySQL Community Server (GPL)
-- S.O. server:                  Win32
-- HeidiSQL Versione:            8.3.0.4694
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dump della struttura del database appaid
CREATE DATABASE IF NOT EXISTS `appaid` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `appaid`;


-- Dump della struttura di tabella appaid.balance
CREATE TABLE IF NOT EXISTS `app_balance` (
  `ID_USER` int(11) NOT NULL,
  `ID_GROUP` int(11) NOT NULL,
  `BALANCE` decimal(10,2) NOT NULL,
  `NOTE` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- L’esportazione dei dati non era selezionata.


-- Dump della struttura di tabella appaid.group
CREATE TABLE IF NOT EXISTS `app_group` (
  `ID_GROUP` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(50) NOT NULL,
  `IMAGE` varchar(100) DEFAULT NULL,
  `ID_USER_CREATION` varchar(50) NOT NULL,
  `DATE_CREATION` date NOT NULL,
  `FLAG_DELETED` varchar(1) NOT NULL,
  PRIMARY KEY (`ID_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- L’esportazione dei dati non era selezionata.


-- Dump della struttura di tabella appaid.owned
CREATE TABLE IF NOT EXISTS `app_owned` (
  `ID_USER` int(11) NOT NULL,
  `ID_GROUP` int(11) NOT NULL,
  `DATE_JOIN` date NOT NULL,
  `FLAG_DELETED` varchar(1) NOT NULL,
  KEY `OWNED_USER_FK` (`ID_USER`),
  KEY `OWNED_GROUP_FK` (`ID_GROUP`),
  CONSTRAINT `OWNED_GROUP_FK` FOREIGN KEY (`ID_GROUP`) REFERENCES `app_group` (`ID_GROUP`),
  CONSTRAINT `OWNED_USER_FK` FOREIGN KEY (`ID_USER`) REFERENCES `app_user` (`ID_USER`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- L’esportazione dei dati non era selezionata.


-- Dump della struttura di tabella appaid.payment
CREATE TABLE IF NOT EXISTS `app_payment` (
  `ID_PAYMENT` int(11) NOT NULL AUTO_INCREMENT,
  `ID_USER` int(11) NOT NULL,
  `ID_GROUP` int(11) NOT NULL,
  `DESCRIPTION` varchar(100) NOT NULL,
  `AMOUNT` decimal(10,2) NOT NULL,
  `DATE_PAYMENT` date NOT NULL,
  `NOTE` varchar(100) DEFAULT NULL,
  `FLAG_DELETED` varchar(1) NOT NULL,
  PRIMARY KEY (`ID_PAYMENT`),
  KEY `PAYMENT_USER_FK` (`ID_USER`),
  KEY `PAYMENT_GROUP_FK` (`ID_GROUP`),
  CONSTRAINT `PAYMENT_GROUP_FK` FOREIGN KEY (`ID_GROUP`) REFERENCES `app_group` (`ID_GROUP`),
  CONSTRAINT `PAYMENT_USER_FK` FOREIGN KEY (`ID_USER`) REFERENCES `app_user` (`ID_USER`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- L’esportazione dei dati non era selezionata.


-- Dump della struttura di tabella appaid.payment_detail
CREATE TABLE IF NOT EXISTS `app_payment_detail` (
  `ID_PAYDET` int(11) NOT NULL AUTO_INCREMENT,
  `ID_PAYMENT` int(11) NOT NULL,
  `ID_USER` int(11) NOT NULL,
  `AMOUNT` date NOT NULL,
  `NOTE` varchar(100) DEFAULT NULL,
  `FLAG_DELETED` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`ID_PAYDET`),
  KEY `PAYDET_PAYMENT_FK` (`ID_PAYMENT`),
  KEY `PAYDET_USER_FK` (`ID_USER`),
  CONSTRAINT `PAYDET_PAYMENT_FK` FOREIGN KEY (`ID_PAYMENT`) REFERENCES `app_payment` (`ID_PAYMENT`),
  CONSTRAINT `PAYDET_USER_FK` FOREIGN KEY (`ID_USER`) REFERENCES `app_user` (`ID_USER`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- L’esportazione dei dati non era selezionata.


-- Dump della struttura di tabella appaid.user
CREATE TABLE IF NOT EXISTS `app_user` (
  `ID_USER` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(50) NOT NULL,
  `SURNAME` varchar(50) NOT NULL,
  `IMAGE` varchar(100) DEFAULT NULL,
  `EMAIL` varchar(50) NOT NULL,
  `NICK_NAME` varchar(50) DEFAULT NULL,
  `PASSWORD` varchar(100) NOT NULL,
  `DATE_REGISTRATION` date NOT NULL,
  `FLAG_DELETED` varchar(1) NOT NULL,
  PRIMARY KEY (`ID_USER`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- L’esportazione dei dati non era selezionata.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
