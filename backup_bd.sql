/*
SQLyog Ultimate v11.11 (64 bit)
MySQL - 8.0.21 : Database - reposteria
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`reposteria` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `reposteria`;

/*Table structure for table `categoria` */

CREATE TABLE `categoria` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `categoria` */

insert  into `categoria`(`id`,`descripcion`,`nombre`) values (1,NULL,'Pasteles'),(2,NULL,'Cupcakes'),(3,NULL,'Galletas'),(4,NULL,'Tartas'),(9,'','Categoria nueva 2'),(10,NULL,'Pasteles Fritos');

/*Table structure for table `ciudad` */

CREATE TABLE `ciudad` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `codigo_ciudad` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `departamento_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKev870hgt8a7wx5t21q4mnsu3k` (`departamento_id`),
  CONSTRAINT `FKev870hgt8a7wx5t21q4mnsu3k` FOREIGN KEY (`departamento_id`) REFERENCES `departamento` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `ciudad` */

insert  into `ciudad`(`id`,`codigo_ciudad`,`nombre`,`departamento_id`) values (1,'4100','Neiva',1);

/*Table structure for table `departamento` */

CREATE TABLE `departamento` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `codigo_departamento` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `pais_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKs4ob59h57ccjv16ie2esul77h` (`pais_id`),
  CONSTRAINT `FKs4ob59h57ccjv16ie2esul77h` FOREIGN KEY (`pais_id`) REFERENCES `pais` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `departamento` */

insert  into `departamento`(`id`,`codigo_departamento`,`nombre`,`pais_id`) values (1,'41','Huila',1);

/*Table structure for table `factura` */

CREATE TABLE `factura` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `estado` bit(1) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `total` double DEFAULT NULL,
  `metodo_pago_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5pm1b22bwy4hjwt6ieg7vqcl5` (`metodo_pago_id`),
  CONSTRAINT `FK5pm1b22bwy4hjwt6ieg7vqcl5` FOREIGN KEY (`metodo_pago_id`) REFERENCES `metodo_pago` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `factura` */

/*Table structure for table `factura_detalle` */

CREATE TABLE `factura_detalle` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `cantidad` int DEFAULT NULL,
  `precio` double DEFAULT NULL,
  `producto` varchar(255) DEFAULT NULL,
  `factura_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK82g5tpb19dn0ed3dh8rjepfeo` (`factura_id`),
  CONSTRAINT `FK82g5tpb19dn0ed3dh8rjepfeo` FOREIGN KEY (`factura_id`) REFERENCES `factura` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `factura_detalle` */

/*Table structure for table `metodo_pago` */

CREATE TABLE `metodo_pago` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `metodo_pago` */

insert  into `metodo_pago`(`id`,`nombre`) values (1,'Tarjeta de Crédito'),(2,'Tarjeta de Débito'),(3,'Transferencia Bancaria'),(4,'Pago en Efectivo');

/*Table structure for table `pais` */

CREATE TABLE `pais` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `codigo_pais` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `pais` */

insert  into `pais`(`id`,`codigo_pais`,`nombre`) values (1,'57','Colombia');

/*Table structure for table `persona` */

CREATE TABLE `persona` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `apellido` varchar(255) DEFAULT NULL,
  `correo` varchar(255) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `telefono` varchar(255) DEFAULT NULL,
  `ciudad_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKlepe3eunysskw7ly9exxa5t8v` (`ciudad_id`),
  CONSTRAINT `FKlepe3eunysskw7ly9exxa5t8v` FOREIGN KEY (`ciudad_id`) REFERENCES `ciudad` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `persona` */

insert  into `persona`(`id`,`apellido`,`correo`,`direccion`,`nombre`,`telefono`,`ciudad_id`) values (1,'Cabrera','paca99@gmail.com','Calle 46 sur 33 178','Maria Paula','3133651565',1);

/*Table structure for table `producto` */

CREATE TABLE `producto` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) DEFAULT NULL,
  `imagen` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `precio` double NOT NULL,
  `stock` int NOT NULL,
  `categoria_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKodqr7965ok9rwquj1utiamt0m` (`categoria_id`),
  CONSTRAINT `FKodqr7965ok9rwquj1utiamt0m` FOREIGN KEY (`categoria_id`) REFERENCES `categoria` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `producto` */

