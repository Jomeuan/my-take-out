CREATE TABLE IF NOT EXISTS category (
    id INT AUTO_INCREMENT PRIMARY KEY COMMENT "同时也是排序",
    category_name VARCHAR(30) UNIQUE NOT NULL COMMENT "分类名字",
    detail VARCHAR(100) COMMENT "分类的描述"
);
CREATE TABLE IF NOT EXISTS dish (
    id INT AUTO_INCREMENT PRIMARY KEY COMMENT "同时也是排序",
    dish_name VARCHAR(30) NOT NULL,
    detail VARCHAR(100),
    image_path VARCHAR(30),
    price FLOAT(7, 3)
);
CREATE TABLE IF NOT EXISTS category_dish(
    id INT AUTO_INCREMENT PRIMARY KEY ,
    category_id INT ,
    dish_id INT,
    FOREIGN KEY(category_id) REFERENCES category(id),
    FOREIGN KEY(dish_id) REFERENCES dish(id)
);
-- 不能使用order作表名得加``
CREATE TABLE IF NOT EXISTS `order`(
    id INT PRIMARY KEY,
    mode varchar(10) COMMENT "U-UNPAID未付款,D-Delivering配送中,F-Finish完成",
    remark VARCHAR(30) COMMENT "订单的备注"
);
CREATE TABLE IF NOT EXISTS order_dishes(
    dish_id INT,
    order_id INT,
    quantity INT COMMENT "菜品数量",
    PRIMARY KEY (dish_id, order_id),
    FOREIGN KEY(dish_id) REFERENCES dish(id),
    FOREIGN KEY(order_id) REFERENCES `order`(id)
);
CREATE TABLE IF NOT EXISTS shopping_cart(
    dish_id INT,
    quantity INT,
    FOREIGN KEY (dish_id) REFERENCES dish(id),
    PRIMARY KEY(dish_id)
);
CREATE TABLE IF NOT EXISTS user(
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_name varchar(50) UNIQUE not null,
    secret_code varchar(500) not null,
    valid boolean not null
);
CREATE TABLE IF NOT EXISTS authority(
    id INT AUTO_INCREMENT primary KEY,
    user_id INT NOT NULL,
    authority varchar(10) not null COMMENT "A-admin C-consumer S-Store",
    constraint fk_authorities_user foreign key(user_id) references user(id)
);