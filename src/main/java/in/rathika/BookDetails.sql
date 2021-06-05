CREATE TABLE bookList (

	bookName varchar (30) UNIQUE NOT NULL,
	language varchar (30) NOT NULL,
	noOfBooks int NOT NULL,
	cost bigint NOT NULL

);

INSERT INTO bookList(bookName,language,noOfBooks,cost) VALUES 
('MOON','ENGLISH',4,500);
INSERT INTO bookList(bookName,language,noOfBooks,cost) VALUES 
('PONNIYIN SELVAN','TAMIL',3,1000);
INSERT INTO bookList(bookName,language,noOfBooks,cost) VALUES 
('A TALE OF TWO CITIES','ENGLISH',4,400);
INSERT INTO bookList(bookName,language,noOfBooks,cost) VALUES 
('The LITTLE PRINCE','ENGLISH',4,700);

SELECT * FROM bookList;

