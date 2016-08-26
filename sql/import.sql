CREATE  TABLE User (
  username VARCHAR(45) NOT NULL ,
  password VARCHAR(45) NOT NULL ,
  enabled TINYINT NOT NULL DEFAULT 1 ,
  PRIMARY KEY (username));

CREATE TABLE User_Role(
  user_role_id int(11) NOT NULL AUTO_INCREMENT,
  username varchar(45) NOT NULL,
  role varchar(45) NOT NULL,
  PRIMARY KEY (user_role_id),
  UNIQUE KEY uni_username_role (role,username),
  KEY fk_username_idx (username),
  CONSTRAINT fk_username FOREIGN KEY (username) REFERENCES User (username));
  
INSERT INTO User(username,password,enabled)
VALUES ('admin','admin', true);
INSERT INTO User(username,password,enabled)
VALUES ('vdp','vdp', true);

INSERT INTO User_Role (username, role)
VALUES ('admin', 'ROLE_USER');
INSERT INTO User_Role (username, role)
VALUES ('admin', 'ROLE_ADMIN');
INSERT INTO User_Role (username, role)
VALUES ('vdp', 'ROLE_USER');  
