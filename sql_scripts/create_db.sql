
/* Create the database */
CREATE DATABASE IF NOT EXISTS metro_bank;

/* Create Employee Model */
CREATE TABLE IF NOT EXISTS metro_bank.employee (
	emp_id integer AUTO_INCREMENT NOT NULL PRIMARY KEY, 
	emp_fname varchar(75) NOT NULL, 
	emp_lname varchar(75) NOT NULL,
    emp_role varchar(75) NOT NULL, 
    emp_email varchar(75) NOT NULL,
	emp_phone varchar(75) NOT NULL
);

