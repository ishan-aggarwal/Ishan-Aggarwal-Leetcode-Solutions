# Write your MySQL query statement below


# select v.customer_id , count(v.visit_id) as count_no_trans from Visits v
# left join Transactions t on v.visit_id = t.visit_id
# where t.visit_id is null
# group by v.customer_id
# order by count_no_trans desc;


SELECT customer_id, COUNT(visit_id) AS count_no_trans
FROM Visits 
WHERE visit_id NOT IN (select visit_id from Transactions)
GROUP BY customer_id
order by count_no_trans desc;
