CREATE TABLE UserRole(
  username varchar(45) NOT NULL,
  role varchar(45) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY uni_username_role (role,username),
  KEY fk_username_idx (username),
  CONSTRAINT fk_username FOREIGN KEY (username) REFERENCES User (username));
  
INSERT INTO User(username,password,enabled)
VALUES ('admin','admin', true);
INSERT INTO User(username,password,enabled)
VALUES ('vdp','vdp', true);

INSERT INTO UserRole (username, role)
VALUES ('admin', 'ROLE_USER');
INSERT INTO UserRole (username, role)
VALUES ('admin', 'ROLE_ADMIN');
INSERT INTO UserRole (username, role)
VALUES ('vdp', 'ROLE_USER');  
