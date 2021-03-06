-- MySQL Script generated by MySQL Workbench
-- 01/26/15 22:01:58
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema equipment_db
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `equipment_db` ;

-- -----------------------------------------------------
-- Schema equipment_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `equipment_db` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `equipment_db` ;

-- -----------------------------------------------------
-- Table `equipment_db`.`system_users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `equipment_db`.`system_users` ;

CREATE TABLE IF NOT EXISTS `equipment_db`.`system_users` (
  `pkey` INT NOT NULL AUTO_INCREMENT,
  `userid` VARCHAR(45) NOT NULL,
  `password` VARCHAR(80) NOT NULL,
  `first_name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `last_login` VARCHAR(45) NULL,
  `system_userscol` DATETIME NULL,
  PRIMARY KEY (`pkey`),
  UNIQUE INDEX `pkey_UNIQUE` (`pkey` ASC),
  UNIQUE INDEX `table1col_UNIQUE` (`userid` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `equipment_db`.`equipment_type`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `equipment_db`.`equipment_type` ;

CREATE TABLE IF NOT EXISTS `equipment_db`.`equipment_type` (
  `pkey` INT NOT NULL AUTO_INCREMENT,
  `equipment_id` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(45) NOT NULL,
  `rank` INT NULL,
  `replacement_cost` INT NULL,
  PRIMARY KEY (`pkey`),
  UNIQUE INDEX `pkey_UNIQUE` (`pkey` ASC),
  UNIQUE INDEX `equipment_id_UNIQUE` (`equipment_id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `equipment_db`.`criteria_ranking`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `equipment_db`.`criteria_ranking` ;

CREATE TABLE IF NOT EXISTS `equipment_db`.`criteria_ranking` (
  `pkey` INT NOT NULL AUTO_INCREMENT,
  `rank` ENUM('HIGHEST', 'HIGH', 'LOW', 'LOWEST') NULL,
  `criteria` ENUM('AGE', 'CRITICALITY', 'QUANTITY', 'SERVICABLE') NULL,
  PRIMARY KEY (`pkey`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `equipment_db`.`minimum_equipment_required`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `equipment_db`.`minimum_equipment_required` ;

CREATE TABLE IF NOT EXISTS `equipment_db`.`minimum_equipment_required` (
  `pkey` INT NOT NULL AUTO_INCREMENT,
  `equipment_type_fk` INT NOT NULL,
  `hs_total` INT NULL,
  `ms_total` INT NULL,
  `es_total` INT NULL,
  PRIMARY KEY (`pkey`),
  INDEX `equipment_type_fk_idx` (`equipment_type_fk` ASC),
  CONSTRAINT `equipment_type_fk`
    FOREIGN KEY (`equipment_type_fk`)
    REFERENCES `equipment_db`.`equipment_type` (`pkey`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `equipment_db`.`manufacturer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `equipment_db`.`manufacturer` ;

CREATE TABLE IF NOT EXISTS `equipment_db`.`manufacturer` (
  `pkey` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`pkey`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `equipment_db`.`equipment_information`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `equipment_db`.`equipment_information` ;

CREATE TABLE IF NOT EXISTS `equipment_db`.`equipment_information` (
  `pkey` INT NOT NULL AUTO_INCREMENT,
  `barcode` VARCHAR(45) NULL,
  `equipment_type_fk` INT NOT NULL,
  `room` VARCHAR(45) NULL,
  `serial_number` VARCHAR(45) NULL,
  `manufacturer_fk` INT NOT NULL,
  `model_number` VARCHAR(45) NULL,
  `begin_service_date` DATETIME NULL,
  `cost` INT NULL,
  `age` INT NULL,
  PRIMARY KEY (`pkey`),
  INDEX `equipment_type_fk_idx` (`equipment_type_fk` ASC),
  INDEX `manufacturer_fk_idx` (`manufacturer_fk` ASC),
  CONSTRAINT `type_fkey`
    FOREIGN KEY (`equipment_type_fk`)
    REFERENCES `equipment_db`.`equipment_type` (`pkey`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `manufacturer_fk`
    FOREIGN KEY (`manufacturer_fk`)
    REFERENCES `equipment_db`.`manufacturer` (`pkey`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE = '';
GRANT USAGE ON *.* TO testuser;
 DROP USER testuser;
SET SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';
CREATE USER 'testuser' IDENTIFIED BY 'password1';

GRANT ALL ON `equipment_db`.* TO 'testuser';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
