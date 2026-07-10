-- Last updated: 7/10/2026, 8:47:50 AM
CREATE FUNCTION getNthHighestSalary(N int) RETURNS INT 
BEGIN
 SET N = N - 1;
 
 RETURN(
    SELECT DISTINCT salary
    FROM Employee
    ORDER BY salary DESC
    LIMIT N,1
 );
 END