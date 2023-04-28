DROP DATABASE IF EXISTS heroes3;
CREATE DATABASE heroes3;
USE heroes3;
CREATE TABLE potrebiteli(
id INT,
name Varchar(255),
pass Varchar(255),
mail Varchar(255));
INSERT INTO potrebiteli VALUES
    (1, "admin", "admin", "admin@local.bg"),
    (2, "usr", "u", "usr@local.bg");
