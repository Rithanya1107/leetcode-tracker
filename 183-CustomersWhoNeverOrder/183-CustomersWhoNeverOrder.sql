-- Last updated: 7/10/2026, 8:47:37 AM
SELECT name AS Customers
FROM Customers
WHERE id NOT IN (
    SELECT customerId
    FROM Orders
);
