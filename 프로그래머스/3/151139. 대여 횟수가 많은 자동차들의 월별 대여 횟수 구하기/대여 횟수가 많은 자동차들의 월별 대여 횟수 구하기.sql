-- 코드를 입력하세요
SELECT MONTH(START_DATE) as MONTH, CAR_ID, count(CAR_ID) as RECORDS from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where YEAR(START_DATE) = 2022
  AND MONTH(START_DATE) BETWEEN 8 AND 10
  AND CAR_ID in(select CAR_ID from CAR_RENTAL_COMPANY_RENTAL_HISTORY 
                where YEAR(START_DATE) = 2022 and (MONTH(START_DATE) >=8 and MONTH(START_DATE) <= 10)
               group by CAR_ID
               having count(CAR_ID)>=5)
               
group by MONTH(START_DATE), CAR_ID
order by MONTH asc, CAR_ID desc;