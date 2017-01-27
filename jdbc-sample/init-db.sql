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

DELIMITER //

CREATE PROCEDURE find_all_blogs_of(IN user_id INT)
  BEGIN
    SELECT
      id,
      username,
      password,
      nickname,
      birthday
    FROM user
    WHERE id = user_id;
  END;

CREATE PROCEDURE get_total_user_count(OUT count INT)
  BEGIN
    SELECT count(id)
    FROM user
    INTO count;
  END;


DELIMITER ;