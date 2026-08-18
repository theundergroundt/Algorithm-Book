-- 코드를 작성해주세요

select ID,
case
    when grp = 1 then 'CRITICAL'
    when grp = 2 then 'HIGH'
    when grp = 3 then 'MEDIUM'
    when grp = 4 then 'LOW'
    end as COLONY_NAME
from (select ID, NTILE(4) OVER (ORDER BY SIZE_OF_COLONY DESC) as grp from ECOLI_DATA) as t
order by ID;