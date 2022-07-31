# Write your MySQL query statement below

SELECT name, SUM(t.amount) AS balance FROM users AS u INNER JOIN transactions AS t ON u.account= t.account 
GROUP BY name HAVING SUM(t.amount) > 10000;
