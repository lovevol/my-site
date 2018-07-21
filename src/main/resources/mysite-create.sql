DROP SCHEMA IF EXISTS `my_site_db`
CREATE DATABASE my_site_db CHARACTER SET utf8;
USE my_site_db;

DROP TABLE IF EXISTS `category`;
CREATE TABLE category (
  id INT          NOT NULL AUTO_INCREMENT,
  name        VARCHAR(100) NOT NULL,
  type        INT          NOT NULL,
  discription VARCHAR(200),
  CONSTRAINT pk_category PRIMARY KEY (id)
)DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS `label`;
CREATE TABLE label (
  id     INT          NOT NULL AUTO_INCREMENT,
  name        VARCHAR(100) NOT NULL,
  idcategory  INT          NOT NULL,
  description VARCHAR(200) NOT NULL,
  articlenum  INT,
  CONSTRAINT pk_label PRIMARY KEY (id),
  CONSTRAINT fk_category_label FOREIGN KEY (id) REFERENCES category (id)
)DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS `ebook`;
CREATE TABLE ebook
(
  id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  bookname VARCHAR(100) NOT NULL,
  description VARCHAR(200) NOT NULL,
  path VARCHAR(200)
)DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS `user`;
CREATE TABLE user
(
  id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
  login_name VARCHAR(50),
  user_name VARCHAR(50),
  password VARCHAR(50),
  gender int,
  role_type TINYINT,
  email VARCHAR(50),
  status INT,
  validate_code VARCHAR(100),
  validate_date DATETIME
)DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS `web`;
CREATE TABLE web
(
  id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  we_burl VARCHAR(200) NOT NULL,
  description VARCHAR(200) NOT NULL,
  remark VARCHAR(200),
  label VARCHAR(100)

)DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS `content`;
CREATE TABLE content
(
  id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  content TEXT
)DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS `article`;
CREATE TABLE article
(
  id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  title VARCHAR(100) NOT NULL,
  date DATE,
  id_label INT NOT NULL,
  id_category INT NOT NULL,
  sketch VARCHAR(200),
  image_path VARCHAR(200),
  id_content INT,
  CONSTRAINT article_category_idcategory_fk FOREIGN KEY (id_category) REFERENCES category (id),
  CONSTRAINT article_label_idlabel_fk FOREIGN KEY (id_label) REFERENCES label (id),
  CONSTRAINT article_content_idcontent_fk FOREIGN KEY (id_content) REFERENCES content (id)
)DEFAULT CHARSET = utf8;
