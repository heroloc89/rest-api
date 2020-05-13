CREATE DATABASE demo_db;
use demo_db;
CREATE TABLE USERS
(
	username varchar(50) not null,
    password varchar(100) not null,
    role varchar(20) not null,
    primary key(username)
);

INSERT INTO USERS (username, password, role) VALUES ('admin', '$2y$12$LuWlLR98EgZ8MdbAGocJTe7jKnHNOyU6CJ2g3vOQMcE2ZnX.wyKx6', 'ADMIN');
INSERT INTO USERS (username, password, role) VALUES ('user', '$2y$12$LuWlLR98EgZ8MdbAGocJTe7jKnHNOyU6CJ2g3vOQMcE2ZnX.wyKx6', 'USER');

select * from users;