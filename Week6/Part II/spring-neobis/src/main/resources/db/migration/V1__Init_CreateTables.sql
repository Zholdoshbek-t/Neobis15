CREATE TABLE `warehouse` (
  `warehouse_id` bigint NOT NULL AUTO_INCREMENT,
  `address` varchar(255) NOT NULL,
  `city` varchar(255) NOT NULL,
  `country` varchar(255) NOT NULL,
  PRIMARY KEY (`warehouse_id`),
  UNIQUE KEY `UK3md6ctc331a341lt6vyx4x0ru` (`address`)
);

CREATE TABLE `product` (
  `product_id` bigint NOT NULL AUTO_INCREMENT,
  `amount` int NOT NULL,
  `name` varchar(255) NOT NULL,
  `price` int NOT NULL,
  `warehouse_id` bigint DEFAULT NULL,
  PRIMARY KEY (`product_id`),
  KEY `FKk6edvfdkq61mjhltx856ncs3x` (`warehouse_id`),
  CONSTRAINT `FKk6edvfdkq61mjhltx856ncs3x` FOREIGN KEY (`warehouse_id`) REFERENCES `warehouse` (`warehouse_id`)
);

CREATE TABLE `order` (
  `order_id` bigint NOT NULL AUTO_INCREMENT,
  `address` varchar(255) NOT NULL,
  `amount` int NOT NULL,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `order_date` date DEFAULT NULL,
  `price` double NOT NULL,
  `product_id` bigint NOT NULL,
  PRIMARY KEY (`order_id`),
  KEY `FKknjaoi59nxmpxhr452bj95tgg` (`product_id`),
  CONSTRAINT `FKknjaoi59nxmpxhr452bj95tgg` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`)
);
