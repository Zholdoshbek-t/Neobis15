DROP DATABASE IF EXISTS shop_pojo;
CREATE DATABASE shop_pojo;
USE shop_pojo;
CREATE TABLE cake
(
	idcake INT NOT NULL,
    `name` VARCHAR(100) NOT NULL,
    size VARCHAR(20) NOT NULL
);

CREATE TABLE car
(
	idcar INT NOT NULL,
    brand VARCHAR(100) NOT NULL,
    model VARCHAR(100) NOT NULL,
    `year` VARCHAR(4) NOT NULL,
    color VARCHAR(100) NOT NULL
);

CREATE TABLE donut
(
	iddonut INT NOT NULL,
    coating VARCHAR(100) NOT NULL,
    topping VARCHAR(100) NOT NULL,
    drizzle VARCHAR(100) NOT NULL
);

CREATE TABLE laptop
(
	idlaptop INT NOT NULL,
    brand VARCHAR(20) NOT NULL,
    model VARCHAR(30) NOT NULL,
    size FLOAT NOT NULL,
    `cpu` VARCHAR(40) NOT NULL,
    storageDrive VARCHAR(30) NOT NULL
);

CREATE TABLE phone
(
	idphone INT NOT NULL,
    brand VARCHAR(20) NOT NULL,
    model VARCHAR(30) NOT NULL,
    phoneMemory SMALLINT NOT NULL
);