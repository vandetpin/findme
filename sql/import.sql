INSERT INTO UserAccount(username,password,isActive)
VALUES ('admin','admin', true);
INSERT INTO UserAccount(username,password,isActive)
VALUES ('vdp','vdp', true);

INSERT INTO UserRole (username, role)
VALUES ('admin', 'ROLE_USER');
INSERT INTO UserRole (username, role)
VALUES ('admin', 'ROLE_ADMIN');
INSERT INTO UserRole (username, role)
VALUES ('vdp', 'ROLE_USER');  