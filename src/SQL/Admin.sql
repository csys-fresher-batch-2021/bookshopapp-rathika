create table adminLogin(
   adminName varchar(30) unique not null,
   password varchar(30) not null
);
INSERT INTO adminLogin(adminName,password) VALUES 
('Admin','admin');
select * from adminLogin;