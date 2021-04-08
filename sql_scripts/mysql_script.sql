
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
	manager_salary double NOT NULL,
	manager_ssn integer NOT NULL,
	manager_address varchar(75) NOT NULL,
	manager_city varchar(75) NOT NULL,
	manager_state varchar(75) NOT NULL
);

/* Create Employee Model */
CREATE TABLE IF NOT EXISTS metro_bank.employee (
	employee_id integer AUTO_INCREMENT NOT NULL PRIMARY KEY,
	employee_fname varchar(75) NOT NULL,
	employee_lname varchar(75) NOT NULL,
    employee_phone varchar(75) NOT NULL,
    employee_email varchar(75) NOT NULL,
	employee_password varchar(75) NOT NULL,
	employee_salary double NOT NULL,
	employee_ssn integer NOT NULL,
    employee_address varchar(75) NOT NULL,
    employee_city varchar(75) NOT NULL,
    employee_state varchar(75) NOT NULL
);

/* Create Student Model */
CREATE TABLE IF NOT EXISTS metro_bank.student (
	student_id integer AUTO_INCREMENT NOT NULL PRIMARY KEY,
	student_fname varchar(75) NOT NULL,
	student_lname varchar(75) NOT NULL,
    student_phone varchar(75) NOT NULL,
    student_email varchar(75) NOT NULL,
	student_password varchar(75) NOT NULL,
	date_created varchar(75) NOT NULL,
	student_ssn integer NOT NULL,
    student_address varchar(75) NOT NULL,
    student_city varchar(75) NOT NULL,
    student_state varchar(75) NOT NULL
);

/* Create Checkings Model */
CREATE TABLE IF NOT EXISTS metro_bank.checkings (
	id integer AUTO_INCREMENT NOT NULL PRIMARY KEY,
	date_opened varchar(75) NOT NULL,
	is_active boolean NOT NULL,
    student_id integer NOT NULL,
    total double NOT NULL,
	is_overdrafted boolean NOT NULL,
	account_number BIGINT NOT NULL,
	routing_number BIGINT NOT NULL,
	debit_card_number BIGINT NOT NULL,
	FOREIGN KEY (student_id) REFERENCES metro_bank.student(student_id)
    ON DELETE CASCADE
);


/* Create Savings Model */
CREATE TABLE IF NOT EXISTS metro_bank.savings (
	id integer AUTO_INCREMENT NOT NULL PRIMARY KEY,
	date_opened varchar(75) NOT NULL,
	is_active boolean NOT NULL,
    student_id integer NOT NULL,
    total double NOT NULL,
	interest double NOT NULL,
	account_number BIGINT NOT NULL,
    routing_number BIGINT NOT NULL,
    FOREIGN KEY (student_id) REFERENCES metro_bank.student(student_id)
    ON DELETE CASCADE
);

/* Create Credit Model */
CREATE TABLE IF NOT EXISTS metro_bank.credit (
	id integer AUTO_INCREMENT NOT NULL PRIMARY KEY,
	date_opened varchar(75) NOT NULL,
	is_active boolean NOT NULL,
    student_id integer NOT NULL,
    balance double NOT NULL,
	statement_balance double NOT NULL,
	available_credit double NOT NULL,
	apr double NOT NULL,
    payment_made boolean NOT NULL,
    FOREIGN KEY (student_id) REFERENCES metro_bank.student(student_id)
    ON DELETE CASCADE
);

/* Create CreditApplication Model */
CREATE TABLE IF NOT EXISTS metro_bank.credit_application (
	id integer AUTO_INCREMENT NOT NULL PRIMARY KEY,
    fname varchar(75) NOT NULL,
    lname varchar(75) NOT NULL,
    address varchar(75) NOT NULL,
    city varchar(75) NOT NULL,
    state varchar(75) NOT NULL,
    email varchar(75) NOT NULL,
    phone varchar(75) NOT NULL,
    ssn integer NOT NULL,
    credit_score integer NOT NULL,
    income double NOT NULL,
    password varchar(75) NOT NULL,
    student_id integer NOT NULL,
    FOREIGN KEY (student_id) REFERENCES metro_bank.student(student_id)
    ON DELETE CASCADE,
    status varchar(75) NOT NULL,
    date_applied varchar(75) NOT NULL
);

