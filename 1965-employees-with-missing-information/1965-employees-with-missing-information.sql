# Write your MySQL query statement below

SELECT 
	employees.employee_id AS employee_id 
FROM
	employees 
LEFT JOIN 
	salaries ON salaries.employee_id = employees.employee_id
WHERE salary IS NULL 

UNION ALL

SELECT
	salaries.employee_id AS employee_id 
FROM
	employees 
RIGHT JOIN 
	salaries ON salaries.employee_id = employees.employee_id
WHERE name IS NULL

ORDER BY employee_id ASC
