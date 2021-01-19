CREATE SCHEMA sys
CREATE TABLE `sys`.`proveedores` (
  `id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `fecha_de_alta` DATE NULL,
  `id_cliente` INT NULL);
  
  insert into proveedores (id, nombre, fecha_de_alta, id_cliente) values (NULL,'proveedoresCoca-cola','2021-01-19',5);
  insert into proveedores (id, nombre, fecha_de_alta, id_cliente) values (NULL,'Pepsi','2021-01-19',5);
  insert into proveedores (id, nombre, fecha_de_alta, id_cliente) values (NULL,'Redbull','2021-01-19',6);