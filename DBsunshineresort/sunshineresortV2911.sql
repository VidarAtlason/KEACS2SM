CREATE DATABASE  IF NOT EXISTS `sunshineresort` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `sunshineresort`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: 127.0.0.1    Database: sunshineresort
-- ------------------------------------------------------
-- Server version	5.6.20

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `company`
--

DROP TABLE IF EXISTS `company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `company` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cvr` varchar(10) NOT NULL,
  `email` varchar(155) NOT NULL,
  `name` varchar(155) NOT NULL,
  `contactName` varchar(155) NOT NULL,
  `phoneNo` varchar(15) NOT NULL,
  `faxNo` varchar(15) DEFAULT NULL,
  `street` varchar(75) NOT NULL,
  `houseNumber` varchar(5) NOT NULL,
  `zip_fk` int(4) NOT NULL,
  `country_fk` int(4) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `company_zip` (`zip_fk`),
  KEY `company_country` (`country_fk`),
  CONSTRAINT `company_country` FOREIGN KEY (`country_fk`) REFERENCES `country` (`id`),
  CONSTRAINT `company_zip` FOREIGN KEY (`zip_fk`) REFERENCES `zip` (`zipCode`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company`
--

LOCK TABLES `company` WRITE;
/*!40000 ALTER TABLE `company` DISABLE KEYS */;
INSERT INTO `company` VALUES (1,'57685000','cph@cph.dk','Copenhagen Ideas','Luke Skywalker','27395518','27396478','BALDERSBÆKVEJ','11A',3520,61);
/*!40000 ALTER TABLE `company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cottage`
--

DROP TABLE IF EXISTS `cottage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cottage` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `street` varchar(100) NOT NULL,
  `houseNumber` varchar(10) NOT NULL,
  `zip_fk` int(4) NOT NULL,
  `cottagetype_fk` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `cottage_zip` (`zip_fk`),
  KEY `cottage_cottagetype` (`cottagetype_fk`),
  CONSTRAINT `cottage_cottagetype` FOREIGN KEY (`cottagetype_fk`) REFERENCES `cottagetype` (`id`),
  CONSTRAINT `cottage_zip` FOREIGN KEY (`zip_fk`) REFERENCES `zip` (`zipCode`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cottage`
--

LOCK TABLES `cottage` WRITE;
/*!40000 ALTER TABLE `cottage` DISABLE KEYS */;
INSERT INTO `cottage` VALUES (1,'Silent Log 1','Vagabond','56',2400,5),(2,'Silent Log 2','Vagabond','57',2400,5),(3,'Silent Log 3','Vagabond','58',2400,5),(4,'Silent Log 4','Vagabond','59',2400,5),(5,'Muse 1','Vagabond','60',2400,6),(6,'Muse 2','Vagabond','61',2400,6),(7,'Muse 3','Vagabond','62',2400,6),(8,'Muse 4','Vagabond','63',2400,6),(9,'Peace 1','Vagabond','64',2400,7),(10,'Peace 2','Vagabond','65',2400,7),(11,'Peace 3','Vagabond','66',2400,7),(12,'Peace 4','Vagabond','67',2400,7),(13,'Carol 1','Diagonal','1',2400,9),(14,'Carol 2','Diagonal','2',2400,9),(15,'Carol 3','Diagonal','3',2400,9),(16,'Carol 4','Diagonal','4',2400,9),(17,'Heaven On Earth 1','Diagonal','5',2400,10),(18,'Heaven On Earth 2','Diagonal','6',2400,10),(19,'Heaven On Earth 3','Diagonal','7',2400,10),(20,'Heaven On Earth 4','Diagonal','8',2400,10),(21,'Heaven On Earth 5','Diagonal','9',2400,10),(22,'Heaven On Earth 6','Diagonal','10',2400,10),(23,'Heaven On Earth 7','Diagonal','11',2400,10),(24,'Heaven On Earth 8','Diagonal','12',2400,10),(25,'Livestrong 1','Melancholia','15',2400,11),(26,'Livestrong 2','Melancholia','16',2400,11),(27,'Livestrong 3','Melancholia','17',2400,11),(28,'Livestrong 4','Melancholia','18',2400,11),(29,'Livestrong 5','Melancholia','19',2400,11),(30,'Livestrong 6','Melancholia','20',2400,11),(31,'Debeste 1','Melancholia','30',2400,12),(32,'Debeste 2','Melancholia','32',2400,12);
/*!40000 ALTER TABLE `cottage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cottagetype`
--

DROP TABLE IF EXISTS `cottagetype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cottagetype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(65) NOT NULL,
  `beds` int(11) NOT NULL,
  `price` decimal(7,2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cottagetype`
--

LOCK TABLES `cottagetype` WRITE;
/*!40000 ALTER TABLE `cottagetype` DISABLE KEYS */;
INSERT INTO `cottagetype` VALUES (5,'Luxury 4',4,1000.00),(6,'Luxury 6',6,1200.00),(7,'Luxury 8',8,1400.00),(8,'Luxury 12',12,1900.00),(9,'Standard 4',4,700.00),(10,'Standard 6',6,900.00),(11,'Standard 8',8,1100.00),(12,'Standard 12',12,1500.00);
/*!40000 ALTER TABLE `cottagetype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `country`
--

DROP TABLE IF EXISTS `country`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `country` (
  `id` int(4) NOT NULL,
  `short_name` varchar(100) NOT NULL,
  `long_name` varchar(150) NOT NULL,
  `calling_code` varchar(4) NOT NULL,
  `iso3` varchar(3) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `country`
--

LOCK TABLES `country` WRITE;
/*!40000 ALTER TABLE `country` DISABLE KEYS */;
INSERT INTO `country` VALUES (61,'Denmark','Kingdom of Denmark','45','DNK');
/*!40000 ALTER TABLE `country` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `equipment`
--

DROP TABLE IF EXISTS `equipment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `equipment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(65) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipment`
--

LOCK TABLES `equipment` WRITE;
/*!40000 ALTER TABLE `equipment` DISABLE KEYS */;
INSERT INTO `equipment` VALUES (1,'TV'),(2,'Spa'),(3,'Sauna');
/*!40000 ALTER TABLE `equipment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `equipment_cottagetype`
--

DROP TABLE IF EXISTS `equipment_cottagetype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `equipment_cottagetype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `equipment_fk` int(11) NOT NULL,
  `cottagetype_fk` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `equipcottage_equipment` (`equipment_fk`),
  KEY `equipcottage_cottagetype` (`cottagetype_fk`),
  CONSTRAINT `equipcottage_cottagetype` FOREIGN KEY (`cottagetype_fk`) REFERENCES `cottagetype` (`id`),
  CONSTRAINT `equipcottage_equipment` FOREIGN KEY (`equipment_fk`) REFERENCES `equipment` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipment_cottagetype`
--

LOCK TABLES `equipment_cottagetype` WRITE;
/*!40000 ALTER TABLE `equipment_cottagetype` DISABLE KEYS */;
INSERT INTO `equipment_cottagetype` VALUES (1,1,9),(2,1,10),(3,1,11),(4,1,12),(5,2,5),(6,2,6),(7,2,7),(8,2,8),(9,3,5),(10,3,6),(11,3,7),(12,3,8),(13,1,5),(14,1,6),(15,1,7),(16,1,8);
/*!40000 ALTER TABLE `equipment_cottagetype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `privatecustomer`
--

DROP TABLE IF EXISTS `privatecustomer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `privatecustomer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fName` varchar(85) NOT NULL,
  `lName` varchar(85) NOT NULL,
  `email` varchar(155) NOT NULL,
  `phoneNo` varchar(13) NOT NULL,
  `street` varchar(75) NOT NULL,
  `houseNumber` varchar(5) NOT NULL,
  `zip_fk` int(4) NOT NULL,
  `country_fk` int(4) NOT NULL,
  `gender` bit(1) NOT NULL,
  `birthdate` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `_zip` (`zip_fk`),
  KEY `_country` (`country_fk`),
  CONSTRAINT `_country` FOREIGN KEY (`country_fk`) REFERENCES `country` (`id`),
  CONSTRAINT `_zip` FOREIGN KEY (`zip_fk`) REFERENCES `zip` (`zipCode`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `privatecustomer`
--

LOCK TABLES `privatecustomer` WRITE;
/*!40000 ALTER TABLE `privatecustomer` DISABLE KEYS */;
INSERT INTO `privatecustomer` VALUES (1,'Marie','Birkehoj','mb@hotmail.com','37292020','GREVE MAIN','17',2450,61,'\0','1988-11-11');
/*!40000 ALTER TABLE `privatecustomer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rate`
--

DROP TABLE IF EXISTS `rate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rate` (
  `id` int(11) NOT NULL,
  `rate` int(3) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rate`
--

LOCK TABLES `rate` WRITE;
/*!40000 ALTER TABLE `rate` DISABLE KEYS */;
INSERT INTO `rate` VALUES (1,100),(2,100),(3,100),(4,100),(5,100),(6,100),(7,100),(8,100),(9,100),(10,100),(11,140),(12,140),(13,140),(14,140),(15,140),(16,140),(17,140),(18,140),(19,140),(20,140),(21,100),(22,100),(23,100),(24,100),(25,100),(26,100),(27,100),(28,100),(29,100),(30,70),(31,70),(32,70),(33,70),(34,70),(35,70),(36,70),(37,70),(38,100),(39,100),(40,100),(41,100),(42,140),(43,140),(44,140),(45,140),(46,140),(47,140),(48,140),(49,140),(50,140),(51,140),(52,140);
/*!40000 ALTER TABLE `rate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservation`
--

DROP TABLE IF EXISTS `reservation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reservation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `reserveDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `durationFrom` int(6) NOT NULL,
  `durationTo` int(6) NOT NULL,
  `paid` bit(1) NOT NULL,
  `price` decimal(10,2) NOT NULL,
  `privatecustomer_fk` int(11) DEFAULT NULL,
  `company_fk` int(11) DEFAULT NULL,
  `cottage_fk` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `reservation_` (`privatecustomer_fk`),
  KEY `reservation_company` (`company_fk`),
  KEY `reservation_cottage` (`cottage_fk`),
  CONSTRAINT `reservation_` FOREIGN KEY (`privatecustomer_fk`) REFERENCES `privatecustomer` (`id`),
  CONSTRAINT `reservation_company` FOREIGN KEY (`company_fk`) REFERENCES `company` (`id`),
  CONSTRAINT `reservation_cottage` FOREIGN KEY (`cottage_fk`) REFERENCES `cottage` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservation`
--

LOCK TABLES `reservation` WRITE;
/*!40000 ALTER TABLE `reservation` DISABLE KEYS */;
/*!40000 ALTER TABLE `reservation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_log`
--

DROP TABLE IF EXISTS `user_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_log` (
  `userId` int(11) NOT NULL,
  `timestamp` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`userId`),
  CONSTRAINT `fk_userId` FOREIGN KEY (`userId`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_log`
--

LOCK TABLES `user_log` WRITE;
/*!40000 ALTER TABLE `user_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(60) NOT NULL,
  `password` varchar(126) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `zip`
--

DROP TABLE IF EXISTS `zip`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `zip` (
  `zipCode` int(4) NOT NULL,
  `city` varchar(75) NOT NULL,
  PRIMARY KEY (`zipCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zip`
--

LOCK TABLES `zip` WRITE;
/*!40000 ALTER TABLE `zip` DISABLE KEYS */;
INSERT INTO `zip` VALUES (2400,'Norrebro'),(2450,'Copenhagen SV'),(3520,'Farum');
/*!40000 ALTER TABLE `zip` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-12-02 14:33:45
