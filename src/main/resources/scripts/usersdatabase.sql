-- MySQL Workbench Forward Engineering



DROP TABLE IF EXISTS user;

-- -----------------------------------------------------
-- Schema usersdatabase
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema usersdatabase
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `usersdatabase` DEFAULT CHARACTER SET utf8 ;
USE `usersdatabase` ;



-- -----------------------------------------------------
-- Table `usersdatabase`.`USER`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `usersdatabase`.`USER` (
  `ID_USER` INT NOT NULL AUTO_INCREMENT,
  `FIRST_NAME` VARCHAR(45) NOT NULL,
  `LAST_NAME` VARCHAR(45) NOT NULL,
  `USERNAME` VARCHAR(45) NOT NULL UNIQUE,
  `PASSWORD` VARCHAR(200) NOT NULL,
  `EMAIL` VARCHAR(45) NOT NULL,
  `PHONE` VARCHAR(45) NOT NULL,
  `ROLE` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID_USER`)
  );
  


-- -----------------------------------------------------
-- Table `usersdatabase`
-- -----------------------------------------------------

  
INSERT INTO USER(ID_USER,FIRST_NAME,LAST_NAME,USERNAME,PASSWORD,EMAIL,PHONE,ROLE)
VALUES(1,'ROGER','WALKER','RWALKER','RW456ER','RWALKER@GMAIL.COM','5678764532','ADMIN');




