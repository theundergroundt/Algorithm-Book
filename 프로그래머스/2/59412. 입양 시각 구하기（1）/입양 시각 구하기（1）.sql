-- 코드를 입력하세요
SELECT HOUR(DATETIME) as HOUR, count(ANIMAL_ID) as 'COUNT' from ANIMAL_OUTS
where HOUR(DATETIME) >= '09:00' and HOUR(DATETIME)< '20:00'
group by HOUR(DATETIME)
order by HOUR asc;