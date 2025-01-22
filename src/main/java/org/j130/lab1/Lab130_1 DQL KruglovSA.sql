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


	--Поставление статуса и даты отгрузки
UPDATE orders 
SET delivery_status = 'S', delivery_datestart = '2025-01-12'
WHERE orders.order_id = 5;

	--Для проверки скрипта ниже по уменьшению остатка на складе добавим стульев на склад
/*
UPDATE products 
SET remainder = 10
WHERE product_article = '3251617';	
*/
	
	--Уменьшение остатка на складе
UPDATE products
SET remainder = remainder - order_position.quantity 
FROM order_position
LEFT JOIN orders ON orders.order_id = order_position.order_id
WHERE orders.order_id = 5 AND orders.order_id=order_position.order_id AND order_position.product_article = products.product_article;