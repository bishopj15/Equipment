DROP SCHEMA IF EXISTS `equipment_db`;
CREATE SCHEMA IF NOT EXISTS `equipment_db` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;


-- CREATE INSPECTION DATABASE USER --
grant all privileges on equipment_db.* to 'testuser'@'%' identified by 'password1' with grant option;
grant all privileges on equipment_db.* to 'testuser'@'127.0.0.1' identified by 'password1' with grant option;
grant all privileges on equipment_db.* to 'testuser'@'localhost' identified by 'password1'with grant option;

flush privileges;