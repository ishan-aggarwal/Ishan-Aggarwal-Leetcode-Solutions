# Write your MySQL query statement below

# select 
#     c.name as 'Customers'
# from 
#     Customers c 
# where 
#     c.id NOT IN (select  o.customerId  from Orders o);


SELECT 
    Name AS Customers
FROM 
    Customers AS c
LEFT JOIN 
    Orders AS o
ON 
    c.Id = o.CustomerId
WHERE 
    o.CustomerId is null;
