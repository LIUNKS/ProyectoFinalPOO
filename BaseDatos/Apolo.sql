CREATE DATABASE  IF NOT EXISTS `Apolo` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `Apolo`;
-- MySQL dump 10.13  Distrib 8.0.40, for Win64 (x86_64)
--
-- Host: localhost    Database: Apolo
-- ------------------------------------------------------
-- Server version	8.0.40

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
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categoria` (
  `CategoriaID` varchar(50) NOT NULL,
  PRIMARY KEY (`CategoriaID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `ClienteID` int unsigned NOT NULL AUTO_INCREMENT,
  `Nombres` varchar(50) DEFAULT NULL,
  `Edad` int unsigned DEFAULT NULL,
  `Telefono` varchar(9) DEFAULT NULL,
  `Direccion` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ClienteID`),
  CONSTRAINT `cliente_chk_1` CHECK ((`Edad` < 125))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalleventa`
--

DROP TABLE IF EXISTS `detalleventa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detalleventa` (
  `VentaID` int unsigned NOT NULL,
  `ProductoID` int unsigned NOT NULL,
  `Cantidad` int unsigned NOT NULL,
  `MontoTotal` decimal(20,3) NOT NULL,
  KEY `fk_VentaID` (`VentaID`),
  KEY `fk_ProductoID` (`ProductoID`),
  CONSTRAINT `fk_ProductoID` FOREIGN KEY (`ProductoID`) REFERENCES `producto` (`ProductoID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_VentaID` FOREIGN KEY (`VentaID`) REFERENCES `venta` (`VentaID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `detalleventa_chk_1` CHECK ((`MontoTotal` >= 0))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalleventa`
--

LOCK TABLES `detalleventa` WRITE;
/*!40000 ALTER TABLE `detalleventa` DISABLE KEYS */;
/*!40000 ALTER TABLE `detalleventa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movimientostock`
--

DROP TABLE IF EXISTS `movimientostock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movimientostock` (
  `MovimientoStockID` int unsigned NOT NULL AUTO_INCREMENT,
  `FechaStock` datetime NOT NULL,
  `TipoMovimento` enum('Entrada','Salida') DEFAULT NULL,
  `Cantidad` int unsigned NOT NULL,
  PRIMARY KEY (`MovimientoStockID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movimientostock`
--

LOCK TABLES `movimientostock` WRITE;
/*!40000 ALTER TABLE `movimientostock` DISABLE KEYS */;
/*!40000 ALTER TABLE `movimientostock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movimientostockxproveedor`
--

DROP TABLE IF EXISTS `movimientostockxproveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movimientostockxproveedor` (
  `MovimientoStockID` int unsigned NOT NULL,
  `ProveedorID` int unsigned NOT NULL,
  KEY `fk1_movimientostockxproveedor` (`MovimientoStockID`),
  KEY `fk2_movimientostockxproveedor` (`ProveedorID`),
  CONSTRAINT `fk1_movimientostockxproveedor` FOREIGN KEY (`MovimientoStockID`) REFERENCES `movimientostock` (`MovimientoStockID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk2_movimientostockxproveedor` FOREIGN KEY (`ProveedorID`) REFERENCES `proveedor` (`ProveedorID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movimientostockxproveedor`
--

LOCK TABLES `movimientostockxproveedor` WRITE;
/*!40000 ALTER TABLE `movimientostockxproveedor` DISABLE KEYS */;
/*!40000 ALTER TABLE `movimientostockxproveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `producto` (
  `ProductoID` int unsigned NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(50) NOT NULL,
  `Precio` decimal(20,3) NOT NULL,
  `Descripcion` varchar(100) DEFAULT NULL,
  `Stock` int unsigned NOT NULL,
  `CodigoBarras` int unsigned NOT NULL,
  `MovimientoStockID` int unsigned NOT NULL,
  `UbicacionAlmacen` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ProductoID`),
  KEY `fk_MovimientoStockID` (`MovimientoStockID`),
  CONSTRAINT `fk_MovimientoStockID` FOREIGN KEY (`MovimientoStockID`) REFERENCES `movimientostock` (`MovimientoStockID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `producto_chk_1` CHECK ((`Precio` >= 0))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productoxcategoria`
--

DROP TABLE IF EXISTS `productoxcategoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productoxcategoria` (
  `ProductoID` int unsigned NOT NULL,
  `CategoriaID` varchar(50) NOT NULL,
  KEY `fk1_ProductoXCategoria` (`ProductoID`),
  KEY `fk2_ProductoXCategoria` (`CategoriaID`),
  CONSTRAINT `fk1_ProductoXCategoria` FOREIGN KEY (`ProductoID`) REFERENCES `producto` (`ProductoID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk2_ProductoXCategoria` FOREIGN KEY (`CategoriaID`) REFERENCES `categoria` (`CategoriaID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productoxcategoria`
--

LOCK TABLES `productoxcategoria` WRITE;
/*!40000 ALTER TABLE `productoxcategoria` DISABLE KEYS */;
/*!40000 ALTER TABLE `productoxcategoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedor`
--

DROP TABLE IF EXISTS `proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proveedor` (
  `ProveedorID` int unsigned NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(50) NOT NULL,
  `Direccion` varchar(50) NOT NULL,
  `Telefono` varchar(9) NOT NULL,
  `Correo` varchar(50) NOT NULL,
  PRIMARY KEY (`ProveedorID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedor`
--

LOCK TABLES `proveedor` WRITE;
/*!40000 ALTER TABLE `proveedor` DISABLE KEYS */;
/*!40000 ALTER TABLE `proveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vendedor`
--

DROP TABLE IF EXISTS `vendedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vendedor` (
  `VendedorID` int unsigned NOT NULL AUTO_INCREMENT,
  `Nombres` varchar(50) DEFAULT NULL,
  `Usuario` varchar(50) DEFAULT NULL,
  `Contrasena` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`VendedorID`),
  UNIQUE KEY `Usuario` (`Usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vendedor`
--

LOCK TABLES `vendedor` WRITE;
/*!40000 ALTER TABLE `vendedor` DISABLE KEYS */;
/*!40000 ALTER TABLE `vendedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venta`
--

DROP TABLE IF EXISTS `venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `venta` (
  `VentaID` int unsigned NOT NULL AUTO_INCREMENT,
  `VendedorID` int unsigned NOT NULL,
  `ClienteID` int unsigned NOT NULL,
  `FechaVenta` datetime NOT NULL,
  `MontoTotal` decimal(20,3) NOT NULL,
  PRIMARY KEY (`VentaID`),
  KEY `fk_VendedorID` (`VendedorID`),
  KEY `fk_ClienteID` (`ClienteID`),
  CONSTRAINT `fk_ClienteID` FOREIGN KEY (`ClienteID`) REFERENCES `cliente` (`ClienteID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_VendedorID` FOREIGN KEY (`VendedorID`) REFERENCES `vendedor` (`VendedorID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `venta_chk_1` CHECK ((`MontoTotal` >= 0))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venta`
--

LOCK TABLES `venta` WRITE;
/*!40000 ALTER TABLE `venta` DISABLE KEYS */;
/*!40000 ALTER TABLE `venta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'Apolo'
--

--
-- Dumping routines for database 'Apolo'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-10-17 13:20:04
