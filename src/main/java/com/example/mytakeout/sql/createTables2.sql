CREATE TABLE IF NOT EXISTS t_category (
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    gmt_create DATETIME,
    gmt_modified DATETIME,
    category_name CHAR(30),
    introduction VARCHAR(100),
    category_sort INT
);
CREATE TABLE IF NOT EXISTS t_dish (
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    gmt_create DATETIME,
    gmt_modified DATETIME,
    dish_name VARCHAR(30) NOT NULL,
    introduction VARCHAR(100),
    price DECIMAL(10, 4),
    image_path VARCHAR(30)
);
CREATE TABLE IF NOT EXISTS t_fk_category_dish(
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    gmt_create DATETIME,
    gmt_modified DATETIME,
    category_id INT UNSIGNED NOT NULL,
    dish_id INT UNSIGNED NOT NULL
);
CREATE TABLE IF NOT EXISTS t_order(
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    gmt_create DATETIME,
    gmt_modified DATETIME,
    order_state TINYINT,
    remark VARCHAR(100) COMMENT "订单的备注"
);
CREATE TABLE IF NOT EXISTS t_fk_order_dish(
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    gmt_create DATETIME,
    gmt_modified DATETIME,
    dish_id INT UNSIGNED NOT NULL,
    order_id INT UNSIGNED NOT NULL,
    dish_quantity INT UNSIGNED NOT NULL COMMENT "菜品数量"
);
CREATE TABLE IF NOT EXISTS t_shopping_cart(
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    gmt_create DATETIME,
    gmt_modified DATETIME,
    dish_id INT UNSIGNED NOT NULL,
    dish_quantity INT UNSIGNED NOT NULL COMMENT "菜品数量"
);
CREATE TABLE IF NOT EXISTS t_user(
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    gmt_create DATETIME,
    gmt_modified DATETIME,
    user_name char(10) UNIQUE NOT NULL,
    user_password varchar(500) NOT NULL,
    user_state TINYINT NOT NULL
);
CREATE TABLE IF NOT EXISTS t_authority(
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    gmt_create DATETIME,
    gmt_modified DATETIME,
    user_id INT UNSIGNED NOT NULL,
    authority CHAR(16) NOT NULL COMMENT "A-admin C-consumer S-Store"
);