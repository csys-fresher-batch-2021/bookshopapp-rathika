create table adminLogin(
   adminName varchar(30) unique not null,
   password varchar(30) not null
);
INSERT INTO adminLogin(adminName,password) VALUES 
('Admin','Admin@123');
select * from adminLogin;