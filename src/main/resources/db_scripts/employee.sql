CREATE DATABASE demo_db;
use demo_db;
CREATE TABLE `employee`
(
  `id`          bigint(20) 	  	NOT NULL      	   	AUTO_INCREMENT,
  `firstname`   varchar(100)    CHARACTER SET utf8 	DEFAULT NULL ,
  `lastname`    varchar(100)    CHARACTER SET utf8 	DEFAULT NULL ,
  `birthdate`   date         					    DEFAULT NULL,
  `gender`      char(1)         					DEFAULT NULL,
  `address`     text            					DEFAULT NULL,
  PRIMARY KEY (`id`)
);

INSERT INTO `employee` (`firstname`,`lastname`,`birthdate`,`gender`,`address`) VALUES ('Leonard', 'Hofstadter','1981-08-24','M','Woodcrest');  
INSERT INTO `employee` (`firstname`,`lastname`,`birthdate`,`gender`,`address`) VALUES ('Robert', 'Phil','1990-11-20','M','3rd Street 34'); 

select * from employee;