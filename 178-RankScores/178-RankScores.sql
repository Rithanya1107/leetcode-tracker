-- Last updated: 7/10/2026, 8:47:48 AM
SELECT 
  score,
  DENSE_RANK() OVER (ORDER BY score DESC) AS 'rank'

FROM Scores
ORDER BY score DESC;