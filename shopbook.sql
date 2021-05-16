//shopbook数据库
create database shopbook default charset utf8;
use shopbook;
//用户登陆名称、用户真实名称、口令、电子邮件地址、电话、邮寄地址
CREATE TABLE bookuser(
	logname VARCHAR(10) primary key,
	realname VARCHAR(15)not null,
	password VARCHAR(15)not null,
	email VARCHAR(15)not null,
	phone VARCHAR(15)not null,
	address VARCHAR(32)not null
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
//订阅号、书名、作者、出版社、出版时间、单价、分类
CREATE TABLE book(
	order_number VARCHAR(10)primary key,
	book_name VARCHAR(15)not null,
	author VARCHAR(15)not null,
	publisher VARCHAR(15)not null,
	publish_time DATE not null,
	price FLOAT(7,2) not null,
	category VARCHAR(15)not null
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE orderform(
    logname VARCHAR(10)not null,
	order_number VARCHAR(10)not null,
	primary key (logname,order_number),
	realname VARCHAR(15),	
	bookname VARCHAR(15),
	author VARCHAR(15),
	mount int(4),
	phone int(4),
	address VARCHAR(20)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
alter table orderform add foreign key (logname) references bookuser(logname) on delete cascade on update cascade;
alter table orderform add foreign key (order_number) references book(order_number)on delete cascade on update cascade;

alter table orderform modify phone varchar(15);
alter table orderform drop author;
