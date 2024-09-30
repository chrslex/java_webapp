--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS employee;

CREATE TABLE employee
(
    id         SERIAL PRIMARY KEY NOT NULL,
    first_name varchar(45) DEFAULT NULL,
    last_name  varchar(45) DEFAULT NULL,
    email      varchar(45) DEFAULT NULL
);

--
-- Data for table `employee`
--

INSERT INTO employee (first_name, last_name, email) VALUES
	('Leslie','Andrews','leslie@luv2code.com'),
	('Emma','Baumgarten','emma@luv2code.com'),
	('Avani','Gupta','avani@luv2code.com'),
	('Yuri','Petrov','yuri@luv2code.com'),
	('Juan','Vega','juan@luv2code.com');

