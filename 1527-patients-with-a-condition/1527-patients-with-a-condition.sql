# Write your MySQL query statement below

SELECT 
    * 
FROM 
    Patients 
WHERE
    Conditions LIKE '% DIAB1%' 
OR
    Conditions LIKE 'DIAB1%';
