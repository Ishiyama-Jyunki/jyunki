--問1
SELECT
 uniform_num,
 name,
 club
FROM
players;

--問2
SELECT
 name,
 group_name
FROM
 countries
WHERE
 group_name = 'C';

--問3
SELECT
 name,
 ranking,
 id,
 group_name
FROM
countries
WHERE
group_name <> 'C';

--問4
SELECT
 id,
 country_id,
 uniform_num,
 position,
 name,
 club,
 birth,
 height,
 weight
FROM
 players
WHERE
 AGE(CURRENT_DATE, birth) >= INTERVAL '40 years';

--問5
SELECT
 id,
 country_id,
 uniform_num,
 position,
 name,
 club,
 birth,
 height,
 weight
FROM
 players
WHERE
 height < 170;

--問6
SELECT
 id,
 name,
 ranking,
 group_name
FROM
 countries
WHERE
 ranking BETWEEN 36 AND 56;

--問7
SELECT
 id,
 country_id,
 uniform_num,
 position,
 name,
 club,
 birth,
 height,
 weight
FROM
 players
WHERE
 position IN ('GK','DF','MF');

--問8
SELECT
 id,
 pairing_id,
 player_id,
 goal_time
FROM
 goals
WHERE
 player_id IS NULL;

--問9
SELECT
 id,
 pairing_id,
 player_id,
 goal_time
FROM
 goals
WHERE
 player_id IS NOT NULL;

--問10
SELECT
 id,
 country_id,
 uniform_num,
 position,
 name,
 club,
 birth,
 height,
 weight
FROM
 players
WHERE
 name LIKE '%ニョ';

--問11
SELECT
 id,
 country_id,
 uniform_num,
 position,
 name,
 club,
 birth,
 height,
 weight
FROM
 players
WHERE
 name LIKE '%ニョ%';

--問12
SELECT
 id,
 country_id,
 uniform_num,
 position,
 name,
 club,
 birth,
 height,
 weight
FROM
 players
WHERE
 height < 165
 OR weight < 60;

--問13
SELECT
 id,
 country_id,
 uniform_num,
 position,
 name,
 club,
 birth,
 height,
 weight
FROM
 players
WHERE
 (position = 'FW' OR position = 'MF')
 AND height < 170;

--問14
SELECT DISTINCT
 position
FROM
 players;
 
--問15
SELECT
 name,
 club,
 height + weight AS 体力指数
FROM
 players;
 
--問16
SELECT
 id,
 country_id,
 uniform_num,
 position,
 name,
 club,
 birth,
 height,
 weight
FROM
 players
ORDER BY
 height DESC,
 weight DESC;
 
--問17
SELECT
 player_id,
 goal_time,
  CASE
   WHEN player_id IS NULL THEN 9999 
   ELSE player_id 
   END AS player_id,
   goal_time
FROM
 goals;
 
--問18
SELECT
 ROUND(AVG(height), 4) AS 平均身長,
 ROUND(AVG(weight), 4) AS 平均体重
FROM
 players;
 
--問19
SELECT
 COUNT(*) AS 日本選手のゴール数
FROM
 goals
WHERE
 player_id BETWEEN 714 AND 736;
 
--問20
SELECT
 MAX(height) AS 最大身長,
 MIN(weight) AS 最軽体重
FROM
 players;
 
--問21
SELECT
 SUM(ranking) AS CグループのFIFAランクの合計値
FROM
 countries
WHERE
 group_name = 'C';
 
--問22
SELECT
 countries.name AS 国名,
 players.name AS 選手名,
 goals.goal_time AS 得点時間
FROM
 goals
 JOIN players ON goals.player_id = players.id
 JOIN countries ON players.country_id = countries.id
WHERE
 goals.player_id IS NOT NULL;
 
--問23
SELECT
 goal_time,
 uniform_num,
 position,
 name
FROM
 goals AS goals
 LEFT JOIN players AS players ON goals.player_id = player_id;
 
