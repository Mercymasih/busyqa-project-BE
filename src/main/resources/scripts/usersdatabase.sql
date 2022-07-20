-- MySQL Workbench Forward Engineering

DROP TABLE IF EXISTS auth_user_role;
DROP TABLE IF EXISTS auth_role;
DROP TABLE IF EXISTS auth_user;

-- -----------------------------------------------------
-- Schema usersdatabase
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema usersdatabase
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `usersdatabase` DEFAULT CHARACTER SET utf8 ;
USE `usersdatabase` ;

-- -----------------------------------------------------
-- Table `usersdatabase`.`ROLE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `usersdatabase`.`ROLE` (
  `ID_ROLE` INT NOT NULL AUTO_INCREMENT,
  `NAME_ROLE` VARCHAR(20) NOT NULL,
  `DESC_ROLE` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID_ROLE`)
  );
  
INSERT INTO ROLE
VALUES(1,'ADMIN','ADMIN');
INSERT INTO ROLE
VALUES(2,'MANAGER','MANAGER');
INSERT INTO ROLE
VALUES(3,'SIMPLE_USER','SIMPLE_USER');


-- -----------------------------------------------------
-- Table `usersdatabase`.`USER`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `usersdatabase`.`USER` (
  `ID_USER` INT NOT NULL AUTO_INCREMENT,
  `FIRST_NAME` VARCHAR(45) NOT NULL,
  `LAST_NAME` VARCHAR(45) NOT NULL,
  `USERNAME` VARCHAR(45) NOT NULL,
  `PASSWORD` VARCHAR(45) NOT NULL,
  `EMAIL` VARCHAR(45) NOT NULL,
  `PHONE` VARCHAR(45) NOT NULL,
  `STATUS` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID_USER`)
  );
  


-- -----------------------------------------------------
-- Table `usersdatabase`.`USER_ROLE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `usersdatabase`.`USER_ROLE` (
  `ID_USER` INT NOT NULL,
  `ID_ROLE` INT NOT NULL,
  PRIMARY KEY (ID_USER,ID_ROLE),
  KEY FK_USR_ROLE(ID_ROLE),
  CONSTRAINT FK_USER FOREIGN KEY (ID_USER) REFERENCES USER (ID_USER),
  CONSTRAINT FK_USER_ROLE FOREIGN KEY (ID_ROLE) REFERENCES ROLE (ID_ROLE)
  );
  
INSERT INTO USER(ID_USER,FIRST_NAME,LAST_NAME,USERNAME,PASSWORD,EMAIL,PHONE,STATUS)
VALUES(1,'ROGER','WALKER','RWALKER','RW456ER','RWALKER@GMAIL.COM','5678764532','VERIFIED');
INSERT INTO USER_ROLE(ID_USER,ID_ROLE)
VALUES('1','1');