insert  into `producto`(`id`,`descripcion`,`imagen`,`nombre`,`precio`,`stock`,`categoria_id`) values (1,'Delicioso pastel de chocolate con cobertura de ganache','https://images.unsplash.com/photo-1578985545062-69928b1d9587','Pastel de Chocolate',15.99,10,1),(2,'Cupcakes esponjosos de vainilla con glaseado de mantequilla sin sal','https://origin.cronosmedia.glr.pe/large/2020/10/26/lg_5f9721983619341ea427baf5.jpg','Cupcakes Vainilla',9.99,20,2),(3,'Crujientes galletas de avena con pasas','https://www.conasi.eu/blog/wp-content/uploads/2013/03/galletas-de-avena-1.jpg','Galletas de Avena 2',4.99,30,3),(4,'Tarta de manzana casera con canela','https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTtJ4tg9pUw8jhcHFwtp2yAM-xbEXrci6A5hg&s','Tarta de Manzana',12.99,15,4),(5,'Brownies de chocolate con trozos de nuez','https://images.unsplash.com/photo-1562440499-64f42e55403e','Brownies de Nuez',7.99,25,1),(6,'Cheesecake cremoso con fresas frescas','https://www.recetasnestlecam.com/sites/default/files/styles/recipe_detail_desktop/public/srh_recipes/07892f02f7c57b83d5703b4ee924221e.jpg?itok=lCKnEZB9','Cheesecake de Fresa',14.99,12,2),(7,'Macarons coloridos con diferentes sabores','https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRgkCV9On8CElGS3watlzaAoWdnR2qZ-2db2Q&s','Macarons Franceses',19.99,50,3),(8,'Eclairs rellenos de crema y cubiertos con chocolate','https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQxCVX8lz-zsq5y2MIQ5AiDJPyMnHA2kRSBcQ&s','Eclairs de Chocolate',11.99,18,4),(9,'Tiramisu clásico italiano con café y mascarpone','https://www.cocinavital.mx/wp-content/uploads/2019/05/tiramisu-clasico-pasos.jpg','Tiramisu Clásico',16.99,10,1),(10,'Galletas tradicionales de mantequilla','https://images.unsplash.com/photo-1602326949483-26a8b3fcf221','Galletas de Mantequilla',5.99,35,2),(11,'Pastel de zanahoria con frosting de queso crema','https://images.unsplash.com/photo-1615486365883-53bc03c8c6fa','Pastel de Zanahoria',13.99,20,3),(12,'Donas esponjosas con glaseado de azúcar','https://images.unsplash.com/photo-1578985545062-69928b1d9587','Donas Glaseadas',8.99,40,4),(13,'Tarta de limón con merengue tostado','https://images.unsplash.com/photo-1566849121255-e2a45f3db9d8','Tarta de Limón',10.99,10,1),(14,'Churros crujientes con azúcar y canela','https://images.unsplash.com/photo-1599907790620-6f4c5d0982c9','Churros',6.99,30,2),(15,'Bizcocho marmoleado de vainilla y chocolate','https://images.unsplash.com/photo-1600789194395-942fea7ab4a1','Bizcocho Marmoleado',9.99,22,3),(16,'Rollos de canela con glaseado de vainilla','https://images.unsplash.com/photo-1584476416697-1bded1e1362d','Rollos de Canela',12.99,15,4),(17,'Pastel de terciopelo rojo con frosting de queso crema','https://images.unsplash.com/photo-1589968781399-6fe53921d6b2','Pastel Red Velvet',15.99,12,1),(18,'Galletas suaves con chispas de chocolate','https://images.unsplash.com/photo-1584568691702-860eee694d7b','Galletas con Chispas de Chocolate',6.99,40,2),(19,'Tarta fresca de fresas con crema batida','https://images.unsplash.com/photo-1616669078632-6fc557f1d898','Tarta de Fresas',14.99,10,3),(20,'Brownies de chocolate blanco con almendras','https://images.unsplash.com/photo-1565299543925-29c8e5165047','Brownies de Chocolate Blanco',8.99,18,4),(21,'Tarta de queso con mermelada de arándanos','https://images.unsplash.com/photo-1620218475640-fd5a5db04624','Tarta de Queso con Arándanos',13.99,15,1),(22,'Muffins esponjosos de banana con nueces','https://images.unsplash.com/photo-1543353071-873f17a7a088','Muffins de Banana y Nueces',7.99,25,2),(23,'Galletas especiadas de jengibre','https://images.unsplash.com/photo-1541976076758-5c08d280d3dd','Galletas de Jengibre',5.99,30,3),(24,'Tarta de calabaza con especias de otoño','https://images.unsplash.com/photo-1559724492-1d19de37d44a','Tarta de Calabaza',11.99,20,4),(25,'Pastel de coco esponjoso con crema de coco','https://images.unsplash.com/photo-1596399571318-9660a02f1e0c','Pastel de Coco',15.99,12,1),(26,'Cupcakes de red velvet con frosting de queso crema','https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSFNnrU_XOue88Zu85dxQL86DrDmGSumi17mQ&s','Cupcakes de Red Velvet',9.99,22,2),(27,'Tarta de chocolate blanco con frambuesas','https://images.unsplash.com/photo-1571695236642-c3c8aef1e42f','Tarta de Chocolate Blanco',14.99,18,3),(28,'Brownies de chocolate con esencia de menta','https://images.unsplash.com/photo-1513639725746-c5d3e861f32a','Brownies de Chocolate y Menta',7.99,25,4),(30,'Galletas de mantequilla con un toque de canela','https://images.unsplash.com/photo-1581804928342-f2f31e6f1159','Galletas de Mantequilla y Canela',5.99,35,2),(31,'Tarta con frutas tropicales y crema de coco','https://images.unsplash.com/photo-1625319571355-1c593202af4e','Tarta de Frutas Tropicales',14.99,15,3),(32,'Cupcakes de limón con arándanos frescos','https://images.unsplash.com/photo-1584680220737-0b3c4f2a6ab1','Cupcakes de Limón y Arándanos',9.99,20,4),(33,'Galletas de mantequilla de maní con chispas de chocolate','https://images.unsplash.com/photo-1609795045502-eec6f4e82e3d','Galletas de Mantequilla de Maní',6.99,30,1),(34,'Tarta de chocolate con relleno de naranja','https://images.unsplash.com/photo-1589461193307-0a7163e04d0a','Tarta de Chocolate y Naranja',12.99,18,2),(35,'Brownies de chocolate con un toque de café','https://images.unsplash.com/photo-1578985545062-69928b1d9587','Brownies de Café',8.99,25,3),(36,'Cupcakes de zanahoria con frosting de queso crema','https://images.unsplash.com/photo-1581447106171-bafd17ff3f38','Cupcakes de Zanahoria',9.99,20,4),(37,'Tarta de crema pastelera con cobertura de chocolate','https://images.unsplash.com/photo-1581447106171-bafd17ff3f38','Tarta de Crema y Chocolate',13.99,15,1),(38,'Galletas crujientes de almendra','https://images.unsplash.com/photo-1563805042-7684ff31f0f9','Galletas de Almendra',5.99,30,2),(39,'Tarta de peras con chocolate fundido','https://images.unsplash.com/photo-1601568872893-f0e04c2e21d7','Tarta de Peras y Chocolate',12.99,20,3),(40,'Brownies de chocolate con trozos de avellana','https://images.unsplash.com/photo-1565963320370-5fb97c12a5ef','Brownies de Avellana',7.99,25,4),(41,'Tarta de queso con un toque de limón','https://images.unsplash.com/photo-1543778930-45f06be13208','Tarta de Queso y Limón',13.99,15,1),(42,'Cupcakes de chocolate con frosting de naranja','https://images.unsplash.com/photo-1595947793924-6ebcd8429a1f','Cupcakes de Chocolate y Naranja',9.99,22,2),(43,'Galletas suaves de miel con especias','https://images.unsplash.com/photo-1551024601-bec78aea704b','Galletas de Miel',6.99,30,3),(44,'Tarta de almendra con miel y frutos secos','https://images.unsplash.com/photo-1601310981497-9349c31b26ae','Tarta de Almendra y Miel',15.99,12,4),(45,'Pastel de chocolate con relleno de frambuesa','https://images.unsplash.com/photo-1543778930-45f06be13208','Pastel de Chocolate y Frambuesa',17.99,10,1),(46,'Galletas crujientes de avena con miel','https://images.unsplash.com/photo-1601310981497-9349c31b26ae','Galletas de Avena y Miel',5.99,35,2),(47,'Tarta de queso con mermelada de frambuesa','https://images.unsplash.com/photo-1601781944894-6cb755dfb110','Tarta de Queso y Frambuesa',14.99,15,3),(48,'Cupcakes de chocolate con frosting de menta','https://images.unsplash.com/photo-1615486365883-53bc03c8c6fa','Cupcakes de Menta y Chocolate',10.99,20,4),(49,'Brownies de chocolate con esencia de naranja','https://images.unsplash.com/photo-1565963320370-5fb97c12a5ef','Brownies de Naranja',7.99,25,1),(50,'Galletas de chocolate blanco con arándanos','https://images.unsplash.com/photo-1551024601-bec78aea704b','Galletas de Chocolate Blanco',6.99,30,2),(61,'Delicioso pastel de pollo','https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR5qfHNqIYCr6v2lkwfD3sSPohrVKIMuCs-Vw&s','Pastel de Pollo',500,3,10);

/*Table structure for table `usuario` */

CREATE TABLE `usuario` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `correo` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` enum('ADMIN','USER') NOT NULL,
  `persona_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKlse7lqghmt3r1sp298ss9s5bc` (`persona_id`),
  CONSTRAINT `FKlse7lqghmt3r1sp298ss9s5bc` FOREIGN KEY (`persona_id`) REFERENCES `persona` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `usuario` */

insert  into `usuario`(`id`,`correo`,`nombre`,`password`,`role`,`persona_id`) values (2,'paca99@gmail.com','Paula Cabrera','$2a$10$ksnyCRCplfoRYYTeG//rVOX0gjPL0dodEjiOrbnDhAFzyhMJsMhxK','ADMIN',1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
