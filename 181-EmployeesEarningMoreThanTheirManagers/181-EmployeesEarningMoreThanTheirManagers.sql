-- Last updated: 7/10/2026, 8:47:41 AM
SELECT 
   e.name AS Employee
FROM Employee e
JOIN Employee m
   ON e.managerId = m.id
WHERE e.salary > m.salary;