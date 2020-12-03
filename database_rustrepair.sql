-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 01, 2020 at 03:07 PM
-- Server version: 10.4.16-MariaDB
-- PHP Version: 7.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `database_rustrepair`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `Cus_ID` int(11) NOT NULL,
  `Name` varchar(30) DEFAULT NULL,
  `NIC` char(12) DEFAULT NULL,
  `EMail` varchar(30) DEFAULT NULL,
  `Address` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`Cus_ID`, `Name`, `NIC`, `EMail`, `Address`) VALUES
(12, 'Cus1', '123123', 'hometv04x@gmail.com', 'sdfsdfsdfsdfsdf'),
(12122, 'Cus4', '12312312312V', 'hometv04x@gmail.com', 'ertertertertert'),
(12123, 'Cus1', '12312312312V', 'hometv04x@gmail.com', 'ertertertertert'),
(12124, 'Cus1', '1231231231vv', 'hometv04x@gmail.com', 'ertertertertert'),
(12126, 'Cus1', '12312312312V', 'hometv04x@gmail.com', 'ertertertertert'),
(12128, 'Cus1', '12312312312V', 'hometv04x@gmail.com', 'ertertertertert');

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `EmployeeID` char(5) NOT NULL,
  `EName` varchar(30) DEFAULT NULL,
  `Address` varchar(40) DEFAULT NULL,
  `PayRate` float DEFAULT NULL,
  `EMail` varchar(30) DEFAULT NULL,
  `DOB` date DEFAULT NULL,
  `Password` char(8) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`EmployeeID`, `EName`, `Address`, `PayRate`, `EMail`, `DOB`, `Password`) VALUES
('ME012', 'asdasdas', 'asdasd', 234, 'asdasd', '2020-11-04', '12345678'),
('ME123', 'kasdjfk', 'dgsdfgk', 234, 'dfgsdfg@gmail.com', '2020-11-08', '12312312'),
('MG123', 'ghdfgdf', 'dfgsdfg', 234, 'dgdfgsdf@gmail.com', '2020-11-10', '12312312'),
('RE123', 'danna', 'dfoasdfspuf.sdif', 1233, 'gfrdgdfg@gmail.com', '2020-11-09', '12312312');

-- --------------------------------------------------------

--
-- Table structure for table `job`
--

