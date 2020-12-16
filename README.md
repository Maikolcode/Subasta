# Subasta
Código libre en java JEE 7.0 y JPA 
------- Creación de la base de datos Con MySQL -----------
CREATE SCHEMA IF NOT EXISTS `subasta` DEFAULT CHARACTER SET utf8 ;
USE `subasta` ;

-- -----------------------------------------------------
-- Table `subasta`.`productos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `subasta`.`productos` (
  `id_productos` INT NOT NULL AUTO_INCREMENT,
  `nombre_producto` VARCHAR(45) NOT NULL,
  `valor_inicial` DOUBLE NOT NULL,
  PRIMARY KEY (`id_productos`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `subasta`.`clientes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `subasta`.`clientes` (
  `id_clientes` INT NOT NULL AUTO_INCREMENT,
  `nombre_cliente` VARCHAR(45) NOT NULL,
  `apellido_cliente` VARCHAR(45) NOT NULL,
  `telefono_cliente` VARCHAR(45) NOT NULL,
  `email_cliente` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_clientes`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `subasta`.`moneda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `subasta`.`moneda` (
  `id_moneda` INT NOT NULL AUTO_INCREMENT,
  `nombre_moneda` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_moneda`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `subasta`.`subasta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `subasta`.`subasta` (
  `id_subasta` INT NOT NULL AUTO_INCREMENT,
  `codigo_producto` INT NOT NULL,
  `codigo_cliente` INT NOT NULL,
  `codigo_moneda` INT NOT NULL,
  `valor_ofrecido` DOUBLE NOT NULL,
  PRIMARY KEY (`id_subasta`),
  INDEX `fk_codigoPdt_idx` (`codigo_producto` ASC),
  INDEX `fk_codigoCli_idx` (`codigo_cliente` ASC),
  INDEX `fk_codigoMd_idx` (`codigo_moneda` ASC),
  CONSTRAINT `fk_codigoPdt`
    FOREIGN KEY (`codigo_producto`)
    REFERENCES `subasta`.`productos` (`id_productos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_codigoCli`
    FOREIGN KEY (`codigo_cliente`)
    REFERENCES `subasta`.`clientes` (`id_clientes`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_codigoMd`
    FOREIGN KEY (`codigo_moneda`)
    REFERENCES `subasta`.`moneda` (`id_moneda`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
