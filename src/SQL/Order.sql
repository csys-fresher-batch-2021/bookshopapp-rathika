CREATE TABLE orderList (
    id serial PRIMARY KEY,
	bookName varchar (30)  NOT NULL,
	language varchar (30) NOT NULL,
	noOfBooks int NOT NULL,
	cost bigint NOT NULL

);
CREATE TABLE confrimOrderList (

	bookName varchar (30)  NOT NULL,
	language varchar (30) NOT NULL,
	noOfBooks int NOT NULL,
	cost bigint NOT NULL

);