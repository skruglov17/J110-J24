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

--Добавление исходных данных

INSERT INTO products VALUES 
	(3251615, 'Стол кухонный', 'белый', 8000, 12),
	(3251616, 'Стол кухонный', NULL, 8000, 15),
	(3251617, 'Стул столовый "гусарский"', 'орех', 4000, 0),
	(3251619, 'Стул столовый с высокой спинкой', 'белый', 3500, 37),
	(3251620, 'Стул столовый с высокой спинкой', 'коричневый', 3500, 52);

INSERT INTO orders VALUES
	(DEFAULT, '2020-11-20', 'Иванов Сергей','(981)123-45-67', NULL, 'ул. Веденеева, 20-1-41', 'S', '2020-11-29'),
	(DEFAULT, '2020-11-22', 'Комаров Алексей','(921)001-22-33', NULL, 'пр. Пархоменко 51-2-123', 'S', '2020-11-29'),
	(DEFAULT, '2020-11-28', 'Ирина Викторова','(911)009-88-77', NULL, 'Тихорецкий пр. 21-21', 'P', NULL),
	(DEFAULT, '2020-12-03', 'Николаев Павел',NULL, 'pasha_nick@mail.ru', 'ул. Хлопина 3-88', 'P', NULL),
	(DEFAULT, '2020-12-03', 'Антонина Васильева','(931)777-66-55', 'antvas66@gmail.com', 'пр. Науки, 11-3-9', 'P', NULL),
	(DEFAULT, '2020-12-10', 'Ирина Викторова','(911)009-88-77', NULL, 'Тихорецкий пр. 21-21', 'P', NULL);

INSERT INTO order_position VALUES 
	(1, 3251616, 7500, 1),
	(2, 3251615, 7500, 1),
	(3, 3251615, 8000, 1),
	(3, 3251617, 4000, 4),
	(4, 3251619, 3500, 2),
	(5, 3251615, 8000, 1),
	(5, 3251617, 4000, 4),
	(6, 3251617, 4000, 2);

--Задания с запросами

--Cписок заказов, созданных: в ноябре, в декабре
SELECT * 
FROM orders
WHERE create_date BETWEEN '2020-11-01' AND '2020-12-31';

--Cписок заказов, отгруженных: в ноябре, в декабре;
SELECT * 
FROM orders
WHERE delivery_datestart BETWEEN '2020-11-01' AND '2020-12-31';					 

--Cписок клиентов: для каждого клиента должны быть выведены его ФИО, телефон и адрес электронной почты
SELECT customer_name, customer_number, customer_email 
FROM orders;

--Cписок позиций заказа с id=3;
SELECT *
FROM order_position 
RIGHT JOIN orders ON orders.order_id = order_position.order_id
WHERE orders.order_id = 3;

--Названия товаров, включённых в заказ с id=3.
SELECT product_name
FROM products 
RIGHT JOIN order_position ON products.product_article = order_position.product_article
RIGHT JOIN orders ON orders.order_id = order_position.order_id
WHERE orders.order_id = 3;

--Cписок отгруженных заказов, и количество позиций в каждом из них
	
	--Создадим таблицу для количества позиций по всем заказам
DROP TABLE IF EXISTS orders_count;
CREATE TABLE orders_count (
	order_id int4,
	order_count int4 NOT NULL,
	order_sum int4
);
	
	--Посчитаем количество позиций и сумм по всем заказам
INSERT INTO orders_count
SELECT order_position.order_id, COUNT(order_position.order_id), SUM(order_position.price)
FROM order_position
RIGHT JOIN orders ON orders.order_id = order_position.order_id
GROUP BY order_position.order_id;
	
	--Выведем список отгруженных заказов с количеством позиций и сумм заказов
SELECT *
FROM orders
LEFT JOIN orders_count ON orders_count.order_id = orders.order_id
WHERE orders.delivery_status = 'S'
ORDER BY orders.order_id ASC;

--Запрос, фиксирующий отгрузку заказа с id=5
    --Для проверки скрипта ниже по уменьшению остатка на складе добавим стульев на склад
/*
UPDATE products
SET remainder = 10
WHERE product_article = '3251617';
*/

WITH orders_update AS (
    UPDATE orders
    SET delivery_status = 'S', delivery_datestart = now()
    WHERE orders.order_id = 5
    RETURNING order_id)
UPDATE products
SET remainder = remainder - order_position.quantity
FROM order_position
LEFT JOIN orders ON orders.order_id = order_position.order_id
WHERE orders.order_id = 5 AND orders.order_id=order_position.order_id AND order_position.product_article = products.product_article;