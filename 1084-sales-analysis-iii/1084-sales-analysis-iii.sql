# Write your MySQL query statement below

SELECT P.product_id, P.product_name FROM
Product P LEFT JOIN Sales S ON P.product_id = S.product_id
GROUP BY P.product_id
HAVING max(S.sale_date)<= '2019-03-31' AND MIN(S.sale_date)>='2019-01-01';

