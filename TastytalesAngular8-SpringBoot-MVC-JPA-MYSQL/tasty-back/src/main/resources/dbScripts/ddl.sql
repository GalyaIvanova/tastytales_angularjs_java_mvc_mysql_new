CREATE DATABASE IF NOT EXISTS corp_tastytales_db1;
USE corp_tastytales_db1;

DROP TABLE IF EXISTS `corp_tastytales_db1`.`user`;
CREATE TABLE `corp_tastytales_db1`.`user` (
  `username`  VARCHAR(45) NOT NULL,
  `password`  VARCHAR(45) NULL,
  `firstname` VARCHAR(45) NOT NULL,
  `lastname`  VARCHAR(45) NULL,
  `email`     VARCHAR(45) NULL,
  `address`   VARCHAR(45) NULL,
  `phone`     INT         NULL,
  PRIMARY KEY (`username`)
);

CREATE TABLE `corp_tastytales_db1`.`food` (
   `id` VARCHAR(45) NOT NULL,
   `item` VARCHAR(45) NOT NULL,
   `prince` INT NOT NULL,
   `quantity` INT NOT NULL,
   `url` VARCHAR(150) NOT NULL ,
   `formID` VARCHAR(50) NOT NULL ,
   `favoritesID` VARCHAR(50) NOT NULL ,
   PRIMARY KEY (`id`));

CREATE TABLE 'corp_tastytales_db1'.'favorites' (
  'quantity1' INT NOT NULL ,
  'quantity2' INT NOT NULL ,
  'quantity3' INT NOT NULL ,
  PRIMARY KEY ('quantity1')
);
