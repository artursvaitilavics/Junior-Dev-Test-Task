CREATE TABLE IF NOT EXISTS `product_item` (

    `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `sku` varchar(20),
    `name` varchar(20),
    `price` int,
    `size` varchar(24),
    `weight` varchar(24),
    `dimensions` varchar(48)


);


