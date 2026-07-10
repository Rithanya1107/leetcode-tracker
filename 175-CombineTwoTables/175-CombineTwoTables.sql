-- Last updated: 7/10/2026, 8:47:54 AM
SELECT
  p.firstName,
  p.lastName,
  a.city,
  a.state

FROM Person p
LEFT JOIN Address a 
ON p.personId = a.personId