CREATE DATABASE demo_db;
use demo_db;
CREATE TABLE `employee`
(
  `id`          bigint(20) 	  	NOT NULL      	   	AUTO_INCREMENT,
  `first_name`   varchar(100)    CHARACTER SET utf8 	DEFAULT NULL ,
  `last_name`    varchar(100)    CHARACTER SET utf8 	DEFAULT NULL ,
  `birth_date`   date         					    DEFAULT NULL,
  `gender`      char(1)         					DEFAULT NULL,
  `address`     text            					DEFAULT NULL,
  PRIMARY KEY (`id`)
);

INSERT INTO `employee` (`first_name`,`last_name`,`birth_date`,`gender`,`address`) VALUES ('Leonard', 'Hofstadter','1981-08-24','M','Woodcrest');
INSERT INTO `employee` (`first_name`,`last_name`,`birth_date`,`gender`,`address`) VALUES ('Robert', 'Phil','1990-11-20','M','3rd Street 34');

select * from employee;