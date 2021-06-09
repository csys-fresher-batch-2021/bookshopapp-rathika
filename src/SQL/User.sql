CREATE TABLE userList (
	id serial PRIMARY KEY,
	username VARCHAR ( 50 ) UNIQUE NOT NULL,
	email VARCHAR ( 255 )  UNIQUE NOT NULL,
	mobileNumber varchar ( 10 ) UNIQUE NOT NULL,
	address varchar ( 50 ) NOT NULL,
	age int  NOT NULL,
	password VARCHAR ( 50 ) NOT NULL
);



INSERT INTO userList(username,email,mobileNumber,address,age,password) VALUES 
('Rathika','rathika@gmail.com',9090909090,'Muhavur',21,'rathika@12');

select email,password from userList;