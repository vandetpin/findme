-- UserAccount ---
INSERT INTO `UserAccount` (`id`,`isActive`,`password`,`username`) VALUES (1, 1,'admin','admin');
INSERT INTO `UserAccount` (`id`,`isActive`,`password`,`username`) VALUES (2, 1,'vdp','vdp');
INSERT INTO `UserAccount` (`id`,`isActive`,`password`,`username`) VALUES (3, 1,'123','tm');
INSERT INTO `UserAccount` (`id`,`isActive`,`password`,`username`) VALUES (4, 1,'123','doc');

-- UserRole --
INSERT INTO `UserRole` (`id`,`role`,`username`) VALUES (1,'ROLE_USER','admin');
INSERT INTO `UserRole` (`id`,`role`,`username`) VALUES (2,'ROLE_ADMIN','admin');
INSERT INTO `UserRole` (`id`,`role`,`username`) VALUES (3,'ROLE_USER','vdp');
INSERT INTO `UserRole` (`id`,`role`,`username`) VALUES (4,'ROLE_USER','tm');
INSERT INTO `UserRole` (`id`,`role`,`username`) VALUES (5,'ROLE_PROFESSIONAL','tm');
INSERT INTO `UserRole` (`id`,`role`,`username`) VALUES (6,'ROLE_USER','doc');
INSERT INTO `UserRole` (`id`,`role`,`username`) VALUES (7,'ROLE_PROFESSIONAL','doc');

-- Profesional ---
INSERT INTO `User` (`userType`,`Id`,`city`,`state`,`street`,`zip`,`dateOfBirth`,`emailAddress`,`firstName`,`gender`,`lastName`,`otherInfo`,`phoneNumber`,`profilePicture`,`isActive`,`type`,`userAccount_id`) VALUES ('PROFESSIONAL',1,'Fairfield','Iowa','4th Street','52557','1960-10-10','prof@gg.com','TM teacher','F','1','short info','902387023','https://x1.xingassets.com/assets/frontend_minified/img/users/nobody_m.original.jpg', 1,'TM_TEACHER',3);
INSERT INTO `User` (`userType`,`Id`,`city`,`state`,`street`,`zip`,`dateOfBirth`,`emailAddress`,`firstName`,`gender`,`lastName`,`otherInfo`,`phoneNumber`,`profilePicture`,`isActive`,`type`,`userAccount_id`) VALUES ('PROFESSIONAL',2,'Fairfield','Iowa','4th Street','52557','1960-10-10','prof@gg.com','Doctor','M','1','short info','902387023','https://x1.xingassets.com/assets/frontend_minified/img/users/nobody_m.original.jpg', 1,'DOCTOR',4);
UPDATE UserAccount SET user_id = 1 WHERE id = 3;
UPDATE UserAccount SET user_id = 2 WHERE id = 4;

-- Appointment ---
INSERT INTO `Appointment` (`appid`,`appEndTime`,`appStartTime`,`capacity`,`description`,`name`,`status`,`owner_Id`) VALUES (5,'2019-10-10 12:00:00','2019-10-10 09:00:00',10,'TM 1st Check','TM 1st Check',1,1);
INSERT INTO `Appointment` (`appid`,`appEndTime`,`appStartTime`,`capacity`,`description`,`name`,`status`,`owner_Id`) VALUES (6,'2019-11-10 12:00:00','2019-11-10 09:00:00',10,'TM 2nd Check','TM 2nd Check',1,1);
INSERT INTO `Appointment` (`appid`,`appEndTime`,`appStartTime`,`capacity`,`description`,`name`,`status`,`owner_Id`) VALUES (7,'2019-11-10 12:00:00','2019-11-10 08:00:00',2,'TB Test','TB Test',1,2);
INSERT INTO `Appointment` (`appid`,`appEndTime`,`appStartTime`,`capacity`,`description`,`name`,`status`,`owner_Id`) VALUES (8,'2019-10-10 12:00:00','2019-10-10 09:00:00',4,'Flu ','Flu',1,2);-- UserAccount ---
