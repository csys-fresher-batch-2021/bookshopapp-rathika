create table orderList(
	id serial primary key,
	userid int not null,
	username varchar(30) not null,
	bookname varchar(20) not null,
	language  varchar(20) not null,
	noofbooks int not null,
	cost int not null,
	order_date DATE NOT NULL,
	delivery_date DATE NOT NULL,
	status varchar (30),
	check(status in('PENDING','DELIVERED','CANCELLED'))
	
);
