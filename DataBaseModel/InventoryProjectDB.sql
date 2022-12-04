-- MySQL Script generated by MySQL Workbench
-- Mon Nov 28 04:21:17 2022
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema inventoryproject
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema inventoryproject
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `inventoryproject` DEFAULT CHARACTER SET utf8 ;
USE `inventoryproject` ;

-- -----------------------------------------------------
-- Table `inventoryproject`.`Clients`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `inventoryproject`.`Clients` (
  `NitC` INT NOT NULL,
  `CompanyNameC` VARCHAR(45) NOT NULL,
  `EmailC` VARCHAR(45) NOT NULL,
  `PhoneNumberC` BIGINT NOT NULL,
  `CityC` VARCHAR(45) NOT NULL,
  `AdressC` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`NitC`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `inventoryproject`.`Products`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `inventoryproject`.`Products` (
  `IdP` INT NOT NULL,
  `NameP` VARCHAR(45) NOT NULL,
  `WheightP` DOUBLE NOT NULL,
  `StockP` INT NOT NULL,
  `DatePurchaseP` DATE NOT NULL,
  `ExpirationDateP` DATE NOT NULL,
  `PriceP` DOUBLE NOT NULL,
  PRIMARY KEY (`IdP`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `inventoryproject`.`UClients`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `inventoryproject`.`UClients` (
  `IdUC` INT NOT NULL,
  `NameUC` VARCHAR(45) NOT NULL,
  `UserNameUC` VARCHAR(45) NOT NULL,
  `PasswordUC` VARCHAR(45) NOT NULL,
  `PhoneNumberUC` BIGINT NOT NULL,
  `EmailUC` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`IdUC`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `inventoryproject`.`Suppliers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `inventoryproject`.`Suppliers` (
  `NitS` INT NOT NULL,
  `CompanyNameS` VARCHAR(45) NOT NULL,
  `EmailS` VARCHAR(45) NOT NULL,
  `PhoneNumberS` BIGINT NOT NULL,
  `CityS` VARCHAR(45) NOT NULL,
  `AdressS` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`NitS`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `inventoryproject`.`UAdmin`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `inventoryproject`.`UAdmin` (
  `IdA` INT NOT NULL,
  `NameA` VARCHAR(45) NOT NULL,
  `UserNameA` VARCHAR(45) NOT NULL,
  `PasswordA` VARCHAR(45) NOT NULL,
  `PhoneNumberA` BIGINT NOT NULL,
  `EmailA` VARCHAR(45) NOT NULL,
  `PositionA` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`IdA`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `inventoryproject`.`PurchaseOrder`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `inventoryproject`.`PurchaseOrder` (
  `CodePO` INT NOT NULL AUTO_INCREMENT,
  `CompanyNameCPO` VARCHAR(45) NOT NULL,
  `NameAPO` VARCHAR(45) NOT NULL,
  `TotalNPO` DOUBLE NOT NULL,
  PRIMARY KEY (`CodePO`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `inventoryproject`.`NewOrder`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `inventoryproject`.`NewOrder` (
  `IdPN` INT NOT NULL,
  `NamePN` VARCHAR(45) NOT NULL,
  `QuantityN` DOUBLE NOT NULL,
  `PricePN` DOUBLE NOT NULL,
  `TotalN` DOUBLE NOT NULL)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
