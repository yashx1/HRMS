--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `hermes`.`employee` (
  `empId` varchar(10) NOT NULL DEFAULT '',
  `fname` varchar(50) DEFAULT NULL,
  `lname` varchar(50) DEFAULT NULL,
  `skills` varchar(100) DEFAULT NULL,
  `createdOn` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`empId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table `team`
--

DROP TABLE IF EXISTS `team`;

CREATE TABLE `hermes`.`team` (
  `teamId` varchar(10) NOT NULL DEFAULT '',
  `teamName` varchar(50) DEFAULT NULL,
  `teamDescription` varchar(200) DEFAULT NULL,
  `createdOn` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`teamId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


--
-- Table structure for table `team_employee_mapper`
--

DROP TABLE IF EXISTS `hermes`.`team_employee_mapper`;

CREATE TABLE `team_employee_mapper` (
  `mapperId` varchar(10) NOT NULL,
  `teamRefId` varchar(10) NOT NULL,
  `empRefId` varchar(10) NOT NULL,
  `isLeader` tinyint(1) DEFAULT '0',
  `isAssigned` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`mapperId`),
  KEY `empRefId` (`empRefId`),
  KEY `teamRefId` (`teamRefId`),
  CONSTRAINT `team_employee_mapper_ibfk_1` FOREIGN KEY (`empRefId`) REFERENCES `employee` (`empId`),
  CONSTRAINT `team_employee_mapper_ibfk_2` FOREIGN KEY (`teamRefId`) REFERENCES `team` (`teamId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