/* Populate Managers */
INSERT INTO metro_bank.manager (
	manager_fname,
    manager_lname,
    manager_phone,
    manager_email,
	manager_password,
	manager_salary,
	manager_ssn,
    manager_address,
    manager_city,
    manager_state
) VALUES
('Safina', 'Nganga', '612-555-1334', 'safina.nganga@metrostate.edu', 'password', 70000, 287030127, '8075 Lawrence Lane', 'New Philadelphia', 'OH'),
('Janaya', 'Thomas', '612-555-2334', 'janaya.thomas@metrostate.edu', 'password', 70000, 087962418, '20 SW. Rose Road', 'Painesville','OH' ),
('Anthony', 'Nguyen', '612-555-1233', 'anthony.nguyen@metrostate.edu', 'password', 70000, 320101434, '38 East George St.', 'Fort Worth', 'TX'),
('John', 'Stamos', '612-432-1453', 'john.stamos@metrostate.edu', 'password', 70000,  044682018 , '7827 S. Jones Ave. ', 'Tacoma', 'WA'),
('Shaun', 'Graham', '612-655-7902', 'shaun.graham@metrostate.edu', 'password', 70000,  505514618  , '139 Vale St. ', 'Portage', 'IN'),
('Walter', 'Stevenson', '612-733-4109', 'walter.stevenson@metrostate.edu', 'password', 70000, 604045823 , '7671 Old Bow Ridge Lane ', 'Irmo', 'SC'),
('Tony', 'Vu', '612-555-1234', 'tony@metrostate.edu', 'password', 70000, 564528512, '9108 W. Gulf St.', 'Olney', 'MD');



/* Populate Employees */
INSERT INTO metro_bank.employee (
	employee_fname,
    employee_lname,
    employee_phone,
    employee_email,
	employee_password,
	employee_salary,
	employee_ssn,
    employee_address,
    employee_city,
    employee_state
) VALUES
('Leona', 'Dunne', '952-555-1177', 'l.Dunne@metrobank.edu', 'password', 50000, 551056283, '55 Summit St.', 'Bedford', 'OH'),
('Walter', 'Smith', '612-555-1234', 'w.Smith@metrobank.edu', 'password', 50000, 403508638, '536 Lakeshore Street ', 'Glen Cove', 'NY'),
('Straw', 'Berry', '622-555-1234', 's.berry@metrobank.edu', 'password', 50000, 461917489, '428 Saxton St.', 'Lexington', 'NC'),
('Darby', 'Dancer', '122-555-1234', 'd.dancer@metrobank.edu', 'password', 50000, 621782035, '374 Water Street ', 'Traverse City', 'MI'),
('Carol', 'Cromwell', '752-575-1222', 'c.cromwell@metrobank.edu', 'password', 50000, 449870041 , '7 West Miles Rd. ', 'Glen Allen', 'VA'),
('Sean', 'Peterson', '651-564-1422', 's.peterson@metrobank.edu', 'password', 50000, 145306325  , '67 Stonybrook Street ', 'Hoboken', 'NJ'),
('Steve', 'Larson', '612-395-5778', 's.larson@metrobank.edu', 'password', 50000, 258097019  , '325 N. Shadow Brook Street ', 'Stone Mountain', 'GA'),
('Bobby', 'Dolphin', '651-555-9987', 'b.dolphin@metrobank.edu', 'password', 50000,  644826097, '32 Newport Drive ', 'Auburndale', 'FL');

/* Populate Students */
INSERT INTO metro_bank.student (
	student_fname,
    student_lname,
    student_phone,
    student_email,
	student_password,
	date_created,
	student_ssn,
    student_address,
    student_city,
    student_state
) VALUES
('Jerry', 'Hills', '953-555-1177', 'j.hills@metrostate.edu', 'password', '2021-02-25T05:47:26.853Z',  119038905 , '8930 Theatre Street', 'Stow', 'OH'),
('Walter', 'Smith', '612-555-1234', 'w.Smith@metrostate.edu', 'password', '2021-02-25T05:47:26.853Z',  632588008 , '50 Tunnel Ave.', 'Philadelphia', 'PA'),
('Straw', 'Berry', '622-555-1234', 's.berry@metrostate.edu', 'password', '2021-02-25T05:47:26.853Z',  586479145 , '446 Tunnel Street ', 'Ridgecrest', 'TX'),
('Darby', 'Dancer', '122-555-1234', 'd.dancer@metrostate.edu', 'password', '2021-02-25T05:47:26.853Z', 159182143 , '977 North Bear Hill St. ', 'Harlingen', 'TX'),
('Dan', 'Johnson', '952-412-5970', 'd.johnson@metrostate.edu', 'password', '2021-02-25T05:47:26.853Z',  530273896 , '1 South St Paul Street ', 'New Rochelle', 'NY'),
('Jean', 'Shorewood', '734-712-0857', 'j.shorewood@metrostate.edu', 'password', '2021-02-25T05:47:26.853Z', 382548071  , '9900 Alderwood St. Suite 228 ', 'Malvern', 'PA'),
('Tony', 'Stark', '970-466-2152', 't.stark@metrostate.edu', 'password', '2021-02-25T05:47:26.853Z', 618653460 , '65 Proctor Street ', 'Sugar Land', 'TX'),
('Elena', 'Adam', '970-346-0526', 'e.adam@metrostate.edu', 'password', '2021-02-25T05:47:26.853Z', 420722015 , '27 N. Riverside St. ', 'Covington', 'GA'),
('Bobby', 'Dolphin', '651-555-9987', 'b.dolphin@metrostate.edu', 'password', '2021-02-25T05:47:26.853Z',  580544296 , '479 S. Santa Clara St.', 'South El Monte', 'CA');