--問24
SELECT
 goal_time,
 uniform_num,
 position,
 name
FROM
 goals AS goals
 RIGHT JOIN players AS players ON goals.player_id = player_id;
 
--問25
SELECT
 c.name AS country_name,
 g.goal_time AS goal_time,
 p.position AS position,
 p.name AS player_name
FROM
 goals AS g
 LEFT JOIN players AS p
 ON g.player_id = p.id
 LEFT JOIN countries AS c 
 ON p.country_id = c.id;
 
--問26
SELECT
  g.goal_time,
  (SELECT p.name FROM players p WHERE p.id = g.player_id) AS player_name
FROM goals g
WHERE g.player_id IS NOT NULL;

 
--問27
SELECT
  p.position,
  p.height,
  p.name,
  p.club
FROM players p
JOIN (
  SELECT position, MAX(height) AS max_height
  FROM players
  GROUP BY position
) mx
  ON p.position = mx.position
 AND p.height   = mx.max_height
ORDER BY p.position;


--問28
SELECT
  group_name,
  MIN(ranking) AS best_rank,   
  MAX(ranking) AS worst_rank,  
  (MAX(ranking) - MIN(ranking)) AS diff
FROM countries
GROUP BY group_name
HAVING (MAX(ranking) - MIN(ranking)) > 50
ORDER BY group_name;

--問29
SELECT '1980' AS birth_year, COUNT(*) AS cnt
FROM players
WHERE birth BETWEEN '1980-01-01' AND '1980-12-31'
UNION ALL
SELECT '1981' AS birth_year, COUNT(*) AS cnt
FROM players
WHERE birth BETWEEN '1981-01-01' AND '1981-12-31';

--問30
SELECT id, name, height, weight
FROM players
WHERE height > 195
UNION ALL
SELECT id, name, height, weight
FROM players
WHERE weight > 95
ORDER BY id ASC;

--問31
WITH ranked AS (
  SELECT
    name,
    height,
    weight,
    ROW_NUMBER() OVER (ORDER BY height DESC, name ASC) AS rn
  FROM players
)
SELECT
  name,
  height,
  weight
FROM ranked
WHERE rn BETWEEN 6 AND 20
ORDER BY rn;

--問32
SELECT
  pr.kickoff                           AS キックオフ日時,
  mc.name                              AS 自国名,
  ec.name                              AS 対戦相手国名,
  mc.ranking                           AS 自国FIFAランク,
  ec.ranking                           AS 対戦相手FIFAランク,
  COUNT(p.id)                          AS 自国のゴール数
FROM pairings AS pr
JOIN countries AS mc ON pr.my_country_id   = mc.id
JOIN countries AS ec ON pr.enemy_country_id = ec.id
LEFT JOIN goals    AS g ON g.pairing_id = pr.id
LEFT JOIN players  AS p ON g.player_id  = p.id
                        AND p.country_id = mc.id   -- 自国のゴールだけを数える
WHERE mc.group_name = 'C'
GROUP BY
  pr.kickoff, mc.name, ec.name, mc.ranking, ec.ranking
ORDER BY
  pr.kickoff, mc.ranking;

--問33
SELECT
  pr.kickoff                           AS キックオフ日時,
  mc.name                              AS 自国名,
  ec.name                              AS 対戦相手国名,
  mc.ranking                           AS 自国FIFAランク,
  ec.ranking                           AS 対戦相手FIFAランク,
  (
    SELECT COUNT(*)
    FROM goals g
    JOIN players p ON p.id = g.player_id
    WHERE g.pairing_id = pr.id
      AND p.country_id = pr.my_country_id
  )                                    AS 自国のゴール数
FROM pairings AS pr
JOIN countries AS mc ON pr.my_country_id   = mc.id
JOIN countries AS ec ON pr.enemy_country_id = ec.id
WHERE mc.group_name = 'C'
ORDER BY
  pr.kickoff, mc.ranking;

--複合インデックス
CREATE INDEX idx_pla


 



