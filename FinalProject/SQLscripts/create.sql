CREATE TABLE IF NOT EXISTS `users` (
  `login`          VARCHAR(45) NOT NULL UNIQUE,
  `password`       VARCHAR(64) NOT NULL,
  `email`          VARCHAR(25) NOT NULL,
  `priviligesLvl` INT(1)      NOT NULL        DEFAULT '0',
  `ID`             INT         NOT NULL UNIQUE AUTO_INCREMENT,
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `ID_UNIQUE` (`ID` ASC)
)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `clients` (
  `name`       VARCHAR(25) NOT NULL,
  `surname`    VARCHAR(45) NOT NULL,
  `patronymic` VARCHAR(45),
  `phone`      VARCHAR(20) NULL DEFAULT NULL,
  `users_ID`   INT UNIQUE  NOT NULL,
  INDEX `fk_clients_users1_idx` (`users_ID` ASC),
  PRIMARY KEY (`users_ID`),
  CONSTRAINT `fk_clients_users1`
  FOREIGN KEY (`users_ID`)
  REFERENCES `users` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `cities` (
  `name` VARCHAR(45) NOT NULL,
  `ID`   INT         NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`ID`)
)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `flight` (
  `ID`               INT         NOT NULL AUTO_INCREMENT UNIQUE ,
  `name`             VARCHAR(40) NOT NULL,
  `max_lagage_count` INT         NOT NULL,
  `flight_time`      TIME     NOT NULL,
  `departure_ID`     INT         NOT NULL,
  `arrival_ID`       INT         NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_flight_countries1_idx` (`departure_ID` ASC),
  INDEX `fk_flight_countries2_idx` (`arrival_ID` ASC),
  CONSTRAINT `fk_flight_countries1`
  FOREIGN KEY (`departure_ID`)
  REFERENCES `cities` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_flight_countries2`
  FOREIGN KEY (`arrival_ID`)
  REFERENCES `cities` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `current_flight` (
  `ID`          INT     NOT NULL AUTO_INCREMENT UNIQUE,
  `ticket_cost` INT(11) NOT NULL,
  `date`        DATE    NOT NULL,
  `lagage_cost` INT     NOT NULL,
  `flight_ID`   INT     NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_current_flight_flight2_idx` (`flight_ID` ASC),
  CONSTRAINT `fk_current_flight_flight2`
  FOREIGN KEY (`flight_ID`)
  REFERENCES `flight` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
  ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `tickets` (
  `ID`                INT(10) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
  `fly_cost`          INT(11)          NOT NULL,
  `clients_users_ID`  INT              NOT NULL,
  `lagage_capacity`   INT              NULL     DEFAULT 0,
  `VIP`               TINYINT(1)       NULL     DEFAULT 0,
  `current_flight_ID` INT              NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_tickets_clients1_idx` (`clients_users_ID` ASC),
  INDEX `fk_tickets_current_flight1_idx` (`current_flight_ID` ASC),
  CONSTRAINT `fk_tickets_clients1`
  FOREIGN KEY (`clients_users_ID`)
  REFERENCES `clients` (`users_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tickets_current_flight1`
  FOREIGN KEY (`current_flight_ID`)
  REFERENCES `current_flight` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8