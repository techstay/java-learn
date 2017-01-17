DROP DATABASE IF EXISTS jdbclearn;
CREATE DATABASE jdbclearn;
USE jdbclearn;
CREATE TABLE user (
  id       INT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(255) UNIQUE,
  password VARCHAR(255) NOT NULL,
  nickname VARCHAR(255),
  birthday DATE
);
CREATE TABLE blog (
  id          INT AUTO_INCREMENT PRIMARY KEY,
  title       VARCHAR(255) NOT NULL,
  content     TEXT         NOT NULL,
  create_time DATETIME     NOT NULL,
  author      INT          NOT NULL,
  FOREIGN KEY (author) REFERENCES user (id)
);