-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: s3_grupo1
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `booking`
--

DROP TABLE IF EXISTS `booking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `booking` (
  `id_booking` int NOT NULL AUTO_INCREMENT,
  `date_from` date DEFAULT NULL,
  `date_to` date DEFAULT NULL,
  `destination` varchar(255) DEFAULT NULL,
  `hotel_code` varchar(255) DEFAULT NULL,
  `people_amount` int DEFAULT NULL,
  `room_type` varchar(255) DEFAULT NULL,
  `payment_method_id` int DEFAULT NULL,
  PRIMARY KEY (`id_booking`),
  KEY `FK94a8jogt778owuqmqxk122kj` (`payment_method_id`),
  CONSTRAINT `FK94a8jogt778owuqmqxk122kj` FOREIGN KEY (`payment_method_id`) REFERENCES `payment_method` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking`
--

LOCK TABLES `booking` WRITE;
/*!40000 ALTER TABLE `booking` DISABLE KEYS */;
/*!40000 ALTER TABLE `booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `booking_people`
--

DROP TABLE IF EXISTS `booking_people`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `booking_people` (
  `booking_model_id_booking` int NOT NULL,
  `people_id` int NOT NULL,
  UNIQUE KEY `UK_tlwq4cokudts2j5owpb9bde8b` (`people_id`),
  KEY `FK7b5mv29jsncbqq84ap6peppwj` (`booking_model_id_booking`),
  CONSTRAINT `FK7b5mv29jsncbqq84ap6peppwj` FOREIGN KEY (`booking_model_id_booking`) REFERENCES `booking` (`id_booking`),
  CONSTRAINT `FKdicjed4sbhx3tpnkod5swuh3x` FOREIGN KEY (`people_id`) REFERENCES `people_model` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking_people`
--

LOCK TABLES `booking_people` WRITE;
/*!40000 ALTER TABLE `booking_people` DISABLE KEYS */;
/*!40000 ALTER TABLE `booking_people` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flight`
--

DROP TABLE IF EXISTS `flight`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `flight` (
  `id` int NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL,
  `destination` varchar(255) DEFAULT NULL,
  `date_from` date DEFAULT NULL,
  `origin` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `seat_type` varchar(255) DEFAULT NULL,
  `date_to` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flight`
--

LOCK TABLES `flight` WRITE;
/*!40000 ALTER TABLE `flight` DISABLE KEYS */;
INSERT INTO `flight` VALUES (1,'BAPI-1235','Puerto Iguazú','2022-02-10','Buenos Aires',6500,'Economy','2022-02-15'),(2,'PIBA-1420','Bogotá','2022-02-10','Puerto Iguazú',43200,'Business','2022-02-20'),(3,'PIBA-1420','Bogotá','2022-02-10','Puerto Iguazú',25735,'Economy','2022-02-21'),(4,'BATU-5536','Tucumán','2022-02-10','Buenos Aires',7320,'Economy','2022-02-17'),(5,'TUPI-3369','Puerto Iguazú','2022-01-02','Tucumán',5400,'Economy','2022-01-16'),(6,'TUPI-3369','Puerto Iguazú','2022-02-12','Tucumán',12530,'Business','2022-02-23'),(7,'BOCA-4213','Cartagena','2022-01-23','Bogotá',8000,'Economy','2022-02-05'),(8,'CAME-0321','Medellín','2022-01-23','Cartagena',7800,'Economy','2022-01-31'),(9,'BOBA-6567','Buenos Aires','2022-02-15','Bogotá',57000,'Business','2022-02-28'),(10,'BOBA-6567','Buenos Aires','2022-03-01','Bogotá',39860,'Economy','2022-03-14'),(11,'BOME-4442','Medellín','2022-02-10','Bogotá',11000,'Economy','2022-02-24'),(12,'MEPI-9986','Puerto Iguazú','2022-04-17','Medellín',1640,'Business','2022-05-02');
/*!40000 ALTER TABLE `flight` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flight_reservation`
--

DROP TABLE IF EXISTS `flight_reservation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `flight_reservation` (
  `id_flight_reservation` int NOT NULL AUTO_INCREMENT,
  `date_from` date DEFAULT NULL,
  `date_to` date DEFAULT NULL,
  `destination` varchar(255) DEFAULT NULL,
  `flight_number` varchar(255) DEFAULT NULL,
  `origin` varchar(255) DEFAULT NULL,
  `seat_type` varchar(255) DEFAULT NULL,
  `seats` int DEFAULT NULL,
  `payment_method_id` int DEFAULT NULL,
  PRIMARY KEY (`id_flight_reservation`),
  KEY `FK86ojqln7d9b4h890xeo40ra5` (`payment_method_id`),
  CONSTRAINT `FK86ojqln7d9b4h890xeo40ra5` FOREIGN KEY (`payment_method_id`) REFERENCES `payment_method` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flight_reservation`
--

LOCK TABLES `flight_reservation` WRITE;
/*!40000 ALTER TABLE `flight_reservation` DISABLE KEYS */;
/*!40000 ALTER TABLE `flight_reservation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flight_reservation_people`
--

DROP TABLE IF EXISTS `flight_reservation_people`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `flight_reservation_people` (
  `flight_reservation_model_id_flight_reservation` int NOT NULL,
  `people_id` int NOT NULL,
  UNIQUE KEY `UK_n7p3fcppm17i80tk2aoa32uwq` (`people_id`),
  KEY `FK6sgox8mxymf0hsp8rpjmxhfhx` (`flight_reservation_model_id_flight_reservation`),
  CONSTRAINT `FK6sgox8mxymf0hsp8rpjmxhfhx` FOREIGN KEY (`flight_reservation_model_id_flight_reservation`) REFERENCES `flight_reservation` (`id_flight_reservation`),
  CONSTRAINT `FKoik187df0nn78yhs43xreo0l` FOREIGN KEY (`people_id`) REFERENCES `people_model` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flight_reservation_people`
--

LOCK TABLES `flight_reservation_people` WRITE;
/*!40000 ALTER TABLE `flight_reservation_people` DISABLE KEYS */;
/*!40000 ALTER TABLE `flight_reservation_people` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hotel`
--

DROP TABLE IF EXISTS `hotel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hotel` (
  `id` int NOT NULL AUTO_INCREMENT,
  `booking` bit(1) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `date_from` date DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `place` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `date_to` date DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hotel`
--

LOCK TABLES `hotel` WRITE;
/*!40000 ALTER TABLE `hotel` DISABLE KEYS */;
INSERT INTO `hotel` VALUES (1,_binary '\0','CH-0002','2022-02-10','Cataratas Hotel','Puerto Iguazú',6300,'2022-03-20','Doble'),(2,_binary '\0','CH-0003','2022-02-10','Cataratas Hotel 2','Puerto Iguazú',8200,'2022-03-23','Triple'),(3,_binary '\0','HB-0001','2022-02-10','Hotel Bristol','Buenos Aires',5435,'2022-03-19','Single'),(4,_binary '\0','BH-0002','2022-02-12','Hotel Bristol 2','Buenos Aires',7200,'2022-04-17','Doble'),(5,_binary '\0','SH-0002','2022-04-17','Sheraton','Tucumán',5790,'2022-05-23','Doble'),(6,_binary '\0','SH-0001','2022-01-02','Sheraton 2','Tucumán',4150,'2022-02-19','Single'),(7,_binary '\0','SE-0001','2022-01-23','Selina','Bogotá',3900,'2022-11-23','Single'),(8,_binary '\0','SE-0002','2022-01-23','Selina 2','Bogotá',5840,'2022-10-15','Doble'),(9,_binary '\0','EC-0003','2022-02-15','El Campín','Bogotá',7020,'2022-03-27','Triple'),(10,_binary '\0','CP-0004','2022-03-01','Central Plaza','Medellín',8600,'2022-04-17','Múltiple'),(11,_binary '\0','CP-0002','2022-02-10','Central Plaza 2','Medellín',6400,'2022-03-20','Doble'),(12,_binary '\0','BG-0004','2022-04-17','Bocagrande','Cartagena',9370,'2022-06-22','Múltiple');
/*!40000 ALTER TABLE `hotel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment_method`
--

DROP TABLE IF EXISTS `payment_method`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payment_method` (
  `id` int NOT NULL AUTO_INCREMENT,
  `dues` int DEFAULT NULL,
  `number` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment_method`
--

LOCK TABLES `payment_method` WRITE;
/*!40000 ALTER TABLE `payment_method` DISABLE KEYS */;
/*!40000 ALTER TABLE `payment_method` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `people_model`
--

DROP TABLE IF EXISTS `people_model`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `people_model` (
  `id` int NOT NULL AUTO_INCREMENT,
  `birthday` varchar(255) DEFAULT NULL,
  `dni` int DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `mail` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `people_model`
--

LOCK TABLES `people_model` WRITE;
/*!40000 ALTER TABLE `people_model` DISABLE KEYS */;
/*!40000 ALTER TABLE `people_model` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-04-04 18:51:47
