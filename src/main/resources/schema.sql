create schema netology;

create table netology.CUSTOMERS (
                                    id bigserial primary key,
                                    name varchar(20) not null,
                                    surname varchar(20) not null,
                                    age int not null,
                                    phone_number bigint
);

create table netology.ORDERS (
                                 id bigserial primary key,
                                 date timestamptz default now(),
                                 customer_id bigint references netology.customers(id),
                                 product_name varchar(50) not null,
                                 amount int default 0
);

insert into netology.CUSTOMERS (name, surname, age, phone_number)
values ('ivan', 'ivanov', 27, 89275555555),
       ('roman', 'romanov', 32, 89276666666);

insert into netology.ORDERS (date, customer_id, product_name, amount)
values (now(), 1, 'fruit', 10),
       (now(), 2, 'tea', 1);

