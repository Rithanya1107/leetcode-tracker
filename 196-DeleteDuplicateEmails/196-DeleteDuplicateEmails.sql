-- Last updated: 7/20/2026, 10:17:19 AM
DELETE p1
FROM Person p1
JOIN Person p2
ON p1.email = p2.email
AND p1.id > p2.id;