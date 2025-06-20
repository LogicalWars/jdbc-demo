select product_name from netology.orders o
inner join netology.customers c on c.id = o.customer_id
where c.name ILIKE :name