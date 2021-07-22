use classicmodels;
-- truy van thong thuong
select * 
from customers
where customerName = 'land of toys inc.';
-- dung explain
explain
select *
from customers
where customerName = 'land of toys inc.';
-- them index
alter table customers add index idx_customerName(customerName);
explain
select *
from customers
where customerName = 'land of toys inc.';
-- them index khac
ALTER TABLE customers ADD INDEX idx_full_name(contactFirstName, contactLastName);
EXPLAIN SELECT * FROM customers WHERE contactFirstName = 'Jean' or contactFirstName = 'King';
-- xoa index
ALTER TABLE customers DROP INDEX idx_full_name;
EXPLAIN SELECT * FROM customers WHERE contactFirstName = 'Jean' or contactFirstName = 'King';
