CREATE TABLE `public`.`user` (
  `userId` INT NOT NULL,
  `firstName` VARCHAR(45) NOT NULL,
  `lastName` VARCHAR(45) NOT NULL,
  `birthDate` DATETIME NOT NULL,
  `emailAddress` VARCHAR(45) NULL,
  `lastUpdateDate` DATETIME NOT NULL,
  `lastUpdatedBy` VARCHAR(50) NULL,
  `createdDate` DATETIME NOT NULL,
  `createdBy` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`userId`),
  UNIQUE INDEX `idUser_UNIQUE` (`userId` ASC) VISIBLE);

ALTER TABLE `public`.`user`
  CHANGE COLUMN `userId` `userId` INT(11) NOT NULL AUTO_INCREMENT ;

CREATE TABLE `public`.`finances_key` (
  `TABLE_NAME` INT NOT NULL,
  `VALUE` INT NULL,
  PRIMARY KEY (`TABLE_NAME`),
  UNIQUE INDEX `VALUE_UNIQUE` (`VALUE` ASC) VISIBLE)
  COMMENT = 'Stores the ids of primary keys ';

ALTER TABLE `public`.`finances_keys`
  CHANGE COLUMN `TABLE_NAME` `TABLE_NAME` VARCHAR(15) NOT NULL ,
  CHANGE COLUMN `VALUE` `VALUE` INT(11) NOT NULL ,
  ADD UNIQUE INDEX `TABLE_NAME_UNIQUE` (`TABLE_NAME` ASC) VISIBLE,
  DROP INDEX `VALUE_UNIQUE` ;
;

CREATE TABLE `public`.`time_test` (
  `timeTestId` INT NOT NULL,
  `dateTime` DATETIME NULL,
  `timeStamp` TIMESTAMP NULL,
  `date` DATE NULL,
  `time` TIME NULL,
  `sqlDateTime` DATETIME NULL,
  `sqlDate` DATE NULL,
  `sqlTime` TIME NULL,
  PRIMARY KEY (`timeTestId`),
  UNIQUE INDEX `timeTestId_UNIQUE` (`timeTestId` ASC) VISIBLE);

ALTER TABLE `public`.`time_test`
  CHANGE COLUMN `timeTestId` `timeTestId` INT(11) NOT NULL AUTO_INCREMENT;
ALTER TABLE `public`.`time_test`
  ADD COLUMN `sqlTimeStamp` TIMESTAMP NULL AFTER `sqlDateTime`;

DROP TABLE IF EXISTS `bank`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bank` (
  `BANK_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(100) NOT NULL,
  `ADDRESS_LINE_1` varchar(100) NOT NULL,
  `ADDRESS_LINE_2` varchar(100) NOT NULL,
  `CITY` varchar(100) NOT NULL,
  `STATE` varchar(2) NOT NULL,
  `ZIP_CODE` varchar(5) NOT NULL,
  `IS_INTERNATIONAL` tinyint(1) NOT NULL,
  `LAST_UPDATED_BY` varchar(45) NOT NULL,
  `LAST_UPDATED_DATE` datetime NOT NULL,
  `CREATED_BY` varchar(45) NOT NULL,
  `CREATED_DATE` datetime NOT NULL,
  `ADDRESS_TYPE` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`BANK_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

CREATE TABLE `bank_contact` (
  `BANK_ID` bigint(20) NOT NULL,
  `NAME` varchar(100) NOT NULL,
  `POSITION_TYPE` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`BANK_ID`,`NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
