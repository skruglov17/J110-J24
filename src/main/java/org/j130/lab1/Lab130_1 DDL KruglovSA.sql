--Удаление таблиц

DROP TABLE IF EXISTS order_position;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS products;

--Создание таблиц

CREATE TABLE products (
	product_article CHAR(7) PRIMARY KEY,
	product_name VARCHAR(50) NOT NULL,
	color VARCHAR(20),
	price int4 CHECK(price > 0),
	remainder int4 CHECK(remainder >= 0)
);

CREATE TABLE orders (
	order_id int4 GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	create_date timestamp NOT NULL,
	customer_name VARCHAR(100) NOT NULL,
	customer_number VARCHAR(50),
	customer_email VARCHAR(50),
	delivery_address VARCHAR(200) NOT NULL,
	delivery_status CHAR(1) CHECK(delivery_status IN ('P', 'S', 'C')), -- P готовится, S - Отгружен, C - Отменён
	delivery_datestart timestamp CHECK((delivery_status IN ('S') AND delivery_datestart > '1900-01-01') OR delivery_datestart = NULL)
);

CREATE TABLE order_position (
	order_id int4,
	CONSTRAINT order_fk FOREIGN KEY (order_id) REFERENCES orders(order_id),
	product_article CHAR(7),
	CONSTRAINT order_product_id PRIMARY KEY (order_id, product_article),
	CONSTRAINT products_fk FOREIGN KEY (product_article) REFERENCES products(product_article),
	price int4 NOT NULL CHECK (price > 0),
	quantity int4 NOT NULL CHECK (quantity > 0)
);