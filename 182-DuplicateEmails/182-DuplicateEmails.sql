-- Last updated: 7/10/2026, 8:47:39 AM
SELECT email AS Email
FROM Person
GROUP BY email
HAVING COUNT(email) > 1;
