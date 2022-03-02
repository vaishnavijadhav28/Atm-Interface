-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: atmapp
-- ------------------------------------------------------
-- Server version	8.0.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `atmuser`
--

DROP TABLE IF EXISTS `atmuser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `atmuser` (
  `uId` bigint NOT NULL,
  `userName` varchar(100) NOT NULL,
  `userAddress` varchar(200) NOT NULL,
  `pin` varchar(100) NOT NULL,
  `balance` double NOT NULL,
  `phone` bigint NOT NULL,
  `email` varchar(50) NOT NULL,
  PRIMARY KEY (`uId`),
  UNIQUE KEY `phone` (`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `atmuser`
--

LOCK TABLES `atmuser` WRITE;
/*!40000 ALTER TABLE `atmuser` DISABLE KEYS */;
INSERT INTO `atmuser` VALUES (1,'vaishnavi','Shrirampur','2345',31000,9089786756,'vaish@gmail.com'),(2,'avi','shrigonda','1122',41000,8978675645,'avi@gmail.com'),(3,'minu','shirdi','3456',30000,8778675645,'minu@gmail.com'),(4,'anu','ahmednagar','9876',20000,8778677656,'anu@gmail.com');
/*!40000 ALTER TABLE `atmuser` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trans`
--

DROP TABLE IF EXISTS `trans`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trans` (
  `tId` bigint NOT NULL,
  `uid` bigint NOT NULL,
  `pin` varchar(50) NOT NULL,
  `withdrawAmt` double DEFAULT NULL,
  `depositeAmt` double DEFAULT NULL,
  PRIMARY KEY (`tId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trans`
--

LOCK TABLES `trans` WRITE;
/*!40000 ALTER TABLE `trans` DISABLE KEYS */;
INSERT INTO `trans` VALUES (101,1,'1234',1000,NULL),(102,1,'1234',NULL,2000);
/*!40000 ALTER TABLE `trans` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transa`
--

DROP TABLE IF EXISTS `transa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transa` (
  `transactionid` bigint NOT NULL,
  `pin` varchar(100) NOT NULL,
  `transactiondate` datetime NOT NULL,
  `withdrawAmt` double DEFAULT NULL,
  `depositAmt` double DEFAULT NULL,
  PRIMARY KEY (`transactionid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transa`
--

LOCK TABLES `transa` WRITE;
/*!40000 ALTER TABLE `transa` DISABLE KEYS */;
INSERT INTO `transa` VALUES (234,'2345','2022-11-25 12:23:35',3000,0),(235,'1122','2022-02-26 13:31:25',0,5000),(567,'1234','2022-12-23 10:45:34',0,200),(870,'2345','2022-02-25 22:42:33',3000,0),(2281,'2345','2022-02-25 22:38:13',3000,0);
/*!40000 ALTER TABLE `transa` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-03-02 15:17:31
