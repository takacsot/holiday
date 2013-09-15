drop table if exists books;
CREATE TABLE books (
  id  int(11) DEFAULT NULL auto_increment PRIMARY KEY,
  author VARCHAR(128),
  title VARCHAR(128),
  isbn VARCHAR(128),
  created_at DATETIME,
  updated_at DATETIME
);

drop table if exists users;
create table users(
	id int(11) default null auto_increment primary key,
	username varchar(128),
	password varchar(255),
	name varchar(128),
	created_at datetime,
	updated_at datetime
);

drop table if exists holidays;  
create table holidays(
	id int(11) default null auto_increment primary key,
	user_id int(11),
	from_date date,
	to_date date,
	step varchar(16),
	category varchar(16),
	comment varchar(2147483647)
);