/* Populate Credit accounts */
INSERT INTO metro_bank.credit (
	date_opened,
    is_active,
    student_id,
    balance,
	statement_balance,
	available_credit,
	apr,
    payment_made
) VALUES
('2021-02-25T05:47:26.853Z', true, 1, 322.22, 50.01, 9000, .2443,1);


/* Populate Credit applications */
INSERT INTO metro_bank.credit_application (
	fname,
    lname,
    address,
    city,
	state,
	email,
	phone,
    ssn,
    credit_score,
    income,
    password,
    student_id,
    status,
    date_applied
) VALUES
('Jerry', 'Hills', '8930 Theatre Street', 'Stow', 'OH', 'j.hills@metrobank.edu', '953-555-1177', 119038905, 500, 35000, 'password', 1, 'In review', '2021-02-25T05:47:26.853Z' );

/* Populate Checkings */
INSERT INTO metro_bank.checkings (
	date_opened,
    is_active,
    student_id,
    total,
    is_overdrafted,
    account_number,
    routing_number,
    debit_card_number
) VALUES
('2021-02-25T05:47:26.853Z', true, 1, 912.43, false, 021000021, 021000021, 1003830171874018),
('2021-02-25T05:47:26.853Z', true, 2, 2576.32, false, 121000021, 021000022, 2003830171874018),
('2021-02-25T05:47:26.853Z', true, 3, 1020.21, false, 221000021, 021000023, 3003830171874018),
('2021-02-25T05:47:26.853Z', true, 4, 30123.22, false, 321000021, 021000024, 4003830171874018),
('2021-02-25T05:47:26.853Z', true, 5, 50.00, false, 421000021, 021000025, 5003830171874018),
('2021-02-25T05:47:26.853Z', true, 6, 123.21, false, 521000021, 021000026, 6003830171874018),
('2021-02-25T05:47:26.853Z', true, 7, 5021.21,  false, 621000021, 021000027, 7003830171874018),
('2021-02-25T05:47:26.853Z', true, 8, 12.00, false, 721000021, 021000028, 8003830171874018),
('2021-02-25T05:47:26.853Z', true, 9, 12.00, false, 821000021, 021000029, 9003830171874018);

/* Populate Savings */
INSERT INTO metro_bank.savings (
	date_opened,
    is_active,
    student_id,
    total,
    interest,
    account_number,
    routing_number
) VALUES
('2021-02-25T05:47:26.853Z', true, 1, 1000.01, 0.02, 011000021, 021001021),
('2021-02-25T05:47:26.853Z', true, 2, 50.01, 0.02, 021000021, 021002021),
('2021-02-25T05:47:26.853Z', true, 3, 7000.11, 0.02, 031000021, 021300021),
('2021-02-25T05:47:26.853Z', true, 4, 200.21, 0.02, 041000021, 021040021),
('2021-02-25T05:47:26.853Z', true, 5, 20.12, 0.02, 051000021, 021005021),
('2021-02-25T05:47:26.853Z', true, 6, 40.66, 0.02, 061000021, 021006021),
('2021-02-25T05:47:26.853Z', true, 7, 232.99, 0.02, 071000021, 021070021),
('2021-02-25T05:47:26.853Z', true, 8, 123.21, 0.02, 081000021, 021080021),
('2021-02-25T05:47:26.853Z', true, 9, 2.21, 0.02, 091000021, 021090021);
