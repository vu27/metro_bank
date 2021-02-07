
/* Create the database */
CREATE DATABASE IF NOT EXISTS metro_bank;

/* Create Employee Model */
CREATE TABLE IF NOT EXISTS metro_bank.user (
	user_id integer AUTO_INCREMENT NOT NULL PRIMARY KEY,
	user_fname varchar(75) NOT NULL,
	user_lname varchar(75) NOT NULL,
    user_phone varchar(75) NOT NULL,
    user_role varchar(75) NOT NULL,
    user_email varchar(75) NOT NULL,
	user_password varchar(75) NOT NULL
);

