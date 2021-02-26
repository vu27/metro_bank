
/* Create the database */
CREATE DATABASE IF NOT EXISTS metro_bank;

/* Create Manager Model */
CREATE TABLE IF NOT EXISTS metro_bank.manager (
	manager_id integer AUTO_INCREMENT NOT NULL PRIMARY KEY,
	manager_fname varchar(75) NOT NULL,
	manager_lname varchar(75) NOT NULL,
    manager_phone varchar(75) NOT NULL,
    manager_email varchar(75) NOT NULL,
	manager_password varchar(75) NOT NULL,
	manager_salary double NOT NULL
);

/* Create Employee Model */
CREATE TABLE IF NOT EXISTS metro_bank.employee (
	employee_id integer AUTO_INCREMENT NOT NULL PRIMARY KEY,
	employee_fname varchar(75) NOT NULL,
	employee_lname varchar(75) NOT NULL,
    employee_phone varchar(75) NOT NULL,
    employee_email varchar(75) NOT NULL,
	employee_password varchar(75) NOT NULL,
	employee_salary double NOT NULL
);

/* Create Student Model */
CREATE TABLE IF NOT EXISTS metro_bank.student (
	student_id integer AUTO_INCREMENT NOT NULL PRIMARY KEY,
	student_fname varchar(75) NOT NULL,
	student_lname varchar(75) NOT NULL,
    student_phone varchar(75) NOT NULL,
    student_email varchar(75) NOT NULL,
	student_password varchar(75) NOT NULL,
	date_created varchar(75) NOT NULL
);

/* Populate Managers */
INSERT INTO metro_bank.manager (
	manager_fname,
    manager_lname,
    manager_phone,
    manager_email,
	manager_password,
	manager_salary
) VALUES
('Safina', 'Nganga', '612-555-1334', 'safina.nganga@metrostate.edu', 'password', 70000),
('Janaya', 'Thomas', '612-555-2334', 'janaya.thomas@metrostate.edu', 'password', 70000),
('Anthony', 'Nguyen', '612-555-1233', 'anthony.nguyen@metrostate.edu', 'password', 70000),
('Tony', 'Vu', '612-555-1234', 'tony@metrostate.edu', 'password', 70000);


/* Populate Employees */
INSERT INTO metro_bank.employee (
	employee_fname,
    employee_lname,
    employee_phone,
    employee_email,
	employee_password,
	employee_salary
) VALUES
('Leona', 'Dunne', '952-555-1177', 'l.Dunne@metrobank.edu', 'password', 50000),
('Walter', 'Smith', '612-555-1234', 'w.Smith@metrobank.edu', 'password', 50000),
('Straw', 'Berry', '622-555-1234', 's.berry@metrobank.edu', 'password', 50000),
('Darby', 'Dancer', '122-555-1234', 'd.dancer@metrobank.edu', 'password', 50000),
('Bobby', 'Dolphin', '651-555-9987', 'b.dolphin@metrobank.edu', 'password', 50000);

/* Populate Students */
INSERT INTO metro_bank.student (
	student_fname,
    student_lname,
    student_phone,
    student_email,
	student_password,
	date_created
) VALUES
('Jerry', 'Hills', '953-555-1177', 'j.hills@metrobank.edu', 'password', '2021-02-25T05:47:26.853Z'),
('Walter', 'Smith', '612-555-1234', 'w.Smith@metrobank.edu', 'password', '2021-02-25T05:47:26.853Z'),
('Straw', 'Berry', '622-555-1234', 's.berry@metrobank.edu', 'password', '2021-02-25T05:47:26.853Z'),
('Darby', 'Dancer', '122-555-1234', 'd.dancer@metrobank.edu', 'password', '2021-02-25T05:47:26.853Z'),
('Bobby', 'Dolphin', '651-555-9987', 'b.dolphin@metrobank.edu', 'password', '2021-02-25T05:47:26.853Z');






















