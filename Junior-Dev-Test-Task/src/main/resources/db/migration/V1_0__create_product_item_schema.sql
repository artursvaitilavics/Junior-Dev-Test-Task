CREATE TABLE IF NOT EXISTS `product_item` (

    `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `sku` varchar(20),
    `name` varchar(20),
    `price` int,
    `size_in_mb` varchar(24),
    `weight_in_kg` varchar(24),
    `dimensions_in_cm` varchar(48),


)ENGINE=InnoDB DEFAULT CHARSET=UTF8;