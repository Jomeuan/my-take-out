DROP TABLE IF EXISTS authority;
DROP TABLE IF EXISTS user;
CREATE TABLE IF NOT EXISTS user(
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_name varchar(50) UNIQUE not null ,
	secret_code varchar(500) not null,
	valid boolean not null
);
CREATE TABLE  IF NOT EXISTS authority(
    id INT AUTO_INCREMENT primary KEY,
	user_id INT NOT NULL,
	authority varchar(10) not null COMMENT "A-admin C-consumer S-Store",
	constraint fk_authorities_user foreign key(user_id) references user(id)
);