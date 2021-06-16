create table bookList(
	id serial primary key,
	bookName varchar(20) not null,
	language  varchar(20) not null,
	noOfBooks int not null,
	cost int not null,
	unique(bookName)
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