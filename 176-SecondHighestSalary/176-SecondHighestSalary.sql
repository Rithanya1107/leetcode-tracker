-- Last updated: 7/10/2026, 8:47:52 AM
SELECT
  (
    SELECT DISTINCT salary
    FROM Employee
    ORDER BY salary DESC
    LIMIT 1 OFFSET 1 
  ) AS SecondHighestSalary;