CREATE TABLE `job` (
  `JobID` int(11) NOT NULL,
  `StartDate` date DEFAULT NULL,
  `DueDate` date DEFAULT NULL,
  `JobType` varchar(36) DEFAULT NULL,
  `Details` varchar(100) DEFAULT NULL,
  `MechanicID` int(11) DEFAULT NULL,
  `vehicleNo` varchar(12) DEFAULT NULL,
  `ServiceCharger` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `job`
--

INSERT INTO `job` (`JobID`, `StartDate`, `DueDate`, `JobType`, `Details`, `MechanicID`, `vehicleNo`, `ServiceCharger`) VALUES
(12, '2020-11-05', '2020-11-12', 'Restoration Job', 'werwer', 12, '18', 30000),
(14, '2020-11-05', '2020-11-12', 'Restoration Job', 'werwer', 12, '16', 30000),
(16, '2020-11-08', '2020-11-12', 'Repir Job', 'werwer', 12, '16', 10000),
(18, '2020-11-05', '2020-11-06', 'Repir Job', 'wetwer', 12, '16', 10000);

-- --------------------------------------------------------

--
-- Table structure for table `managers`
--

CREATE TABLE `managers` (
  `EmployeeID` char(5) DEFAULT NULL,
  `MgrID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `managers`
--

INSERT INTO `managers` (`EmployeeID`, `MgrID`) VALUES
('ME012', 321);

-- --------------------------------------------------------

--
-- Table structure for table `mechanic`
--

CREATE TABLE `mechanic` (
  `EmployeeID` char(5) DEFAULT NULL,
  `MechanicID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `mechanic`
--

INSERT INTO `mechanic` (`EmployeeID`, `MechanicID`) VALUES
('ME012', 12);

-- --------------------------------------------------------

--
-- Table structure for table `parts`
--

CREATE TABLE `parts` (
  `PartsID` int(11) NOT NULL,
  `PName` varchar(30) DEFAULT NULL,
  `Quantity` int(11) DEFAULT NULL,
  `SupplierID` int(11) NOT NULL,
  `Price` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `parts`
--

INSERT INTO `parts` (`PartsID`, `PName`, `Quantity`, `SupplierID`, `Price`) VALUES
(122, 'Hood', 120, 1, 1200),
(123, 'Headmpa', 70, 4, 1200),
(124, 'Wheel', 40, 2, 1200),
(126, 'Mirrors', 100, 4, 1200),
(128, 'Covers', 60, 8, 1200);

-- --------------------------------------------------------

--
-- Table structure for table `receptionist`
--

CREATE TABLE `receptionist` (
  `EmployeeID` char(5) DEFAULT NULL,
  `ReceptionistID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE `supplier` (
  `SupplierID` int(11) NOT NULL,
  `SName` varchar(30) DEFAULT NULL,
  `Address` varchar(40) DEFAULT NULL,
  `Email` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `supplier`
--

INSERT INTO `supplier` (`SupplierID`, `SName`, `Address`, `Email`) VALUES
(1, 'dfsdfas', 'ertertertertert', 'yeyona7071@btsese.com'),
(2, 'dfsdfsd', 'sdfsdf', 'yeyona7071@btsese.com'),
(4, 'dfsdfsd', 'sdfsdf', 'yeyona7071@btsese.com'),
(8, 'dfsdfsd', 'sdfsdf', 'yeyona7071@btsese.com');

-- --------------------------------------------------------

--
-- Table structure for table `vehicle`
--

CREATE TABLE `vehicle` (
  `vehicleNo` varchar(12) NOT NULL,
  `ModelName` varchar(30) DEFAULT NULL,
  `Engine_Details` varchar(30) DEFAULT NULL,
  `Cus_ID` int(11) DEFAULT NULL,
  `ManufactureDate` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `vehicle`
--

INSERT INTO `vehicle` (`vehicleNo`, `ModelName`, `Engine_Details`, `Cus_ID`, `ManufactureDate`) VALUES
('16', '123123', '123', 12122, '2020-11-09'),
('18', '123123', '123', 12122, '2020-11-09'),
('20', '123123', '123', 12128, '2020-11-09'),
('22', '123123', '123', 12128, '2020-11-09');

-- --------------------------------------------------------

--
-- Table structure for table `worksin`
--

CREATE TABLE `worksin` (
  `MechanicID` int(11) NOT NULL,
  `JobID` int(11) NOT NULL,
  `Status` varchar(20) DEFAULT NULL,
  `Extraservice_charges` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `worksin`
--

INSERT INTO `worksin` (`MechanicID`, `JobID`, `Status`, `Extraservice_charges`) VALUES
(12, 12, 'Not Completed', 0),
(12, 14, 'Not Completed', 0),
(12, 16, 'Not Completed', 0),
(12, 18, 'Not Completed', 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`Cus_ID`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`EmployeeID`);

--
-- Indexes for table `job`
--
ALTER TABLE `job`
  ADD PRIMARY KEY (`JobID`),
  ADD KEY `GVFK` (`vehicleNo`),
  ADD KEY `JFK` (`MechanicID`);

--
-- Indexes for table `managers`
--
ALTER TABLE `managers`
  ADD PRIMARY KEY (`MgrID`),
  ADD KEY `MEFK` (`EmployeeID`);

--
-- Indexes for table `mechanic`
--
ALTER TABLE `mechanic`
  ADD PRIMARY KEY (`MechanicID`),
  ADD KEY `MCEFK` (`EmployeeID`);

--
-- Indexes for table `parts`
--
ALTER TABLE `parts`
  ADD PRIMARY KEY (`PartsID`,`SupplierID`),
  ADD KEY `PSFK` (`SupplierID`);

--
-- Indexes for table `receptionist`
--
ALTER TABLE `receptionist`
  ADD PRIMARY KEY (`ReceptionistID`),
  ADD KEY `REFK` (`EmployeeID`);

--
-- Indexes for table `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`SupplierID`);

--
-- Indexes for table `vehicle`
--
ALTER TABLE `vehicle`
  ADD PRIMARY KEY (`vehicleNo`),
  ADD KEY `VFK` (`Cus_ID`);

--
-- Indexes for table `worksin`
--
ALTER TABLE `worksin`
  ADD PRIMARY KEY (`JobID`,`MechanicID`),
  ADD KEY `WMFK` (`MechanicID`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `job`
--
ALTER TABLE `job`
  ADD CONSTRAINT `GVFK` FOREIGN KEY (`vehicleNo`) REFERENCES `vehicle` (`vehicleNo`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `JFK` FOREIGN KEY (`MechanicID`) REFERENCES `mechanic` (`MechanicID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `managers`
--
ALTER TABLE `managers`
  ADD CONSTRAINT `MEFK` FOREIGN KEY (`EmployeeID`) REFERENCES `employee` (`EmployeeID`);

--
-- Constraints for table `mechanic`
--
ALTER TABLE `mechanic`
  ADD CONSTRAINT `MCEFK` FOREIGN KEY (`EmployeeID`) REFERENCES `employee` (`EmployeeID`);

--
-- Constraints for table `parts`
--
ALTER TABLE `parts`
  ADD CONSTRAINT `PSFK` FOREIGN KEY (`SupplierID`) REFERENCES `supplier` (`SupplierID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `receptionist`
--
ALTER TABLE `receptionist`
  ADD CONSTRAINT `REFK` FOREIGN KEY (`EmployeeID`) REFERENCES `employee` (`EmployeeID`);

--
-- Constraints for table `vehicle`
--
ALTER TABLE `vehicle`
  ADD CONSTRAINT `VFK` FOREIGN KEY (`Cus_ID`) REFERENCES `customer` (`Cus_ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `worksin`
--
ALTER TABLE `worksin`
  ADD CONSTRAINT `WJFK` FOREIGN KEY (`JobID`) REFERENCES `job` (`JobID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `WMFK` FOREIGN KEY (`MechanicID`) REFERENCES `mechanic` (`MechanicID`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
